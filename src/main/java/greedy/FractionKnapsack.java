package greedy;

import java.util.*;

public class FractionKnapsack {

    public static void main(String[] args) {
        FractionKnapsack fractionKnapsack = new FractionKnapsack();
        List<KnapsackItem> items = new ArrayList<>();
        int[] values = {100, 120, 60};
        int[] weight = {20, 30, 10};
        int capacity = 50;
        for(int i = 0; i < values.length; i ++) {
            items.add(new KnapsackItem(i + 1, values[i], weight[i]));
        }
        fractionKnapsack.knapsack(items, capacity);
    }

    void knapsack(List<KnapsackItem> items, int capacity) {
        Comparator<KnapsackItem> comparator = new Comparator<KnapsackItem>() {
            @Override
            public int compare(KnapsackItem o1, KnapsackItem o2) {
                if(o2.getRatio() > o1.getRatio()) { // sort based on descending order of knapsack
                    return 1;
                } else {
                    return -1;
                }
            }
        };

        Collections.sort(items, comparator);
        int usedCapacity = 0;
        double totalValue = 0;
        for(KnapsackItem item: items) {
            if(usedCapacity + item.getWeight() <= capacity) {
                usedCapacity += item.getWeight();
                System.out.println("Taken: " + item);
                totalValue += item.getValue();
            } else {
                int usedWeight = capacity - usedCapacity;
                double value = item.getRatio() * usedWeight;
                System.out.println("Taken: item index = " + item.getIndex() + " obtained value = " + value + " used weight = "
                + usedWeight + ", ratio = " + item.getRatio());
                usedCapacity += usedWeight;
                totalValue += value;
            }

            if(usedCapacity == capacity) {
                break;
            }
        }
        System.out.println("Total value obtained: " + totalValue);
    }
}

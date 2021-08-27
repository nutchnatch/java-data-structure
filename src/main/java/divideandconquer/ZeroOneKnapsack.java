package divideandconquer;

public class ZeroOneKnapsack {
    public static void main(String[] args) {
        ZeroOneKnapsack knapsack = new ZeroOneKnapsack();
        int[] profits = {31, 26, 17, 72};
        int[] weights = {3, 1, 2, 5};
        int maxProfit = knapsack.knapsack(profits, weights, 7);
        System.out.println(maxProfit);
    }

    private int knapsack(int[] profits, int[] weighs, int capacity, int currentIndex) {
        if(capacity <= 0 || currentIndex < 0 || currentIndex >= profits.length) {
            return 0;
        }
        int profit1 = 0;
        if(weighs[currentIndex] <= capacity) {
            profit1 = profits[currentIndex] + knapsack(profits, weighs, capacity - weighs[currentIndex], currentIndex + 1);

        }
        int profit2 = knapsack(profits, weighs, capacity, currentIndex + 1);
        return Math.max(profit1, profit2);
    }

    public int knapsack(int[] profits, int[] weighs, int capacity) {
        return  knapsack(profits, weighs, capacity, 0);
    }
}

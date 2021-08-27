package divideandconquer;

public class HouseRobber {

    public static void main(String[] args) {
        int[] houseNetWorth = {6, 7, 1, 30, 8, 2, 4};
        HouseRobber houseRobber = new HouseRobber();
        System.out.println(houseRobber.maximumMoneyRecursive(houseNetWorth));
    }

    private int maximumMoneyRecursive(int[] houseNetWorth, int currentIndex) {
        if(currentIndex >= houseNetWorth.length) {
            return 0;
        }
        int stealCurrentHouse = houseNetWorth[currentIndex] + maximumMoneyRecursive(houseNetWorth, currentIndex + 2);
        int skipCurrentHouse = maximumMoneyRecursive(houseNetWorth, currentIndex + 1);
        return Math.max(stealCurrentHouse, skipCurrentHouse);
    }

    public int maximumMoneyRecursive(int[] houseNetWorth) {
        return maximumMoneyRecursive(houseNetWorth, 0);
    }
}

package dynamicprogramming;

public class HouseRobberDP {

    public static void main(String[] args) {
        int[] houseNetWorth = {6, 7, 1, 30, 8, 2, 4};
        HouseRobberDP houseRobber = new HouseRobberDP();
        System.out.println(houseRobber.maxMoneyTopDown(houseNetWorth));
        System.out.println();
        System.out.println(houseRobber.maxMoneyBottomUp(houseNetWorth));
    }

    public int maxMoneyTopDown(int[] houseNetWorth) {
        // TODO
        return maxMoneyTopDown(houseNetWorth, 0, new int[houseNetWorth.length]);
    }

    private int maxMoneyTopDown(int[] houseNetWorth, int currentIndex, int[] dp) {
        if(currentIndex >= houseNetWorth.length) {
            return 0;
        }
        if(dp[currentIndex] == 0) {
            int stealCurrentHouse = houseNetWorth[currentIndex] + maxMoneyTopDown(houseNetWorth, currentIndex + 2, dp);
            int skipCurrentHouse = maxMoneyTopDown(houseNetWorth, currentIndex + 1, dp);
            dp[currentIndex] = Math.max(stealCurrentHouse, skipCurrentHouse);
        }
        return dp[currentIndex];
    }

    private int maxMoneyBottomUp(int[] houseNetWorth) {
        int[] dp = new int[houseNetWorth.length + 2];
        dp[houseNetWorth.length] = 0;
        dp[houseNetWorth.length + 1] = 0;
        for(int i = houseNetWorth.length - 1; i >= 0; i --) {
            dp[i] = Math.max(houseNetWorth[i] + dp[i + 2], dp[i + 1]);
        }
        return dp[0];
    }
}

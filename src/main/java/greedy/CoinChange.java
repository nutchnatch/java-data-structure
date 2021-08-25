package greedy;

import java.util.*;

public class CoinChange {

    public static void main(String[] args) {
        CoinChange coinChange = new CoinChange();
        int[] coins = {1, 2, 5, 10, 20, 50, 10, 1000};
        int amount = 2035;
        System.out.println("Coins available: " + Arrays.toString(coins));
        System.out.println("Target amount: " + amount);
        coinChange.coinChangeProblem(coins, amount);
    }

    void coinChangeProblem(int[] coins, int N) {
        Arrays.sort(coins);
        int index = coins.length - 1;
        while(true) {
            int coinValue = coins[index];
            index --;
            int maxAmount = (N/coinValue) * coinValue;
            if(maxAmount > 0) {
                System.out.println("Coin value: " + coinValue + " taken account: " + (N/coinValue));
                N = N - maxAmount;
            }
            if(N == 0) {
                break;
            }
        }
    }
}

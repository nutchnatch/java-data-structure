package dynamicprogramming;


public class NumberFactorDP {
    public static void main(String[] args) {
        NumberFactorDP numberFactor = new NumberFactorDP();
        System.out.println(numberFactor.waysToGetNTopDown(4));
        System.out.println(numberFactor.waysToGetNTopDown(5));
        System.out.println(numberFactor.waysToGetNTopDown(6));

        System.out.println();
        System.out.println(numberFactor.waysToGetNBottomUp(4));
        System.out.println(numberFactor.waysToGetNBottomUp(5));
        System.out.println(numberFactor.waysToGetNBottomUp(6));
    }

    public int waysToGetNTopDown(int n) {
        // TODO
        return waysToGetNTopDown(n, new int[n+1]);
    }

    private  int waysToGetNTopDown(int n, int[] dp) {
        if(n == 0 || n == 1 || n == 2) {
            return 1;
        }
        if(n == 3) {
            return 2;
        }
        if(dp[n] == 0) {
            dp[n] = waysToGetNTopDown(n-4, dp) + waysToGetNTopDown(n - 3, dp) + waysToGetNTopDown(n - 1, dp);
        }
        return dp[n];
    }

    public  int waysToGetNBottomUp(int n) {
        return waysToGetNTopDown(n, new int[n+1]);
    }

    private  int waysToGetNBottomUp(int n, int[] dp) {
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 2;
        for(int i = 4; i <= n; i ++) {
            dp[i] = dp[i - 1] + dp[i - 3] + dp[i - 4];
        }
        return dp[n];
    }
}

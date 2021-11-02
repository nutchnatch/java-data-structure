package divideandconquer;

public class MinCostFindLastCell {

    public static void main(String[] args) {
        MinCostFindLastCell minCostFindLastCell = new MinCostFindLastCell();
        int[][] array = {
                {4, 7, 8, 6, 4},
                {6, 7, 3, 9, 2},
                {3, 8, 1, 2, 4},
                {7, 1, 7, 3, 7},
                {2, 9, 8, 9, 3}
        };
        System.out.println(minCostFindLastCell.findMinCost(array, array.length - 1, array[0].length - 1));
        System.out.println(minCostFindLastCell.mincCos(array));
    }

    public int findMinCost(int[][] cost, int row, int col) {
        if(row == -1 || col == -1) {
            return Integer.MAX_VALUE;
        }
        if(row == 0 && col == 0) {
            return cost[0][0];
        }
        int minCost1 = findMinCost(cost, row, col - 1);
        int minCost2 = findMinCost(cost, row - 1, col);
        return cost[row][col] + Math.min(minCost1, minCost2);
    }

    private int minConst(int[][] arr, int id1, int id2) {
        if(id1 == -1 || id2 == -1) {
            return Integer.MAX_VALUE;
        }
        if(id1 == 0 && id2 == 0) {
            return arr[0][0];
        }

        if(id1 == 0) {
            return minConst(arr, 0, id2 - 1);
        }
        if(id2 == 0) {
            return minConst(arr, id1 - 1, 0);
        }

        int op1 = minConst(arr, id1 - 1, id2);
        int op2 = minConst(arr, id1, id2 - 1);
        return Math.min(op1, op2);
    }

    //https://www.algorithmsandme.com/minimum-cost-path-matrix/
    public int mincCos(int[][] arr) {
        int[][] dp = new int[arr.length][arr.length];
        dp[0][0] = arr[0][0];
        for(int i = 1; i < arr.length; i ++) {
            dp[i][0] = dp[i-1][0] + arr[i][0];
        }
        for(int i = 1; i < arr.length; i ++) {
            dp[0][i] = dp[0][i-1] + arr[0][i];
        }
        for(int i = 1; i < arr.length; i ++) {
            for(int j = 1; j < arr.length; j ++) {
                if(dp[i-1][j] < dp[i][j-1]) {
                    dp[i][j] = dp[i-1][j] + arr[i][j];
                } else {
                    dp[i][j] = dp[i][j-1] + arr[i][j];
                }
            }
        }
        return dp[arr.length-1][arr[0].length-1];
    }
}

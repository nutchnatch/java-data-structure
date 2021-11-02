package divideandconquer;

public class NumberOfPathsToReachLastCell {

    public static void main(String[] args) {
        NumberOfPathsToReachLastCell npc = new NumberOfPathsToReachLastCell();
        int[][] array = {
                {4, 7, 1, 6},
                {5, 7, 3, 9},
                {3, 2, 1, 2},
                {7, 1, 6, 3},
        };
        System.out.println(npc.findNumOfPaths(array, array.length - 1, array[0].length - 1, 25));
        System.out.println(npc.npec(array, 25));
    }

    public int findNumOfPaths(int[][] array, int row, int col, int cost) {
        if(cost < 0) {
            return 0;
        }
        if(row == 0 && col == 0) {
            return array[0][0] - cost == 0 ? 1 : 0;
        }
        if(row == 0) {
            return findNumOfPaths(array, 0, col - 1, cost - array[row][col]);
        }
        if(col == 0) {
            return findNumOfPaths(array, row - 1, 0, cost - array[row][col]);
        }
        int opt1 = findNumOfPaths(array, row - 1, col, cost- array[row][col]);
        int opt2 = findNumOfPaths(array, row, col - 1, cost- array[row][col]);
        return opt1 + opt2;
    }


    //Not validated (created by myself)
    //https://www.techiedelight.com/counting-paths-on-grid-to-reach-destination-cell/
    public int npec(int[][] arr, int n) {
        int [][] dp = new int[arr.length][arr.length];
        int r = arr.length;
        int c = arr[0].length;
        int [][] cost = new int[arr.length][arr.length];
        cost[0][0] = arr[0][0];
        dp[0][0] = 0;
//        dp[r-1][c-1] = 1;
//        for(int i = r - 1; i > 0; i--) {
//            for (int j = c - 1; j > 0; j--) {
//                if(arr[i][j] + arr[i-1][j] < n) {
//                    arr[i-1][j] = arr[i-1][j] + arr[i][j];
//                    dp[i-1][j] = dp[i-1][j] + dp[i][j];
//                }
//                if(arr[i][j] + arr[i][j-1] < n) {
//                    arr[i][j-1] = arr[i][j] + arr[i][j-1];
//                    dp[i][j-1] = dp[i-1][j] + dp[i][j-1];
//                }
//            }
//        }

//        for(int i = 0; i < r; i ++) {
//            dp[0][i] = 1;
//        }
//
//        for(int i = 0; i < c; i ++) {
//            dp[i][0] = 1;
//        }

        for(int i = 1; i < arr.length; i ++) {
            cost[i][0] = cost[i-1][0] + arr[i][0];
        }
        for(int i = 1; i < arr.length; i ++) {
            cost[0][i] = cost[0][i-1] + arr[0][i];
        }
//
        for(int i = 1; i < r; i++) {
            for(int j = 1; j < c; j ++) {
                if(cost[i-1][j] < cost[i][j-1] && + arr[i][j] <= n) {
                    cost[i][j] = cost[i-1][j] + arr[i][j];
                    dp[i][j] = 1 + dp[i-1][j];
                }
                else if(cost[i][j-1] + arr[i][j] <= n) {
                    cost[i][j] = cost[i][j-1] + arr[i][j];
                    dp[i][j] = 1 + dp[i][j-1];
                }
            }
        }
        return dp[r-1][c-1];
//        return dp[0][0];
    }
}

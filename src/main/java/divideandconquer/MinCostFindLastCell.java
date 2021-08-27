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
}

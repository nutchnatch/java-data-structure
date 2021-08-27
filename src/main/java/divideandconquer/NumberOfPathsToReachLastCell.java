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
}

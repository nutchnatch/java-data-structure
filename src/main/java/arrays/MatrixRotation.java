package arrays;

import java.util.Arrays;

public class MatrixRotation {

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3}, {4,5,6},{7,8,9}};
        rotateMatrix2(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }

    private static boolean rotateMatrix(int[][] matrix) {
        if(matrix.length == 0 || matrix.length != matrix[0].length) {
            return false;
        }
        int n = matrix.length;
        for(int layer = 0; layer < n / 2; layer ++) {
            int first = layer; // first - is column ref
            int last = n - 1 - layer;
            for(int i = first; i < last; i ++) { // find the lines
                int offset = i - first; //offset - is the difference of the current line, considering the layer
                int top = matrix[first][i];
                matrix[first][i] = matrix[last-offset][first]; //first is ref of the layer
                matrix[last-offset][first] = matrix[last][last-offset];
                matrix[last][last-offset] = matrix[i][last];
                matrix[i][last] = top;
            }
        }
        return true;
    }

    //https://www.youtube.com/watch?v=SA867FvqHrM
    private static boolean rotateMatrix2(int[][] matrix) {
        if(matrix.length == 0 || matrix.length != matrix[0].length) {
            return false;
        }
        int n = matrix.length;
        for(int i = 0; i < n; i ++) {
            for(int j = i; j < n; j ++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }

        for(int i = 0; i < n; i ++) {
            for(int j = 0; j < n/2; j ++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[i][n-1-j];
                matrix[i][n-1-j] = tmp;
            }
        }
        return true;
    }
}

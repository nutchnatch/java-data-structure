package arrays;

public class Permutation {

    public static void main(String[] args) {
        int[] array1 = {1, 2, 3, 5, 4};
        int[] array2 = {4, 3, 2, 5, 1};
        System.out.println(isPermutation(array1, array2));
    }

    private static boolean isPermutation(int[] array1, int[] array2) {
        if(array1.length != array2.length) {
            return false;
        }
        int sum1 = 0;
        int sum2 = 0;
        int mult1 = 1;
        int mult2 = 1;
        for(int i = 0; i < array1.length; i ++) {
            sum1 += array1[i];
            mult1 *= array1[i];
        }
        for(int i = 0; i < array2.length; i ++) {
            sum2 += array2[i];
            mult2 *= array2[i];
        }
        if(sum1 == sum2 && mult1 == mult2) {
            return true;
        }
        return false;
    }
}

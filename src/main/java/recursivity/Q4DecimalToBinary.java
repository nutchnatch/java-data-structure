package recursivity;

import java.util.ArrayList;
import java.util.List;

public class Q4DecimalToBinary {
    private static StringBuilder sb = new StringBuilder();
    private static List<Integer> binList = new ArrayList<Integer>();

    public static void main(String[] args) {
//        intToBin(13);
//        for(int i: binList) {
//            System.out.print(i);
//        }

        System.out.println(intToBin2(13));
    }

    private static int intToBin(int n) {
        if(n == -1) {
            return -1;
        }
        if(n == 0) {
            return 0;
        }
        binList.add(0, n % 2);
        return intToBin(n/2);
    }

    private static int intToBin2(int n) {
        if(n == -1) {
            return -1;
        }
        if(n == 0) {
            return 0;
        }
        return n % 2 + 10 * intToBin2(n/2);
    }
}

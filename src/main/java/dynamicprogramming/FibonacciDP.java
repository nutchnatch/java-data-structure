package dynamicprogramming;

import java.util.*;

public class FibonacciDP {

    public static void main(String[] args) {
        FibonacciDP fibonacciDP = new FibonacciDP();
        System.out.println(fibonacciDP.fibMemo(6, new HashMap<>()));
        System.out.println();
        System.out.println("Fibonacci with tabulation - bottom up");
        System.out.println(fibonacciDP.fibTab(6));
    }

    // fibonacci series with memoization
    public int fibMemo(int n, Map<Integer, Integer> memo) {
        if(n == 0) {
            return 0;
        }
        if(n == 1 || n == 2) {
            return 1;
        }
        if(!memo.containsKey(n)) {
            memo.put(n, fibMemo(n - 1, memo) + fibMemo(n - 2, memo));
        }
        return memo.get(n);
    }

    // fibonacci series with tabulation
    public int fibTab(int n) {
        List<Integer> tb = new ArrayList<>();
        tb.add(0);
        tb.add(1);
        for(int i = 2; i <= n; i ++) {
            tb.add(tb.get(i-1) + tb.get(i-2));
        }
        return tb.get(n);
    }
}

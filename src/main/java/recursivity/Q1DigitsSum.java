package recursivity;

public class Q1DigitsSum {

    public static void main(String[] args) {
        System.out.println(sumDigits(111));
    }

    private static int sumDigits(int n) {
        if(n == 0 || n < 0) {
            return 0;
        }
        return n%10 + sumDigits(n/10);
    }
}

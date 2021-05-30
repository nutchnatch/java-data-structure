package recursivity;

public class Q2Power {

    public static void main(String[] args) {
        System.out.println(power(2, 4));
    }

    private static int power(int x, int n) {
        if(n < 0) {
            return -1;
        }
        if(n == 0) {
            return 1;
        }
        return x * power(x, n-1);
    }
}

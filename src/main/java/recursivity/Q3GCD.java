package recursivity;

public class Q3GCD {

    public static void main(String[] args) {
        System.out.println(gcd(48, 18));
    }

    private static int gcd(int a, int b) {
        if(a < 0 || b < 0) {
            return -1;
        }
        if(b == 0) {
            return a;
        }
//        int tmp = b;
//        b = a % b;
//        a = tmp;
        return gcd(b, a % b);
    }
}

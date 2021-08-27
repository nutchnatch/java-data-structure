package divideandconquer;

public class NumberFactor {

    public static void main(String[] args) {
        NumberFactor numberFactor = new NumberFactor();
        System.out.println(numberFactor.waysToGetN(4));
        System.out.println(numberFactor.waysToGetN(5));
        System.out.println(numberFactor.waysToGetN(6));
    }

    int waysToGetN(int n) {
        if(n == 0 || n == 1 || n == 2) {
            return 1;
        } else if(n == 3) {
            return 2; //{1,1,1} {3}
        }
        return waysToGetN(n - 4) + waysToGetN(n - 3) + waysToGetN(n - 1);
    }
}

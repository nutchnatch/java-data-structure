package divideandconquer;

public class ConvertOneStringToAnother {

    public static void main(String[] args) {
        ConvertOneStringToAnother convertOneStringToAnother = new ConvertOneStringToAnother();
        System.out.println(convertOneStringToAnother.findOperations("table", "tbres"));
//        System.out.println(convertOneStringToAnother.findOperations("catch", "carch"));
    }

    private int findOperations(String s1, String s2, int i1, int i2) {
        if(i1 == s1.length()) {
            return s2.length() - i2;
        }
        if(i2 == s2.length()) {
            return s1.length() - i1;
        }
        if(s1.charAt(i1) == s2.charAt(i2)) {
            return findOperations(s1, s2, i1 + 1, i2 + 1);
        }
        int deleteOp = 1 + findOperations(s1, s2, i1, i2 + 1);
        int insertOp = 1 + findOperations(s1, s2, i1 + 1, i2);
        int replaceOp = 1 + findOperations(s1, s2, i1 + 1, i2 + 1);
        return Math.min(Math.min(deleteOp, insertOp), replaceOp);
    }

    public int findOperations(String s1, String s2) {
        return  findOperations(s1, s2, 0, 0);
    }
}

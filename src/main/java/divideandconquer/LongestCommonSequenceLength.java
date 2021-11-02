package divideandconquer;

public class LongestCommonSequenceLength {
    public static void main(String[] args) {
        LongestCommonSequenceLength longestCommonSequence = new LongestCommonSequenceLength();
        System.out.println(longestCommonSequence.longestCommonSequence("elephant", "erepat"));
    }

    private int longestCommonSequence(String s1, String s2, int i1, int i2) {
        if(i1 == s1.length() || i2 == s2.length()) {
            return 0;
        }
        int c1 = 0;
        if(s1.charAt(i1) == s2.charAt(i2)) {
            c1 = 1 + longestCommonSequence(s1, s2, i1 +1, i2 + 1);
        }
        int c2 = longestCommonSequence(s1, s2, i1, i2 + 1);
        int c3 = longestCommonSequence(s1, s2, i1 + 1, i2);
        return Math.max(c1, Math.max(c2, c3));
    }

    public int longestCommonSequence(String s1, String s2) {
        return longestCommonSequence(s1, s2, 0, 0);
    }
}

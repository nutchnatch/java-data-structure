package divideandconquer;

public class LongestPalindromicSequence {

    public static void main(String[] args) {
        LongestPalindromicSequence lps = new LongestPalindromicSequence();
        System.out.println(lps.longestPalindromicSequence("elrmenmet"));
    }

    private int longestPalindromicSequence(String s, int startIndex, int endIndex) {
        if(startIndex > endIndex) {
            return 0;
        }
        if(startIndex == endIndex) {
            return 1;
        }
        int count1 = 0;
        if(s.charAt(startIndex) == s.charAt(endIndex)) {
            count1 = 2 + longestPalindromicSequence(s, startIndex + 1, endIndex - 1);
        }
        int count2 = longestPalindromicSequence(s, startIndex + 1, endIndex);
        int count3 = longestPalindromicSequence(s, startIndex, endIndex - 1);
        return Math.max(count1, Math.max(count2, count3));
    }

    public int longestPalindromicSequence(String s) {
        return longestPalindromicSequence(s, 0, s.length() - 1);
    }
}

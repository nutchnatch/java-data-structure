package dynamicprogramming;

public class LongestCommonSequenceDP {
    public static void main(String[] args) {
        LongestCommonSequenceDP longestCommonSequence = new LongestCommonSequenceDP();
        longestCommonSequence.longestCommonSequenceBU2("elephant", "erepat");
        System.out.println();
        longestCommonSequence.longestCommonSequenceBU2("ABCBDAB", "BDCABA");
    }

    private void longestCommonSequenceBU2(String s1, String s2) {

        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        for(int i = 0; i <= s1.length(); i ++) {
            for (int j = 0; j <= s2.length(); j++) {
                if(i == 0 || j == 0) {
                    dp[i][j] = 0;
                }
                 else if(s1.charAt(i- 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }

        }

        int index = dp[s1.length()][s2.length()];
        char[] result = new char[index];
        result[index - 1] = '\u0000';

        int i = s1.length();
        int j = s2.length();

        while(i > 0 && j > 0) {
            if(s1.charAt(i - 1) == s2.charAt(j - 1)) {
                result[index - 1] = s1.charAt(i - 1);
                i --;
                j --;
                index --;
            } else if(dp[i - 1][j] > dp[i][j - 1]) {
                i --;
            } else {
                j --;
            }
        }

        for(int k = 0; k < result.length; k ++) {
            System.out.print(result[k]);
        }
    }
}

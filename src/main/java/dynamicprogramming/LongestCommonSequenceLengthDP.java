package dynamicprogramming;

public class LongestCommonSequenceLengthDP {
    public static void main(String[] args) {
        LongestCommonSequenceLengthDP longestCommonSequence = new LongestCommonSequenceLengthDP();
        System.out.println(longestCommonSequence.longestCommonSequence("elephant", "erepat"));
        System.out.println(longestCommonSequence.longestCommonSequenceDP("elephant", "erepat"));
        System.out.println(longestCommonSequence.longestCommonSequenceBU("elephant", "erepat"));
        System.out.println(longestCommonSequence.longestCommonSequenceBU2("elephant", "erepat"));
        System.out.println(longestCommonSequence.longestCommonSequenceBU2("ABCBDAB", "BDCABA"));
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

    public int longestCommonSequenceDP(String s1, String s2) {
        int[][] dp = new int[s1.length()][s2.length()];
        for(int i = 0; i < s1.length(); i ++) {
            for(int j = 0; j < s2.length(); j ++) {
                dp[i][j] = -1;
            }
        }
        return longestCommonSequenceDP(dp, s1, s2, 0 ,0);
    }

    private int longestCommonSequenceDP(int[][] dp, String s1, String s2, int i1, int i2) {
        if(i1 == s1.length() || i2 == s2.length()) {
            return 0;
        }
        if(dp[i1][i2] == -1) {
            if(s1.charAt(i1) == s2.charAt(i2)) {
                dp[i1][i2] = 1 + longestCommonSequenceDP(dp, s1, s2, i1 + 1, i2 + 1);
//                return dp[i1][i2];
            } else {
                int opt1 = longestCommonSequenceDP(dp, s1, s2, i1, i2 + 1);
                int opt2 = longestCommonSequenceDP(dp, s1, s2, i1 + 1, i2);
                dp[i1][i2] = Math.max(opt1, opt2);
            }
        }
        return dp[i1][i2];
    }

    private int longestCommonSequenceBU(String s1, String s2) {

        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        for(int i = s1.length(); i >= 1; i --) {
            for (int j = s2.length(); j >= 1; j--) {
                if(s1.charAt(i- 1) == s2.charAt(j - 1)) {
                    dp[i-1][j-1] = Math.max(1 + dp[i][j], Math.max(dp[i-1][j], dp[i][j-1]));
                } else {
                    dp[i-1][j-1] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }

        }
        return dp[0][0];
    }

    private int longestCommonSequenceBU2(String s1, String s2) {

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
        return dp[s1.length()][s2.length()];
    }
}

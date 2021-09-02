package dynamicprogramming;

public class LongestPalindromicSequenceDP {

    public static void main(String[] args) {
        LongestPalindromicSequenceDP lps = new LongestPalindromicSequenceDP();
//        System.out.println(lps.longestPalindromicSequence("elrmenmet"));
        System.out.println(lps.longestPalindromicSequenceTD("elrmenmet"));
        System.out.println(lps.longestPalindromicSequenceBU("elrmenmet"));
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

    public int longestPalindromicSequenceTD(String s) {
        Integer[][] dp = new Integer[s.length()][s.length()];
        return longestPalindromicSequenceTD(s, 0, s.length() - 1, dp);
    }

    private int longestPalindromicSequenceTD(String s, int startIndex, int endIndex, Integer[][] dp) {

        if(startIndex > endIndex) {
            return  0;
        }
        if(startIndex == endIndex) {
            return  1;
        }
        int count1 = 0;
        if(dp[startIndex][endIndex] == null) {
            if(s.charAt(startIndex) == s.charAt(endIndex)) {
                count1 = 2 + longestPalindromicSequenceTD(s, startIndex + 1, endIndex - 1, dp);
            }
            int count2 = longestPalindromicSequenceTD(s, startIndex + 1, endIndex, dp);
            int count3 = longestPalindromicSequenceTD(s, startIndex, endIndex - 1, dp);
            dp[startIndex][endIndex] = Math.max(count1, Math.max(count2, count3));
        }

        return dp[startIndex][endIndex];
    }

    private int longestPalindromicSequenceBU(String s) {
        int[][] dp = new int[s.length()][s.length()];
        for(int col = 0; col < s.length(); col ++) {
            for(int row = s.length() - 1; row >= 0; row --) {
                if(row > col) {
                    dp[row][col] = 0;
                } else if(col == row) {
                    dp[row][col] = 1;
                } else {
                    if(s.charAt(col) == s.charAt(row)) {
                        dp[row][col] = Math.max(2 + dp[row+1][col-1], Math.max(dp[row][col-1], dp[row+1][col]));
//                        dp[row][col] = 2 + dp[row+1][col-1];
                    } else {
                        int count2 = dp[row+1][col];
                        int count3 = dp[row][col-1];
                        dp[row][col] = Math.max(count2, count3);
                    }
                }
            }
        }
        return dp[0][s.length() - 1];
    }
}

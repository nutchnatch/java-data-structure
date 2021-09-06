package divideandconquer;

public class LongestRepeatedSequence {
    public static void main(String[] args) {
        LongestRepeatedSequence lrs = new LongestRepeatedSequence();
        System.out.println(lrs.longestRepeatedSequence("ATAKTKGGA"));
        System.out.println(lrs.findLongestRepeatingSubSeq("ATAKTKGGA"));
    }

    public int longestRepeatedSequence(String s) {
        return longestRepeatedSequence(s, s.length(), s.length());
    }

    private int longestRepeatedSequence(String s, int i1, int i2) {
        if(i1 == 0 || i2 == 0) {
            return  0;
        }
        int count = 0;
        if(s.charAt(i1 - 1) == s.charAt(i2 - 1) && i1 != i2) {
            count = 1 + longestRepeatedSequence(s, i1 - 1, i2 - 1);
        }
        int count2 = longestRepeatedSequence(s, i1 - 1, i2);
        int count3 = longestRepeatedSequence(s, i1, i2 - 1);
        return Math.max(count, Math.max(count2, count3));
    }

    public int findLongestRepeatingSubSeq(String str)
    {
        int n = str.length();
        int[][] dp = new int[n+1][n+1];

        for (int i=1; i<=n; i++)
        {
            for (int j=1; j<=n; j++)
            {
                if (str.charAt(i-1) == str.charAt(j-1) && i!=j)
                    dp[i][j] =  1 + dp[i-1][j-1];
                else
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
            }
        }
        return dp[n][n];
    }
}

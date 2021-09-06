package dynamicprogramming;

public class LongestPolidromeSubstringDP {
    public static void main(String[] args) {
        LongestPolidromeSubstringDP lps = new LongestPolidromeSubstringDP();
        System.out.println(lps.longestPalindromeBU("babad"));
    }

    public String longestPalindromeBU(String s) {
        int length = s.length();
        String res = s.substring(0, 1);
        for(int i = 0; i < length; i++) {
            // base case (i, i) and (i, i + 1);
            String ps = getPalindrome(s, i, i);
            res = (ps.length() > res.length()) ? ps : res;
            ps = getPalindrome(s, i, i + 1);
            res = (ps.length() > res.length()) ? ps : res;
        }
        return res;
    }

    private String getPalindrome(String s, int l, int r){
        while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)){
            l--;
            r++;
        }
        return s.substring(l + 1, r);
    }
}

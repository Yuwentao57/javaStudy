package algo.jz2;

public class JZJZ97 {
    public static void main(String[] args) {
        Solution97 solution97 = new Solution97();
        String s = "rabbbit", t = "rabbit";
        System.out.println(solution97.numDistinct(s, t));
    }
}


class Solution97 {
    public int numDistinct(String s, String t) {
        if (s == null || t == null || s.length() < t.length()) return 0;
        int m = s.length();
        int n = t.length();
        int[][] dp = new int[m + 1][n + 1];
        //dp[m][n]必须等于1
        for (int i = 0; i <= m; i ++) dp[i][n] = 1;
        for (int i = m - 1; i > -1; i--) {
            for (int j = n - 1; j > -1; j--) {
                if (t.charAt(j) == s.charAt(i)) {
                    dp[i][j] = dp[i + 1][j + 1] + dp[i + 1][j];
                } else {
                    dp[i][j] = dp[i + 1][j];
                }
            }
        }
        return dp[0][0];
    }
}
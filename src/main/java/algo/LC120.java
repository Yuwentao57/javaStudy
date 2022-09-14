package algo;

public class LC120 {
    public static void main(String[] args) {

    }

    public static int triangle(int[][] a) {
        int n = a.length;
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            dp[n - 1][i] = a[n - 1][i];
        }
        for (int i = n - 2; i > -1; --i) {
            for (int j = 0; j <= i; j++) {
                dp[i][j] = Math.min(dp[i + 1][j], dp[i + 1][j + 1]) + a[i][j];
            }
        }
        return dp[0][0];
    }
}

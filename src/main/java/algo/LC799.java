package algo;

public class LC799 {
    public static void main(String[] args) {
        Solution799 solution799 = new Solution799();
        System.out.println(solution799.champagneTower(2, 1, 1));
        System.out.println(solution799.champagneTower(100000009, 33, 17));
    }
}


class Solution799 {
    public double champagneTower(int poured, int query_row, int query_glass) {
        double[][] dp = new double[101][101];
        dp[0][0] = poured;
        for (int i = 0; i < 100; i++) {
            int j = 0;
            for (; j <= i; j++) {
                if (dp[i][j] > 1.00) {
                    double rest = dp[i][j] - 1.00;
                    dp[i][j] = 1.0;
                    dp[i + 1][j] += rest / 2.0;
                    dp[i + 1][j + 1] += rest / 2.0;
                }
            }
        }
        return dp[query_row][query_glass];
    }
}

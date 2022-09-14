package algo.jz2;

public class JZJZ112 {
    public static void main(String[] args) {
        Solution112 solution112 = new Solution112();
        int[][] a = {
                {9, 9, 4},
                {6, 6, 8},
                {2, 1, 1}
        };
        System.out.println(solution112.longestIncreasingPath(a));
    }
}

/**
 * 官方解答，基于有向图更精妙，真是精妙
 */
class Solution112 {
    private int ans = 1;
    int[][] direction = {
            {-1, 0},
            {0, 1},
            {1, 0},
            {0, -1}
    };

    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0 | matrix[0].length == 0) return 0;
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] dp = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (dp[i][j] == 0)
                    dp[i][j] = 1;
                dfsFind(i, j, matrix, dp);
            }
        }
        return ans;
    }

    private void dfsFind(int i, int j, int[][] m, int[][] dp) {
        for (int[] ele : direction) {
            int r = i + ele[0];
            int c = j + ele[1];
            if (r > -1 && r < m.length && c > -1 && c < m[0].length && m[i][j] < m[r][c]) {
                if (dp[r][c] < dp[i][j] + 1) {
                    dp[r][c] = dp[i][j] + 1;
                    ans = Math.max(ans, dp[r][c]);
                    dfsFind(r, c, m, dp);
                }
            }
        }
    }
}

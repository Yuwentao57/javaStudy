package algo.jz2;

import java.util.Arrays;

public class JZJZ107 {
    public static void main(String[] args) {
        Solution107 solution107 = new Solution107();
        int[][] a = {
                {0, 0, 0},
                {0, 1, 0},
                {1, 1, 1}};
        int[][] ans = solution107.updateMatrix(a);
        for (int[] ele : ans) {
            System.out.println(Arrays.toString(ele));
        }
    }
}

/**
 * 这个题解有点巧妙，很巧妙。。。。
 */
class Solution107 {
    int[][] direction = {
            {-1, 0},
            {0, 1},
            {1, 0},
            {0, -1}};
    int row;
    int col;

    public int[][] updateMatrix(int[][] mat) {
        row = mat.length;
        col = mat[0].length;
        int[][] dp = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (mat[i][j] == 1) {
                    continue;
                }
                dfs(mat, dp, i, j);
            }
        }
        return dp;
    }

    public void dfs(int[][] mat, int[][] dp, int r, int c) {
        for (int[] ele : direction) {
            int nr = r + ele[0];
            int nc = c + ele[1];
            if (nr > -1 && nr < row && nc > -1 && nc < col && mat[nr][nc] == 1) {
                if (dp[nr][nc] == 0 || dp[nr][nc] > dp[r][c] + 1) {
                    dp[nr][nc] = dp[r][c] + 1;
                    dfs(mat, dp, nr, nc);
                }
            }
        }
    }
}
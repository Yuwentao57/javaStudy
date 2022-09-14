package algo.jz2;

public class JZJZ40 {
}


class Solution40 {
    public int maximalRectangle(String[] matrix) {
        if (matrix == null || matrix.length < 1) return 0;
        int row = matrix.length;
        int col = matrix[0].length();
        int[][] left = new int[row][col];
        int ans = 0;
        for (int i = 0; i < row; i++) {
            int cnt = 0;
            for (int j = 0; j < col; j++) {
                cnt = matrix[i].charAt(j) == '1' ? cnt + 1 : 0;
                left[i][j] = cnt;
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i].charAt(j) == '0')
                    continue;
                int w = left[i][j];
                int h = 1;
                ans = Math.max(ans, w * h);
                for (int up = i - 1; up > -1; up--) {
                    h += 1;
                    w = Math.min(w, left[up][j]);
                    ans = Math.max(ans, w * h);
                }
            }
        }
        return ans;
    }
}
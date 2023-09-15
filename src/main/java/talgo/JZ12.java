package talgo;

/**
 * @Description TODO
 */
public class JZ12 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        char[][] board = {
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}};
        System.out.println(solution.exist(board, "ABCCED"));

    }

    static class Solution {
        private int[][] director = {
                {-1, 0},//up
                {0, 1}, //right
                {1, 0}, //down
                {0, -1} //left
        };

        public boolean exist(char[][] board, String word) {
            if (board == null) return false;
            int row = board.length;
            int col = board[0].length;
            boolean[][] track = new boolean[row][col];
            for (int i = 0; i < row; i++)
                for (int j = 0; j < col; j++)
                    if (word.charAt(0) == board[i][j] && dfs(board, word, 0, track, i, j))
                        return true;
            return false;
        }

        private boolean dfs(char[][] matrix, String word, int index, boolean[][] track, int i, int j) {
            if (index == word.length() - 1) {
                return true;
            }
            track[i][j] = true;
            int row = matrix.length;
            int col = matrix[0].length;
            for (int k = 0; k < 4; k++) {
                int[] ele = director[k];
                int nr = i + ele[0];
                int nc = j + ele[1];
                if (-1 < nr && nr < row && -1 < nc && nc < col && !track[nr][nc] && matrix[nr][nc] == word.charAt(index + 1)) {
                    if (dfs(matrix, word, index + 1, track, nr, nc))
                        return true;
                }
            }
            track[i][j] = false;
            return false;
        }
    }
}

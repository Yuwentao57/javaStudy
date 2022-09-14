package algo;

public class LC200 {
    public static void main(String[] args) {
        char[][] a = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}};

        char[][] b = {
                {'1', '0', '1', '1', '1'},
                {'1', '0', '1', '0', '1'},
                {'1', '1', '1', '0', '1'}};
        Solution200 solution200 = new Solution200();
        System.out.println(solution200.numIslands(b));
    }
}

class Solution200 {
    private int ans = 0;

    public int numIslands(char[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int[] unionset = new int[row * col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1') {
                    unionset[i * col + j] = i * col + j;
                    ans += 1;
                } else {
                    unionset[i * col + j] = -1;
                }
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '0') continue;
                if (grid[i][j] == '1') {
                    if (i > 0 && grid[i - 1][j] == '1') {
                        unionNode(unionset, (i - 1) * col + j, i * col + j);
                    }
                    if (j < col - 1 && grid[i][j + 1] == '1') {
                        unionNode(unionset, i * col + j + 1, i * col + j);
                    }
                    if (i < row - 1 && grid[i + 1][j] == '1') {
                        unionNode(unionset, (i + 1) * col + j, i * col + j);
                    }
                    if (j > 0 && grid[i][j - 1] == '1') {
                        unionNode(unionset, i * col + j - 1, i * col + j);
                    }
                }
            }
        }
        return ans;
    }

    private void unionNode(int[] a, int p1, int p2) {
        int root = p1;
        while (root != a[root]) {
            root = a[root];
        }

        while (p1 != a[p1]) {
            int t = a[p1];
            a[p1] = root;
            p1 = t;
        }

        root = p2;
        while (root != a[root]) {
            root = a[root];
        }

        while (p2 != a[p2]) {
            int t = a[p2];
            a[p2] = root;
            p2 = t;
        }
        if (p1 != p2) {
            a[p2] = p1;
            ans -= 1;
        }
    }
}
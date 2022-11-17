package algo.jz2;

public class LC200 {
    public static void main(String[] args) {
        Solution200 solution200 = new Solution200();

    }


}


class Solution200 {
    int[] unionarr;
    int nums;
    int[][] direction = {
            {-1, 0},
            {0, 1},
            {1, 0},
            {0, -1}};

    public int numIslands(char[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        unionarr = new int[row * col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                unionarr[i * col + j] = -1;
                if (grid[i][j] == '1') {
                    unionarr[i * col + j] = i * col + j;
                    nums += 1;
                }
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1') {
                    dfsunion(i ,j, grid);
                }
            }
        }
        return nums;
    }

    private void dfsunion(int i, int j, char[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        for (int[] d : direction) {
            if (-1 < i + d[0] && i + d[0] < row && -1 < j + d[1] && j + d[1] < col && grid[i + d[0]][j + d[1]] == '1') {
                int ll = i * col + j;
                int rr = (i + d[0]) * col + j + d[1];

                if (find(ll) == find(rr)) continue;
                union(ll, rr);
                dfsunion(i + d[0], j + d[1], grid);
            }
        }
    }

    private void union(int l, int r) {
        int lr = find(l);
        int rr = find(r);
        if (lr == rr) return;
        nums -= 1;
        unionarr[r] = lr;
    }

    private int find(int root) {
        while (unionarr[root] != root) {
            root = unionarr[root];
        }
        return root;
    }
}
package algo;

import java.util.*;

public class LC864 {
}

class Solution {
    public int shortestPathAllKeys(String[] grid) {
        int[][] direction = {
                {-1, 0},
                {0, 1},
                {1, 0},
                {0, -1}
        };
        int limit = 10;
        int INF = 0x3f3f3f3f;
        Map<Character, Integer> keyPosMap = new HashMap<>();
        int[][][] dp = new int[30][30][1 << limit];
        Deque<int[]> deque = new ArrayDeque<>();
        int rows = grid.length;
        int cols = grid[0].length();
        int keys = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                Arrays.fill(dp[i][j], INF);
                if (grid[i].charAt(j) == '@') {
                    deque.add(new int[]{i, j, 0});
                } else if (Character.isLowerCase(grid[i].charAt(j))) {
                    keyPosMap.put(grid[i].charAt(j), keys++);
                }
            }
        }

        dp[deque.peek()[0]][deque.peek()[1]][deque.peek()[2]] = 0;
        while (!deque.isEmpty()) {
            int[] ele = deque.pollFirst();
            int x = ele[0], y = ele[1], m = ele[2];
            for (int[] cell : direction) {
                int nx = x + cell[0];
                int ny = y + cell[1];
                if (!(nx > -1 && nx < rows && ny > -1 && ny < cols)) {
                    continue;
                }
                if (grid[nx].charAt(ny) == '#') continue;

                if (grid[nx].charAt(ny) == '.' || grid[nx].charAt(ny) == '@') {
                    if (dp[nx][ny][m] > dp[x][y][m] + 1) {
                        dp[nx][ny][m] = dp[x][y][m] + 1;
                        deque.add(new int[]{nx, ny, m});
                    }
                } else if (Character.isLowerCase(grid[nx].charAt(ny))) {
                    int bitleft = keyPosMap.get(grid[nx].charAt(ny));
                    if (dp[nx][ny][m | 1 << bitleft] > dp[x][y][m] + 1) {
                        dp[nx][ny][m | 1 << bitleft] = dp[x][y][m] + 1;
                        deque.add(new int[]{nx, ny, m | 1 << bitleft});
                    }
                    if ((m | 1 << bitleft) == (1 << keys) - 1) return dp[nx][ny][m | 1 << bitleft];
                } else {
                    if ((m & 1 << keyPosMap.get(Character.toLowerCase(grid[nx].charAt(ny)))) != 0) {
                        if (dp[nx][ny][m] > dp[x][y][m] + 1) {
                            dp[nx][ny][m] = dp[x][y][m] + 1;
                            deque.add(new int[]{nx, ny, m});
                        }
                    }
                }
            }
        }
        return -1;
    }

}

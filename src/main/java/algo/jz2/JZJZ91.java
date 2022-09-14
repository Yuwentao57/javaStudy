package algo.jz2;

import java.util.Arrays;

public class JZJZ91 {
    public static void main(String[] args) {
        Solution91 solution91 = new Solution91();
        int[][] a = {{20,18,4},{9,9,10}};
        int[][] b = {{5,8,6},{19,14,13},{7,5,12},{14,15,17},{3,20,10}};
        System.out.println(solution91.minCost(b));
    }
}

class Solution91 {
    int mincost = Integer.MAX_VALUE;
    int[][] cr;

    public int minCost2(int[][] costs) {
        cr = costs;
        dfs(1, 0, costs[0][0]);
        dfs(1, 1, costs[0][1]);
        dfs(1, 2, costs[0][2]);
        return mincost;
    }

    private void dfs(int n, int ci, int tc) {
        if (n >= cr.length) {
            mincost = Math.min(mincost, tc);
            return;
        }
        ci = (ci + 1) % 3;
        dfs(n + 1, ci, tc + cr[n][ci]);

        ci = (ci + 1) % 3;
        dfs(n + 1, ci, tc + cr[n][ci]);
    }

    class Solution {
        public int minCost(int[][] costs) {
            int n = costs.length;
            int[] dp = new int[3];
            for (int j = 0; j < 3; j++) {
                dp[j] = costs[0][j];
            }
            for (int i = 1; i < n; i++) {
                int[] dpNew = new int[3];
                for (int j = 0; j < 3; j++) {
                    dpNew[j] = Math.min(dp[(j + 1) % 3], dp[(j + 2) % 3]) + costs[i][j];
                }
                dp = dpNew;
            }
            return Arrays.stream(dp).min().getAsInt();
        }
    }

    //算法错误、、、、、、、、、、、、、、、、、、、、、、、、、

    /**
     * 不应该使用DP来保存每间房的选择颜色，这样会存在一种漏算的可能，比如
     * @param costs
     * @return
     */
    public int minCost(int[][] costs) {
        int houses = costs.length;
        int choice = costs[0].length;
        int[][] dp = new int[houses][3];
        for (int i = 0; i < 3; i ++) {
            dp[0][i] = costs[0][i];
        }
        for (int i = 1; i < houses; i++) {
            for (int j = 0; j < choice; j ++) {
                dp[i][j] = Math.min(dp[i - 1][(j + 1) % choice], dp[i - 1][(j + 2) % choice]) + costs[i - 1][j];
            }
        }
        return Arrays.stream(dp[houses - 1]).min().getAsInt();
    }

}
package algo.mg;

/**
 * 不含62，或者 4
 */
public class BitDP {
    int BITS = 13;
    int[][] dp = new int[BITS][2];
    int[] a;

    public int dfs(int pos, int status, int pre, boolean limit) {
        if (pos == -1) return 1;
        if (!limit && dp[pos][status] != 0) return dp[pos][status];
        int temp = 0;
        int up = limit ? a[pos] : 9;
        for (int i = 0; i <= up; i++) {
            if (i == 4) continue;
            if (i == 2 && pre == 6) continue;
            temp += dfs(pos - 1, i == 6 ? 1 : 0, i, limit && i == up);
        }

        if (!limit) dp[pos][status] = temp;
        return temp;
    }

    public int solve(int n) {
        a = new int[BITS];
        int p = 0;
        while (n > 0) {
            a[p++] = n % 10;
            n /= 10;
        }
        return dfs(p - 1, 0, -1, true);
    }
}

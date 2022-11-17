package algo;

public class LC600 {
    public static void main(String[] args) {
        Solution600 solution600 = new Solution600();
        System.out.println(solution600.findIntegers(5));
    }
}

class Solution600 {
    public int findIntegers(int n) {
        return solve(n);
    }

    int BITS = 32;
    int[][] dp = new int[BITS][2];
    int[] a;

    public int dfs(int pos, int status, int pre, boolean limit) {
        if (pos == -1) return 1;
        if (!limit && dp[pos][status] != 0) return dp[pos][status];
        int temp = 0;
        int up = limit ? a[pos] : 1;
        for (int i = 0; i <= up; i++) {
            if (i == 1 && pre == 1) continue;
            temp += dfs(pos - 1, i == 1 ? 1 : 0, i, limit && i == up);
        }

        if (!limit) dp[pos][status] = temp;
        return temp;
    }

    public int solve(int n) {
        a = new int[BITS];
        int p = 0;
        while (n > 0) {
            a[p++] = (n & 1);
            n = (n >> 1);
        }
        return dfs(p - 1, 0, -1, true);
    }

}

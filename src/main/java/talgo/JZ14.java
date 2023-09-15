package talgo;

import java.util.Arrays;

/**
 * @Description TODO
 */
public class JZ14 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.cuttingRope(120));
    }

    static class Solution {
        /**
         * 这道题不能采用动态规划，以为即使是long类型也会越界，
         * 同时MOD不满足交换律
         * MOD 和 MAX 不满足交换律，如： MAX(6 % 8, 9 % 8) = MAX(6, 1) = 6，而 MAX(6, 9) % 8 = 9 % 8 = 1，交换后的结果发生了改变。
         * @param n
         * @return
         */

        //学习高等数学，大数定律
        public int cuttingRope(int n) {
            if (n < 3) return 1;
            if (n == 3) return 2;
            long MOD = 1000000007;
            long[] dp = new long[n + 1];
            dp[1] = 1L;
            dp[2] = 2L;
            dp[3] = 3L;
            for (int i = 4; i < n + 1; i++) {
                for (int j = 1; j < i / 2 + 1; j++) {
                    long ans = dp[j] * dp[i - j];
                    dp[i] = Math.max(dp[i], ans % MOD);
                }
            }
            return (int)dp[n];
        }

    }
}

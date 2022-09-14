package algo.jz2;

import java.util.Arrays;
import java.util.HashMap;

public class JZJZ102 {
    public static void main(String[] args) {
        Solution102 solution102 = new Solution102();
        System.out.println(solution102.findTargetSumWays(new int[]{0, 0, 0, 0, 0, 0, 0, 0, 1}, 1));
        int[] a = {2, 107, 109, 113, 127, 131, 137, 3, 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 47, 53};
        System.out.println(solution102.findTargetSumWays(a, 1000));
    }
}

class Solution102 {
    public int findTargetSumWays(int[] nums, int target) {
        if (nums == null) return 0;
        int sum = Arrays.stream(nums).sum();
        if (((sum - target) & 1) == 1 || sum < target) return 0;
        int row = nums.length;
        int neg = (sum - target) / 2;
        int[] dp = new int[neg + 1];
        dp[0] = 1;
        for (int i = 1; i <= row; i++) {
            for (int j = neg; j >= 0; j--) {
                if (j < nums[i - 1]) {
                    dp[j] = dp[j];
                } else {
                    dp[j] = dp[j] + dp[j - nums[i - 1]];
                }
            }
        }
        return dp[neg];
    }


    public int findTargetSumWays2(int[] nums, int target) {
        if (nums == null) return 0;
        int sum = Arrays.stream(nums).sum();
        if (((sum - target) & 1) == 1 || sum < target) return 0;
        int row = nums.length;
        int neg = (sum - target) / 2;
        int[][] dp = new int[row + 1][neg + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= row; i++) {
            for (int j = 0; j <= neg; j++) {
                if (j < nums[i - 1]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - nums[i - 1]];
                }
            }
        }
        return dp[row][neg];
    }

    public int findTargetSumWays3(int[] nums, int target) {
        if (nums == null) return 0;
        HashMap<Integer, Integer> cache = new HashMap<>();
        cache.put(nums[0], 1);
        cache.put(-nums[0], cache.getOrDefault(-nums[0], 0) + 1);
        for (int i = 1; i < nums.length; i++) {
            HashMap<Integer, Integer> nc = new HashMap<>();
            for (Integer key : cache.keySet()) {
                if (nums[i] == 0) {
                    nc.put(key, cache.get(key) * 2);
                    continue;
                }
                nc.put(key + nums[i], nc.getOrDefault(key + nums[i], 0) + cache.get(key));
                nc.put(key - nums[i], nc.getOrDefault(key - nums[i], 0) + cache.get(key));
            }
            cache = nc;
        }
        return cache.getOrDefault(target, 0);
    }


}

package algo;

public class LC300 {
    public static void main(String[] args) {
        Solution300 solution300 = new Solution300();
        int[] a = {10, 9, 2, 5, 3, 7, 101, 18};
        int[] b = {0, 1, 0, 3, 2, 3};
        System.out.println(solution300.lengthOfLIS(b));
    }
}


class Solution300 {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int len = nums.length;
        int ans = 1;
        int[] dp = new int[len];
        for (int i = 0; i < len; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j])
                    dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}
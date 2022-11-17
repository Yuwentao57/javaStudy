package algo;

public class LC801 {
    public static void main(String[] args) {
        int[] a = {0, 4, 4, 5, 9};
        int[] b = {0, 1, 6, 8, 10};
        Solution801 solution801 = new Solution801();
        System.out.println(solution801.minSwap(a, b));
    }
}


class Solution801 {
    public int minSwap(int[] nums1, int[] nums2) {
        int len = nums1.length;
        int[][] dp = new int[len][2];
        dp[0][0] = 0;
        dp[0][1] = 1;
        for (int i = 1; i < len; i++) {
            boolean c1 = nums1[i] > nums1[i - 1] && nums2[i] > nums2[i - 1];
            boolean c2 = nums1[i] > nums2[i - 1] && nums2[i] > nums1[i - 1];
            if (c1) {
                dp[i][0] = dp[i - 1][0];
                dp[i][1] = dp[i - 1][1] + 1;
            }
            if (c2) {
                dp[i][0] = c1 ? Math.min(dp[i - 1][0], dp[i - 1][1]) : dp[i - 1][1];
                dp[i][1] = c1 ? Math.min(dp[i - 1][1], dp[i - 1][0]) + 1 : dp[i - 1][0] + 1;
            }
        }
        return Math.min(dp[len - 1][0], dp[len - 1][1]);
    }
}

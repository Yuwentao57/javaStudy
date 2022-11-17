package algo.jz2;

public class JZJZ89 {
    public static void main(String[] args) {
        Solution89 solution89 = new Solution89();
        int[] a = {2,7,9,3,1};
        System.out.println(solution89.rob(a));
    }
}


class Solution89 {
    public int rob(int[] nums) {
        int len = nums.length;
        int preNO = 0, preYes = 0, tNo = 0, tYes = 0;
        for (int i = 0; i < len; i++) {
            tNo = Math.max(preNO, preYes);
            tYes = nums[i] + preNO;
            preNO = tNo;
            preYes = tYes;
        }
        return Math.max(preNO, preYes);
    }

    public int rob2(int[] nums) {
        int len = nums.length;
        int preNO = 0, preYes = 0;
        int[][] dp = new int[len][2];
        dp[0][0] = 0;
        dp[0][1] = nums[0];
        for (int i = 1; i < len; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
            dp[i][1] = nums[i] + dp[i - 1][0];
        }
        return Math.max(dp[len - 1][0], dp[len - 1][1]);
    }
}

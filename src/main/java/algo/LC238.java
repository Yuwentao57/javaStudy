package algo;

public class LC238 {
}

class Solution238 {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] ans = new int[len];
        int pre = 1;
        for (int i = len - 1; i > 0; i--) {
            pre = nums[i] * pre;
            ans[i] = pre;
        }
        ans[0] = pre;
        pre = nums[0];
        for (int i = 1; i < len - 1; i ++) {
            ans[i] = pre * ans[i + 1];
            pre *= nums[i];
        }
        ans[len - 1] = pre;
        return ans;
    }
}
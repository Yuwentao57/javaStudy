package algo.jz2;

public class JZJZ90 {
    public static void main(String[] args) {

    }

}



class Solution {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        int len = nums.length;
        int s0 = 0, e0 = len - 1;
        int s1 = 1, e1 = len;
        int f1 = fuc(nums, s0, e0);
        int f2 = fuc(nums, s1, e1);
        return Math.max(f1, f2);
    }

    public int fuc(int[] nums, int s, int e) {
        int preNO = 0, preYes = 0, tNo = 0, tYes = 0;
        for (int i = s; i < e; i++) {
            tNo = Math.max(preNO, preYes);
            tYes = nums[i] + preNO;
            preNO = tNo;
            preYes = tYes;
        }
        return Math.max(preNO, preYes);
    }
}

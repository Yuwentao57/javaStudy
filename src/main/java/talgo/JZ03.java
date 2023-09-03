package talgo;

/**
 * @Description TODO
 */
public class JZ03 {
    public static void main(String[] args) {
        Solution solution = new Solution();

    }

    static class Solution {
        public int findRepeatNumber(int[] nums) {
            if (nums == null || nums.length < 2) return 0;
            int len = nums.length;
            int i = 0;
            int temp = -1;
            while (i < len) {
                if(i == nums[i]) {
                    i += 1;
                } else {
                    temp = nums[nums[i]];
                    if (temp == nums[i]) return nums[i];
                    nums[nums[i]] = nums[i];
                    nums[i] = temp;
                }
            }
            return -1;
        }
    }
}

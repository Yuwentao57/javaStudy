package talgo;

/**
 * @Description TODO
 */
public class JZ21 {
    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {
        public int[] exchange(int[] nums) {
            int l = 0;
            int r = nums.length - 1;
            while (l < r) {
                while (l < r && (nums[l] & 1) == 1) l += 1;
                while (l < r && (nums[r] & 1) == 0) r-= 1;
                if (l >= r) break;
                int t = nums[r];
                nums[r] = nums[l];
                nums[l] = t;
            }
            return nums;
        }
    }
}

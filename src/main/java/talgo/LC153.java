package talgo;

/**
 * @Description TODO
 */
public class LC153 {
    public static void main(String[] args) {
        Solution solution = new Solution();

    }

    static class Solution {
        public int findMin(int[] nums) {
            if (nums == null) return -1;
            int l = 0;
            int r = nums.length - 1;
            while (l < r) {
                int mid = (l + r) >> 1;
                if (nums[mid] > nums[r]){
                    l = mid + 1;
                } else {
                    r = mid;
                }
            }
            return nums[l];
        }
    }
}

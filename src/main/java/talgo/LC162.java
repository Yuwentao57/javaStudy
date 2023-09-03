package talgo;

/**
 * @Description TODO
 */
public class LC162 {
    public static void main(String[] args) {
        Solution solution = new Solution();

    }

    static class Solution {
        public int findPeakElement(int[] nums) {
            if (nums == null) return -1;
            int l = 0, r = nums.length - 1;
            while (l < r) {
                int mid = (l + r) >> 1;
                int ml = mid - 1 > -1 ? nums[mid - 1] : Integer.MIN_VALUE;
                int mr = mid + 1 < nums.length ? nums[mid + 1] : Integer.MIN_VALUE;
                if (nums[mid] > ml && nums[mid] > mr) {
                    return mid;
                } else if (mr > nums[mid]) {
                    l = mid + 1;
                } else {
                    r = mid;
                }
            }
            return nums[l];
        }
    }
}

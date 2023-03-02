package algonew;

/**
 * @Description 35. 搜索插入位置
 */
public class LC36 {
    public static void main(String[] args) {
        Solution solution = new Solution();

    }

    static class Solution {
        public int searchInsert(int[] nums, int target) {
            if (nums == null || nums.length < 1) return 0;
            int l = 0;
            int r = nums.length - 1;
            while (l <= r) {
                int mid = (l + r) / 2;
                if (nums[mid] == target) {
                    return mid;
                } else if (nums[mid] > target) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }
            return l;
        }
    }
}

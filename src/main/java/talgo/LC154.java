package talgo;

/**
 * @Description TODO
 */
public class LC154 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.findMin(new int[]{2,2,2,0,1});
    }

    static class Solution {
//        [2,2,2,0,1]
        public int findMin(int[] nums) {
            if (nums == null) return -1;
            int l = 0;
            int r = nums.length - 1;
            while (l < r) {
                int mid = (l + r) >> 1;
                if (nums[mid] > nums[r]) {
                    l = mid + 1;
                } else if (nums[mid] < nums[r]) {
                    r = mid;
                } else {
                    int t = l;
                    for (int i = l + 1; i < r; i++) {
                        if (nums[i] > nums[t]) t = i;
                    }
                    return nums[t];
                }
            }
            return nums[l];
        }
    }
}

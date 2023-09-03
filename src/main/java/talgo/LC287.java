package talgo;

/**
 * @Description TODO
 */
public class LC287 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int a[] = {2,2,2,4,4};
        System.out.println(solution.findDuplicate(a));
    }

    static class Solution {
        public int findDuplicate(int[] nums) {
            if (nums == null || nums.length < 2) return -1;
            int l = 1;
            int r = nums.length - 1;

            while (l < r) {
                int mid = (l + r) >> 1;
                int lc = coutGap(nums, l, mid);
                if (lc > mid - l + 1) {
                    r = mid;
                } else {
                    l = mid + 1;
                }

            }
            return l;
        }

        private int coutGap(int[] nums, int l, int r) {
            int ans = 0;
            for (int t : nums) {
                if (t >= l && t <= r) ans += 1;
            }
            return ans;
        }
    }
}

package algo;

public class LC153 {
    public static void main(String[] args) {
        Solution153 solution153 = new Solution153();
        int[] a = {3,1,2};
        System.out.println(solution153.findMin(a));
    }
}


class Solution153 {
    /**
     * 比价右侧
     * @param nums
     * @return
     */
    public int findMin(int[] nums) {
        if (nums.length == 1) return nums[0];
        int len = nums.length;
        if (nums[0] < nums[len - 1]) return nums[0];
        int l = 0;
        int r = len - 1;
        while (l < r) {
            int mid = (l + r) >> 1;
            if (nums[mid] < nums[r]) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return nums[l];
    }



    /**
     * 这个算法我是比较左侧
     * @param nums
     * @return
     */
    public int findMin2(int[] nums) {
        if (nums.length == 1) return nums[0];
        int len = nums.length;
        if (nums[0] < nums[len - 1]) return nums[0];
        int l = 0;
        int r = len - 1;
        while (l < r) {
            int mid = (l + r) >> 1;
            if (nums[mid] >= nums[l]) {
                l = mid + 1;
            } else {
                r = mid;
            }
            if (l > 0 && nums[l] < nums[l - 1]) {
                break;
            }
        }
        return nums[l];
    }
}

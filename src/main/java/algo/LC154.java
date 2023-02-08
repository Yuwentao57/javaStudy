package algo;

public class LC154 {
    public static void main(String[] args) {
        Solution154 solution154 = new Solution154();
        int[] a = {3,3,1,3};
        System.out.println(solution154.findMin(a));
    }
}


class Solution154 {
    public int findMin(int[] nums) {
        if (nums.length == 1) return nums[0];
        return binaryFind(nums, 0, nums.length - 1);
    }

    private int binaryFind(int[] nums, int l, int r) {
        if (l == r) {
            return nums[l];
        }
        while (l < r) {
            int mid = (l + r) >> 1;
            if (nums[mid] == nums[l] && nums[mid] == nums[r]) {
                int b1 = binaryFind(nums, l, mid);
                int b2 = binaryFind(nums, mid + 1, r);
                return Math.min(b1, b2);
            } else if (nums[mid] <= nums[r]) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return nums[l];
    }
}

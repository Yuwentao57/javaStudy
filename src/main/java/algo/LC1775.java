package algo;

import java.util.Arrays;

public class LC1775 {
    public static void main(String[] args) {
        Solution1775 solution1775 = new Solution1775();
        int[] a = {1, 1, 2, 2, 2, 2};
        int[] b = {1, 2, 3, 4, 5, 6};

        int[] c = {6, 6};
        int[] d = {1};
        System.out.println(solution1775.minOperations(a, b));
        System.out.println(solution1775.minOperations(c, d));
    }
}


class Solution1775 {
    public int minOperations(int[] nums1, int[] nums2) {
        if (nums1.length < nums2.length && nums1.length * 6 < nums2.length) return -1;
        if (nums2.length < nums1.length && nums2.length * 6 < nums1.length) return -1;
        int s1 = Arrays.stream(nums1).sum();
        int s2 = Arrays.stream(nums2).sum();
        if (s1 == s2) return 0;
        int t;
        int[] a;
        int ans = 0;
        if (s1 < s2) {
            a = nums2;
            t = s2;
            s2 = s1;
            nums2 = nums1;
            s1 = t;
            nums1 = a;
        }
        int[] cnt1 = new int[6];
        int[] cnt2 = new int[6];
        for (int ele : nums1) {
            cnt1[ele - 1] += 1;
        }
        for (int ele : nums2) {
            cnt2[ele - 1] += 1;
        }
        int gap, g1, g2;
        gap = s1 - s2;
        while (gap != 0) {
            ans += 1;
            g1 = 0;
            g2 = 0;
            int i = cnt1.length - 1;
            for (; i > 0; i--) {
                if (cnt1[i] > 0) {
                    g1 = Math.min(i, gap);
                    break;
                }
            }
            int j = 0;
            for (; j < cnt2.length - 1; j++) {
                if (cnt2[j] > 0) {
                    g2 = Math.min(5 - j, gap);
                    break;
                }
            }
            if (g1 >= g2) {
                gap -= g1;
                cnt1[i - g1] += 1;
                cnt1[i] -= 1;
            } else {
                gap -= g2;
                cnt2[j + g2] += 1;
                cnt2[j] -= 1;
            }
        }
        return ans;
    }
}

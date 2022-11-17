package algo;

import java.util.Arrays;

public class LC17 {
    public static void main(String[] args) {
        Solution17 solution17 = new Solution17();
        int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21,
                22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40,
                41, 42, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60,
                61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 80,
                81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99, 100};
        int[] b = {1, 2, 3, 4, 5, 6, 7};
//        int aa = 6;
//        int bb = 4;
//        aa ^= bb;
//        System.out.println(aa);
        System.out.println(Arrays.toString(solution17.missingTwo(a)));
        System.out.println(Arrays.toString(solution17.missingTwo(b)));
    }
}


class Solution17 {
    public int[] missingTwo(int[] nums) {
        int cnt = nums.length + 2;
        int xor = 0;
        for (int ele : nums) {
            xor ^= ele;
        }

        for (int i = 1; i < cnt + 1; i ++) {
            xor ^= i;
        }

        int last1 = xor & -xor;

        int xor1 = 0, xor2 = 0;
        for (int ele : nums) {
            if ((ele & last1) == 0) {
                xor1 ^= ele;
            } else {
                xor2 ^= ele;
            }
        }

        for (int i = 1; i < cnt + 1; i ++) {
            if ((i & last1) == 0) {
                xor1 ^= i;
            } else {
                xor2 ^= i;
            }
        }
        int[] ans = new int[2];
        ans[0] = xor1;
        ans[1] = xor2;
        return ans;
    }

    public int[] missingTwo2(int[] nums) {
        int cnt = nums.length + 2;
        long sum1 = (long) (1 + cnt) * cnt / 2;
        long sum2 = 0;
        long acc1 = 1;
        long acc2 = 1;
        for (int i = 1; i < cnt + 1; i++) {
            acc1 *= i;
        }
        for (int ele : nums) {
            sum2 += ele;
            acc2 *= ele;
        }
        sum1 = sum1 - sum2;
        acc1 = acc1 / acc2;
        int[] ans = new int[2];
        ans[0] = (int) ((sum1 + (int) Math.sqrt(sum1 * sum1 - 4 * acc1)) / 2);
        ans[1] = (int) (sum1 - ans[0]);
        return ans;
    }
}
package algo;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LC805 {
}


class Solution805 {
    /**
     * 背包，很独特的思路
     *
     * @param nums
     * @return
     */
    public boolean splitArraySameAverage(int[] nums) {
        if (nums == null || nums.length < 2) return false;

        int midLen = nums.length / 2;
        int sum = Arrays.stream(nums).sum();
        for (int i = 1; i <= midLen; i++) {
            if (sum * i % nums.length != 0) {
                return false;
            }
        }

        Set<Integer>[] dp = new HashSet[midLen + 1];
        for (int i = 0; i <= midLen; i++) {
            dp[i] = new HashSet<Integer>();
        }
        dp[0].add(0);
        for (int ele : nums) {
            for (int i = midLen; i > -1; i--) {
                for (Integer k : dp[i - 1]) {
                    int temp  = k + ele;
                    if (temp * nums.length == sum * i) {
                        return true;
                    }
                    dp[i].add(temp);
                }
            }

        }
        return false;
    }


    public boolean splitArraySameAverage2(int[] nums) {
        if (nums == null || nums.length < 2) return false;
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] * nums.length;
        }

        int sum = Arrays.stream(nums).sum();
        int avg = sum / nums.length;
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] - avg;
        }
        int midLen = nums.length / 2;
        Set<Integer> sets = new HashSet<>();
        for (int i = 1; i < (1 << midLen); i++) {
            int temp = 0;
            for (int j = 0; j < midLen; j++) {
                if ((i & 1 << j) != 0) {
                    temp += nums[j];
                }
            }
            if (temp == 0) return true;
            sets.add(temp);
        }
        int right = 0;
        for (int i = midLen; i < nums.length; i++) {
            right += nums[i];
        }

        for (int i = 1; i < (1 << (nums.length - midLen)); i++) {
            int temp = 0;
            for (int j = midLen; j < nums.length; j++) {
                if ((i & 1 << (j - midLen)) != 0) {
                    temp += nums[j];
                }
            }
            if (temp == 0 || right != temp && sets.contains(-temp)) return true;
        }
        return false;
    }
}

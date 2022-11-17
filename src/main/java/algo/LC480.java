package algo;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class LC480 {
    public static void main(String[] args) {
        Solution480 solution480 = new Solution480();
        int[] a = {-2147483648, -2147483648, 2147483647, -2147483648, -2147483648, -2147483648, 2147483647, 2147483647, 2147483647, 2147483647, -2147483648, 2147483647, -2147483648};
        System.out.println(Arrays.toString(solution480.medianSlidingWindow(a, 3)));

    }
}

class Solution480 {
    public double[] medianSlidingWindow(int[] nums, int k) {
        double[] ans = new double[nums.length - k + 1];
        PriorityQueue<Integer> big = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                long ans = o2.longValue() - o1.longValue();
                if (ans > 0) return 1;
                else if (ans < 0) return -1;
                else return 0;
            }
        });
        PriorityQueue<Integer> small = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                long ans = o1.longValue() - o2.longValue();
                if (ans > 0) return 1;
                else if (ans < 0) return -1;
                else return 0;
            }
        });
        for (int i = 0; i < k; i++) {
            if (i < k / 2) {
                small.add(nums[i]);
            } else {
                small.add(nums[i]);
                big.add(small.poll());
            }
        }
        double t = (k & 1) == 1 ? (double) big.peek() : ((double) small.peek() + (double) big.peek()) / 2;
        ans[0] = t;
        for (int i = k; i < nums.length; i++) {
            small.add(nums[i]);
            big.add(small.poll());
            if (nums[i - k] <= big.peek()) {
                big.remove(nums[i - k]);
            } else {
                small.remove(nums[i - k]);
                small.add(big.poll());
            }
            t = (k & 1) == 1 ? (double) big.peek() : ((double) small.peek() + (double) big.peek()) / 2;
            ans[i - k + 1] = t;
        }
        return ans;
    }
}

//[-2147483648.0,-2147483648.0,-2147483648.0,-2147483648.0,-2147483648.0,2147483647.0,2147483647.0,2147483647.0,2147483647.0,2147483647.0,-2147483648.0];
//[-2.147483648E9, -2.147483648E9, -2.147483648E9, -2.147483648E9, -2.147483648E9, -2.147483648E9, 2.147483647E9, 2.147483647E9, 2.147483647E9, 2.147483647E9, 2.147483647E9]

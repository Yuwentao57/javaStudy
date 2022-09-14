package algo.jz2;

import java.util.ArrayDeque;
import java.util.Deque;

public class JZJZ39 {
    public static void main(String[] args) {
        Solution39 solution39 = new Solution39();
        int[] a = {1, 1, 0, 3};
        System.out.println(solution39.largestRectangleArea(a));
    }
}

class Solution39 {


    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length < 1) return 0;
        int ans = 0;
        int cnt = heights.length;
        int[] left = new int[cnt];
        int[] right = new int[cnt];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < cnt; i++) {
            right[i] = cnt;
            while (!stack.isEmpty() && heights[stack.getLast()] >= heights[i]) {
                right[stack.removeLast()] = i;
            }
            left[i] = stack.isEmpty() ? -1 : stack.getLast();
            stack.add(i);
        }
        for (int i = 0; i < cnt; i ++) {
            ans = Math.max(ans, heights[i] * (right[i] - left[i] - 1));
        }
        return ans;
    }


    /**
     * 枚举高度
     *
     * @param heights
     * @return
     */
    public int largestRectangleArea2(int[] heights) {
        if (heights == null || heights.length < 1) return 0;
        int ans = 0;
        int cnt = heights.length;
        int[] left = new int[cnt];
        int[] right = new int[cnt];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < cnt; i++) {
            while (!stack.isEmpty() && heights[stack.getLast()] >= heights[i]) {
                stack.removeLast();
            }
            left[i] = stack.isEmpty() ? -1 : stack.getLast();
            stack.add(i);
        }

        stack.clear();
        for (int i = cnt - 1; i > -1; i--) {
            while (!stack.isEmpty() && heights[stack.getLast()] >= heights[i]) {
                stack.removeLast();
            }
            right[i] = stack.isEmpty() ? cnt : stack.getLast();
            stack.add(i);
        }
        for (int i = 0; i < cnt; i ++) {
            ans = Math.max(ans, heights[i] * (right[i] - left[i] - 1));
        }
        return ans;
    }


    /**
     * 枚举宽，但是这个方法很笨拙
     *
     * @param heights
     * @return
     */
    public int largestRectangleArea3(int[] heights) {
        if (heights == null || heights.length < 1) return 0;
        int ans = 0;
        int cnt = heights.length;
        for (int i = 0; i < cnt; i++) {
            int w = 1;
            int h = heights[i];
            ans = Math.max(ans, w * h);
            for (int j = i - 1; j > -1; j--) {
                h = Math.min(h, heights[j]);
                w += 1;
                ans = Math.max(ans, w * h);
            }
        }
        return ans;
    }
}
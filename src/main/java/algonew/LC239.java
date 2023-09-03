package algonew;

import java.util.*;

/**
 * @Description 239. 滑动窗口最大值
 */
public class LC239 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] a = {3, -3, 1, 3, 6, 7};
        int k = 3;

        int[] b = {1, 2, 4, 5};
        System.out.println(solution.binaryFind(b, 0));

        //[3,3,5,5,6,7]
        System.out.println(Arrays.toString(solution.maxSlidingWindow2(a, k)));


        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>() {
            public int compare(int[] pair1, int[] pair2) {
                return pair1[0] != pair2[0] ? pair2[0] - pair1[0] : pair1[1] - pair2[1];
            }
        });

        pq.offer(new int[]{5, 0});
        pq.offer(new int[]{5, 1});
        System.out.println(Arrays.toString(pq.poll()));
        System.out.println(Arrays.toString(pq.poll()));

    }

    static class Solution {
        private int binaryFind(int[] a, int k) {
            int l = 0;
            int r = a.length - 1;
            while (l <= r) {
                int m = (l + r) >>> 1;
                if (a[m] == k) return m;
                else if (a[m] > k) {
                    r = m - 1;
                } else {
                    l = m + 1;
                }
            }
            return l;
        }

        public int[] maxSlidingWindow(int[] nums, int k) {
            if (nums == null) return null;
            int[] ans = new int[nums.length - k + 1];
            int[] window = new int[k];
            for (int i = 0; i < k; i++) {
                window[i] = nums[i];
            }
            Arrays.sort(window);
            int cnt = 0;
            ans[cnt] = window[k - 1];
            for (int i = k; i < nums.length; i++) {
                int lv = nums[i - k];
                int posLv = binaryFind(window, lv);
                int posCur = binaryFind(window, nums[i]);
                if (posCur == posLv) {
                } else if (posCur > posLv) {
                    posCur = Math.min(posCur, k - 1);
                    while (posLv < posCur && nums[i] > window[posLv + 1]) window[posLv] = window[++posLv];
                } else {
                    while (posCur < posLv && nums[i] < window[posLv - 1]) window[posLv] = window[--posLv];
                }
                posCur = posLv;
                window[posCur] = nums[i];
                ans[++cnt] = window[k - 1];
            }

            return ans;
        }


        //没必要过度删除,可以先存在，过时再删除
        public int[] maxSlidingWindow2(int[] nums, int k) {
            int n = nums.length;
            PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>() {
                public int compare(int[] pair1, int[] pair2) {
                    return pair1[0] != pair2[0] ? pair2[0] - pair1[0] : pair2[1] - pair1[1];
                }
            });
            for (int i = 0; i < k; ++i) {
                pq.offer(new int[]{nums[i], i});
            }
            int[] ans = new int[n - k + 1];
            ans[0] = pq.peek()[0];
            for (int i = k; i < n; ++i) {
                pq.offer(new int[]{nums[i], i});
                while (pq.peek()[1] <= i - k) {
                    pq.poll();
                }
                ans[i - k + 1] = pq.peek()[0];
            }
            return ans;
        }


    }
}

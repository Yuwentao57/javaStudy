package algo;

import java.util.HashMap;
import java.util.Map;

public class LC873 {
    public static void main(String[] args) {
        Solution873 solution873 = new Solution873();
        int[] a = {1, 2, 3, 4, 5, 6, 7, 8};
        int[] b = {1, 4, 5};
        int[] c = {2, 4, 7, 8, 9, 10, 14, 15, 18, 23, 32, 50};
        System.out.println(solution873.lenLongestFibSubseq(b));
    }
}

class Solution873 {

    public int lenLongestFibSubseq(int[] arr) {
        if (arr == null || arr.length < 3) return 0;
        int len = arr.length;
        int[][] dp = new int[len][len];
        Map<Integer, Integer> cache = new HashMap<>();
        int maxV = 0;
        for (int k = 0; k < len; k++) {
            cache.put(arr[k], k);
            for (int i = k - 1; i > -1; i--) {
                int j = cache.getOrDefault(arr[k] - arr[i], -1);
                if (j > -1 && j < i) {
                    dp[k][i] = Math.max(Math.max(dp[i][j] + 1, 3), dp[k][i]);
                }
                maxV = Math.max(maxV, dp[k][i]);
            }
        }
        return maxV;
    }


    public int lenLongestFibSubseq2(int[] arr) {
        if (arr == null || arr.length < 3) return 0;
        int len = arr.length;
        int[][] dp = new int[len][len];
        int maxV = 0;
        for (int k = 0; k < len; k++) {
            for (int i = k - 1; i > -1; i--) {
                for (int j = 0; j < i; j++) {
                    if (arr[k] == arr[i] + arr[j]) {
                        dp[k][i] = Math.max(Math.max(dp[i][j] + 1, 3), dp[k][i]);
                    }
                }
                maxV = Math.max(maxV, dp[k][i]);
            }
        }
        return maxV;
    }


}

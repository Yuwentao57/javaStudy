package algo.jz2;

public class JZJZ93 {
    public static void main(String[] args) {
        Solution93 solution93 = new Solution93();
        int[] a = {1, 2, 3, 4, 5, 6, 7, 8};
        System.out.println(solution93.lenLongestFibSubseq(a));
    }
}

class Solution93 {

    /**
     * 自己写第二次的思路：
     * 1）dp[i][j]，第i个元素以第j个元素为前缀构成的斐波那契额数列
     * 这个题如果有三重循环，重要在边界的处理，但可以借助map省去一个for循环
     * @param arr
     * @return
     */
    public int lenLongestFibSubseq(int[] arr) {
        if (arr == null || arr.length < 3) return 0;
        int len = arr.length;
        int ans = 0;
        int[][] dp = new int[len][len];
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                for (int k = i - 1; k > -1; k--) {
                    if (arr[i] + arr[k] == arr[j]) {
                        dp[i][j] = Math.max(Math.max(dp[k][i] + 1, 3), dp[i][j]);
                    }
                }
                ans = Math.max(ans, dp[i][j]);
            }
        }
        return ans;
    }
}

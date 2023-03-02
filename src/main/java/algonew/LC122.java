package algonew;

/**
 * @Description TODO
 */
public class LC122 {
    public static void main(String[] args) {
        Solution solution = new Solution();

    }

    static class Solution {
        public int maxProfit(int[] prices) {
            int sizes = prices.length;
            int[][] mp = new int[sizes][2];
            mp[0][1] = -prices[0];
            mp[0][0] = 0;
            for (int i = 1; i < sizes; i++) {
                mp[i][0] = Math.max(mp[i - 1][0], mp[i - 1][1] + prices[i]);
                mp[i][1] = Math.max(mp[i - 1][1], mp[i - 1][0] - prices[i]);
            }
            return mp[sizes - 1][0];
        }
    }
}

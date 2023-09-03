package algonew;

/**
 * @Description TODO
 */
public class LC309 {
    public static void main(String[] args) {
        Solution solution = new Solution();

    }

    static class Solution {
        public int maxProfit(int[] prices) {
            if (prices == null || prices.length < 2) return 0;
            int sizes = prices.length;
            int[][] mp = new int[sizes][2];
            mp[0][1] = -prices[0];
            mp[0][0] = 0;
            mp[1][0] = Math.max(mp[0][0], mp[0][1] + prices[1]);
            mp[1][1] = Math.max(mp[0][1], mp[1][0] - prices[1]);
            for (int i = 2; i < sizes; i++) {
                mp[i][0] = Math.max(mp[i - 1][0], mp[i - 1][1] + prices[i]);
                mp[i][1] = Math.max(mp[i - 1][1], mp[i - 2][0] - prices[i]);
            }
            return mp[sizes - 1][0];
        }

        public int maxProfit2(int[] prices) {
            if (prices == null || prices.length < 2) return 0;
            int sizes = prices.length;
            int[][] mp = new int[sizes][3];
            mp[0][0] = -prices[0];  //手里有一支股票
            mp[0][1] = 0; //手里没有股票，且处于冷冻期
            mp[0][2] = 0; //手里没有股票，且处于非冷冻期
            for (int i = 1; i < sizes; i++) {
                mp[i][0] = Math.max(mp[i - 1][0], mp[i - 1][2] - prices[i]);
                mp[i][1] = mp[i - 1][0] + prices[i];
                mp[i][2] = Math.max(mp[i - 1][1], mp[i - 1][2]);
            }

            return Math.max(mp[sizes - 1][1], mp[sizes - 1][2]);
        }

    }
}

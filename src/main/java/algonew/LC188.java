package algonew;

import java.util.Arrays;

/**
 * @Description 188. 买卖股票的最佳时机 IV
 */
public class LC188 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxProfit(2, new int[]{2, 4, 1}));

    }

    static class Solution {
        public int maxProfit(int k, int[] prices) {
            int nums = prices.length;
            int[][][] mp = new int[nums][k + 1][2];
            mp[0][0][1] = -prices[0];
            mp[0][0][0] = 0;
            for (int i = 1; i <= k; i++) {
                mp[0][i][1] = Integer.MIN_VALUE / 2;
            }
            for (int i = 1; i < nums; i++) {
                mp[i][0][1] = Math.max(mp[i - 1][0][1], mp[i - 1][0][0] - prices[i]);
                for (int cnt = 1; cnt <= k; cnt++) {
                    //注意mp[i - 1][cnt][0] - prices[i]是cnt，不是cnt- 1，一次交易（买和卖）
                    mp[i][cnt][1] = Math.max(mp[i - 1][cnt][1], mp[i - 1][cnt][0] - prices[i]);
                    mp[i][cnt][0] = Math.max(mp[i - 1][cnt][0], mp[i - 1][cnt - 1][1] + prices[i]);
                }
            }

            int ans = 0;
            for (int i = 0; i <= k; i++) {
                ans = Math.max(ans, mp[nums - 1][i][0]);
            }
            return ans;
        }
    }
}

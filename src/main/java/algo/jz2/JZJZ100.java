package algo.jz2;

import java.util.List;

public class JZJZ100 {
}

class Solution100 {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() < 1) return 0;
        int len = triangle.size();
        int[] dp = new int[len + 1];
        for (int i= len - 1; i > -1; i--) {
            for (int j = 0; j < triangle.get(i).size(); j ++) {
                dp[j] = Math.min(dp[j], dp[j + 1]) + triangle.get(i).get(j);
            }
        }
        return dp[0];
    }
}

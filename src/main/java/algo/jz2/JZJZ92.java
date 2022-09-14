package algo.jz2;

public class JZJZ92 {
    public static void main(String[] args) {
        Solution92 solution92 = new Solution92();
        System.out.println(solution92.minFlipsMonoIncr("0101100011"));
        System.out.println(solution92.minFlipsMonoIncr("00110"));
    }
}


class Solution92 {
    /**
     * 方法答案
     *
     * @param s
     * @return
     */
    /**
     * 规范化动态方程
     * dp[i][0],第 i 个字符为0的最小翻转次数
     * dp[i][1],第 i 个字符为1的最小翻转次数
     * dp[0][0] = s.char[i] == '0'? 0:1;
     * dp[0][1] = s.char[i] == '1'? 0:1;
     * dp[i][0] = dp[i- 1][0] + s.char[i] == '1'? 1:0;
     * dp[i][1] = min(dp[i-1][0], dp[i - 1][1]) + s.char[i] == '1'? 0:1;
     */
    //这个优先级真是坑比，fuck the code!!!
    public int minFlipsMonoIncr(String s) {
        int[][] dp = new int[s.length()][2];
        dp[0][0] = (s.charAt(0) == '1' ? 1 : 0);
        dp[0][1] = (s.charAt(0) == '0' ? 1 : 0);
        for (int i = 1; i < s.length(); i++) {
            dp[i][0] = dp[i - 1][0] + (s.charAt(i) == '1' ? 1 : 0);
            dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][1]) + (s.charAt(i) == '0' ? 1 : 0);
        }
        return Math.min(dp[s.length() - 1][0], dp[s.length() - 1][1]);
    }

    public int minFlipsMonoIncr3(String s) {
        int pre0 = 0, pre1 = 0;
        for (int i = 0; i < s.length(); i ++) {
            pre1 = Math.min(pre0, pre1);
            if (s.charAt(i) == '1') pre0 += 1;
            else pre1 += 1;
        }
        return Math.min(pre0, pre1);
    }
    public int minFlipsMonoIncr2(String s) {
        if (s == null) return 0;
        int len = s.length();
        int num1 = 0;
        int ans = 0;
        char pre = ' ';
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            num1 += c == '1' ? 1 : 0;
            if (c < pre) {
                if (num1 > ans + 1) {
                    ans += 1;
                    pre = '1';
                } else {
                    ans = num1;
                    pre = '0';
                }
            } else {
                pre = c;
            }
        }
        return ans;
    }
}

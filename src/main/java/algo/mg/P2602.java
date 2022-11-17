package algo.mg;

import java.util.Arrays;

public class P2602 {
    public static void main(String[] args) {
        P2602 p2602 = new P2602();
        System.out.println(Arrays.toString(p2602.countDigits(1, 99)));
        System.out.println(Arrays.toString(p2602.countDigits(1, 19)));
        System.out.println(Arrays.toString(p2602.countDigits(44, 55)));
    }
    //最多13位数
    int numbitsup = 15;
    long[] dp = new long[numbitsup];
    long[] exp = new long[numbitsup];
    public long[] countDigits(int down, int up) {
        long[] ans = new long[10];
        long[] ansd = new long[10];
        long[] ansu = new long[10];
        exp[0] = 1;
        for (int i = 1; i < 14;i ++) {
            dp[i] = 10 * dp[i - 1] + exp[i - 1];
            exp[i] = 10 * exp[i - 1];
        }
        solve(down - 1, ansd);
        solve(up, ansu);
        for (int i = 0 ; i < 10 ; i ++) {
         ans[i] = ansu[i] - ansd[i];
        }
        return ans;
    }

    private void solve(int n, long[] ans) {
        int[] ndigit = new int[numbitsup];
        int nlen = 0;
        int temp = n;
        while (temp > 0) {
            ndigit[++nlen] = temp % 10;
            temp /= 10;
        }
        for (int i = nlen; i > 0; i --) {
            for (int j = 0; j < 10; j ++) ans[j] += ndigit[i] * dp[i - 1];
            for (int j = 0; j < ndigit[i]; j ++) ans[j] += exp[i - 1];
            n -= ndigit[i] * exp[i - 1];
            ans[ndigit[i]] += n + 1;
            ans[0] -= exp[i - 1];
        }
    }
}



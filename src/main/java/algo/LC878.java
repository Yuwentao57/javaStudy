package algo;

public class LC878 {
    public static void main(String[] args) {
        Solution878 solution878 = new Solution878();
        System.out.println(solution878.nthMagicalNumber(1000000000, 40000,40000));
    }
}

class Solution878 {
    /**
     * 首先这个题一定要想到
     * f(x) = [x / a] + [x / b] - [x / c]
     * 函数f(x)表示，在x范围内，总共存在多少个数是a,b的倍数，c是a,b的最小公倍数
     *
     * @param n
     * @param a
     * @param b
     * @return
     */
    public int nthMagicalNumber(int n, int a, int b) {
        int mod = 1000_000_000 + 7;
        int c = lcm(a, b);
        int min = Math.min(a, b);
        long l = min;
        long r = (long) n * min;
        while (l <= r) {
            long mid = (l + r) >> 1;
            long cnt = mid / a + mid / b - mid / c;
            if (cnt < n) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return (int) ((r + 1) % mod);
    }

    private int lcm(int a, int b) {
        int acc = a * b;
        while (a != b) {
            if (a > b) {
                a = a - b;
            } else {
                b = b - a;
            }
        }
        acc = acc / a;
        return acc;
    }
}

package algo;

public class LC204 {
}


class Solution204 {
    public int countPrimes(int n) {
        int cnt = 0;
        int i = 1;
        while (i < n) {
            cnt += isPrimes(i) ? 1 : 0;
            i += 1;
        }
        return cnt;
    }

    public int countPrimes2(int n) {
        int cnt = 0;
        if (n == 2) return 0;
        if (n == 3) return 1;
        if (n >= 4) {
            cnt = 2;
        }
        int base = 5;
        while (base < n) {
            if (base % 6 != 5 && base % 6 != 1) {
                base += 1;
                continue;
            }
            int divide = (int) Math.sqrt(base);
            int i = 5;
            boolean ans = true;
            while (i < divide) {
                if (base % i == 0 || base % (i + 2) == 0) {
                    ans = false;
                    break;
                }
                i += 6;
            }
            cnt += ans ? 1 : 0;
            base += 1;
        }
        return cnt;
    }

    /**
     * 质数存在普遍现象，在6i左右
     * 6i - 1, 6i,  6i + 1, 6i + 2, 6i + 3, 6i + 4
     *
     * @param n
     * @return
     */
    private boolean isPrimes(int n) {
        if (n < 4) return n > 1;
        if (n % 6 != 5 && n % 6 != 1) return false;
        int divide = (int) Math.sqrt(n);
        int i = 5;
        while (i <= divide) {
            if (n % i == 0 || n % (i + 2) == 0) return false;
            i += 6;
        }
        return true;
    }
}

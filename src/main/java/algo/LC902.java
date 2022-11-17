package algo;

public class LC902 {
    public static void main(String[] args) {
        Solution902 solution902 = new Solution902();
        String[] digits1 = {"1", "4", "9"};
        int n1 = 1000000000;

        String[] digits2 = {"1", "3", "5", "7"};
        int n2 = 100;

        String[] digits3 = {"3", "4", "5", "6"};
        int n3 = 64;

        String[] digits4 = {"1"};
        int n4 = 834;

        System.out.println(solution902.atMostNGivenDigitSet(digits1, n1));
        System.out.println(solution902.atMostNGivenDigitSet(digits2, n2));
        System.out.println(solution902.atMostNGivenDigitSet(digits3, n3));
        System.out.println(solution902.atMostNGivenDigitSet(digits4, n4));


    }
}

class Solution902 {

    public int atMostNGivenDigitSet(String[] digits, int n) {
        int ans = 0;
        String sn = String.valueOf(n);
        String[] snarr = new String[sn.length()];
        for (int i = 0; i < sn.length(); i++)
            snarr[i] = String.valueOf(sn.charAt(i));
        int acc = digits.length;
        for (int i = 1; i < snarr.length; i++) {
            ans += acc;
            acc *= digits.length;
        }
        boolean error = false;
        int i = 0;
        for (; i < snarr.length; i++) {
            int pv = exp(digits.length, snarr.length - i - 1);
            int j = 0;
            for (; j < digits.length; j++) {
                int com = digits[j].compareTo(snarr[i]);
                if (com < 0) {
                    ans += pv;
                } else if (com == 0) {
                    ans += i == snarr.length -1 ? 1: 0;
                    break;
                } else {
                    error = true;
                }
            }
            if (j == digits.length) break;
            if (error) break;
        }
        return ans;
    }

    private int exp(int b, int e) {
        int acc = 1;
        while (e > 0) {
            acc *= b;
            e -= 1;
        }
        return acc;
    }
}

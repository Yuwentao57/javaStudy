package algo;

public class LC1780 {
    public static void main(String[] args) {
        String s = new String("123");
    }
}


class Solution1780 {
    public boolean checkPowersOfThree(int n) {
        while (n > 1) {
            if (n % 3 == 0) {
                n = n / 3;
            } else if ((n - 1) % 3 == 0) {
                n -= 1;
            } else {
                return false;
            }
        }
        return true;
    }
}

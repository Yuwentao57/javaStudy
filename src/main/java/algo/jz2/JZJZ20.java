package algo.jz2;

public class JZJZ20 {
    public static void main(String[] args) {
        Solution20 solution20 = new Solution20();
        System.out.println(solution20.countSubstrings("abc"));
    }
}


class Solution20 {
    public int countSubstrings(String s) {
        if (s == null || s.length() < 1) return 0;
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            ans += 1;
            for (int j = i - 1; j > -1; j--) {
                if (mirror(s.substring(j, i + 1))) ans += 1;
            }
        }
        return ans;
    }

    private boolean mirror(String s) {
        int len = s.length();
        int i = 0;
        while (i < len / 2 && s.charAt(i) == s.charAt(len - 1 - i)) i++;
        return i == len / 2;
    }
}
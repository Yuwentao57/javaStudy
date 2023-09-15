package talgo;

import java.util.Arrays;

/**
 * @Description TODO
 */
public class JZ20 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isNumber("0.8"));
    }

    static class Solution {
        public boolean isNumber(String s) {
            int ls = 0, re = s.length() - 1;
            while (ls < s.length() && s.charAt(ls) == ' ') ls += 1;
            while (re > -1 && s.charAt(re) == ' ') re -= 1;
            if (ls > re) return false;
            int[] pos = new int[]{ls, re};
            boolean ans = scanNumber(s, pos);
            if (pos[0] <= re && s.charAt(pos[0]) == '.') {
                pos[0] += 1;
                ans = (scanUnsignedNumber(s, pos) || ans);
            }
            if (!ans) return false;
            if (pos[0] <= re && (s.charAt(pos[0]) == 'E' || s.charAt(pos[0]) == 'e')) {
                pos[0] += 1;
                ans = scanNumber(s, pos);
            }
            return ans && pos[0] > re;
        }

        private boolean scanUnsignedNumber(String s, int[] pos) {
            System.out.println(Arrays.toString(pos));
            if (pos[0] > pos[1]) return false;
            int bound = pos[0];
            while (pos[0] <= pos[1] && isDigit(s.charAt(pos[0]))) pos[0] += 1;
            return pos[0] > bound;
        }

        private boolean scanNumber(String s, int[] pos) {
            if (pos[0] > pos[1]) return false;
            if (s.charAt(pos[0]) == '-' || s.charAt(pos[0]) == '+') {
                pos[0] += 1;
            }
            int bound = pos[0];
            while (pos[0] <= pos[1] && isDigit(s.charAt(pos[0]))) pos[0] += 1;
            return pos[0] > bound;
        }

        private boolean isDigit(char ch) {
            return ch >= '0' && ch <= '9';
        }


        public boolean isNumber2(String s) {
            boolean ecnt = false;
            int ls = 0, re = s.length() - 1;
            while (ls < s.length() && s.charAt(ls) == ' ') ls += 1;
            while (re > -1 && s.charAt(re) == ' ') re -= 1;
            if (ls <= re && (s.charAt(ls) == '-' || s.charAt(ls) == '+')) ls += 1;
            if (ls > re) return false;
            int lbound = ls;
            while (ls <= re) {
                if (s.charAt(ls) == '.') {
                    if (ecnt) return false;
                    int j = ls + 1;
                    while (j <= re && isDigit(s.charAt(j))) j += 1;
                    if (j <= re && (s.charAt(j) != 'E' && s.charAt(j) != 'e')) {
                        return false;
                    }
                    if (ls - 1 < lbound && (ls + 1 > re || j - ls < 2)) {
                        return false;
                    }
                    if (j <= re) ls = j - 1;
                } else if (s.charAt(ls) == 'E' || s.charAt(ls) == 'e') {
                    if (ecnt) return false;
                    if (ls - 1 < lbound || ls + 1 > re) return false;
                    if (s.charAt(ls + 1) == '-' || s.charAt(ls + 1) == '+') {
                        if (ls + 2 > re) return false;
                        else ls += 1;
                    } else if (!isDigit(s.charAt(ls + 1))) {
                        return false;
                    }
                    ecnt = true;
                } else if (!isDigit(s.charAt(ls))) {
                    return false;
                }
                ls += 1;
            }
            return true;
        }

    }
}

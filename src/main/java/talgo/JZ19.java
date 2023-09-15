package talgo;

/**
 * @Description TODO
 */
public class JZ19 {
    public static void main(String[] args) {
        Solution solution = new Solution();
//        System.out.println(solution.isMatch("a", "aa"));
//        System.out.println(solution.isMatch("ab", ".*"));
        System.out.println(solution.isMatch("a", ".*..a*"));
//        System.out.println(solution.isMatch("ippi", "ip*."));
//        System.out.println(solution.isMatch("mississippi", "mis*is*ip*."));
        System.out.println(solution.isMatch("abcaaaaaaabaabcabac", ".*ab.a.*a*a*.*b*b*"));
//        System.out.println(solution.isMatch("abcaaaaaaabaabcabac", ".*ab.a.*a*a*.*b*b*"));
    }

    static class Solution {
        public boolean isMatch(String s, String p) {
            return subfind(s, p, 0, 0);
        }

        /**
         * 剑指offer，采用先定位*，再递归
         *
         * @param s
         * @param p
         * @param si
         * @param pi
         * @return
         */
        private boolean subfind(String s, String p, int si, int pi) {
            if (si == s.length() && pi == p.length()) return true;
            if (si < s.length() && pi >= p.length()) {
                return false;
            }
            boolean ans = false;
            boolean has = pi + 1 < p.length() && p.charAt(pi + 1) == '*';
            if (p.charAt(pi) == '.') {
                if (has) {
                    for (int i = si; i < s.length() + 1; i++) {
                        ans = subfind(s, p, i, pi + 2);
                        if (ans) break;
                    }
                } else {
                    ans = si < s.length() && subfind(s, p, si + 1, pi + 1);
                }
            } else {
                if (has) {
                    char pre = p.charAt(pi);
                    ans = subfind(s, p, si, pi + 2);//0
                    if (ans) return true;

                    for (int i = si; i < s.length(); i++) {
                        if (pre == s.charAt(i)) {
                            if (subfind(s, p, i + 1, pi + 2)) {
                                ans = true;
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                } else {
                    ans = si < s.length() && s.charAt(si) == p.charAt(pi) && subfind(s, p, si + 1, pi + 1);
                }
            }

            return ans;
        }
    }
}

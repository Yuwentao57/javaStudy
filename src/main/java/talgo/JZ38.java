package talgo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description TODO
 */
public class JZ38 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] ans = solution.permutation("aba");
        for (String ele : ans) {
            System.out.println(ele);
        }
    }

    static class Solution {
        public String[] permutation(String s) {
            if (s == null) return new String[0];
            char[] arr = new char[s.length()];
            for (int i = 0; i < s.length(); i++) {
                arr[i] = s.charAt(i);
            }
            Arrays.sort(arr);
            s = new String(arr);
            int deep = 0;
            List<String> list = new ArrayList<>();
            dfs(s, arr, deep, list);
            String[] ans = new String[list.size()];
            return list.toArray(ans);
        }

        private void dfs(String s, char[] arr, int deep, List<String> sl) {
            if (arr.length == deep) {
                sl.add(new String(arr));
                return;
            }
            for (int i = 0; i < s.length(); i++) {
                if (i > 0 && s.charAt(i) == s.charAt(i - 1)) continue;
                arr[deep] = s.charAt(i);
                dfs(getSubString(s, i), arr, deep + 1, sl);
            }
        }

        private String getSubString(String s, int pos) {
            if (s.length() == 1) return "";
            if (pos == 0) return s.substring(1);
            if (pos == s.length() - 1) return s.substring(0, s.length() - 1);
            return s.substring(0, pos) + s.substring(pos + 1);
        }

    }
}
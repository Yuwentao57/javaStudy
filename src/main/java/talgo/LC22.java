package talgo;

import sun.plugin2.gluegen.runtime.StructAccessor;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Description TODO
 */
public class LC22 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        List<String> ans = solution.generateParenthesis(4);
        for (String ele : ans) {
            System.out.println(ele);
        }
        System.out.println(ans.size());
    }

    static class Solution {
        // f(n) = ( + f(p) + ) + f(q)
        // p + q = n - 1
        public List<String> generateParenthesis(int n) {
            List<String> list = new ArrayList<>();
            List<List<String>> ans = new ArrayList<>();
            list.add("");
            ans.add(list);
            list = new ArrayList<>();
            list.add("()");
            ans.add(list);
            int i = 2;
            while (i <= n) {
                list = new ArrayList<>();
                int p = 0;
                for (; p < i; p++) {
                    for (String ele_l : ans.get(p)) {
                        for (String ele_r : ans.get(i - 1 - p)) {
                            list.add('(' + ele_l + ')' + ele_r);
                        }
                    }
                }
                ans.add(list);
                i += 1;
            }
            return ans.get(n);
        }
    }

}

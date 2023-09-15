package talgo;

import comm.TreeNode;

import java.util.*;

/**
 * @Description TODO
 */
public class JZ34 {
    public static void main(String[] args) {
        Solution solution = new Solution();

    }

    static class Solution {

        public List<List<Integer>> pathSum(TreeNode root, int target) {
            List<List<Integer>> ans = new ArrayList<>();
            List<Integer> cache = new ArrayList<>();
            int sum = 0;
            dfsFind(root, target, sum, cache, ans);
            return ans;
        }

        private void dfsFind(TreeNode root, int target, int sum, List<Integer> cache, List<List<Integer>> ans) {
            if (root == null) return;
            sum += root.val;
            cache.add(root.val);

            if (root.left == null && root.right == null) {
                if (target == sum) {
                    List<Integer> tl = new ArrayList<>(cache);
                    ans.add(tl);
                }
                cache.remove(cache.size() - 1);
                return;
            }
            dfsFind(root.left, target, sum, cache,ans);

            dfsFind(root.right, target, sum, cache,ans);

            cache.remove(cache.size() - 1);
        }
    }
}

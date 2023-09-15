package talgo;

import comm.TreeNode;

/**
 * @Description TODO
 */
public class JZ28 {
    public static void main(String[] args) {
        Solution solution = new Solution();

    }

    static class Solution {
        public boolean isSymmetric(TreeNode root) {
            if (root == null) return true;
            return travel(root.left, root.right);
        }

        private boolean travel(TreeNode l, TreeNode r) {
            if (l == null && r == null) return true;
            if (l == null || r == null) return false;
            boolean ans = l.val == r.val ;
            ans = ans && travel(l.left, r.right) && travel(l.right, r.left);
            return ans;
        }
    }
}

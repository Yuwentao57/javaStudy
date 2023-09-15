package talgo;

import comm.TreeNode;

import javax.print.attribute.standard.NumberUp;

/**
 * @Description TODO
 */
public class JZ26 {
    public static void main(String[] args) {
        Solution solution = new Solution();

    }

    static class Solution {
        public boolean isSubStructure(TreeNode A, TreeNode B) {
            if (B == null || A == null) return false;
            if (A.val == B.val && compareTree(A, B))
                return true;
            return isSubStructure(A.left, B) || isSubStructure(A.right, B);
        }

        private boolean compareTree(TreeNode A, TreeNode B) {
            if (B == null) return true;
            if (A == null || B.val != A.val) return false;
            return compareTree(A.left, B.left) && compareTree(A.right, B.right);
        }
    }
}

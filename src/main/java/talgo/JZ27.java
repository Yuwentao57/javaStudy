package talgo;

import comm.TreeNode;

/**
 * @Description TODO
 */
public class JZ27 {
    public static void main(String[] args) {
        Solution solution = new Solution();

    }

    static class Solution {
        public TreeNode mirrorTree(TreeNode root) {
            if (root == null) return null;
            TreeNode temp = root.left;
            root.left = mirrorTree(root.right);
            root.right = mirrorTree(temp);
            return root;
        }
    }
}

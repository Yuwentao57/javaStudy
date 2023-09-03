package talgo;

import comm.TreeNode;

/**
 * @Description TODO
 */
public class JZ07 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7});

    }

    static class Solution {
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            if (preorder == null || preorder.length < 1) return null;
            int len = preorder.length - 1;
            return dpsBuild(preorder, 0, len, inorder, 0, len);
        }

        private TreeNode dpsBuild(int[] parr, int pl, int pr, int[] iarr, int il, int ir) {
            TreeNode root = new TreeNode(parr[pl], null, null);
            int pos = il;
            while (pos <= ir && iarr[pos] != parr[pl]) pos += 1;
            int lsize = pos - il;
            if (lsize > 0) {
                root.left = dpsBuild(parr, pl + 1, pl + lsize, iarr, il, pos - 1);
            }
            int rsize = ir - pos;
            if (rsize > 0) {
                root.right = dpsBuild(parr, pr - rsize + 1, pr, iarr, pos + 1, ir);
            }
            return root;
        }

    }
}

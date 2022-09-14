package algo.jz2;

import comm.TreeNode;

public class JZJZ51 {
}

class Solution51 {
    private int maxval = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return maxval;
    }

    private int dfs(TreeNode root) {
        if (root == null) return 0;
        int l = Math.max(dfs(root.left), 0);
        int r = Math.max(dfs(root.right), 0);
        int lrcon = Math.max(l, r);
        maxval = Math.max(root.val + r + l, maxval);
        return lrcon + root.val;
    }
}

package algo;

import comm.TreeNode;

public class LC124 {
    public static void main(String[] args) {
    }
}


class Solution124 {
    int maxsum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        if (root == null) return 0;
        midpreview(root);
        return maxsum;
    }

    /**
     * < 0 直接丢弃，参考 {@link algo.jz2.JZJZ51}
     *
     * @param root
     * @return
     */

    private int midpreview(TreeNode root) {
        if (root == null) return 0;
        int leftv = midpreview(root.left);
        int rightv = midpreview(root.right);
        int edgel = leftv + root.val;
        int edger = rightv + root.val;
        maxsum = Math.max(maxsum, edgel);
        maxsum = Math.max(maxsum, edger);
        maxsum = Math.max(maxsum, rightv + leftv + root.val);
        return Math.max(Math.max(edgel, edger), root.val);
    }
}

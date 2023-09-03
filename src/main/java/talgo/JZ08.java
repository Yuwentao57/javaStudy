package talgo;

import comm.TreeLinkNode;

/**
 * @Description TODO
 * 在牛客上运行
 */

public class JZ08 {
    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {
        public TreeLinkNode GetNext(TreeLinkNode pNode) {
            if (pNode == null) return null;
            if (pNode.right == null) {
                TreeLinkNode parent = pNode.next;
                if (parent == null) {
                    return null;
                } else if (pNode == parent.left) {
                    return parent;
                } else {
                    while (parent != null && pNode == parent.right) {
                        pNode = parent;
                        parent = parent.next;
                    }
                    return parent;
                }
            } else {
                TreeLinkNode pr = pNode.right;
                while (pr.left != null) {
                    pr = pr.left;
                }
                return pr;
            }
        }
    }
}

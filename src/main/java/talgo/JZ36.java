package talgo;

/**
 * @Description TODO
 */
public class JZ36 {
    public static void main(String[] args) {
        Solution solution = new Solution();

    }

    static class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val,Node _left,Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }

    static class Solution {
        Node header = new Node(-1), pre = header;
        public Node treeToDoublyList(Node root) {
            if (root == null) return null;
            pre.right = header.right;
            header.right.left = pre;
            return header.right;
        }
        private void dfs(Node root) {
            if (root == null) return;
            treeToDoublyList(root.left);
            if (header.right == null) {
                header.right = root;
            }
            pre.right = root;
            root.left = pre;
            pre = root;
            treeToDoublyList(root.right);
        }
    }
}

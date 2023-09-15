package talgo;

import comm.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @Description TODO
 */
public class JZ32 {
    public static void main(String[] args) {
        Solution solution = new Solution();

    }

    static class Solution {
        public List<List<Integer>> levelOrder(TreeNode root) {
            if (root == null) return null;
            List<List<Integer>> ans = new ArrayList<>();
            Queue<TreeNode> levelView = new ArrayDeque<>();
            levelView.add(root);
            TreeNode bound = root;
            TreeNode lastNode = null;
            List<Integer> valList = new ArrayList<>();
            boolean direction = true;
            while (!levelView.isEmpty()) {
                TreeNode out = levelView.remove();
                valList.add(out.val);
                if (out.left != null) {
                    lastNode = out.left;
                    levelView.add(out.left);
                }
                if (out.right != null) {
                    lastNode = out.right;
                    levelView.add(out.right);
                }
                if (out == bound) {
                    bound = lastNode;
                    if (!direction) {
                        int l = 0;
                        int r = valList.size() - 1;
                        while (l < r) {
                            Integer t = valList.get(l);
                            valList.set(l, valList.get(r));
                            valList.set(r, t);
                            l -= 1;
                            r -= 1;
                        }
                    }
                    direction = !direction;
                    ans.add(valList);
                    valList.clear();
                }
            }
            return ans;
        }
    }
}

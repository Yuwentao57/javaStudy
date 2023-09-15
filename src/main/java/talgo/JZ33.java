package talgo;

/**
 * @Description TODO
 */
public class JZ33 {
    public static void main(String[] args) {
        Solution solution = new Solution();

    }

    static class Solution {
        public boolean verifyPostorder(int[] postorder) {
            if (postorder == null || postorder.length < 1) return false;
            return dfs(postorder, 0, postorder.length - 1);
        }

        private boolean dfs(int[] arr, int l, int r) {
            if (l >= r) return true;
            int root = arr[r];
            int i = r - 1;
            for (; i >= l; i--) {
                if (arr[i] < root) break;
            }
            int j = i - 1;
            for (; j>= l; j--) {
                if (arr[j] > root) break;
            }
            if (j >= l) return false;
            return dfs(arr, l, i) && dfs(arr, i + 1, r - 1);
        }
    }
}

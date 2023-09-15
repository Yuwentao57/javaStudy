package talgo;

/**
 * @Description TODO
 */
public class LCFood {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] a = {1,2,3,1,2,4};
//        System.out.println(solution.minUse(a, 4));
        int[] b = {4,9,9,1};
        System.out.println(solution.minUse(b, 2));

    }

    static class Solution {
        public long minUse(int[] foods, int gap) {
            long[] ans = new long[foods.length];
            ans[0] = 1;
            for (int i = 1; i < foods.length; i++) {
                long temp = -1;
                for (int j = i - 1; j > -1 ; j--) {
                    if (foods[j] == foods[i]) {
                        temp = ans[j];
                        break;
                    }
                }
                if (temp != -1) {
                    ans[i] = temp + gap + 1;
                }
                ans[i] = Math.max(ans[i], ans[i - 1] + 1);
            }
            return ans[foods.length - 1];
        }

    }
}

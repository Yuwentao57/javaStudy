package algo;

import java.util.Arrays;

public class LC698 {
    public static void main(String[] args) {
        Solution698 solution698 = new Solution698();
        int[] a = {4, 3, 2, 3, 5, 2, 1};
        int[] c = {3522,181,521,515,304,123,2512,312,922,407,146,1932,4037,2646,3871,269};
        System.out.println(solution698.canPartitionKSubsets2(c, 5));

    }
}


class Solution698 {

    private boolean ans;

    public boolean canPartitionKSubsets2(int[] nums, int k) {
        ans = false;
        int[] sums = new int[k];
        dfs(nums, sums, 0);
        return ans;
    }

    private void dfs(int[] a, int[] s, int aindex) {
        if (aindex == a.length) {
            boolean res = isequal(s);
            ans = ans | res;
            return;
        }
        for (int i = 0; i < s.length; i++) {
            if (ans) return;
            s[i] += a[aindex];
            dfs(a, s, aindex + 1);
            s[i] -= a[aindex];
        }
    }

    private boolean isequal(int[] a) {
        int i = 0;
        while (i < a.length - 1) {
            if (a[i] != a[i + 1]) return false;
            i++;
        }
        return true;
    }
}
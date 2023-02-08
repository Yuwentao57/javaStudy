package algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC891 {
    public static void main(String[] args) {
        int[] a = {2, 1, 3};
        Solution891 solution891 = new Solution891();
        System.out.println(solution891.sumSubseqWidths(a));
    }
}


class Solution891 {
    public int sumSubseqWidths(int[] nums) {
        if (nums == null || nums.length < 2) return 0;
        long ans = 0;
        int Mod = 1000_000_000 + 7;
        Arrays.sort(nums);
        long[] powers = new long[nums.length];
        powers[0] = 1;
        for (int i = 1; i < powers.length; i++) {
            powers[i] = powers[i - 1] * 2 % Mod;
        }
        for (int i = 0; i < nums.length; i++) {
            ans += nums[i] * (powers[i] - powers[nums.length - 1- i]);
        }
        return (int)((ans % Mod + Mod) % Mod);
    }

    /**
     * 暴力求解
     *
     * @param nums
     * @return
     */
    public int sumSubseqWidths2(int[] nums) {
        if (nums == null || nums.length < 2) return 0;
        int ans = 0;
        int Mod = 1000_000_000 + 7;
        List<Integer> big = new ArrayList<>();
        List<Integer> small = new ArrayList<>();
        List<Integer> bt = new ArrayList<>();
        List<Integer> st = new ArrayList<>();

        for (int ele : nums) {
            int size = big.size();
            bt.clear();
            st.clear();
            for (int i = 0; i < size; i++) {
                bt.add(Math.max(big.get(i), ele));
                st.add(Math.min(small.get(i), ele));
            }
            bt.add(ele);
            st.add(ele);
            size = bt.size();
            for (int i = 0; i < size; i++) {
                ans = (ans + bt.get(i) - st.get(i)) % Mod;
            }
            big.addAll(bt);
            small.addAll(st);
        }
        return ans;
    }
}

package algo;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class LC128 {
    public static void main(String[] args) {
        Solution128 solution128 = new Solution128();
        int[] a = {0,3,7,2,5,8,4,6,0,1};
        System.out.println(solution128.longestConsecutive(a));
    }
}

class Solution128 {

    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        HashSet<Integer> set = new HashSet<>();
        for (int ele: nums) {
            set.add(ele);
        }
        int ans = 1;
        for (int ele: nums) {
            if (set.contains(ele - 1)) continue;
            int next = ele + 1;
            map.put(ele, 1);
            while (set.contains(next)) {
                map.put(ele, map.get(ele) + 1);
                next = next + 1;
            }
            ans = Math.max(ans, map.get(ele));
        }
        return ans;
    }

}

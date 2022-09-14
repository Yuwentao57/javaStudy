package algo.jz2;

import java.util.HashMap;
import java.util.Map;

public class JZJZ10 {
}

class Solution10 {
    public int subarraySum(int[] nums, int k) {
        int len = nums.length;
        int ans = 0;
        for (int i = 0; i < len; i++) {
            int sum = 0;
            for (int j = i; j >=0 ; j --) {
                sum += nums[j];
                if (sum == k) ans ++;
            }
        }
        return ans;
    }

    public int subarraySum2(int[] nums, int k) {
        int len = nums.length;
        int ans = 0, pre = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int i = 0; i < len; i++) {
            pre += nums[i];
            if (map.containsKey(pre - k)) {
                ans += map.get(pre - k);
            }
            map.put(pre, map.getOrDefault(pre, 0));
        }
        return ans;
    }
}
package algo;

import java.util.HashMap;
import java.util.Map;

public class LC904 {
    public static void main(String[] args) {
        int[] a = {3, 3, 3, 1, 2, 1, 1, 2, 3, 3, 4};
        int[] b = {1, 1, 6, 5, 6, 6, 1, 1, 1, 1};
        Solution904 solution904 = new Solution904();
//        System.out.println(solution904.totalFruit(a));
        System.out.println(solution904.totalFruit(b));
    }
}

class Solution904 {

    /**
     * 这个方法更具泛型，如果是三个，四个篮子。。。。。。
     */
    public int totalFruit(int[] fruits) {
        if (fruits == null || fruits.length < 1) return 0;
        int ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int l = 0, r = 0;

        for (;r < fruits.length; r++) {
            map.put(fruits[r], map.getOrDefault(fruits[r], 0) + 1);
            while (map.size() > 2) {
                int cur = fruits[l];
                map.put(cur, map.get(cur) - 1);
                if (map.get(cur) == 0) {
                    map.remove(cur);
                }
                l += 1;
            }

            ans = Math.max(ans, r - l + 1);
        }
        return ans;
    }


    public int totalFruit2(int[] fruits) {
        if (fruits == null || fruits.length < 1) return 0;
        int ans = 0;
        int l, p = -1;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < fruits.length; i++) {
            if (map.size() > 1 && !map.containsKey(fruits[i])) {
                int ts = map.keySet().stream().mapToInt(Integer::intValue).sum();
                l = fruits[i - 1];
                p = map.remove(ts - l);
            }
            map.put(fruits[i], i);
            ans = Math.max(ans, i - p);
        }
        return ans;
    }
}

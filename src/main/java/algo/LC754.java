package algo;

import java.util.HashSet;
import java.util.Set;

public class LC754 {
}

/**
 * 看题解吧，更经典。。。。
 * 我用的是暴力计算
 */
class Solution754 {
    public int reachNumber(int target) {
        target = Math.abs(target);
        int ans = 0;
        int sum = 0;
        int i = 1;
        while (sum < target) {
            sum += i;
            i += 1;
            ans += 1;
        }
        int gap = sum - target;
        return gap % 2 == 0 ? ans : ans + (gap + i) % 2;
    }

    public static int reachNumber2(int target) {
        int t = target > 0 ? target : -target;
        int ans = 0;
        Set<Integer> set = new HashSet<>();
        set.add(0);
        for (int i = 1; i <= t + 1; i++) {
            ans += 1;
            Set<Integer> temp = new HashSet<>();
            for (Integer ele : set) {
                temp.add(ele + i);
                temp.add(ele - i);
            }
            set = temp;
            if (set.contains(target)) {
                break;
            }
        }
        return ans;
    }

}
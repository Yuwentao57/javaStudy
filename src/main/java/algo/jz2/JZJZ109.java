package algo.jz2;

import java.util.*;

/**
 * A star算法学习
 *
 * https://blog.csdn.net/simon_world/article/details/42173351
 * https://www.jianshu.com/p/fdeae8366b7f
 */
public class JZJZ109 {
    public static void main(String[] args) {
        Solution109 solution109 = new Solution109();
        String[] a = {"0201", "0101", "0102", "1212", "2002"};
        String target = "0202";
        System.out.println(solution109.openLock(a, target));
    }
}

class Solution109 {
    public int openLock(String[] deadends, String target) {
        Set<String> set = new HashSet<>(Arrays.asList(deadends));
        if (set.contains("0000")) return -1;
        Map<String, Integer> cache = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        sb.append('0').append('0').append('0').append('0');
        cache.put(sb.toString(), 0);
        Deque<String> deque = new ArrayDeque<>(cache.keySet());
        String t = null;
        int cnt = 0;
        while (deque.size() > 0) {
            t = deque.pollFirst();
            cnt = cache.get(t);
            if (target.equals(t)) {
                return cnt;
            }
            sb.setLength(0);
            for (int i = 0; i < t.length(); i++) {
                sb.append(t.charAt(i));
            }

            for (int i = 0; i < t.length(); i++) {
                int intc = sb.charAt(i) - '0';
                char c = (char) ('0' + (intc + 1) % 10);
                sb.setCharAt(i, c);
                if (!cache.containsKey(sb.toString()) && !set.contains(sb.toString())){
                    cache.put(sb.toString(), cnt + 1);
                    deque.offer(sb.toString());
                }
                c = (char) ('0' + (intc - 1 + 10) % 10);
                sb.setCharAt(i, c);
                if (!cache.containsKey(sb.toString()) && !set.contains(sb.toString())){
                    cache.put(sb.toString(), cnt + 1);
                    deque.offer(sb.toString());
                }
                c = (char) ('0' + intc);
                sb.setCharAt(i, c);
            }

        }
        return -1;
    }

}

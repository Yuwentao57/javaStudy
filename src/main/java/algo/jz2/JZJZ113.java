package algo.jz2;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class JZJZ113 {


}

/**
 * 拓扑排序
 */
class Solution113 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] vertex = new int[numCourses];
        for (int[] ele : prerequisites) {
            vertex[ele[0]] += 1;
        }
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++) {
            if (vertex[i] == 0) queue.add(i);
        }
        List<Integer> ans = new ArrayList<>();
        while (queue.size() > 0) {
            int parent = queue.poll();
            ans.add(parent);
            for (int[] ele: prerequisites) {
                if (ele[1] == parent) {
                    vertex[ele[0]] -= 1;
                    if (vertex[ele[0]] == 0){
                        queue.add(ele[0]);
                    }
                }
            }
        }
        if (ans.size() != numCourses) return new int[0];
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }
}
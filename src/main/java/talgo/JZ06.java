package talgo;

import comm.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description TODO
 */
public class JZ06 {
    public static void main(String[] args) {
        Solution solution = new Solution();

    }

    static class Solution {
        /**
        * 多种方法：
        * 1）可以先存入list中，转成int数组，之后翻转数组
        * 2）就地翻转链表，然后顺序遍历
        * 3）递归遍历，这个不建议，如果list很长，会报死循环
        */
        public int[] reversePrint(ListNode head) {

            List<Integer> ans = new ArrayList<>();
            ans.stream().mapToInt(i -> i).toArray();
            return null;
        }
    }
}

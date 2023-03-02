package algonew.jz;

import comm.ListNode;

import java.util.Stack;

/**
 * @Description 025. 链表中的两数相加
 */
public class JZJZ25 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode l1 = ListNode.createLinkList(new int[]{7, 2, 4, 3});
        ListNode l2 = ListNode.createLinkList(new int[]{5, 6, 4});
        ListNode ans = solution.addTwoNumbers(l1, l2);
        ListNode.showLinkList(ans);

    }

    static class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            Stack<Integer> s1 = new Stack<>();
            Stack<Integer> s2 = new Stack<>();
            ListNode t = l1;
            while (t != null) {
                s1.push(t.val);
                t = t.next;
            }
            t = l2;
            while (t != null) {
                s2.push(t.val);
                t = t.next;
            }
            ListNode header = new ListNode(-1);
            boolean isUp = false;
            while (s1.size() > 0 && s2.size() > 0) {
                int t1 = s1.pop();
                int t2 = s2.pop();
                int sum = (isUp ? 1 : 0) + t1 + t2;
                if (sum > 9) {
                    header.next = new ListNode(sum - 10, header.next);
                    isUp = true;
                } else {
                    header.next = new ListNode(sum, header.next);
                    isUp = false;
                }
            }
            if (s2.size() > 0) s1 = s2;
            while (s1.size() > 0) {
                int sum = (isUp ? 1 : 0) + s1.pop();
                if (sum > 9) {
                    header.next = new ListNode(sum - 10, header.next);
                    isUp = true;
                } else {
                    header.next = new ListNode(sum, header.next);
                    isUp = false;
                }
            }
            if (isUp) header.next = new ListNode(1, header.next);
            return header.next;
        }
    }
}

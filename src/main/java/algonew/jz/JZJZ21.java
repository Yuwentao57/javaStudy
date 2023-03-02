package algonew.jz;

import comm.ListNode;

/**
 * @Description 021. 删除链表的倒数第 n 个结点
 */
public class JZJZ21 {
    public static void main(String[] args) {
        Solution solution = new Solution();

        ListNode head = ListNode.createLinkList(new int[]{1, 2, 3, 4, 5});
        ListNode.showLinkList(head);
        ListNode ans = solution.removeNthFromEnd(head, 2);
        ListNode.showLinkList(ans);

    }

    static class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            if (head == null) return null;
            ListNode fast = head;
            ListNode slow = null;
            while (fast != null && n > 1) {
                fast = fast.next;
                n -= 1;
            }

            while (fast != null) {
                if (fast.next == null) {
                    break;
                }
                fast = fast.next;
                if (slow == null) {
                    slow = head;
                } else {
                    slow = slow.next;
                }
            }
            if (fast == null) return head;
            if (slow == null) {
                head = head.next;
            } else {
                slow.next = slow.next.next;
            }
            return head;
        }

        /**
         * 这个题没有考虑，当 n 大于链表长度时的场景
         * @param head
         * @param n
         * @return
         */
        public ListNode removeNthFromEndS(ListNode head, int n) {
            if (head == null) return null;
            ListNode dummy = new ListNode(0, head);
            ListNode fast = head, slow = dummy;
            while (fast != null && n > 0) {
                fast = fast.next;
                n -= 1;
            }
            while (fast != null) {
                fast = fast.next;
                slow = slow.next;
            }
            slow.next = slow.next.next;
            return dummy.next;
        }
    }
}

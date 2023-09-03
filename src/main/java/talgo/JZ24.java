package talgo;

import comm.ListNode;

/**
 * @Description TODO
 */
public class JZ24 {
    public static void main(String[] args) {
        Solution solution = new Solution();

    }

    static class Solution {
        public ListNode reverseList(ListNode head) {
            ListNode tail = new ListNode(-1);
            while(head != null) {
                ListNode temp = head.next;
                head.next = tail.next;
                tail.next = head;
                head = temp;
            }

            return tail.next;
        }
    }
}

package talgo;

import comm.ListNode;

/**
 * @Description TODO
 */
public class JZ23 {
    public static void main(String[] args) {
        Solution solution = new Solution();

    }

    static class Solution {
        public ListNode EntryNodeOfLoop(ListNode pHead) {
            if (pHead == null || pHead.next == null || pHead.next.next == null) return null;
            ListNode slow = pHead;
            ListNode quick = pHead.next.next;
            while (slow != quick && slow.next != null && quick.next != null) {
                slow = slow.next;
                if (quick.next.next == null) break;
                quick = quick.next.next;
            }
            if (slow != quick) return null;

            int circleCnt = 1;
            ListNode node = slow.next;
            while (slow != node) {
                node = node.next;
                circleCnt += 1;
            }
            node = pHead;
            while (circleCnt > 0) {
                circleCnt -= 1;
                node = node.next;
            }
            while (pHead != node) {
                pHead = pHead.next;
                node = node.next;

            }
            return node;
        }
    }
}

package talgo;

import comm.Node;

/**
 * @Description TODO
 */
public class JZ35 {
    public static void main(String[] args) {
        Solution solution = new Solution();

    }

    static class Solution {
        public Node copyRandomList(Node head) {
            if (head == null) return null;
            Node tHead = head;
            while (tHead != null) {
                Node node = new Node(tHead.val);
                node.next = tHead.next;
                tHead.next = node;
                tHead = node.next;
            }
            tHead = head;
            while (tHead != null) {
                if (tHead.random != null) {
                    tHead.next.random = tHead.random.next;
                }
                tHead = tHead.next.next;
            }
            Node ans = head.next;
            head.next = ans.next;
            tHead = head.next;
            Node aHead = ans;
            while (tHead != null) {
                aHead.next = tHead.next;
                tHead.next = tHead.next.next;
                tHead = tHead.next;
                aHead = aHead.next;
            }
            return ans;
        }
    }
}

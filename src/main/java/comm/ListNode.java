package comm;

import java.util.List;

/**
 * @Description TODO
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static ListNode createLinkList(int[] var) {
        if (var == null || var.length == 0) return null;
        ListNode header = new ListNode(var[0]);
        ListNode cursor = header;
        for (int i = 1; i < var.length; i++) {
            ListNode t = new ListNode(var[i]);
            cursor.next = t;
            cursor = t;
        }
        return header;
    }


    public static void showLinkList(ListNode header) {
        StringBuilder sbr = new StringBuilder();
        sbr.append('[');
        ListNode cursor = header;
        while (cursor != null) {
            sbr.append(cursor.val).append(',');
            cursor = cursor.next;
        }
        sbr.setLength(sbr.length() - 1);
        sbr.append(']');
        System.out.println(sbr);
    }
}

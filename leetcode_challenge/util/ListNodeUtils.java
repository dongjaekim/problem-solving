package util;

import java.util.StringJoiner;

public class ListNodeUtils {
    public static class ListNode {
        public int val;
        public ListNode next;
        public ListNode() {}
        public ListNode(int val) { this.val = val; }
        public ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static String toString(ListNode listNode) {
        StringJoiner joiner = new StringJoiner(", ");

        if (listNode == null)
            return "[]";

        while (listNode.next != null) {
            joiner.add(String.valueOf(listNode.val));
            listNode = listNode.next;
        }
        joiner.add(String.valueOf(listNode.val));

        return "[" + joiner + "]";
    }
    
    public static ListNode makeListNode(int[] heads) {
        ListNode root = new ListNode(heads[0]);

        if (heads.length > 1) {
            ListNode prev = root;
            for (int i = 1; i < heads.length; i++) {
                ListNode listNode = new ListNode(heads[i]);
                prev.next = listNode;
                prev = listNode;
            }
        }

        return root;
    }
}

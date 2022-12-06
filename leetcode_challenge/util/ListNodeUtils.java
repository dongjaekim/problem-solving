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
}

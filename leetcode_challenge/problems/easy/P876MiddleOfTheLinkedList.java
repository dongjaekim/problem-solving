package problems.easy;

import java.util.ArrayList;
import java.util.List;

public class P876MiddleOfTheLinkedList {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static ListNode middleNode(ListNode head) {
        List<ListNode> temp = new ArrayList<>();

        while (head.next != null) {
            temp.add(head);
            head = head.next;
        }

        int size = temp.size();
        return size% 2 == 0 ? temp.get(size / 2) : temp.get((size / 2) + 1);
    }

    public static void main(String[] args) {
        ListNode listNode5 = new ListNode(5);
        ListNode listNode4 = new ListNode(4, listNode5);
        ListNode listNode3 = new ListNode(3, listNode4);
        ListNode listNode2 = new ListNode(2, listNode3);
        ListNode listNode1 = new ListNode(1, listNode2);

        ListNode p1 = middleNode(listNode1);
        System.out.println("p1.val = " + p1.val);

        ListNode listNode6 = new ListNode(6);
        listNode5.next = listNode6;
        ListNode p2 = middleNode(listNode1);
        System.out.println("p2.val = " + p2.val);
    }
}

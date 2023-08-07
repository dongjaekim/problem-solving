package problems.medium;

import util.ListNodeUtils;

import static util.ListNodeUtils.*;

public class P1721SwappingNodesInALinkedList {

    public static ListNode swapNodes(ListNode head, int k) {

        ListNode temp = null;
        for (int i = 0; i < k; i++) {
            if (i == 0)
                temp = head;
            else
                temp = temp.next;
        }

        ListNode start = temp;
        ListNode end = head;

        while (temp.next != null) {
            temp = temp.next;
            end = end.next;
        }

        int swap = start.val;
        start.val = end.val;
        end.val = swap;

        return head;
    }

    public static void main(String[] args) {
        ListNode e1_input = ListNodeUtils.makeListNode(new int[]{1, 2, 3, 4, 5});
        ListNode e1 = swapNodes(e1_input, 2);
        System.out.println("ListNode.ListNodeToString(e1) = " + ListNodeUtils.toString(e1)); // 1, 4, 3, 2, 5

        ListNode e2_input = ListNodeUtils.makeListNode(new int[]{7, 9, 6, 6, 7, 8, 3, 0, 9, 5});
        ListNode e2 = swapNodes(e2_input, 5);
        System.out.println("ListNode.ListNodeToString(e2) = " + ListNodeUtils.toString(e2)); // 7, 9, 6, 6, 8, 7, 3, 0, 9, 5

        ListNode e3_input = ListNodeUtils.makeListNode(new int[]{1, 2});
        ListNode e3 = swapNodes(e3_input, 1);
        System.out.println("ListNode.ListNodeToString(e3) = " + ListNodeUtils.toString(e3)); // 2 1
    }
}

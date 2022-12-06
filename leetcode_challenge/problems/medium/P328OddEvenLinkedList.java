package problems.medium;

import util.ListNodeUtils;

import static util.ListNodeUtils.*;

public class P328OddEvenLinkedList {

    public static ListNode oddEvenList(ListNode head) {
        if (head == null) return null;
        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = head.next;

        while (even != null && even.next != null) {
            // Put odd to the odd list
            odd.next = odd.next.next;

            // Put even to the even list
            even.next = even.next.next;

            // Move the pointer to the next odd/even
            odd = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }

    public static ListNode oddEvenList2(ListNode head) {
        ListNode reverse = new ListNode(head.val);

        int cnt = 1;
        while (head.next != null) {
            ListNode temp = reverse;
            reverse = new ListNode(head.next.val);
            reverse.next = temp;
            head = head.next;
            cnt++;
        }
        System.out.println("reverse = " + ListNodeUtils.toString(reverse));
        System.out.println("cnt = " + cnt);

        ListNode odd = null;
        ListNode even = null;
        for (int i = 0; i < cnt; i++) {
            if ((i % 2 == 0 && cnt % 2 == 1) || (i % 2 == 1 && cnt % 2 == 0)) {
                ListNode temp = odd;
                odd = new ListNode(reverse.val);
                odd.next = temp;
            } else if ((i % 2 == 1 && cnt % 2 == 1) || (i % 2 == 0 && cnt % 2 == 0)) {
                ListNode temp = even;
                even = new ListNode(reverse.val);
                even.next = temp;
            }
            reverse = reverse.next;
        }

        ListNode temp = odd;
        while (temp.next != null)
            temp = temp.next;
        temp.next = even;
        return odd;
    }

    public static void main(String[] args) {
        ListNode p1l5 = new ListNode(5);
        ListNode p1l4 = new ListNode(4, p1l5);
        ListNode p1l3 = new ListNode(3, p1l4);
        ListNode p1l2 = new ListNode(2, p1l3);
        ListNode p1l1 = new ListNode(1, p1l2);
        ListNode p1 = oddEvenList(p1l1);
        System.out.println("p1 = " + ListNodeUtils.toString(p1));

        ListNode p2l7 = new ListNode(7);
        ListNode p2l4 = new ListNode(4, p2l7);
        ListNode p2l6 = new ListNode(6, p2l4);
        ListNode p2l5 = new ListNode(5, p2l6);
        ListNode p2l3 = new ListNode(3, p2l5);
        ListNode p2l1 = new ListNode(1, p2l3);
        ListNode p2l2 = new ListNode(2, p2l1);
        ListNode p2 = oddEvenList(p2l2);
        System.out.println("p2 = " + ListNodeUtils.toString(p2));

        ListNode p3l8 = new ListNode(8);
        ListNode p3l7 = new ListNode(7, p3l8);
        ListNode p3l6 = new ListNode(6, p3l7);
        ListNode p3l5 = new ListNode(5, p3l6);
        ListNode p3l4 = new ListNode(4, p3l5);
        ListNode p3l3 = new ListNode(3, p3l4);
        ListNode p3l2 = new ListNode(2, p3l3);
        ListNode p3l1 = new ListNode(1, p3l2);
        ListNode p3 = oddEvenList(p3l1);
        System.out.println("p3 = " + ListNodeUtils.toString(p3));

    }
}

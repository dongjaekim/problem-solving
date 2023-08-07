package problems.medium;

import util.ListNodeUtils;

import java.util.ArrayList;
import java.util.List;

import static util.ListNodeUtils.*;

public class P24SwapNodesInPairs {

    public static ListNode swapPairs(ListNode head) {
        List<ListNode> nodes = new ArrayList<>();

        if(head == null)
            return null;

        ListNode temp = head;
        while (temp.next != null) {
            nodes.add(temp);
            temp = temp.next;
        }
        nodes.add(temp);

        int n = nodes.size();
        ListNode prev = null;
        for (int i = 0; i < n / 2; i++) {
            ListNode swap = nodes.get(i * 2);
            ListNode swapNext = swap.next;
            
            swap.next = swapNext.next;
            swapNext.next = swap;
            nodes.set(i * 2, swapNext);
            nodes.set(i * 2 + 1, swap);

            if (prev != null)
                prev.next = swapNext;

            prev = swap;
        }

        return nodes.get(0);
    }

    public static void main(String[] args) {
        ListNode e1_input = ListNodeUtils.makeListNode(new int[]{1, 2, 3, 4}); // 2, 1, 4, 3
        ListNode e1 = swapPairs(e1_input);
        System.out.println("e1: " + ListNodeUtils.toString(e1));
    }
}

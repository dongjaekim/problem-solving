package April;

public class lc_210401 {
    public static void main(String[] args) {
        Solution sol = new Solution();


    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static class Solution {
        public boolean isPalindrome(ListNode head) {
            String str = "";

            while(head != null) {
                str += head.val;
                head = head.next;
            }

            for(int i = 0; i < str.length() / 2; i++) {
                if(str.charAt(i) != str.charAt(str.length() - i - 1))
                    return false;
            }

            return true;
        }
    }

    public static class bestSolution {
        public boolean isPalindrome(ListNode head) {
            ListNode slow = head;
            ListNode fast = head;
            ListNode prev = null;

            while(fast != null && fast.next != null) {
                fast = fast.next.next;
                ListNode temp = slow.next;
                slow.next = prev;
                prev = slow;
                slow = temp;
            }

            if(fast != null)
                slow = slow.next;

            while(slow != null) {
                if(slow.val != prev.val)
                    return false;
                slow = slow.next;
                prev = prev.next;
            }

            return true;
        }
    }
}

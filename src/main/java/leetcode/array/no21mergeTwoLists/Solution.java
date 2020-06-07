package array.no21mergeTwoLists;

public class Solution {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (null == l1) {
            return l2;
        } else if (null == l2) {
            return l1;
        } else if (l1.val > l2.val) {
            l2.next = mergeTwoLists(l1.next, l2);
            return l2;
        } else {
            l1.next = mergeTwoLists(l1, l2.next);
            return l1;
        }

    }

    private void getAllNode(ListNode result, ListNode l1, ListNode l2) {

        if (l1 == null || l2 == null) {
            return;
        }
        if (result.next == null) {
            result.next = new ListNode(0);
        }
        if (l1.val > l2.val) {
            result.val = l2.val;
            getAllNode(result.next, l1, l2.next);
        }
        if (l1.val == l2.val) {
            result.val = l2.val;
            getAllNode(result.next, l1.next, l2.next);
        }
        if (l1.val < l2.val) {
            result.val = l1.val;
            getAllNode(result.next, l1.next, l2);
        }
        System.out.println(result.val + "->" + result.next.val);
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);
        l1.next.next.next = new ListNode(5);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);
        String s = "";
        printList(new Solution().mergeTwoLists(l1, l2), s);
        System.out.println("" + "" + s);
    }

    private static void printList(ListNode l, String s) {
        while (l.next != null) {
            s = s + l.val;
            printList(l.next, s);
        }
    }
}


class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
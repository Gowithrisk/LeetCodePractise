package array.no83deleteDuplicates;

public class Solution {
    public ListNode deleteDuplicates(ListNode head) {

        if(null == head)
        {
            return null;
        }
        while (head != null && head.next != null) {
            if (head.val == head.next.val) {
                head.next = head.next.next;
            }else {
                head=head.next;
            }
        }

        return head;
    }

    public static void main(String[] args) {

        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(1);
        ListNode l3 = new ListNode(2);
        ListNode l31 = new ListNode(2);
        ListNode l4 = new ListNode(2);
        ListNode l5 = new ListNode(3);
        l1.next = l2;
        l2.next = l3;
        l3.next=l31;
        l31.next = l4;
        l4.next = l5;

        new Solution().deleteDuplicates(l1);
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}



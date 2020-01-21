package leetcode.numberAdd;

/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * 
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * 
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * 
 * 示例：
 * 
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4) 输出：7 -> 0 -> 8 原因：342 + 465 = 807
 * 
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/add-two-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author Administrator
 *
 */
public class Solution {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode newNode = new ListNode(0);
		calcDigui(l1, l2, newNode, 0);
		return newNode;
	}

	public void calcDigui(ListNode l1, ListNode l2, ListNode newNode, int jinwei) {

		int val1, val2;
		val1 = null == l1 ? 0 : l1.val;
		val2 = null == l2 ? 0 : l2.val;

		newNode.val = val1 + val2 + jinwei;

		if (newNode.val >= 10) {
			newNode.val = newNode.val - 10;
			jinwei = 1;
			System.out.println(newNode.val);
		} else {
			jinwei = 0;
			System.out.println(newNode.val);
		}

		if (l1.next != null || l2.next != null || jinwei == 1) {
			if (l1.next == null) {
				l1.next = new ListNode(0);
			}
			if (l2.next == null) {
				l2.next = new ListNode(0);
			}
			System.out.println("Enter next Level");

			newNode.next = new ListNode(0);
			calcDigui(l1.next, l2.next, newNode.next, jinwei);
		}

	}

	// * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4) 输出：7 -> 0 -> 8 原因：342 + 465 = 807
	public static void main(String[] arags) {
		ListNode l1 = new ListNode(5);
		// l1.next = new ListNode(4);
		// l1.next.next = new ListNode(3);
		// l1.next.next.next = new ListNode(5);

		ListNode l2 = new ListNode(5);
		// l2.next = new ListNode(6);
		// l2.next.next = new ListNode(4);

		ListNode result = new Solution().addTwoNumbers(l1, l2);
		System.out.println(result.toString());
	}
}

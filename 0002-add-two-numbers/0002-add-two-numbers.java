/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // Sol1. Iteration - O(max(M, N))
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, currentNode = dummyHead;
        int carry = 0;

        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;

            carry = sum / 10;
            currentNode.next = new ListNode(sum % 10);
            currentNode = currentNode.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }

        if (carry > 0) {
            currentNode.next = new ListNode(carry);
        }
        return dummyHead.next;

        // Sol2. Recursive - O(max(M, N))
        // return addTwoNumbersRecursive(l1, l2, 0);
    }

    private ListNode addTwoNumbersRecursive(ListNode l1, ListNode l2, int carry) {
        if (l1 == null && l2 == null && carry == 0) return null;

        int x = (l1 != null) ? l1.val : 0;
        int y = (l2 != null) ? l2.val : 0;
        int sum = x + y + carry;
        ListNode node = new ListNode(sum % 10);

        node.next = addTwoNumbersRecursive(
            (l1 != null) ? l1.next : null, 
            (l2 != null) ? l2.next : null, 
            sum / 10
        );

        return node;
    }
}
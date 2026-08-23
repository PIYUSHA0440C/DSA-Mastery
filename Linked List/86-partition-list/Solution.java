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
    public ListNode partition(ListNode head, int x) {
        ListNode lessHead = new ListNode(0);
        ListNode greaterHead = new ListNode(0);

        ListNode lessTail = lessHead;
        ListNode greaterTail = greaterHead;

        ListNode curr = head;

        while(curr != null){
            if (curr.val < x){
                lessTail.next = curr;
                lessTail = curr;
            } else {
                greaterTail.next = curr;
                greaterTail = curr;
            }

            curr = curr.next;
        }

        greaterTail.next = null;

        lessTail.next = greaterHead.next;

        return lessHead.next;
    }
}

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
    public void reorderList(ListNode head) {
        if(head == null || head.next == null) return;

        ListNode midNode = middleNode(head);
        ListNode secondHead = midNode.next;
        midNode.next = null;

        ListNode prev = null;

        while(secondHead != null){
            ListNode next = secondHead.next;

            secondHead.next = prev;
            prev = secondHead;

            secondHead = next;
        }

        secondHead = prev;

        ListNode firstHead = head;

        while(secondHead != null) {
            ListNode temp1 = firstHead.next;
            ListNode temp2 = secondHead.next;

            firstHead.next = secondHead;
            secondHead.next = temp1;

            firstHead = temp1;
            secondHead = temp2;
        }
    }

    private ListNode middleNode(ListNode head){
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
}


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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode head = list1;
        ListNode prev = head;

        int idx = 1;
        while(idx < a){
            prev = prev.next;
            idx++;
        }

        ListNode secondHead = prev;
        while(idx <= b + 1){
            secondHead = secondHead.next;
            idx++;
        }

        prev.next = list2;

        ListNode tail = list2;

        while(tail.next != null){
            tail = tail.next;
        }

        tail.next = secondHead;

        return head;
    }
}

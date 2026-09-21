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
    public int getDecimalValue(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while(curr != null){
            ListNode next = curr.next;

            curr.next = prev;
            prev = curr;
            curr = next;
        }

        curr = prev;

        int ans = 0;
        int power = 0;

        while(curr != null) {
            int val = curr.val;

            ans += (val * Math.pow(2, power));

            power++;
            curr = curr.next;
        }

        return ans;
    }
}

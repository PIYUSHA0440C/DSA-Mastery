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
    public ListNode doubleIt(ListNode head) {
        Deque<ListNode> stack = new ArrayDeque<>();
        int carry = 0;

        ListNode curr = head;
        while(curr != null) {
            stack.push(curr);
            curr = curr.next;
        }

        while(!stack.isEmpty()){
            ListNode node = stack.pop();
            int product = (node.val * 2) + carry;
            int digit = product % 10;
            
            node.val = digit;

            carry = product / 10;
        }

        while(carry > 0){
            int digit = carry % 10;

            ListNode node = new ListNode(digit);
            node.next = head;
            head = node;

            carry /= 10;
        }

        return head;
    }
}

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
        Deque<Integer> stack1 = new ArrayDeque<>();
        Deque<Integer> stack2 = new ArrayDeque<>();

        ListNode node1 = l1;
        ListNode node2 = l2;

        while(node1 != null){ 
            stack1.push(node1.val);
            node1 = node1.next;
        }
        while(node2 != null){
            stack2.push(node2.val);
            node2 = node2.next;
        }

        ListNode head = null;
        int carry = 0;

        while(!stack1.isEmpty() || !stack2.isEmpty() ||carry != 0){
            int sum = 0;

            if(!stack1.isEmpty()) sum += stack1.pop();
            if(!stack2.isEmpty()) sum += stack2.pop();

            sum += carry;

            int value = sum % 10;
            carry = sum / 10;

            ListNode node = new ListNode(value);
            node.next = head;

            head = node;
        }
        return head;
    }
}

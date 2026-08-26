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
    public ListNode removeNodes(ListNode head) {
        Deque<ListNode> stack = new ArrayDeque<>();

        while(head != null){
            if (stack.size() != 0 && head.val > stack.peek().val){
                stack.pop();
            } else {
                stack.push(head);
                head = head.next;
            }
        }

        ListNode node = null;

        while(!stack.isEmpty()){
            ListNode curr = stack.pop();

            curr.next = node;
            node = curr;
        }

        return node;
    }
}

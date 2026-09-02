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
    public int[] nextLargerNodes(ListNode head) {
        Deque<Integer> stack = new ArrayDeque<>();
        ArrayList<Integer> list = new ArrayList<>();

        ListNode tail = head;

        while(tail != null) {
            list.add(tail.val);
            tail = tail.next;
        }

        int size = list.size();
        int result[] = new int[size];

        for(int i = 0; i < size; i++){
            while(!stack.isEmpty() && list.get(stack.peek()) < list.get(i)) {
                result[stack.pop()] = list.get(i);
            }

            stack.push(i);
        }

        return result;
    }
}

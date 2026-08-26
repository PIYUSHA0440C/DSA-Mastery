# 2487. Remove Nodes From Linked List (Medium)


## 📝 Problem Statement


Given the head of a linked list, remove every node that has a node with a greater value anywhere to its right.


Return the head of the modified linked list.


## 💡 Intuition & Approach


We use a **monotonic stack** to keep nodes that should remain in the final list.


While traversing the linked list, if the current node has a greater value than the node at the top of the stack, the top node must be removed because the current node is a greater value on its right.


We continue removing smaller nodes from the stack until the current node can be safely added.


Finally, the stack contains the remaining nodes in reverse order, so we rebuild the linked list by popping the nodes and connecting them in the correct order.


### 🛠️ The Strategy:


1. Create a stack to store candidate nodes.
2. Traverse the linked list from left to right.
3. If the current node is greater than the node at the top of the stack, remove the top node.
4. Continue this comparison until the stack is empty or its top value is greater than or equal to the current value.
5. Add the current node to the stack.
6. Pop the nodes from the stack and reconnect them to restore the original order.
7. Return the reconstructed list.


## 📊 Complexity Analysis


* **Time Complexity:** O(n) - Each node is pushed and popped from the stack at most once.


* **Space Complexity:** O(n) - The stack can contain up to n nodes.


## 💻 Implementation (Java)


```java
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

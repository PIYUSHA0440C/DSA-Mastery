# 2816. Double a Number Represented as a Linked List (Medium)

## 📝 Problem Statement

Given a linked list representing a non-negative integer, double the number and return the head of the resulting linked list.

Each node contains a single digit, and the list does not contain leading zeroes except when the number itself is `0`.

## 💡 Intuition & Approach

Since multiplication starts from the least significant digit, we need to process the linked list from right to left. A stack allows us to access the nodes in reverse order while modifying the existing nodes.

### 🛠️ The Strategy:

1. Traverse the linked list and push every node onto a stack.
2. Pop nodes one by one, starting from the last digit.
3. Double each digit and add the carry from the previous digit.
4. Store the resulting digit back in the current node.
5. Update the carry using integer division by `10`.
6. If a carry remains after processing all nodes, create a new node and place it at the beginning of the list.
7. Return the updated head.

## 📊 Complexity Analysis

- **Time Complexity:** O(n), where `n` is the number of nodes.
- **Space Complexity:** O(n) for the stack.

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
```

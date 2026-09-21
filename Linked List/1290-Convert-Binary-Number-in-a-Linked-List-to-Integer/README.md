# 1290. Convert Binary Number in a Linked List to Integer (Easy)

## 📝 Problem Statement

Given a singly linked list where each node contains either `0` or `1`, the linked list represents a binary number with the most significant bit at the head.

Return the decimal value represented by the linked list.

## 💡 Intuition & Approach

The binary number is easiest to evaluate from the least significant bit. The given solution first reverses the linked list so that the least significant bit is at the beginning, then calculates the decimal value using powers of `2`.

### 🛠️ The Strategy:

1. Reverse the linked list using three pointers: `prev`, `curr`, and `next`.
2. Traverse the reversed list from the least significant bit.
3. Maintain a `power` starting from `0`.
4. For each node, add `node.val * 2^power` to the result.
5. Increment `power` after processing each node.
6. Return the calculated decimal value.

## 📊 Complexity Analysis

- **Time Complexity:** O(n), where `n` is the number of nodes.
- **Space Complexity:** O(1), excluding the recursive stack since the solution is iterative.

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
```

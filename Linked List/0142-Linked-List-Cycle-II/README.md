# 142. Linked List Cycle II (Medium)

## 📝 Problem Statement
Given the `head` of a linked list, return the node where the cycle begins. If there is no cycle, return `null`. Do not modify the linked list. Solve using $O(1)$ constant memory.

## 💡 Intuition & Approach
While a `HashSet` tracks visited nodes easily ($O(N)$ space), we can achieve $O(1)$ space using **Floyd's Tortoise and Hare Algorithm**. 

The algorithm works in two distinct phases:
1. **Detecting the Cycle:** Move a `slow` pointer by 1 step and a `fast` pointer by 2 steps. If they meet, a cycle exists.
2. **Finding the Cycle Origin:** Once they meet, reset the `slow` pointer to the `head` of the list. Move both `slow` and `fast` pointers at a uniform speed of 1 step per iteration. The exact node where they collide again is structurally guaranteed to be the start of the loop cycle.

### 📐 Mathematical Proof:
* Let $L_1$ be the distance from the `head` to the start of the cycle.
* Let $L_2$ be the distance from the start of the cycle to the meeting point.
* Let $C$ be the total length of the cycle loop.

When the pointers first collide, the travel distances are:
$$\text{Distance}_{\text{slow}} = L_1 + L_2$$
$$\text{Distance}_{\text{fast}} = L_1 + L_2 + n \cdot C \quad (\text{where } n \text{ is the number of complete loops})$$

Since `fast` travels exactly twice as fast as `slow`:
$$2 \cdot (L_1 + L_2) = L_1 + L_2 + n \cdot C$$
$$L_1 + L_2 = n \cdot C$$
$$L_1 = n \cdot C - L_2$$

This proves that the distance from the `head` to the cycle start ($L_1$) is exactly equivalent to moving from the first collision spot around the remaining loop length ($n \cdot C - L_2$). 

## 📊 Complexity Analysis
* **Time Complexity:** O(N) - Phase 1 tracking takes at most $O(N)$ steps to detect a match. Phase 2 takes exactly $L_1$ steps to find the node index. Total execution is strictly linear.
* **Space Complexity:** O(1) - Pointers are updated in-place without dynamic table tracking variables.

## 💻 Implementation (Java)
```java
/**
 * Definition for singly-linked list.
 * class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) {
 * val = x;
 * next = null;
 * }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        // Phase 1: Determine if a cycle exists
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            // Cycle detected
            if (slow == fast) {
                // Phase 2: Locate the start node of the cycle
                slow = head;
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow; // The meeting point is the start of the cycle
            }
        }

        return null; // No cycle found
    }
}

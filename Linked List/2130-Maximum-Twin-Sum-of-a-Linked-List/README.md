# 2130. Maximum Twin Sum of a Linked List (Medium)

## 📝 Problem Statement
In a linked list of even size `n`, the $i$-th node (0-indexed) is the twin of the $(n-1-i)$-th node for $0 \le i \le (n / 2) - 1$. The twin sum is defined as the sum of a node and its twin. Given the head of a linked list with even length, return the maximum twin sum.

## 💡 Intuition & Approach
To calculate the twin sums, we need to pair elements from the first half of the list with elements from the second half in reverse order (e.g., matching the first node with the last node). Since we cannot traverse a singly-linked list backward, a naive approach might copy values to an array, which requires $O(N)$ extra space.

We can optimize this to $O(1)$ constant auxiliary space by altering the list structure in-place using a three-step pipeline:
1. **Find the Midpoint:** Use the Fast & Slow Pointer technique to locate the exact start of the second half of the list.
2. **Reverse the Second Half:** Invert all the `next` pointers of the second half. This turns the tail of the list into a new head pointer (`prev`), allowing us to traverse the second half backward.
3. **Calculate Maximum Twin Sum:** Run two pointers simultaneously from the absolute `head` and the new reversed head (`prev`), computing the pairwise sum at each step to track down the maximum value.

## 📊 Complexity Analysis
* **Time Complexity:** O(N) - Finding the midpoint takes $N/2$ steps, reversing the second half takes $N/2$ steps, and the maximum sum traversal takes another $N/2$ steps. This yields a strictly linear total runtime.
* **Space Complexity:** O(1) - Pointers are updated directly in-place without dynamic allocations or extra tables.

## 💻 Implementation (Java)
```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int pairSum(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        int sum = 0;

        // Step 1: Locate the starting point of the second half
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Step 2: Reverse the second half of the linked list in-place
        ListNode prev = null;
        ListNode curr = slow;
        while (curr != null) {
            ListNode nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }

        // Step 3: Walk both halves inward to compute max twin sums
        slow = head;
        while (prev != null) {
            sum = Math.max(sum, slow.val + prev.val);
            slow = slow.next;
            prev = prev.next;
        }

        return sum;
    }
}

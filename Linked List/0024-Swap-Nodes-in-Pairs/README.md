# 24. Swap Nodes in Pairs (Medium)

## 📝 Problem Statement
Given a linked list, swap every two adjacent nodes and return its head. You must solve the problem without modifying the values in the list's nodes (i.e., only nodes themselves may be changed.)

## 💡 Intuition & Approach
To swap pairs of nodes without altering their data values, we must explicitly manipulate the pointers that connect them. 

Since the original head of the list changes when the first two elements swap, we introduce a `dummy` node pointing to `head`. We maintain two references, `prev` (to connect the processed segment to the newly swapped pair) and `curr` (the first node of the current pair to be swapped).

### 🛠️ The Strategy:
1. **Base Case:** If the list is empty (`null`) or contains only a single node, return `head` directly.
2. **Link Restructuring:** For each iteration where `curr` and `curr.next` exist:
   - Link `prev.next` to the second node (`curr.next`).
   - Route `curr.next` to the node trailing the pair (`curr.next.next`).
   - Complete the swap by making the second node point back to the first node (`prev.next.next = curr`).
3. **Pointer Updates:** Advance `prev` to `curr` and set `curr` to its updated `next` position to evaluate the next pair.

## 📊 Complexity Analysis
* **Time Complexity:** O(N) - The loop scans the linked list once, stepping forward by two nodes in each pass.
* **Space Complexity:** O(1) - The solution reallocates pointers in-place, consuming constant extra memory.

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
    public ListNode swapPairs(ListNode head) {
        // Base case: list is empty or has only one element
        if (head == null || head.next == null) return head;

        ListNode dummy = new ListNode(0, head);
        ListNode prev = dummy;
        ListNode curr = head;

        // Loop runs as long as a complete pair is available
        while (curr != null && curr.next != null) {
            // Adjust pointers to swap curr and curr.next
            prev.next = curr.next;
            curr.next = curr.next.next;
            prev.next.next = curr;

            // Shift tracking variables forward for the next iteration
            prev = curr;
            curr = curr.next;
        }

        return dummy.next;
    }
}

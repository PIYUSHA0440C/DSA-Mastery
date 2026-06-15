# 2095. Delete the Middle Node of a Linked List (Medium)

## 📝 Problem Statement
You are given the `head` of a linked list. Delete the middle node, and return the head of the modified linked list. The middle node of a linked list of size `n` is the $\lfloor n / 2 \rfloor$-th node from the start using 0-based indexing.

## 💡 Intuition & Approach
To delete a node from a singly-linked list, you must stop at its predecessor to change its `next` pointer. 

We can optimize the search using a modified **Fast & Slow Pointer** approach to find the element right before the middle node in a single pass:
* If we initialize `slow` at `head` and `fast` at `head.next.next`, `fast` has a 2-node head start.
* By the time `fast` reaches the end of the list (moving 2 steps at a time), `slow` (moving 1 step at a time) will land exactly one node *before* the actual middle node.
* This eliminates the need to keep track of a separate `prev` pointer.

### 🛠️ The Strategy:
1. **Edge Case:** If the list has only one node (`head.next == null`), deleting it leaves an empty list. Return `null` immediately.
2. **Offset Initialization:** Start `slow = head` and `fast = head.next.next`.
3. **Traversal:** Advance `slow = slow.next` and `fast = fast.next.next` until `fast` or `fast.next` becomes `null`.
4. **Deletion:** Sever the middle node by rewiring `slow.next = slow.next.next`.

## 📊 Complexity Analysis
* **Time Complexity:** O(N) - The fast pointer reaches the end of the list in $N/2$ steps, reading elements in a single linear pass.
* **Space Complexity:** O(1) - The deletion is performed in-place using constant auxiliary pointer references.

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
    public ListNode deleteMiddle(ListNode head) {
        // Base Case: If there is only one node, deleting it results in null
        if (head.next == null) return null;

        // Initialize fast with a 2-node offset so slow stops right before the middle
        ListNode slow = head;
        ListNode fast = head.next.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Bypass the middle node
        slow.next = slow.next.next;

        return head;
    }
}

# 328. Odd Even Linked List (Medium)

## 📝 Problem Statement

Given the head of a singly linked list, group all nodes positioned at **odd indices** together followed by all nodes positioned at **even indices**, while preserving the original relative order within each group.

The first node is considered odd, the second node is even, and so on.

The solution must run in **O(n)** time and use **O(1)** extra space.

---

## 💡 Intuition & Approach

Since the nodes are already connected in order, creating new lists or using extra memory is unnecessary.

Instead, maintain two pointers:
- One traverses all **odd-indexed** nodes.
- The other traverses all **even-indexed** nodes.

As we iterate through the list:
- Connect each odd node to the next odd node.
- Connect each even node to the next even node.
- Preserve the head of the even list so it can be attached after the odd list is fully processed.

This rearranges the existing links without creating any additional nodes, satisfying the constant space requirement.

### 🛠️ The Strategy

1. **Handle Edge Cases**
   - If the list is empty or contains only one node, return it directly.

2. **Initialize Pointers**
   - `odd` starts at the head.
   - `even` starts at the second node.
   - Store `evenHead` to remember the beginning of the even-indexed list.

3. **Rewire the List**
   - Link each odd node to the next odd node.
   - Link each even node to the next even node.
   - Move both pointers forward until no further even pair exists.

4. **Merge Both Lists**
   - Connect the last odd node to `evenHead`.
   - Return the original head.

---

## 📊 Complexity Analysis

- **Time Complexity:** **O(n)** - Every node is visited exactly once.

- **Space Complexity:** **O(1)** - Only a few pointers are used regardless of the list size.

---

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
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = even;

        while(even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;

            even.next = even.next.next;
            even = even.next;
        }

        odd.next = evenHead;

        return head;
    }
}
```

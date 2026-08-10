# 92. Reverse Linked List II (Medium)

## 📝 Problem Statement

Given the head of a singly linked list and two positions `left` and `right`, reverse the nodes between positions `left` and `right` while keeping the rest of the list unchanged.

The reversal should be performed by modifying the linked-list pointers rather than creating a new list.

---

## 💡 Intuition & Approach

The key is to reverse only the required section of the linked list without affecting the nodes before and after it.

A **dummy node** is placed before the head so that the same pointer logic works even when `left = 1`.

First, move `prev` to the node immediately before the reversal section. Then repeatedly move the node immediately after `curr` to the front of the reversing section.

For example:

```text
1 → 2 → 3 → 4 → 5
    ↑       ↑
   left   right
```

During each iteration, the next node is extracted from after `curr` and inserted directly after `prev`.

For:

```text
1 → 2 → 3 → 4 → 5
```

The reversal gradually becomes:

```text
1 → 3 → 2 → 4 → 5
1 → 4 → 3 → 2 → 5
```

No separate list or array is required.

### 🛠️ The Strategy

1. **Create a Dummy Node**
   - Place it before `head` to simplify handling when `left = 1`.

2. **Find the Reversal Start**
   - Move `prev` until it points to the node immediately before position `left`.

3. **Initialize `curr`**
   - `curr` points to the first node of the section being reversed.

4. **Move Nodes to the Front**
   - Take `curr.next`.
   - Remove it from its current position.
   - Insert it immediately after `prev`.
   - Repeat `right - left` times.

5. **Return the Result**
   - Return `dummy.next`.

---

## 📊 Complexity Analysis

- **Time Complexity:** **O(n)** - The list is traversed only as far as necessary, with each pointer operation taking O(1).

- **Space Complexity:** **O(1)** - Only a constant number of pointers are used.

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
 *     ListNode(int val, ListNode next) {
 *         this.val = val;
 *         this.next = next;
 *     }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prev = dummy;

        for(int i = 1; i < left; i++) {
            prev = prev.next;
        }

        ListNode curr = prev.next;

        for(int i = 0; i < right - left; i++) {
            ListNode nextNode = curr.next;

            curr.next = nextNode.next;
            nextNode.next = prev.next;
            prev.next = nextNode;
        }

        return dummy.next;
    }
}
```

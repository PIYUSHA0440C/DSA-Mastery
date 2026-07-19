# 148. Sort List (Medium)

## 📝 Problem Statement

Given the head of a singly linked list, sort the list in ascending order and return the sorted head.

The follow-up requires achieving **O(n log n)** time complexity while using **O(1)** extra memory.

---

## 💡 Intuition & Approach

Unlike arrays, linked lists do not support random access, making algorithms like Quick Sort or Heap Sort inefficient. **Merge Sort** is the ideal choice because it naturally works with sequential access and guarantees **O(n log n)** time complexity.

The algorithm repeatedly divides the linked list into two halves, recursively sorts each half, and finally merges the two sorted lists.

To split the list efficiently, we use the **Slow and Fast Pointer** technique to locate the middle node. After recursively sorting both halves, they are merged into a single sorted linked list.

### 🛠️ The Strategy

1. **Handle Base Case**
   - If the list is empty or contains only one node, it is already sorted.

2. **Find the Middle**
   - Use slow and fast pointers to locate the midpoint.
   - Split the list into two independent halves.

3. **Recursively Sort**
   - Apply Merge Sort to both left and right halves.

4. **Merge the Sorted Lists**
   - Compare the current nodes of both halves.
   - Recursively attach the smaller node to the merged list.
   - Continue until one list is exhausted, then append the remaining nodes.

---

## 📊 Complexity Analysis

- **Time Complexity:** **O(n log n)** - The list is repeatedly divided into halves, and each merge processes all nodes once.

- **Space Complexity:** **O(log n)** - Due to the recursive Merge Sort call stack. The algorithm does not allocate additional data structures for sorting and rearranges the existing nodes.

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
 *     ListNode(int val, ListNode next) { this.next = next; this.val = val; }
 * }
 */
class Solution {
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode mid = FindMid(head);
        ListNode midNext = mid.next;
        mid.next = null;

        ListNode left = sortList(head);
        ListNode right = sortList(midNext);

        return merge(left, right);
    }

    private ListNode FindMid(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next.next;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    private ListNode merge(ListNode left, ListNode right) {
        if(left == null) return right;
        if(right == null) return left;

        if(left.val < right.val) {
            left.next = merge(left.next, right);
            return left;
        } else {
            right.next = merge(left, right.next);
            return right;
        }
    }
}
```

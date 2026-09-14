# 143. Reorder List (Medium)

## 📝 Problem Statement

Given the head of a singly linked list, reorder the list in the following pattern:

`L0 → Ln → L1 → Ln-1 → L2 → Ln-2 → …`

The node values must remain unchanged. Only the links between nodes can be modified.

## 💡 Intuition & Approach

The list can be reordered efficiently by splitting it into two halves, reversing the second half, and then merging both halves alternately.

### 🛠️ The Strategy:

1. Find the middle node of the linked list using the slow and fast pointer technique.
2. Split the list into two separate halves at the middle.
3. Reverse the second half of the list.
4. Keep pointers to the first and reversed second halves.
5. Merge the two halves by alternating nodes from each list.
6. Connect each node from the second half between consecutive nodes of the first half.
7. Continue until all nodes from the second half are merged.
8. The original node values remain unchanged throughout the process.

## 📊 Complexity Analysis

* **Time Complexity:** O(n)
* **Space Complexity:** O(1)

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
    public void reorderList(ListNode head) {
        if(head == null || head.next == null) return;

        ListNode midNode = middleNode(head);
        ListNode secondHead = midNode.next;
        midNode.next = null;

        ListNode prev = null;

        while(secondHead != null){
            ListNode next = secondHead.next;

            secondHead.next = prev;
            prev = secondHead;

            secondHead = next;
        }

        secondHead = prev;

        ListNode firstHead = head;

        while(secondHead != null) {
            ListNode temp1 = firstHead.next;
            ListNode temp2 = secondHead.next;

            firstHead.next = secondHead;
            secondHead.next = temp1;

            firstHead = temp1;
            secondHead = temp2;
        }
    }

    private ListNode middleNode(ListNode head){
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
}
```

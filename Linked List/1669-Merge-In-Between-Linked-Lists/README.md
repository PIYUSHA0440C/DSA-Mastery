# 1669. Merge In Between Linked Lists (Medium)

## 📝 Problem Statement

Given two linked lists, `list1` and `list2`, remove the nodes from index `a` to index `b` in `list1` and insert the entire `list2` in their place.

Return the head of the resulting linked list.

## 💡 Intuition & Approach

The key is to reconnect the list around the portion that needs to be removed.

### 🛠️ The Strategy:

1. Traverse `list1` to reach the node at index `a - 1`.
2. Continue traversing to find the node immediately after index `b`.
3. Connect the node before index `a` to the head of `list2`.
4. Traverse `list2` to its last node.
5. Connect the last node of `list2` to the node after index `b`.
6. Return the original head of `list1`.

This modifies the existing linked lists directly without creating additional nodes.

## 📊 Complexity Analysis

- **Time Complexity:** O(n + m), where `n` is the length of `list1` and `m` is the length of `list2`.
- **Space Complexity:** O(1)

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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode head = list1;
        ListNode prev = head;

        int idx = 1;
        while(idx < a){
            prev = prev.next;
            idx++;
        }

        ListNode secondHead = prev;
        while(idx <= b + 1){
            secondHead = secondHead.next;
            idx++;
        }

        prev.next = list2;

        ListNode tail = list2;

        while(tail.next != null){
            tail = tail.next;
        }

        tail.next = secondHead;

        return head;
    }
}
```

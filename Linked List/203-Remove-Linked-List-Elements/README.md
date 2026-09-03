# 203. Remove Linked List Elements (Easy)

## 📝 Problem Statement

Given the head of a linked list and an integer `val`, remove all nodes whose value is equal to `val` and return the new head of the linked list.

## 💡 Intuition & Approach

A dummy node is used before the original head to simplify the removal process, especially when the head itself needs to be removed. The list is traversed using `prev` and `curr` pointers, keeping only the nodes whose values are different from `val`.

### 🛠️ The Strategy:

1. Create a dummy node and initialize `prev` to the dummy node.
2. Set `curr` to the head of the linked list.
3. Traverse the list using `curr`.
4. If `curr.val` is different from `val`, connect it after `prev` and move `prev` forward.
5. If `curr.val` equals `val`, skip that node.
6. Move `curr` to the next node.
7. Set `prev.next` to `null` to properly terminate the resulting list.
8. Return `dummy.next` as the new head.

## 📊 Complexity Analysis

* **Time Complexity:** O(n), where `n` is the number of nodes in the linked list.
* **Space Complexity:** O(1), using only a constant number of pointers.

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
    public ListNode removeElements(ListNode head, int val) {
        if(head == null) return null;

        ListNode dummy = new ListNode(0);
        ListNode prev = dummy;
        ListNode curr = head;

        while(curr != null){
            if (curr.val != val) {
                prev.next = curr;
                prev = curr; 
            }

            curr = curr.next;
        }

        prev.next = null;
        
        return dummy.next;
    }
}
```

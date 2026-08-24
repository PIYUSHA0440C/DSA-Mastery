# 83. Remove Duplicates from Sorted List (Easy)


## 📝 Problem Statement


Given the head of a sorted linked list, delete all duplicates so that each element appears only once.


The resulting linked list must remain sorted.


## 💡 Intuition & Approach


Because the linked list is sorted, duplicate values always appear next to each other.


We use two pointers:


- `prev` points to the last node with a unique value.
- `curr` traverses the remaining nodes.


When `curr.val` differs from `prev.val`, it is a new unique value, so we connect `prev.next` to `curr` and move `prev` forward.


If the values are equal, `curr` is a duplicate, so we simply skip it by continuing the traversal.


After the traversal, `prev.next` is set to `null` to remove any remaining duplicate nodes from the end of the list.


### 🛠️ The Strategy:


1. Return `null` if the list is empty.
2. Initialize `prev` at the head and `curr` at the second node.
3. Compare the values of `curr` and `prev`.
4. If they are different, connect `prev.next` to `curr` and move `prev` forward.
5. If they are equal, skip the duplicate node.
6. Continue until `curr` reaches the end of the list.
7. Set `prev.next` to `null` to terminate the resulting list.
8. Return the original head.


## 📊 Complexity Analysis


* **Time Complexity:** O(n) - Every node is visited once.


* **Space Complexity:** O(1) - Only two pointers are used.


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
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null) return null;

        ListNode prev = head;
        ListNode curr = head.next;

        while(curr != null){
            if (curr.val != prev.val){
                prev.next = curr;
                prev = curr;
            }
            
            curr = curr.next;
        }

        prev.next = null;

        return head;
    }
}

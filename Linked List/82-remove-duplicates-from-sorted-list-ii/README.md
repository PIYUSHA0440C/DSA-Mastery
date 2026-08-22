# 82. Remove Duplicates from Sorted List II (Medium)


## 📝 Problem Statement


Given the head of a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.


The resulting linked list must remain sorted.


## 💡 Intuition & Approach


Since the linked list is sorted, duplicate values always appear consecutively.


We use a **dummy node** before the head to handle cases where duplicate values occur at the beginning of the list.


Two pointers are used:


- `prev` points to the last node confirmed to contain a distinct value.
- `curr` scans the list and identifies groups of duplicate values.


When a duplicate group is found, `prev.next` is updated to skip the entire group. Otherwise, `prev` moves forward normally.


### 🛠️ The Strategy:


1. Create a dummy node pointing to the head.
2. Initialize `prev` at the dummy node and `curr` at the head.
3. For each node, check whether consecutive nodes have the same value.
4. If duplicates are found, move `curr` to the last node of that duplicate group.
5. Skip the entire duplicate group by setting `prev.next = curr.next`.
6. If no duplicate is found, move `prev` to the current node.
7. Move `curr` to the next node.
8. Return `dummy.next` as the head of the resulting list.


## 📊 Complexity Analysis


* **Time Complexity:** O(n) - Each node is visited at most once.


* **Space Complexity:** O(1) - Only a constant number of pointers are used.


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

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prev = dummy;
        ListNode curr = head;

        while (curr != null) {

            boolean duplicate = false;

            while (curr.next != null && curr.val == curr.next.val) {
                duplicate = true;
                curr = curr.next;
            }

            if (duplicate) {
                prev.next = curr.next;
            } else {
                prev = prev.next;
            }

            curr = curr.next;
        }

        return dummy.next;
    }
}

# 3217. Delete Nodes From Linked List Present in Array (Medium)


## 📝 Problem Statement


Given an array of integers `nums` and the head of a linked list, remove all nodes from the linked list whose values are present in `nums`.


Return the head of the modified linked list.


## 💡 Intuition & Approach


We use a **HashSet** to store all values from `nums` so that we can check whether a linked list node should be removed in average O(1) time.


A dummy node is used before the head to simplify the process of building the resulting linked list.


We traverse the linked list once. If the current node's value is not present in the set, we keep the node and connect it using the `prev` pointer. Otherwise, we skip the node.


### 🛠️ The Strategy:


1. Store all values from `nums` in a `HashSet`.
2. Create a dummy node and use `prev` to build the resulting list.
3. Traverse the linked list using `curr`.
4. If `curr.val` is not present in the set, connect it to the result list.
5. If the value is present, skip the current node.
6. Move `curr` to the next node.
7. Set `prev.next` to `null` to terminate the resulting list.
8. Return `dummy.next`.


## 📊 Complexity Analysis


* **Time Complexity:** O(n + m) - Building the set takes O(m), and traversing the linked list takes O(n), where `n` is the number of linked list nodes and `m` is the length of `nums`.


* **Space Complexity:** O(m) - The `HashSet` stores the values from `nums`.


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
    public ListNode modifiedList(int[] nums, ListNode head) {
        HashSet<Integer> set = new HashSet<>();
        for(int num : nums) set.add(num);

        ListNode dummy = new ListNode(0);
        ListNode prev = dummy;
        ListNode curr = head;

        while(curr != null){
            if(!set.contains(curr.val)){
                prev.next = curr;
                prev = curr;
            }

            curr = curr.next;
        }

        prev.next = null;

        return dummy.next;
    }
}

# 237. Delete Node in a Linked List (Medium)

## 📝 Problem Statement
There is a singly-linked list `head` and we want to delete a specific node `node` in it. You are given only the node to be deleted; you will not be given access to the first node of `head`. It is guaranteed that the node to be deleted is not the last node in the linked list.

## 💡 Intuition & Approach
In a standard linked list deletion, you need access to the previous node to modify its `next` pointer. Here, we are only given the node itself, making a traditional pointer bypass impossible. 

Instead of removing the actual node container from memory, we shift the data. We overwrite the value of the current node with the value of its immediate next neighbor. This effectively shifts the neighbor's value backward. We then bypass that neighbor by linking our current node's `next` pointer to `node.next.next`.

### 🛠️ The Strategy:
1. **Copy Next Value:** Set `node.val = node.next.val` to take the identity of the succeeding element.
2. **Bypass Next Node:** Break the link to the original next node by updating `node.next = node.next.next`.

## 📊 Complexity Analysis
* **Time Complexity:** O(1) - The operation performs a flat variable overwrite and a single pointer realignment, completing in constant time.
* **Space Complexity:** O(1) - No supplementary structures or variables are allocated.

## 💻 Implementation (Java)
```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
        // Step 1: Copy the value of the next node into the current node
        node.val = node.next.val;
        
        // Step 2: Skip the next node
        node.next = node.next.next;
    }
}

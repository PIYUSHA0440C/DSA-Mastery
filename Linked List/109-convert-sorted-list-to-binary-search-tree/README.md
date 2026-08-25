# 109. Convert Sorted List to Binary Search Tree (Medium)


## 📝 Problem Statement


Given the head of a singly linked list where elements are sorted in ascending order, convert it to a **height-balanced Binary Search Tree (BST)**.


## 💡 Intuition & Approach


Since the linked list is sorted, the middle element can be used as the root of the BST.


We use the **slow and fast pointer technique** to find the middle node of the current list segment. The middle node becomes the root, while the nodes before it form the left subtree and the nodes after it form the right subtree.


The list is split by disconnecting the node before the middle from the middle node.


### 🛠️ The Strategy:


1. Handle the empty list and single-node cases.
2. Use `slow` and `fast` pointers to find the middle node.
3. Keep track of the node before `slow`.
4. Create a tree node using the middle node's value as the root.
5. Disconnect the left portion of the list from the middle node.
6. Recursively convert the left portion into the left subtree.
7. Recursively convert the right portion into the right subtree.
8. Return the constructed height-balanced BST.


## 📊 Complexity Analysis


* **Time Complexity:** O(n log n) - Finding the middle node takes linear time at each level of the balanced recursion.


* **Space Complexity:** O(log n) - The recursion depth is proportional to the height of the balanced BST.


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
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return new TreeNode(head.val);

        ListNode slow = head, fast = head, slow_prev = null;

        while (fast != null && fast.next != null) {
            slow_prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        TreeNode root = new TreeNode(slow.val);
        slow_prev.next = null;
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(slow.next);
        
        return root;
    }
}

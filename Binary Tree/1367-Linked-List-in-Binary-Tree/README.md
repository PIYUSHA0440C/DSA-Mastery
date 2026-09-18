# 1367. Linked List in Binary Tree (Medium)

## 📝 Problem Statement

Given a binary tree `root` and a linked list with `head` as the first node, determine whether all elements of the linked list correspond to some downward path in the binary tree.

A downward path starts at any tree node and continues through its left or right child.

## 💡 Intuition & Approach

The linked list can start matching from any node in the binary tree. Once a matching tree node is found, recursively check whether the remaining linked list can follow a downward path through the tree.

### 🛠️ The Strategy:

1. Traverse every node of the binary tree as a potential starting point.
2. For each node, use a helper function to check whether the linked list matches a downward path starting there.
3. If the current tree node and linked list node have different values, the path cannot match.
4. If the linked list reaches its end, a valid path has been found.
5. Otherwise, recursively continue through the tree node's left or right child.
6. If no starting node produces a complete match, return `false`.

## 📊 Complexity Analysis

- **Time Complexity:** O(n × m), where `n` is the number of nodes in the binary tree and `m` is the number of nodes in the linked list.
- **Space Complexity:** O(h + m), where `h` is the height of the binary tree due to recursive calls.

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
    public boolean isSubPath(ListNode head, TreeNode root) {
        if (root == null) return false;

        return recur(head, root) || isSubPath(head, root.left) || isSubPath(head, root.right);
    }

    private boolean recur(ListNode head, TreeNode root) {
        if (head == null) return true;

        if (root == null || root.val != head.val) return false;

        return recur(head.next, root.left) || recur(head.next, root.right);
    }
}
```

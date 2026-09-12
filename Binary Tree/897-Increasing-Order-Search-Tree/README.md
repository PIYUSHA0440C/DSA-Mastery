# 897. Increasing Order Search Tree (Easy)

## 📝 Problem Statement

Given the root of a Binary Search Tree, rearrange the tree so that the smallest element becomes the root, every node has no left child, and each node has only one right child. The nodes must appear in inorder sequence.

## 💡 Intuition & Approach

An inorder traversal of a BST visits nodes in ascending order. We can use this property to directly rearrange the existing nodes into a right-skewed tree without creating new nodes for each value.

A dummy node is used to simplify building the resulting tree.

### 🛠️ The Strategy:

1. Create a dummy node to act as the starting point of the new tree.
2. Maintain a pointer `ans` to the last node added to the increasing-order tree.
3. Perform an inorder traversal of the original BST.
4. For every visited node, attach it as the right child of `ans`.
5. Set the visited node's left child to `null`.
6. Move `ans` to the newly attached node.
7. Continue until all nodes are processed in ascending order.
8. Return `head.right`, which is the actual root of the rearranged tree.

## 📊 Complexity Analysis

* **Time Complexity:** O(n), where `n` is the number of nodes in the BST.
* **Space Complexity:** O(h), where `h` is the height of the tree due to the recursive call stack.

## 💻 Implementation (Java)

```java
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
    TreeNode ans = new TreeNode(0);

    public TreeNode increasingBST(TreeNode root) {
        TreeNode head = ans;
        inOrder(root);

        return head.right;        
    }

    private void inOrder(TreeNode root){
        if(root == null) return;

        inOrder(root.left);

        ans.right = root;
        root.left = null;
        ans = ans.right;

        inOrder(root.right);
    }
}
```

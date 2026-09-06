# 965. Univalued Binary Tree (Easy)

## 📝 Problem Statement

Given the root of a binary tree, determine whether every node in the tree has the same value.

## 💡 Intuition & Approach

The value of the root node is used as the reference value. Recursively traverse the entire tree and check whether every node has the same value. If any node contains a different value, the tree is not uni-valued.

### 🛠️ The Strategy:

1. Use the root node's value as the required value for every node.
2. Recursively traverse the binary tree.
3. If the current node is `null`, return `true`.
4. If the current node's value differs from the reference value, return `false`.
5. Recursively check the left and right subtrees.
6. Return `true` only if both subtrees are uni-valued with the same reference value.

## 📊 Complexity Analysis

* **Time Complexity:** O(n), where `n` is the number of nodes in the tree.
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
    public boolean isUnivalTree(TreeNode root) {
        return isUnivalTree(root, root.val);
    }

    private boolean isUnivalTree(TreeNode root, int value){
        if(root == null) return true;

        if(root.val != value) return false;

        return isUnivalTree(root.left, value) && isUnivalTree(root.right, value);
    }
}
```

# 814. Binary Tree Pruning (Medium)

## 📝 Problem Statement

Given the root of a binary tree containing only `0` and `1`, remove every subtree that does not contain a node with value `1` and return the pruned tree.

## 💡 Intuition & Approach

Use postorder recursion to process the left and right subtrees before deciding whether the current node should remain. After pruning both children, a node with value `0` and no remaining children can be safely removed because its entire subtree contains no `1`.

### 🛠️ The Strategy:

1. If the current node is `null`, return `null`.
2. Recursively prune the left subtree.
3. Recursively prune the right subtree.
4. Update the current node's left and right pointers with the pruned subtrees.
5. If the current node has value `0` and both children are `null`, remove it by returning `null`.
6. Otherwise, keep the current node.
7. Return the root of the pruned tree.

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
    public TreeNode pruneTree(TreeNode root) {
        if(root == null) return null;

        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);

        if(root.val == 0 && root.left == null && root.right == null) return null;

        return root;
    }
}
```

# 112. Path Sum (Easy)

## 📝 Problem Statement

Given the root of a binary tree and an integer `targetSum`, determine whether the tree has a **root-to-leaf** path such that the sum of all node values along the path equals `targetSum`.

A leaf is a node with no children.

---

## 💡 Intuition & Approach

Starting from the root, each node contributes its value to the path sum.

Instead of maintaining a running sum, we subtract the current node's value from the remaining target as we move down the tree. By the time we reach a leaf node, if the remaining target equals the leaf's value, we have found a valid root-to-leaf path.

This naturally fits a **Depth-First Search (DFS)** recursive traversal.

### 🛠️ The Strategy

1. **Handle Empty Tree**
   - If the root is `null`, no path exists.

2. **Check Leaf Node**
   - If the current node is a leaf, verify whether its value equals the remaining target.

3. **Recurse on Children**
   - Subtract the current node's value from the target.
   - Recursively search the left and right subtrees.

4. **Return the Result**
   - If either subtree contains a valid path, return `true`; otherwise return `false`.

---

## 📊 Complexity Analysis

- **Time Complexity:** **O(n)** - Every node is visited at most once.

- **Space Complexity:** **O(h)** - Recursive call stack, where `h` is the height of the tree. (Worst case: **O(n)** for a skewed tree, **O(log n)** for a balanced tree.)

---

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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null) return false;

        if(root.left == null && root.right == null) {
            return root.val == targetSum;
        }

        boolean leftSum = hasPathSum(root.left, targetSum - root.val);
        boolean rightSum = hasPathSum(root.right, targetSum - root.val);

        return leftSum || rightSum;
    }
}
```

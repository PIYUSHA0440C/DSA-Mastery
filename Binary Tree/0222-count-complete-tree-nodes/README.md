# 222. Count Complete Tree Nodes (Medium)

## 📝 Problem Statement

Given the root of a **complete binary tree**, return the total number of nodes in the tree.

A complete binary tree is a binary tree in which every level, except possibly the last, is completely filled, and all nodes in the last level are positioned as far left as possible.

The challenge is to design an algorithm that runs in **less than O(n)** time.

---

## 💡 Intuition & Approach

A complete binary tree has a useful property:

- If the height of the leftmost path is equal to the height of the rightmost path, then the tree is a **perfect binary tree**.
- A perfect binary tree with height `h` contains exactly:
  ```
  2^h - 1
  ```
  nodes.

Instead of traversing every node, we first compare the leftmost and rightmost heights.

- If both heights are equal, we directly compute the answer using the formula.
- Otherwise, the tree is not perfect, so recursively count the nodes in the left and right subtrees.

This optimization avoids visiting every node in perfect subtrees, giving a faster solution than a normal DFS.

### 🛠️ The Strategy

1. **Handle Empty Tree**
   - If the root is `null`, return `0`.

2. **Compute Heights**
   - Traverse left pointers to find the left height.
   - Traverse right pointers to find the right height.

3. **Check for Perfect Tree**
   - If both heights are equal, return `(2^height) - 1`.

4. **Otherwise**
   - Recursively count nodes in the left and right subtrees.
   - Add `1` for the current root.

---

## 📊 Complexity Analysis

- **Time Complexity:** **O(log² n)** - For each recursive call, computing the left and right heights takes **O(log n)**, and the recursion depth is also **O(log n)**.

- **Space Complexity:** **O(log n)** - Due to the recursive call stack.

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
    public int countNodes(TreeNode root) {
        if (root == null) return 0;

        int leftHeight = getLeftHeight(root);
        int rightHeight = getRightHeight(root);

        if (leftHeight == rightHeight)
            return (1 << leftHeight) - 1;

        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    private int getLeftHeight(TreeNode node) {
        int height = 0;
        while (node != null) {
            height++;
            node = node.left;
        }
        return height;
    }

    private int getRightHeight(TreeNode node) {
        int height = 0;
        while (node != null) {
            height++;
            node = node.right;
        }
        return height;
    }
}
```

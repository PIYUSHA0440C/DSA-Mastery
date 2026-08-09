# 530. Minimum Absolute Difference in BST (Easy)

## 📝 Problem Statement

Given the root of a **Binary Search Tree (BST)**, return the minimum absolute difference between the values of any two different nodes.

---

## 💡 Intuition & Approach

The key property of a BST is that an **inorder traversal visits its nodes in ascending order**.

Because the values are sorted during inorder traversal, the minimum absolute difference can only occur between **two consecutive nodes** in that traversal.

For example:

```text
BST:
      4
     / \
    2   6
   / \
  1   3

Inorder:
1 → 2 → 3 → 4 → 6
```

Instead of comparing every pair of nodes, we only compare the current node with the previously visited node.

During the traversal:

- Keep a reference to the previous node.
- For every current node, calculate the difference between its value and `prev.val`.
- Update the minimum difference.
- Move `prev` to the current node.

### 🛠️ The Strategy

1. **Perform Inorder Traversal**
   - Traverse the left subtree first.

2. **Compare Consecutive Values**
   - If a previous node exists, calculate:
     ```
     current.val - prev.val
     ```
   - Update the minimum difference.

3. **Update Previous Node**
   - Set `prev = current`.

4. **Traverse the Right Subtree**
   - Continue until every node has been processed.

Because inorder traversal of a BST is sorted, checking consecutive nodes is sufficient.

---

## 📊 Complexity Analysis

- **Time Complexity:** **O(n)** - Every node is visited exactly once.

- **Space Complexity:** **O(h)** - The recursive call stack requires space proportional to the height of the tree. In the worst case, this is O(n).

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
    private int ans = Integer.MAX_VALUE;
    private TreeNode prev = null;

    public int getMinimumDifference(TreeNode root) {
        if (root == null) return 0;

        inorder(root);

        return ans;
    }

    private void inorder(TreeNode root) {
        if (root == null) return;

        inorder(root.left);

        if (prev != null) {
            ans = Math.min(ans, Math.abs(prev.val - root.val));
        }

        prev = root;

        inorder(root.right);
    }
}
```

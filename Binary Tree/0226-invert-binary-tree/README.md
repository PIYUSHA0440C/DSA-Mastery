# 226. Invert Binary Tree (Easy)

## 📝 Problem Statement

Given the root of a binary tree, invert the tree by swapping the left and right child of every node, and return the root of the inverted tree.

---

## 💡 Intuition & Approach

Inverting a binary tree simply means mirroring it about its root. For every node in the tree:

- The left child becomes the right child.
- The right child becomes the left child.

A **Depth-First Search (DFS)** recursively visits every node exactly once. After recursively processing both subtrees, we swap the current node's left and right children.

Since every node is visited once and the swap operation takes constant time, the solution is both simple and efficient.

### 🛠️ The Strategy

1. **Handle the Base Case**
   - If the current node is `null`, return `null`.

2. **Recursively Traverse**
   - Invert the left subtree.
   - Invert the right subtree.

3. **Swap the Children**
   - Exchange the left and right child pointers of the current node.

4. **Return the Root**
   - Return the root of the inverted subtree.

---

## 📊 Complexity Analysis

- **Time Complexity:** **O(n)** - Every node is visited exactly once.

- **Space Complexity:** **O(h)** - Due to the recursion stack, where `h` is the height of the tree. In the worst case, this becomes **O(n)** for a skewed tree and **O(log n)** for a balanced tree.

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
    public TreeNode invertTree(TreeNode root) {
        if(root == null) return null;

        invertTree(root.left);
        invertTree(root.right);

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        return root;
    }
}
```

# 701. Insert into a Binary Search Tree (Medium)

## 📝 Problem Statement

You are given the root of a **Binary Search Tree (BST)** and an integer `val`. Insert `val` into the BST and return the root of the updated tree.

It is guaranteed that `val` does not already exist in the tree. Any valid insertion that preserves the BST property is accepted.

---

## 💡 Intuition & Approach

A **Binary Search Tree (BST)** maintains the following property:

- All values in the **left subtree** are smaller than the current node.
- All values in the **right subtree** are greater than the current node.

Starting from the root, compare the value to be inserted with the current node:

- If the value is smaller, recursively move to the left subtree.
- If the value is greater, recursively move to the right subtree.
- Once a `null` position is reached, create a new node and insert it there.

Since each recursive call returns the updated subtree, the original tree structure is preserved while the new node is attached at the correct location.

### 🛠️ The Strategy

1. **Base Case**
   - If the current node is `null`, create and return a new node containing `val`.

2. **Traverse the BST**
   - If `val` is smaller than the current node, recursively insert into the left subtree.
   - If `val` is greater, recursively insert into the right subtree.

3. **Reconnect the Subtree**
   - Assign the returned subtree back to the corresponding child pointer.

4. **Return the Root**
   - Return the current node so the updated tree propagates back through the recursive calls.

---

## 📊 Complexity Analysis

- **Time Complexity:** **O(H)**, where `H` is the height of the BST.
  - **Balanced BST:** `O(log n)`
  - **Skewed BST:** `O(n)`

- **Space Complexity:** **O(H)** due to the recursion stack.
  - **Balanced BST:** `O(log n)`
  - **Skewed BST:** `O(n)`

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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);

        if (val > root.val)
            root.right = insertIntoBST(root.right, val);
        else if (val < root.val)
            root.left = insertIntoBST(root.left, val);

        return root;
    }
}
```

# 101. Symmetric Tree (Easy)

## 📝 Problem Statement
Given the `root` of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).

## 💡 Intuition & Approach
A binary tree is symmetric if its left subtree is a perfect mirror image of its right subtree. To verify this property, we can conceptualize cloning the tree into two separate structural branches and traversing them simultaneously in a mirrored fashion.

Two subtrees are mirrors of each other if:
1. Their current root nodes hold identical values.
2. The **left** child of the left subtree matches the **right** child of the right subtree.
3. The **right** child of the left subtree matches the **left** child of the right subtree.

We use a recursive helper function `isMirror` that takes two node references simultaneously. If both references hit null boundaries at the same time, that path is symmetric. If only one hits null or if the node values differ, the symmetry breaks immediately.

### 🛠️ The Strategy:
1. **Root Verification:** If the tree is empty (`root == null`), return `true`. Otherwise, invoke the mirrored comparison between `root.left` and `root.right`.
2. **Base Cases:** - If both node references are null, return `true`.
   - If only one node reference is null, return `false`.
3. **Value and Structure Check:** Return true only if `leftNode.val == rightNode.val` AND the outer children match (`isMirror(leftNode.left, rightNode.right)`) AND the inner children match (`isMirror(leftNode.right, rightNode.left)`).

## 📊 Complexity Analysis
* **Time Complexity:** O(N) - We visit every node in the binary tree exactly once, executing constant-time structural comparisons at each node pair.
* **Space Complexity:** O(H) - The maximum memory allocated on the call stack corresponds directly to the height of the binary tree $H$. In the worst-case scenario of a completely skewed tree, this takes $O(N)$ space.

## 💻 Implementation (Java)
```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;

        // Verify if the left branch and right branch mirror each other
        return isMirror(root.left, root.right);
    }

    private boolean isMirror(TreeNode leftNode, TreeNode rightNode) {
        // Case 1: Both paths terminate together
        if (leftNode == null && rightNode == null) return true;

        // Case 2: Structural asymmetry detected (one is null, other is not)
        if (leftNode == null || rightNode == null) return false;

        // Case 3: Values must match, and children must mirror each other crosswise
        return (leftNode.val == rightNode.val)
            && isMirror(leftNode.left, rightNode.right)
            // Outer subtrees match
            && isMirror(leftNode.right, rightNode.left); // Inner subtrees match
    }
}

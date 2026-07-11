# 1008. Construct Binary Search Tree from Preorder Traversal (Medium)

## 📝 Problem Statement
Given an array of integers `preorder`, which represents the preorder traversal of a BST (i.e., binary search tree), construct the tree and return its root.

A binary search tree is a binary tree where for every node, any descendant of `Node.left` has a value strictly less than `Node.val`, and any descendant of `Node.right` has a value strictly greater than `Node.val`.
A preorder traversal displays the value of the node first, then traverses `Node.left`, then traverses `Node.right`.

## 💡 Intuition & Approach
A preorder traversal follows the **Root $\rightarrow$ Left $\rightarrow$ Right** sequence. This means the first element of any sub-segment in the array is guaranteed to be the root node for that specific subtree. 

Leveraging the structural properties of a Binary Search Tree (BST), all elements smaller than the root's value belong to its left subtree, and all elements larger belong to its right subtree. By tracking our array boundaries with `start` and `end` pointers, we can:
1. Establish the current element at `preorder[start]` as the root node.
2. Scan the remaining elements in the segment to find the first value strictly greater than the root's value. This index `i` marks the structural boundary split between the left and right subtrees.
3. Recursively build the left subtree using the range `[start + 1, i - 1]` and the right subtree using the range `[i, end]`.

### 🛠️ The Strategy:
1. **Divide and Conquer Routine:** Set up a recursive helper method taking index boundaries `start` and `end`.
2. **Base Condition:** If `start > end`, the range is exhausted; return `null`.
3. **Pivot Search:** Initialize the current root node with `preorder[start]`. Loop from `start` onward until finding an element where `preorder[i] > node.val` to locate the right subtree threshold.
4. **Subtree Assembly:** Bind `node.left` to the left partition result and `node.right` to the right partition result, then return the constructed node.

## 📊 Complexity Analysis
* **Time Complexity:** O(N²) worst-case, O(N log N) average-case - In the worst-case scenario of a strictly skewed tree (e.g., sorted descending), the inner loop scans the remaining elements completely at each step, resulting in a quadratic $O(N^2)$ time pattern.
* **Space Complexity:** O(H) - The maximum memory allocated on the call stack corresponds directly to the height of the tree $H$. In the worst-case scenario of a skewed tree, it takes $O(N)$ space.

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
    public TreeNode bstFromPreorder(int[] preorder) {
        return helper(preorder, 0, preorder.length - 1);
    }

    private TreeNode helper(int[] preorder, int start, int end) {
        if (start > end) return null;

        // The first element in a preorder segment is always the root of that subtree
        TreeNode node = new TreeNode(preorder[start]);
        
        // Locate the boundary where elements become larger than the root value
        int i;
        for (i = start; i <= end; i++) {
            if (preorder[i] > node.val) break;
        }

        // Elements before index 'i' go to the left; elements from 'i' onward go to the right
        node.left = helper(preorder, start + 1, i - 1);
        node.right = helper(preorder, i, end);
        
        return node;
    }
}

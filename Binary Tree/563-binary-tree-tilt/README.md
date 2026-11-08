# 563. Binary Tree Tilt (Easy)

## 📝 Problem Statement

Given the root of a binary tree, calculate the sum of the tilt of every node.

The tilt of a node is the absolute difference between the sum of its left subtree values and the sum of its right subtree values. A missing subtree has a sum of zero.

## 💡 Intuition & Approach

Use a postorder traversal to calculate subtree sums.

For each node, recursively calculate the sums of its left and right subtrees. Their absolute difference gives the node's tilt. Add this tilt to the total and return the sum of the entire subtree to the parent.

## 🛠️ The Strategy:

1. Initialize a variable `totalTilt` to store the cumulative tilt.
2. Use a recursive helper method `valueSum()`:
   - Return `0` if the node is null.
   - Calculate the left and right subtree sums recursively.
   - Calculate the current node's tilt using the absolute difference between both sums.
   - Add the tilt to `totalTilt`.
   - Return the current node's value plus both subtree sums.
3. Return `totalTilt` after processing the tree.

## 📊 Complexity Analysis

- **Time Complexity:** O(n), as every node is visited exactly once.
- **Space Complexity:** O(h), where h is the height of the tree, due to the recursion stack. In the worst case, O(n).

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
    private int totalTilt = 0;

    
    public int findTilt(TreeNode root) {
        valueSum(root);

        return totalTilt;
    }

    private int valueSum(TreeNode node) {
        if (node == null) return 0;

        int leftSum = valueSum(node.left);
        int rightSum = valueSum(node.right);
        int tilt = Math.abs(leftSum - rightSum);

        totalTilt += tilt;

        return node.val + leftSum + rightSum;
    }
}
```

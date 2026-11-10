# 1372. Longest ZigZag Path in a Binary Tree (Medium)

## 📝 Problem Statement

Given the root of a binary tree, find the length of the longest ZigZag path.

A ZigZag path starts at any node and alternates directions between left and right at every step. Its length is the number of edges traversed.

## 💡 Intuition & Approach

Use Depth-First Search (DFS) to explore both possible directions from every node while tracking the current ZigZag path length.

The `goLeft` boolean indicates the direction of the next move:

- If `goLeft` is `true`, move to the left child and increment the current path length. For the right child, start a new path with length 1.
- If `goLeft` is `false`, move to the right child and increment the current path length. For the left child, start a new path with length 1.

At every node, update the global `pathLength` with the maximum number of edges found so far.

Starting DFS with `goLeft = true` and `steps = 0` is sufficient because both possible directions are explored from the root, and every subsequent child is also considered as a potential starting point for a new ZigZag path.

## 🛠️ The Strategy:

1. Initialize `pathLength` to 0.
2. Start DFS from the root with `goLeft = true` and `steps = 0`.
3. Update the maximum path length at each visited node.
4. Continue in the expected alternating direction with `steps + 1`.
5. Start a new ZigZag path in the opposite direction with `steps = 1`.
6. Return the maximum path length.

## 📊 Complexity Analysis

- **Time Complexity:** O(n), where n is the number of nodes. Each node is visited once.
- **Space Complexity:** O(h), where h is the height of the tree, due to the recursive DFS call stack. In the worst case, this is O(n).

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
    private int pathLength = 0;

    public int longestZigZag(TreeNode root) {
        dfs(root, true, 0);
        return pathLength;
    }

    private void dfs(TreeNode node, boolean goLeft, int steps) {
        if (node == null) return;

        pathLength = Math.max(pathLength, steps);

        if (goLeft) {
            dfs(node.left, false, steps + 1);
            dfs(node.right, true, 1);
        } else {
            dfs(node.left, false, 1);
            dfs(node.right, true, steps + 1);
        }
    }
}
```

# 437. Path Sum III (Medium)

## 📝 Problem Statement

Given the root of a binary tree and an integer `targetSum`, count the number of downward paths whose node values add up to `targetSum`.

A path can start and end at any node, but it must follow the parent-to-child direction.

## 💡 Intuition & Approach

A valid path can start from any node in the tree. Therefore, consider every node as a possible starting point and explore all downward paths from it.

Use a recursive traversal to calculate the running sum and count paths that match the target.

## 🛠️ The Strategy:

1. Use `findPath()` to visit every node and treat it as a possible starting point.
2. For each starting node, call `explore()` to traverse all downward paths.
3. Maintain a running sum using `long` to avoid integer overflow.
4. Whenever the running sum equals `targetSum`, increment the path count.
5. Recursively explore the left and right subtrees.

## 📊 Complexity Analysis

- **Time Complexity:** O(n²) in the worst case. Each node can initiate a traversal of the remaining tree. This occurs in a highly skewed tree.
- **Space Complexity:** O(h), where h is the height of the tree, due to recursive calls. In the worst case, this becomes O(n).

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
    private int count = 0;

    public int pathSum(TreeNode root, int targetSum) {
        findPath(root, targetSum);
        return count;
    }

    private void findPath(TreeNode root, int target) {
        if (root == null) return;

        explore(root, 0, target);

        findPath(root.left, target);
        findPath(root.right, target);
    }

    private void explore(TreeNode root, long sum, int target) {
        if (root == null) return;

        sum += root.val;

        if (sum == target) count++;

        explore(root.left, sum, target);
        explore(root.right, sum, target);
    }
}
```

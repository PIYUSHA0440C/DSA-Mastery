# 671. Second Minimum Node In a Binary Tree (Easy)

## 📝 Problem Statement

Given a special binary tree where every internal node has exactly two children and its value is the minimum of its children's values, find the second distinct minimum value among all nodes.

Return `-1` if no second minimum value exists.

## 💡 Intuition & Approach

The root contains the minimum value of the entire tree because every parent is the minimum of its two children.

To find the second minimum value, use Depth-First Search (DFS):

- Store the root value as the global minimum (`min1`).
- Maintain `ans` to track the smallest value greater than `min1`.
- If the current node's value is greater than `min1` and smaller than `ans`, update `ans`.
- If the current node's value equals `min1`, explore its left and right subtrees because a larger value may exist deeper in those subtrees.
- If the current node's value is already greater than `min1`, there is no need to explore its descendants. The special tree property guarantees that its descendants cannot have a smaller value.

Finally, return `ans` if a second distinct minimum was found; otherwise, return `-1`.

## 🛠️ The Strategy:

1. Initialize `min1` with `root.val`.
2. Start DFS from the root.
3. Update the candidate answer whenever a value greater than `min1` is smaller than the current candidate.
4. Continue traversal only through nodes equal to `min1`.
5. Return the candidate or `-1` if no valid value exists.

## 📊 Complexity Analysis

- **Time Complexity:** O(n), where n is the number of nodes. Each node is visited at most once.
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
    private int min1;
    private long ans = Long.MAX_VALUE;

    public int findSecondMinimumValue(TreeNode root) {
        min1 = root.val;
        dfs(root);

        return ans < Long.MAX_VALUE ? (int) ans : -1;
    }

    private void dfs(TreeNode root) {
        if (root == null) return;

        if (min1 < root.val && root.val < ans) ans = root.val;
        else if (min1 == root.val) {
            dfs(root.left);
            dfs(root.right);
        }
    }
}
```

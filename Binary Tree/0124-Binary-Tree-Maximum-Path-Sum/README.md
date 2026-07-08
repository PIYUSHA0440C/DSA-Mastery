# 124. Binary Tree Maximum Path Sum (Hard)

## 📝 Problem Statement
A path in a binary tree is a sequence of nodes where each pair of adjacent nodes in the sequence has an edge connecting them. A node can only appear in the sequence at most once. Note that the path does not need to pass through the root.

The path sum of a path is the sum of the node's values in the path. Given the `root` of a binary tree, return the maximum path sum of any non-empty path.

## 💡 Intuition & Approach
To find the maximum path sum anywhere in the tree, we can think of every node as a potential "turnaround point" or highest hook of the path. A path turning around at a specific node will include that node's value plus the best contributions from its left and right subtrees. 

We use a recursive **Post-Order Traversal (DFS)**. For each node, we recursively calculate the maximum gain its left and right subtrees can contribute. If a subtree returns a negative sum, it will only decrease our path sum, so we greedily ignore it by capping it at `0` using `Math.max(contribution, 0)`.

At each node, we perform two distinct calculations:
1. **Local Path Sum (Turnaround):** We check the sum if a path passes from the left subtree, through the current node, and down into the right subtree (`node.val + left + right`). We check this sum against a global maximum tracker (`ans`).
2. **Max Gain to Return:** A parent node can only continue a path down one of its branches (either left or right, not both). Thus, the function returns `node.val + Math.max(left, right)` up to its parent call.

### 🛠️ The Strategy:
1. **Global Maximum Tracker:** Initialize a global instance variable `ans = Integer.MIN_VALUE` to handle trees containing entirely negative node values.
2. **Bottom-Up Post-Order Core:** Recursively calculate subtree gains.
3. **Greedy Negative Filtering:** If `helper(node.left)` or `helper(node.right)` returns a value less than zero, substitute it with `0`.
4. **Global Updates:** Compute `pathSum = node.val + left + right` at each step and update `ans = Math.max(ans, pathSum)`.
5. **Parent Linkage:** Return `node.val + Math.max(left, right)` back up the recursion stack to allow upper nodes to continue the path.

## 📊 Complexity Analysis
* **Time Complexity:** O(N) - We visit every node in the tree exactly once to calculate sub-path values.
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
    int ans = Integer.MIN_VALUE; // Tracks the global maximum path sum found
    
    public int maxPathSum(TreeNode root) {
        helper(root);
        return ans;
    }

    private int helper(TreeNode node) {
        if (node == null) return 0;

        // Get left and right max path sum; greedily ignore negative paths
        int left = Math.max(helper(node.left), 0);
        int right = Math.max(helper(node.right), 0);

        // Compute the path sum if the current node acts as the highest point (turnaround node)
        int pathSum = node.val + left + right;
        
        // Update the global tracker
        ans = Math.max(ans, pathSum);

        // Return the maximum single-branch gain including the current node to its parent
        return node.val + Math.max(left, right);
    }
}

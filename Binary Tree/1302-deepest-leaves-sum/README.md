# 1302. Deepest Leaves Sum (Medium)

## 📝 Problem Statement

Given the root of a binary tree, return the sum of the values of all leaves located at the maximum depth.

## 💡 Intuition & Approach

Use Breadth-First Search (BFS) to traverse the tree level by level.

Calculate the sum of nodes at each level. Since BFS processes all nodes at the same depth together, the sum from the final processed level will be the sum of the deepest leaves.

## 🛠️ The Strategy:

1. Initialize a queue and insert the root node.
2. Process the tree level by level using BFS.
3. For each level:
   - Store the current queue size.
   - Reset the level sum to zero.
   - Process all nodes at that level and add their values.
   - Add their non-null children to the queue.
4. Update the answer with the current level sum.
5. Return the answer after the queue becomes empty.

## 📊 Complexity Analysis

- **Time Complexity:** O(n), as every node is visited exactly once.
- **Space Complexity:** O(w), where w is the maximum width of the tree, for the BFS queue. In the worst case, O(n).

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
    public int deepestLeavesSum(TreeNode root) {
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);

        int ans = 0;
        while (!queue.isEmpty()) {
            int len = queue.size();
            int sum = 0;
            
            for (int i = 0; i < len; i++) {
                TreeNode node = queue.poll();
                sum += node.val;

                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }

            ans = sum;
        }

        return ans;
    }
}
```

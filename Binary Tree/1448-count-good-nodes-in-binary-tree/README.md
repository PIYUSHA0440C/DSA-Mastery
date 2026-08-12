# 1448. Count Good Nodes in Binary Tree (Medium)

## 📝 Problem Statement
Given the root of a binary tree, a node X is considered **good** if there are no nodes with a value greater than X on the path from the root to X.

Return the number of good nodes in the binary tree.

## 💡 Intuition & Approach
To determine whether a node is good, we only need to know the **maximum value encountered on the path from the root to that node**.

We use **Depth-First Search (DFS)** and pass the current maximum value along the traversal.

At each node:
1. If `node.val >= max`, the node is a good node.
2. Update the maximum value with the current node's value.
3. Recursively traverse the left and right subtrees using the updated maximum.
4. Add the number of good nodes returned by both subtrees.

The root is always considered a good node because there are no previous nodes on its path.

### 🛠️ The Strategy:
1. Start DFS from the root with `Integer.MIN_VALUE` as the initial maximum.
2. Compare the current node's value with the maximum value encountered on its path.
3. If `node.val >= max`, count it as a good node and update `max`.
4. Recursively process the left and right subtrees.
5. Return the total count.

## 📊 Complexity Analysis
* **Time Complexity:** O(n) - Every node is visited exactly once.
* **Space Complexity:** O(h) - The recursion stack requires space proportional to the height of the tree, where `h` is the tree height. In the worst case, this is O(n).

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
    public int goodNodes(TreeNode root) {
        return dfs(root, Integer.MIN_VALUE);
    }

    private int dfs(TreeNode node, int max) {
        if(node == null) return 0;

        int count = 0;

        if(node.val >= max) {
            count = 1;
            max = Math.max(max, node.val);
        }

        count += dfs(node.left, max);
        count += dfs(node.right, max);

        return count;
    }
}
```

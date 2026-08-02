# 111. Minimum Depth of Binary Tree (Easy)

## 📝 Problem Statement

Given the root of a binary tree, return its **minimum depth**.

The minimum depth is the number of nodes along the shortest path from the root down to the nearest **leaf node**.

A leaf is a node with no left or right child.

---

## 💡 Intuition & Approach

Since we need the **shortest root-to-leaf path**, **Breadth-First Search (BFS)** is the most natural approach.

BFS explores the tree **level by level**. The first leaf node encountered must be the closest one to the root, so we can immediately return the current depth without traversing the remaining nodes.

This avoids unnecessary work compared to exploring every path.

### 🛠️ The Strategy

1. **Handle Empty Tree**
   - If the root is `null`, return `0`.

2. **Initialize BFS**
   - Insert the root into a queue.
   - Initialize the current depth as `1`.

3. **Traverse Level by Level**
   - Process all nodes at the current depth.
   - If a node is a leaf, return the current depth immediately.
   - Otherwise, enqueue its non-null children.

4. **Return the Minimum Depth**
   - The first leaf reached during BFS gives the minimum depth.

---

## 📊 Complexity Analysis

- **Time Complexity:** **O(n)** - In the worst case, every node is visited once.

- **Space Complexity:** **O(n)** - The queue may contain all nodes at the widest level of the tree.

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
    public int minDepth(TreeNode root) {
        if(root == null) return 0;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int depth = 0;

        while(!queue.isEmpty()) {
            depth++;

            int n = queue.size();

            while(n > 0) {
                TreeNode node = queue.poll();

                if(node.left == null && node.right == null) {
                    return depth;
                }

                if(node.left != null) queue.offer(node.left);
                if(node.right != null) queue.offer(node.right);

                n--;
            }
        }

        return depth;
    }
}
```

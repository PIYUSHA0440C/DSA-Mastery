# 2583. Kth Largest Sum in a Binary Tree (Medium)

## 📝 Problem Statement

Given the root of a binary tree and an integer `k`, find the kth largest level sum.

A level sum is the sum of all node values at the same depth. If the tree has fewer than `k` levels, return `-1`.

## 💡 Intuition & Approach

Use Breadth-First Search (BFS) to calculate the sum of each level. Maintain a min-heap of size at most `k` to keep track of the `k` largest level sums.

The smallest element in the heap represents the kth largest level sum once all levels have been processed.

## 🛠️ The Strategy:

1. Initialize a BFS queue and insert the root node.
2. Create a min-heap to store the `k` largest level sums.
3. Traverse the tree level by level:
   - Calculate the sum of all nodes at the current level.
   - Add their non-null children to the queue.
   - Insert the level sum into the min-heap.
   - If the heap size exceeds `k`, remove its smallest element.
4. After processing all levels, check whether the heap contains at least `k` elements.
5. Return `-1` if fewer than `k` levels exist; otherwise, return the heap's minimum element.

## 📊 Complexity Analysis

Let `n` be the number of nodes and `L` be the number of levels.

- **Time Complexity:** O(n + L log k). BFS visits every node once, and each level sum requires O(log k) heap operations.
- **Space Complexity:** O(n + k) in the worst case, including the BFS queue and min-heap.

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
    public long kthLargestLevelSum(TreeNode root, int k) {
        PriorityQueue<Long> minHeap = new PriorityQueue<>();

        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            long sum = 0;

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                sum += node.val;

                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }

            minHeap.offer(sum);
            if (minHeap.size() > k) minHeap.poll();
        }

        return minHeap.size() < k ? -1 : minHeap.peek();
    }
}
```

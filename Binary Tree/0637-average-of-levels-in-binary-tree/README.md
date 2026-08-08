# 637. Average of Levels in Binary Tree (Easy)

## 📝 Problem Statement

Given the root of a binary tree, return the **average value of the nodes at each level**.

The averages can be returned in any format accepted by the problem, with an error tolerance of `10^-5`.

---

## 💡 Intuition & Approach

Since the average needs to be calculated separately for every level, **Breadth-First Search (BFS)** is a natural fit.

A queue is used to process the tree level by level. At the beginning of each level, the queue contains exactly the nodes belonging to that level.

For every level:

- Store the number of nodes currently in the queue.
- Remove and process exactly those nodes.
- Add their values to a running sum.
- Add their children to the queue for the next level.
- Divide the sum by the number of nodes in the current level and store the result.

Using `double` for the sum and average avoids integer division and handles the required precision.

### 🛠️ The Strategy

1. **Initialize BFS**
   - Add the root to a queue.

2. **Process One Level**
   - Store the current queue size as `n`.
   - Process exactly `n` nodes.
   - Calculate their total sum.

3. **Prepare the Next Level**
   - Add every non-null left and right child to the queue.

4. **Calculate Average**
   - Compute:
     ```
     average = sum / n
     ```
   - Add it to the result list.

5. **Repeat**
   - Continue until the queue becomes empty.

---

## 📊 Complexity Analysis

- **Time Complexity:** **O(n)** - Every node is visited exactly once.

- **Space Complexity:** **O(n)** - The queue can contain up to O(n) nodes in the widest level.

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
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> ans = new ArrayList<>();

        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int n = queue.size();
            double sum = 0.0;

            for (int i = 0; i < n; i++) {
                TreeNode temp = queue.poll();
                sum += temp.val;

                if (temp.left != null) queue.offer(temp.left);
                if (temp.right != null) queue.offer(temp.right);
            }

            double avg = sum / n;
            ans.add(avg);
        }

        return ans;
    }
}
```

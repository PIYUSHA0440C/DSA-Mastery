# 1161. Maximum Level Sum of a Binary Tree (Medium)

## 📝 Problem Statement
Given the root of a binary tree, where the root is at level `1`, return the **smallest level** whose sum of node values is maximum.

## 💡 Intuition & Approach
Since we need to calculate the sum of values at each level, **Breadth-First Search (BFS)** is a natural approach.

We use a queue to process the tree level by level. For each level:
- Store the number of nodes currently in the queue.
- Remove exactly those nodes and calculate their sum.
- Add their children to the queue for the next level.
- Compare the current level sum with the maximum sum found so far.

We update the answer only when `levelSum > maxSum`. This is important because if two levels have the same maximum sum, keeping the earlier level gives the required **smallest level**.

### 🛠️ The Strategy:
1. Initialize a queue with the root node.
2. Track the current level, maximum sum, and corresponding level.
3. Process all nodes belonging to the current level.
4. Calculate the sum of that level and add its children to the queue.
5. Update the maximum only when the current sum is strictly greater.
6. Continue until all levels are processed.
7. Return the level with the maximum sum.

## 📊 Complexity Analysis
* **Time Complexity:** O(n) - Every node is visited and processed exactly once.

* **Space Complexity:** O(w) - The queue stores nodes from the current/next level, where `w` is the maximum width of the tree. In the worst case, this is O(n).

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
    public int maxLevelSum(TreeNode root) {
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        
        int maxSum = Integer.MIN_VALUE;
        int maxLevel = 1;
        int currentLevel = 1;

        while(!queue.isEmpty()){
            int levelSize = queue.size();
            int levelSum = 0;

            for(int i = 0; i < levelSize; i++){
                TreeNode node = queue.poll();
                levelSum += node.val;

                if(node.left != null) queue.offer(node.left);
                if(node.right != null) queue.offer(node.right);
            }

            if(levelSum > maxSum) {
                maxSum = levelSum;
                maxLevel = currentLevel;
            }

            currentLevel++;
        }

        return maxLevel;
    }
}
```

# 515. Find Largest Value in Each Tree Row (Medium)


## 📝 Problem Statement


Given the root of a binary tree, return an array containing the largest value in each row of the tree.


## 💡 Intuition & Approach


We use **Breadth-First Search (BFS)** to traverse the tree level by level.


For each level, we initialize the maximum value to `Integer.MIN_VALUE` and compare it with every node in that level. After processing the entire level, we add the maximum value found to the result.


### 🛠️ The Strategy:


1. Return an empty list if the tree is empty.
2. Add the root node to a queue.
3. For each level, determine the number of nodes currently in the queue.
4. Initialize `max` to `Integer.MIN_VALUE`.
5. Process every node in the current level and update `max`.
6. Add each node's left and right children to the queue.
7. Add the maximum value of the current level to the result.
8. Continue until all levels have been processed.


## 📊 Complexity Analysis


* **Time Complexity:** O(n) - Every node is visited exactly once.


* **Space Complexity:** O(n) - The queue can contain up to O(n) nodes in the worst case.


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
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();

        if(root == null) return res;

        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);


        while(!queue.isEmpty()){
            int size = queue.size();
            int max = Integer.MIN_VALUE;

            for(int i = 0; i < size; i++){
                TreeNode node = queue.poll();

                max = Math.max(max, node.val);

                if(node.left != null) queue.offer(node.left);
                if(node.right != null) queue.offer(node.right);
            }

            res.add(max);
        }

        return res;
    }
}

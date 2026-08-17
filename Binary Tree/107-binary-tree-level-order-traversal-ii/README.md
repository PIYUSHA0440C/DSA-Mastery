# 107. Binary Tree Level Order Traversal II (Medium)


## 📝 Problem Statement


Given the root of a binary tree, return the **bottom-up level order traversal** of its nodes' values.


The traversal should process the tree level by level from left to right, but return the levels in reverse order, starting from the leaf level and ending at the root level.


## 💡 Intuition & Approach


We use **Breadth-First Search (BFS)** to traverse the binary tree level by level.


A queue stores the nodes that need to be processed. For each level, we collect all node values into a separate list and add that list to the result.


Since BFS naturally processes levels from the root to the leaves, we reverse the result at the end to obtain the required bottom-up order.


### 🛠️ The Strategy:


1. Create an empty result list.
2. If the root is `null`, return the empty result.
3. Add the root to a queue.
4. Process the tree level by level using the current queue size.
5. Store the values of all nodes at the current level in a list.
6. Add the left and right children of each node to the queue.
7. Add the current level to the result.
8. Reverse the result to obtain the bottom-up level order traversal.
9. Return the reversed result.


## 📊 Complexity Analysis


* **Time Complexity:** O(n) - Every node is visited exactly once.


* **Space Complexity:** O(n) - The queue and result list require space proportional to the number of nodes.


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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();

        if(root == null) return ans;

        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            int n = queue.size();
            List<Integer> nodes = new ArrayList<>();

            for(int i = 0; i < n; i++){
                TreeNode node = queue.poll();
                nodes.add(node.val);

                if(node.left != null) queue.offer(node.left);
                if(node.right != null) queue.offer(node.right);
            }

            ans.add(nodes);
        }

        Collections.reverse(ans);

        return ans;
    }
}

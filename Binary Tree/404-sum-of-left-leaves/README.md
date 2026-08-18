# 404. Sum of Left Leaves (Easy)


## 📝 Problem Statement


Given the root of a binary tree, return the sum of all left leaves.


A **leaf** is a node with no children. A **left leaf** is a leaf that is the left child of another node.


## 💡 Intuition & Approach


We use **Breadth-First Search (BFS)** to traverse the binary tree level by level.


For every node, we check whether its left child exists and is a leaf node. If so, we add its value to the answer.


A node is a left leaf when:


- It is the left child of another node.
- It has no left child.
- It has no right child.


### 🛠️ The Strategy:


1. Create a queue and add the root node.
2. Traverse the tree using BFS.
3. For each node, check whether its left child is a leaf.
4. If the left child is a leaf, add its value to the sum.
5. Add the current node's left and right children to the queue if they exist.
6. Continue until all nodes have been processed.
7. Return the total sum of all left leaves.


## 📊 Complexity Analysis


* **Time Complexity:** O(n) - Every node is visited once.


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
    public int sumOfLeftLeaves(TreeNode root) {
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);

        int ans = 0;

        while(!queue.isEmpty()){
            int n = queue.size();

            for(int i = 0; i < n; i++){
                TreeNode node = queue.poll();

                if (node.left != null && node.left.left == null && node.left.right == null) {
                    ans += node.left.val;
                }
                
                if(node.left != null) queue.offer(node.left);
                if(node.right != null) queue.offer(node.right);
            }
        }

        return ans;
    }
}

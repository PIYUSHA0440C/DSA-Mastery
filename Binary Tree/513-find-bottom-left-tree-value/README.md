# 513. Find Bottom Left Tree Value (Medium)


## 📝 Problem Statement


Given the root of a binary tree, return the **leftmost value in the last row** of the tree.


## 💡 Intuition & Approach


We use **Breadth-First Search (BFS)** to traverse the binary tree level by level.


At the beginning of each level, the first node in the queue is the leftmost node of that level. By updating the answer with this node before processing the level, the final value assigned to `ans` will be the leftmost node of the last level.


### 🛠️ The Strategy:


1. Create a queue and add the root node.
2. At the start of each level, store the value of the first node in the queue.
3. Process all nodes of the current level.
4. Add each node's left child before its right child to maintain left-to-right order.
5. Continue until all levels are processed.
6. The final stored value is the leftmost value of the bottom level.
7. Return the answer.


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
    public int findBottomLeftValue(TreeNode root) {
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        int ans = 0;

        while(!queue.isEmpty()){
            ans = queue.peek().val;
            int size = queue.size();

            for(int i = 0; i < size; i++){
                TreeNode node = queue.poll();

                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
            }
        }

        return ans;
    }
}

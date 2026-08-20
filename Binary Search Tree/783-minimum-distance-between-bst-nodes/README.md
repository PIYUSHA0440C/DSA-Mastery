# 783. Minimum Distance Between BST Nodes (Easy)


## 📝 Problem Statement


Given the root of a Binary Search Tree (BST), return the minimum difference between the values of any two different nodes in the tree.


## 💡 Intuition & Approach


An important property of a BST is that an **inorder traversal visits the nodes in sorted order**.


Therefore, the minimum difference between any two node values must occur between two consecutive values in the inorder traversal.


We use an **iterative inorder traversal** with a stack. While traversing the nodes in sorted order, we compare each node's value with the previously visited value and keep track of the minimum difference.


### 🛠️ The Strategy:


1. Initialize `minDiff` with `Integer.MAX_VALUE`.
2. Use a stack to perform an iterative inorder traversal.
3. Traverse as far left as possible and push each node onto the stack.
4. Pop the next node from the stack.
5. Compare its value with the previously visited node's value.
6. Update `minDiff` with the smaller difference.
7. Store the current node's value as `prev`.
8. Continue with the current node's right subtree.
9. Return the minimum difference found.


## 📊 Complexity Analysis


* **Time Complexity:** O(n) - Every node is visited exactly once.


* **Space Complexity:** O(h) - The stack stores nodes along the current path, where `h` is the height of the tree. In the worst case, this becomes O(n).


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
    public int minDiffInBST(TreeNode root) {
        int minDiff = Integer.MAX_VALUE;
        Integer prev = null;

        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode current = root;

        while(current != null || !stack.isEmpty()){
            while(current != null){
                stack.push(current);
                current = current.left;
            }

            current = stack.pollFirst();

            if(prev != null){
                minDiff = Math.min(minDiff, current.val - prev);
            }

            prev = current.val;

            current = current.right;
        }

        return minDiff;
    }
}

# 230. Kth Smallest Element in a BST (Medium)

## 📝 Problem Statement
Given the `root` of a binary search tree, and an integer `k`, return the `kth` smallest value (1-indexed) of all the values of the nodes in the tree.

## 💡 Intuition & Approach
A key property of a Binary Search Tree (BST) is that performing an **Inorder Traversal (Left $\rightarrow$ Root $\rightarrow$ Right)** visits the nodes in strictly ascending numerical order. Therefore, finding the $k$-th smallest element is equivalent to finding the $k$-th node visited during an inorder traversal.

Instead of traversing the entire tree and storing all elements in a separate list (which consumes extra memory), we can optimize the process using an **early-exit state tracking mechanism**. We maintain a global `count` tracking variable initialized to `k`. As we traverse the tree from left to right, we decrement `count` each time we visit a node's root state. When `count` drops to zero, we have landed exactly on the $k$-th smallest value. We log it in a `result` variable and execute immediate early returns to prune the remaining unvisited execution branches.

### 🛠️ The Strategy:
1. **Initialize State Trackers:** Bind the value `k` to an instance counter variable `count`.
2. **Left Subtree Drill:** Recursively traverse down `node.left`. If `count <= 0` at any point, trigger early returns to stop deeper evaluations.
3. **Node Processing & Decrement:** Decrement `count`. If `count == 0`, capture `result = node.val` and stop further execution.
4. **Right Subtree Pivot:** Recursively branch down `node.right` to process remaining paths if the target has not yet been hit.

## 📊 Complexity Analysis
* **Time Complexity:** O(H + K) - The traversal drops down to the leftmost leaf node taking $O(H)$ steps, then moves through $K$ nodes to find the target. In the worst-case scenario of a highly skewed tree, this operation takes $O(N)$ time.
* **Space Complexity:** O(H) - The memory footprint corresponds to the recursive call stack height $H$. For balanced trees, this equates to $O(\log N)$, maximizing stack space efficiency without auxiliary storage arrays.

## 💻 Implementation (Java)
```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    private int count;
    private int result;

    public int kthSmallest(TreeNode root, int k) {
        this.count = k;
        this.result = -1;

        // Initiate our ordered search pattern
        inorder(root);

        return result;
    }

    private void inorder(TreeNode node) {
        // Stop traversal early if target node has already been found
        if (node == null || count <= 0) return;

        // Traverse Left Subtree
        inorder(node.left);
        
        // Process Current Node (Root step)
        if (--count == 0) {
            result = node.val;
            return;
        }

        // Traverse Right Subtree
        inorder(node.right);
    }
}

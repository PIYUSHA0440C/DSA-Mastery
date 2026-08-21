# 1379. Find a Corresponding Node of a Binary Tree in a Clone of That Tree (Easy)


## 📝 Problem Statement


Given two binary trees `original` and `cloned`, where `cloned` is an exact copy of `original`, and a reference to a target node in the `original` tree, return a reference to the corresponding node in the `cloned` tree.


The trees and the target node must not be modified.


## 💡 Intuition & Approach


Since the `cloned` tree has the exact same structure as the `original` tree, we can traverse both trees simultaneously.


At each step, we compare the current node of the `original` tree with the `target` node. When they are the same node, the corresponding node in the `cloned` tree is the answer.


We use **Depth-First Search (DFS)** and recursively traverse the left and right subtrees while keeping both trees synchronized.


### 🛠️ The Strategy:


1. Start DFS with the roots of both the `original` and `cloned` trees.
2. If the current node in `original` is the target, return the corresponding node from `cloned`.
3. Recursively search the left subtrees of both trees.
4. If the target is found in the left subtree, return the corresponding cloned node.
5. Otherwise, recursively search the right subtrees.
6. Return the result from the right subtree.
7. Since the trees have the same structure, the corresponding node is reached through the same traversal path.


## 📊 Complexity Analysis


* **Time Complexity:** O(n) - In the worst case, every node may need to be visited.


* **Space Complexity:** O(h) - The recursive call stack requires space proportional to the height of the tree, where `h` is the tree height. In the worst case, this becomes O(n).


## 💻 Implementation (Java)


```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        TreeNode res = null;

        if(original == target) return cloned;

        if(original.left != null){
            res = getTargetCopy(original.left, cloned.left, target);
            if(res != null) return res;
        }

        if(original.right != null){
            res = getTargetCopy(original.right, cloned.right, target);
        }

        return res;
    }
}

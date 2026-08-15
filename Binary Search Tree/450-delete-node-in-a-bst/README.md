# 450. Delete Node in a BST (Medium)


## 📝 Problem Statement


Given the root node of a Binary Search Tree (BST) and a key, delete the node with the given key from the BST and return the root node of the resulting BST.


The deletion process can be divided into two stages:


1. Search for the node containing the given key.
2. Delete the node while maintaining the BST properties.


When the node is found, there are three possible cases:


- The node is a leaf node, so it can be directly removed.
- The node has one child, so it can be replaced by its child.
- The node has two children, so it is replaced with its inorder successor, which is the smallest node in its right subtree.


## 💡 Intuition & Approach


We use the Binary Search Tree property to efficiently search for the node.


At each node:


1. If the key is smaller than the current node's value, recursively search in the left subtree.
2. If the key is greater than the current node's value, recursively search in the right subtree.
3. If the key matches the current node's value, handle the deletion based on its children.
4. If the node has two children, find the minimum-valued node in the right subtree (inorder successor).
5. Replace the current node's value with the successor's value and delete the successor from the right subtree.


### 🛠️ The Strategy:


1. Start from the root and compare the key with `root.val`.
2. Move left if `key < root.val` and right if `key > root.val`.
3. When the target node is found:
   - Return `null` if it is a leaf node.
   - Return its non-null child if it has only one child.
   - Find the inorder successor if it has two children.
4. Replace the node's value with the successor's value.
5. Delete the successor from the right subtree.
6. Return the updated root.


## 📊 Complexity Analysis


* **Time Complexity:** O(h) - The search and deletion follow a single path in the BST. Finding the inorder successor also takes at most O(h) time.


* **Space Complexity:** O(h) - The recursive calls require space proportional to the height of the tree. In the worst case, this becomes O(n).


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
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) return null;

        if(key < root.val) root.left = deleteNode(root.left, key);
        else if(key > root.val) root.right = deleteNode(root.right, key);
        else {
            if(root.left == null && root.right == null) return null;

            if(root.left == null) return root.right;
            if(root.right == null) return root.left;

            TreeNode successor = findMin(root.right);
            root.val = successor.val;
            root.right = deleteNode(root.right, successor.val);
        }

        return root;
    }

    private TreeNode findMin(TreeNode root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }
}

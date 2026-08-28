# 257. Binary Tree Paths (Easy)


## 📝 Problem Statement


Given the root of a binary tree, return all root-to-leaf paths in any order.


A leaf is a node with no children.


## 💡 Intuition & Approach


We use **Depth-First Search (DFS)** to explore every root-to-leaf path.


A `StringBuilder` is used to build the current path efficiently. When a leaf node is reached, the complete path is added to the result.


After processing a node's children, we restore the `StringBuilder` to its previous length. This **backtracking** allows the same `StringBuilder` to be reused for other paths.


### 🛠️ The Strategy:


1. Start DFS from the root with an empty `StringBuilder`.
2. Store the current path length before adding the node's value.
3. Append the current node's value to the path.
4. If the node is a leaf, add the completed path to the result.
5. Otherwise, append `"->"` and recursively process the left and right children.
6. Restore the previous path length after processing the node.
7. Return all collected root-to-leaf paths.


## 📊 Complexity Analysis


* **Time Complexity:** O(n × h) - Each node is visited once, and constructing/storing a path can take O(h), where `h` is the tree height.


* **Space Complexity:** O(h) - The recursion stack and current path require space proportional to the tree height, excluding the output.


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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        if (root != null) {
            dfs(root, new StringBuilder(), result);
        }

        return result;
    }

    private void dfs(TreeNode node, StringBuilder path, List<String> result){
        int currentLength = path.length();

        path.append(node.val);

        if (node.left == null && node.right == null) {
            result.add(path.toString());
        } else {
            path.append("->");
            if (node.left != null) {
                dfs(node.left, path, result);
            }
            if (node.right != null) {
                dfs(node.right, path, result);
            }
        }

        path.setLength(currentLength);
    }
}

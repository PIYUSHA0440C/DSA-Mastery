# 113. Path Sum II (Medium)

## 📝 Problem Statement

Given the root of a binary tree and an integer `targetSum`, return all **root-to-leaf** paths whose node values add up to `targetSum`.

Each valid path should be returned as a list of node values.

A leaf is a node with no children.

---

## 💡 Intuition & Approach

Since every root-to-leaf path must be explored, **Depth-First Search (DFS)** with **backtracking** is a natural solution.

As we traverse the tree:

- Keep track of the current path.
- Maintain the running sum of node values.
- Whenever a leaf node is reached, check if the running sum equals the target.
- If it does, store a copy of the current path.
- Backtrack by removing the current node before returning to the previous recursive call so the path can be reused for exploring other branches.

Backtracking ensures we use only one path list throughout the traversal while correctly exploring every possible root-to-leaf path.

### 🛠️ The Strategy

1. **Handle Empty Tree**
   - If the root is `null`, return an empty list.

2. **Perform DFS**
   - Add the current node to the path.
   - Update the running sum.

3. **Check Leaf Node**
   - If the current node is a leaf and the running sum equals the target, store a copy of the current path.

4. **Explore Both Subtrees**
   - Recursively traverse the left and right children.

5. **Backtrack**
   - Remove the current node from the path before returning.

---

## 📊 Complexity Analysis

- **Time Complexity:** **O(n × h)**, where `n` is the number of nodes and `h` is the average length of a valid path copied into the result. Every node is visited once, and copying a valid path takes **O(h)**.

- **Space Complexity:** **O(h)** for the recursion stack and current path, where `h` is the height of the tree (excluding the output list).

---

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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> output = new ArrayList<>();

        if(root == null) return output;

        dfs(root, 0, targetSum, output, new ArrayList<>());

        return output;
    }

    private void dfs(TreeNode node, int currSum, int target,
                     List<List<Integer>> output,
                     List<Integer> currentPath) {

        if(node == null) return;

        currSum += node.val;
        currentPath.add(node.val);

        if(node.left == null && node.right == null && currSum == target) {
            output.add(new ArrayList<>(currentPath));
        } else {
            dfs(node.left, currSum, target, output, currentPath);
            dfs(node.right, currSum, target, output, currentPath);
        }

        currentPath.remove(currentPath.size() - 1);
    }
}
```

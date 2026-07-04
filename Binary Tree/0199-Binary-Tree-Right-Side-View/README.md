# 199. Binary Tree Right Side View (Medium)

## 📝 Problem Statement
Given the `root` of a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.

## 💡 Intuition & Approach
To capture the right side view of a binary tree, we need to extract the last (rightmost) node visible at every single depth level. A recursive **Modified Depth-First Search (DFS)** traversal exploring the right subtrees before the left subtrees provides an elegant solution.

We maintain a tracking variable `currDepth` during our recursion. Because we prioritize the right child branches, the first node we encounter at any given depth level will always be the rightmost node of that layer. We can easily detect if this is our first time visiting a specific depth by comparing `currDepth` against the current size of our `result` list. If `currDepth == result.size()`, it means no node from this level has been recorded yet, so we safely add the current node's value.

### 🛠️ The Strategy:
1. **Initialize State:** Create an ArrayList `result` to accumulate the right-side values and start the helper routine at depth `0`.
2. **Base Case Validation:** If the current node reference is null, return immediately to break the recursion stack frame.
3. **Layer Detection:** Check if `currDepth == result.size()`. If true, record the current node value since it is the first node encountered at this level.
4. **Right-First Traversal:** Recursively call the helper function on `curr.right` first, incrementing `currDepth + 1`. Follow up with a recursive call on `curr.left` at `currDepth + 1` to capture deeper hidden nodes on the left side.

## 📊 Complexity Analysis
* **Time Complexity:** O(N) - We visit every node in the binary tree exactly once to evaluate its positional depth mapping.
* **Space Complexity:** O(H) - The maximum space allocated on the call stack corresponds directly to the height of the binary tree $H$. In the worst-case scenario of a completely skewed tree, this takes $O(N)$ space.

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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        rightView(root, result, 0);
        return result;
    }

    private void rightView(TreeNode curr, List<Integer> result, int currDepth) {
        if (curr == null) return;

        // If this depth level matches the list size, it's the first (rightmost) node seen at this layer
        if (currDepth == result.size()) {
            result.add(curr.val);
        }

        // Prioritize right branch traversal to capture the right side profile first
        rightView(curr.right, result, currDepth + 1);
        rightView(curr.left, result, currDepth + 1);
    }
}

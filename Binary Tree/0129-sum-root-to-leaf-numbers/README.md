# 129. Sum Root to Leaf Numbers (Medium)

## 📝 Problem Statement

You are given the root of a binary tree where each node contains a digit from `0` to `9`.

Each root-to-leaf path represents a number formed by concatenating the digits along the path.

Return the sum of all root-to-leaf numbers.

A leaf node is a node with no children.

---

## 💡 Intuition & Approach

Each root-to-leaf path naturally forms a number by appending one digit at every level.

Instead of storing the entire path, we can build the number incrementally while traversing the tree using **Depth-First Search (DFS)**.

At every node:

- Multiply the current number by `10`.
- Add the current node's digit.
- If a leaf node is reached, add the completed number to the final answer.
- Otherwise, continue the traversal for both left and right subtrees.

This allows every root-to-leaf number to be computed in a single traversal without extra storage for paths.

### 🛠️ The Strategy

1. **Start DFS from the Root**
   - Initialize the current number as `0`.

2. **Build the Current Number**
   - Update it as:
     ```
     current = current × 10 + node.val
     ```

3. **Check for a Leaf**
   - If the node has no children, add the current number to the answer.

4. **Continue Traversal**
   - Recursively process the left and right children.

5. **Return the Final Sum**
   - After visiting all root-to-leaf paths, return the accumulated sum.

---

## 📊 Complexity Analysis

- **Time Complexity:** **O(n)** - Every node is visited exactly once.

- **Space Complexity:** **O(h)** - Recursive call stack, where `h` is the height of the tree.

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
    private int sum = 0;

    public int sumNumbers(TreeNode root) {
        sumNumbers(root, 0);
        return sum;
    }

    private void sumNumbers(TreeNode root, int current_num) {
        if(root == null) return;

        current_num = (current_num * 10) + root.val;

        if(root.left == null && root.right == null) {
            sum += current_num;
        } else {
            sumNumbers(root.left, current_num);
            sumNumbers(root.right, current_num);
        }
    }
}
```

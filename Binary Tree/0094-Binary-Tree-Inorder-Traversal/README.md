# 94. Binary Tree Inorder Traversal (Easy)

## 📝 Problem Statement
Given the `root` of a binary tree, return the inorder traversal of its nodes' values.

## 💡 Intuition & Approach
An **Inorder Traversal** processes nodes in a specific structural order: **Left subtree $\rightarrow$ Root $\rightarrow$ Right subtree**. While a recursive approach is straightforward, solving this iteratively requires manually simulating the system call stack using an explicit `Stack` structure.

To process nodes in Left-Root-Right order, we must drill down as far left as possible before printing any values. We maintain a pointer `node` starting at the root. We push the current node onto our stack and move to its left child, repeating this action until we hit a null pointer. Reaching a null means we have exhausted the left boundary. We then pop the top element from our stack, append its value to our results, and shift our pointer to its right child to begin the same deep-left search on that subtree.

### 🛠️ The Strategy:
1. **Initialize Control Elements:** Set up a `Stack` to track parent nodes and an ArrayList `result` to store the traversed values.
2. **Deep Left Exploration:** Inside an infinite loop, if the current `node` is not null, push it onto the stack and step left (`node = node.left`).
3. **Backtrack and Collect:** If `node` is null, check if the stack is empty. If it is, the traversal is complete; break the loop. Otherwise:
   - Pop the top node from the stack.
   - Record its value in `result`.
   - Step right (`node = node.right`) to evaluate the right branch.

## 📊 Complexity Analysis
* **Time Complexity:** O(N) - Every node in the binary tree is visited exactly twice: once when pushing it onto the stack during the left-down exploration, and once when popping it to record its value.
* **Space Complexity:** O(H) - The maximum memory footprint allocated to the stack matches the height of the binary tree $H$. In the worst-case scenario of a skewed tree, this takes $O(N)$ space.

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
    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> st = new Stack<>();
        TreeNode node = root;
        List<Integer> result = new ArrayList<>();

        while (true) {
            if (node != null) {
                // Keep pushing current nodes and drill down to the leftmost leaf
                st.push(node);
                node = node.left;
            } else {
                // If we hit a null boundary, check if we are finished
                if (st.isEmpty()) break;

                // Backtrack to parent node, record value, and shift right
                node = st.pop();
                result.add(node.val);
                node = node.right;
            }
        }

        return result;
    }
}

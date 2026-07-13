# 653. Two Sum IV - Input is a BST (Easy)

## 📝 Problem Statement
Given the `root` of a binary search tree and an integer `k`, return `true` if there exist two elements in the BST such that their sum is equal to `k`, or `false` otherwise.

## 💡 Intuition & Approach
This problem adapts the classic **Two Sum** hash set approach to a tree structure. While a Binary Search Tree (BST) allows for sorted order traversals, using a global lookup container gives us an efficient way to check for complementary pairs in a single traversal pass.

As we traverse each node in the tree using Depth-First Search (DFS), we compute the complement required to reach the target sum: $\text{complement} = k - \text{node.val}$. 
* If our `HashSet` already contains this complement, it means we previously encountered a node that pairs perfectly with the current node to equal `k`. We immediately return `true`.
* If the complement isn't found, we store the current node's value in the `HashSet` and continue our recursive search down both the left and right child branches.

### 🛠️ The Strategy:
1. **Global Lookup Storage:** Utilize an instance-level `HashSet<Integer>` to persist seen node values across recursive stack frames.
2. **Base Condition:** If the current node pointer hits `null`, return `false`.
3. **Complement Verification:** Check if `set.contains(k - root.val)`. If found, trigger early return with `true`.
4. **State Preservation & Branching:** Add `root.val` to the set, then return the logical OR result of searching the left and right subtrees (`findTarget(root.left, k) || findTarget(root.right, k)`).

## 📊 Complexity Analysis
* **Time Complexity:** O(N) - In the worst-case scenario where no valid pair exists, we visit every node in the binary search tree exactly once. Hash table lookups take $O(1)$ constant time on average.
* **Space Complexity:** O(N) - Dynamic memory usage scales linearly. The `HashSet` stores up to $N$ unique node values, and the recursive call stack uses up to $O(H)$ space where $H$ is the tree height.

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
    // Shared hash set to hold visited node values across recursion frames
    HashSet<Integer> set = new HashSet<>();
    
    public boolean findTarget(TreeNode root, int k) {
        if (root == null) return false;

        // If the matching pair number exists in our set, target sum found
        if (set.contains(k - root.val)) return true;

        // Log the current value for future complement checks
        set.add(root.val);

        // Terminate early if either the left or right branch uncovers a valid pair
        return findTarget(root.left, k) || findTarget(root.right, k);
    }
}

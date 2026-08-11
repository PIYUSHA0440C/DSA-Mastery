# 872. Leaf-Similar Trees (Easy)

## 📝 Problem Statement

Given the roots of two binary trees, compare their **leaf value sequences**.

The leaf value sequence is the sequence of values of all leaf nodes, visited from left to right.

Return `true` if both trees have the same leaf value sequence; otherwise, return `false`.

---

## 💡 Intuition & Approach

Only the **leaf nodes** matter for this problem. The internal structure and values of non-leaf nodes do not affect the result.

We perform a **Depth-First Search (DFS)** on both trees.

During the traversal:

1. If the current node is `null`, return.
2. If the node has no left or right child, it is a leaf, so add its value to the sequence.
3. Otherwise, recursively traverse the left subtree first and then the right subtree.
4. This naturally produces the leaf values in **left-to-right order**.
5. After generating both sequences, compare them using `List.equals()`.

For example:

```text
Tree 1 leaves: 6 → 7 → 4 → 9 → 8
Tree 2 leaves: 6 → 7 → 4 → 9 → 8

Sequences are equal → true
```

### 🛠️ The Strategy

1. Create one list for each tree's leaf sequence.
2. Run DFS on the first tree and collect only leaf values.
3. Run DFS on the second tree and collect only leaf values.
4. Compare the two lists.
5. Return whether they are equal.

---

## 📊 Complexity Analysis

Let `n` and `m` be the number of nodes in the two trees.

- **Time Complexity:** **O(n + m)** - Each node in both trees is visited once.

- **Space Complexity:** **O(n + m)** - The leaf sequences require storage for the leaf values, in addition to the recursive DFS stack.

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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        dfs(root1, list1);
        dfs(root2, list2);

        return list1.equals(list2);
    }

    private void dfs(TreeNode root, List<Integer> seq) {
        if(root == null) return;

        if(root.left == null && root.right == null) {
            seq.add(root.val);
            return;
        }

        dfs(root.left, seq);
        dfs(root.right, seq);
    }
}
```

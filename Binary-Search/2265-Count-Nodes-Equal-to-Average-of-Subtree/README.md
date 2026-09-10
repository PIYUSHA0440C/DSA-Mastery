# 2265. Count Nodes Equal to Average of Subtree (Medium)

## 📝 Problem Statement

Given the root of a binary tree, count the number of nodes whose value is equal to the average of all values in its subtree. The average is rounded down to the nearest integer.

## 💡 Intuition & Approach

For every node, we need the sum and number of nodes in its entire subtree. A postorder DFS processes the left and right subtrees first, allowing us to calculate these values for the current node. If the integer division of the subtree sum by its node count equals the current node's value, we increment the answer.

### 🛠️ The Strategy:

1. Perform a postorder DFS traversal of the binary tree.
2. Recursively calculate the sum and node count of the left subtree.
3. Recursively calculate the sum and node count of the right subtree.
4. Calculate the current subtree's total sum and node count.
5. Compare `sum / count` with the current node's value.
6. Increment the answer if they are equal.
7. Return the subtree sum and count to the parent node.
8. Return the final count after processing the entire tree.

## 📊 Complexity Analysis

* **Time Complexity:** O(n)
* **Space Complexity:** O(h)

## 💻 Implementation (Java)

```java
class Solution {
    int ans = 0;

    public int averageOfSubtree(TreeNode root) {
        dfs(root);

        return ans;
    }

    private int[] dfs(TreeNode node) {
        if(node == null) return new int[]{0, 0};
        int[] left = dfs(node.left);
        int[] right = dfs(node.right);

        int sum = left[0] + right[0] + node.val;
        int count = left[1] + right[1] + 1;
        if(sum / count == node.val) ans++;

        return new int[]{sum, count};
    }
}
```

# 501. Find Mode in Binary Search Tree (Easy)

## 📝 Problem Statement

Given the root of a Binary Search Tree (BST) that may contain duplicate values, return all modes (the values that occur most frequently).

If multiple values have the same highest frequency, return all of them in any order.

## 💡 Intuition & Approach

In-order traversal of a BST visits its nodes in non-decreasing order. This means duplicate values appear consecutively during traversal.

We can use this property to count consecutive occurrences without maintaining a frequency map.

Maintain three variables:
- `currentVal`: The previously visited node's value.
- `currentCount`: The frequency of the current value.
- `maxCount`: The highest frequency encountered so far.

Store the modes in a list and update it whenever a new maximum frequency is found or another value reaches the existing maximum.

### 🛠️ The Strategy:

1. Perform an in-order traversal of the BST.
2. For each node, compare its value with `currentVal`.
3. If both values match, increment `currentCount`; otherwise, reset it to `1`.
4. If `currentCount` equals `maxCount`, add the current value to the modes list.
5. If `currentCount` exceeds `maxCount`, update the maximum, clear the previous modes, and add the current value.
6. Update `currentVal` and continue the traversal.
7. Convert the modes list into an integer array and return it.

## 📊 Complexity Analysis

Let `n` be the number of nodes and `h` be the height of the BST.

- **Time Complexity:** O(n). Every node is visited exactly once, and each node requires constant-time processing.
- **Space Complexity:** O(h + k), where `h` is the recursion stack space and `k` is the number of modes stored in the result list. Excluding the output list, auxiliary space is O(h).

## 💻 Implementation (Java)

\`\`\`java
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
    private int currentVal;
    private int currentCount = 0;
    private int maxCount = 0;
    private List<Integer> modes = new ArrayList<>();

    public int[] findMode(TreeNode root) {
        inOrderTraversal(root);
        int[] result = new int[modes.size()];
        for(int i = 0; i < modes.size(); i++) {
            result[i] = modes.get(i);
        }

        return result;
    }

    private void inOrderTraversal(TreeNode node) {
        if (node == null) return;

        inOrderTraversal(node.left);

        currentCount = node.val == currentVal ? currentCount + 1 : 1;

        if (currentCount == maxCount) modes.add(node.val);
        else if (currentCount > maxCount) {
            maxCount = currentCount;
            modes.clear();
            modes.add(node.val);
        }

        currentVal = node.val;

        inOrderTraversal(node.right);
    }
}
\`\`\`

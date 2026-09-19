# 654. Maximum Binary Tree (Medium)

## 📝 Problem Statement

Given an integer array `nums` with no duplicates, construct a Maximum Binary Tree using the following rules:

1. The maximum value in the current subarray becomes the root.
2. Recursively construct the left subtree using the elements to the left of the maximum.
3. Recursively construct the right subtree using the elements to the right of the maximum.

Return the root of the constructed binary tree.

## 💡 Intuition & Approach

The construction directly follows the recursive definition of a Maximum Binary Tree. For every subarray, find its maximum element, create a node for it, and recursively build the two resulting subarrays.

### 🛠️ The Strategy:

1. Start with the complete array using its left and right boundaries.
2. Find the index of the maximum value within the current range.
3. Create a `TreeNode` using that maximum value.
4. Recursively construct the left subtree from the range before the maximum.
5. Recursively construct the right subtree from the range after the maximum.
6. Return the created node as the root of the current subtree.
7. Stop when the current range becomes empty.

## 📊 Complexity Analysis

- **Time Complexity:** O(n²) in the worst case, when the array is already sorted and each recursive call scans almost the entire remaining range.
- **Space Complexity:** O(n) in the worst case due to the recursive call stack.

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
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return build(nums, 0, nums.length - 1);
    }

    private TreeNode build(int[] nums, int left, int right) {
        if(left > right) return null;

        int maxIndex = maxIndex(nums, left, right);

        TreeNode root = new TreeNode(nums[maxIndex]);

        root.left = build(nums, left, maxIndex - 1);
        root.right = build(nums, maxIndex + 1, right);

        return root;
    }

    private int maxIndex(int[] nums, int left, int right) {
        int index = left;

        for (int i = left; i <= right; i++) {
            if (nums[i] > nums[index]) index = i;
        }

        return index;
    }
}
```

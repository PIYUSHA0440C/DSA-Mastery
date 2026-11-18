
# 501. Find Mode in Binary Search Tree (Easy)

## 📝 Problem Statement

Given the root of a Binary Search Tree (BST) that may contain duplicate values, return all modes (most frequently occurring elements) in the tree.

If multiple values have the highest frequency, return all of them in any order.

## 💡 Intuition & Approach

A Binary Search Tree has an important property: its inorder traversal visits nodes in sorted, non-decreasing order.

This means duplicate values appear consecutively during inorder traversal. We can use this property to count consecutive occurrences without using a HashMap.

## 🛠️ The Strategy:

1. Perform an inorder traversal of the BST to process values in sorted order.
2. Maintain `currentVal` to track the previously visited value.
3. Maintain `currentCount` to count consecutive occurrences of the current value.
4. Maintain `maxCount` to track the highest frequency encountered.
5. If the current frequency equals `maxCount`, add the value to the modes list.
6. If the current frequency exceeds `maxCount`, update the maximum, clear the previous modes, and add the current value.
7. Convert the modes list into an integer array and return it.

## 📊 Complexity Analysis

- **Time Complexity:** O(n) - Every node is visited exactly once during inorder traversal.
- **Space Complexity:** O(h + k) - O(h) for the recursive call stack, where h is the tree height, and O(k) for storing the modes, where k is the number of modes.

## 💻 Implementation (Java)

```java
class Solution {
    private int currentVal;
    private int currentCount = 0;
    private int maxCount = 0;
    private List<Integer> modes = new ArrayList<>();

    public int[] findMode(TreeNode root) {
        inOrderTraversal(root);

        int[] result = new int[modes.size()];

        for (int i = 0; i < modes.size(); i++) {
            result[i] = modes.get(i);
        }

        return result;
    }

    private void inOrderTraversal(TreeNode node) {
        if (node == null) return;

        inOrderTraversal(node.left);

        currentCount = node.val == currentVal
                ? currentCount + 1
                : 1;

        if (currentCount == maxCount) {
            modes.add(node.val);
        } else if (currentCount > maxCount) {
            maxCount = currentCount;
            modes.clear();
            modes.add(node.val);
        }

        currentVal = node.val;

        inOrderTraversal(node.right);
    }
}
```

# 99. Recover Binary Search Tree (Medium)

## 📝 Problem Statement

You are given the root of a **Binary Search Tree (BST)** in which the values of exactly **two nodes have been swapped** by mistake.

Recover the tree by restoring the correct node values **without modifying its structure**.

---

## 💡 Intuition & Approach

A valid **inorder traversal** of a Binary Search Tree always produces values in **ascending order**.

If two nodes are swapped, this sorted order is violated.

During an inorder traversal:

- Maintain a pointer to the previously visited node.
- Whenever the previous node's value is greater than the current node's value, an inversion is detected.
- The **first misplaced node** is the previous node from the first inversion.
- The **second misplaced node** is updated to the current node whenever an inversion occurs.

This approach correctly handles both:

- **Adjacent swapped nodes** (one inversion)
- **Non-adjacent swapped nodes** (two inversions)

After the traversal, swapping the values of the two misplaced nodes restores the BST.

### 🛠️ The Strategy

1. **Perform Inorder Traversal**
   - Traverse the tree in Left → Root → Right order.

2. **Detect Violations**
   - Compare the current node with the previously visited node.
   - Whenever `prev.val > current.val`, record the misplaced nodes.

3. **Track the Swapped Nodes**
   - Store the first incorrect node only once.
   - Continuously update the second incorrect node whenever another inversion is found.

4. **Recover the BST**
   - Swap the values of the two identified nodes.

---

## 📊 Complexity Analysis

- **Time Complexity:** **O(n)** - Every node is visited exactly once.

- **Space Complexity:** **O(h)** - Due to the recursion stack, where `h` is the height of the tree. (Worst case: **O(n)** for a skewed tree, **O(log n)** for a balanced tree.)

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
    TreeNode first;
    TreeNode second;
    TreeNode prev;

    public void recoverTree(TreeNode root) {
        helper(root);

        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }

    void helper(TreeNode node) {
        if(node == null) return;

        helper(node.left);

        if(prev != null && prev.val > node.val) {
            if(first == null) {
                first = prev;
            }

            second = node;
        }

        prev = node;

        helper(node.right);
    }
}
```

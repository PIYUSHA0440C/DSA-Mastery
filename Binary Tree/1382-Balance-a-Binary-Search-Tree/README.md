# 1382. Balance a Binary Search Tree (Medium)

## 📝 Problem Statement

Given the root of a Binary Search Tree, return a balanced BST containing the same node values. A BST is balanced when the depths of the two subtrees of every node differ by at most `1`.

## 💡 Intuition & Approach

An inorder traversal of a BST produces its values in sorted order. By recursively choosing the middle element of this sorted list as the root, the resulting tree can be constructed with balanced left and right subtrees.

### 🛠️ The Strategy:

1. Perform an inorder traversal of the BST.
2. Store all node values in a list in sorted order.
3. Choose the middle element as the root of the balanced BST.
4. Recursively construct the left subtree using the left half of the list.
5. Recursively construct the right subtree using the right half of the list.
6. Continue until the subarray range becomes empty.
7. Return the newly constructed balanced BST.

## 📊 Complexity Analysis

* **Time Complexity:** O(n)
* **Space Complexity:** O(n)

## 💻 Implementation (Java)

```java
class Solution {
    public TreeNode balanceBST(TreeNode root) {
        List<Integer> inorder = new ArrayList<>();
        inorderTraversal(root, inorder);

        return createBalanceBST(inorder, 0, inorder.size() - 1);
    }

    private void inorderTraversal(TreeNode root, List<Integer> inorder) {
        if(root == null) return;

        inorderTraversal(root.left, inorder);
        inorder.add(root.val);
        inorderTraversal(root.right, inorder);
    }

    private TreeNode createBalanceBST(List<Integer> inorder, int start, int end) {
        if(start > end) return null;

        int mid = start + (end - start) / 2;

        TreeNode leftSubtree = createBalanceBST(inorder, start, mid - 1);
        TreeNode rightSubtree = createBalanceBST(inorder, mid + 1, end);

        TreeNode node = new TreeNode(inorder.get(mid));
        node.left = leftSubtree;
        node.right = rightSubtree;

        return node;
    }
}
```

# 1305. All Elements in Two Binary Search Trees (Medium)

## 📝 Problem Statement

Given two Binary Search Trees, `root1` and `root2`, return a list containing all the integers from both trees sorted in ascending order.

## 💡 Intuition & Approach

Since an inorder traversal of a BST produces its elements in sorted order, we can first generate sorted lists from both trees and then merge those two sorted lists.

### 🛠️ The Strategy:

1. Perform an inorder traversal of `root1` and store the elements in `list1`.
2. Perform an inorder traversal of `root2` and store the elements in `list2`.
3. Both lists are now sorted because they come from BST inorder traversals.
4. Use two pointers, one for each list, to compare their current elements.
5. Add the smaller element to the result and move the corresponding pointer.
6. If the elements are equal, add either one and move that pointer; the other occurrence will be added separately.
7. Append any remaining elements from either list after one pointer reaches the end.
8. Return the merged sorted list.

## 📊 Complexity Analysis

* **Time Complexity:** O(n + m), where `n` and `m` are the number of nodes in the two BSTs.
* **Space Complexity:** O(n + m), for storing the inorder traversal lists and the result.

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
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> ans = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        dfs(root1, list1);
        dfs(root2, list2);

        mergeLists(ans, list1, list2);

        return ans;
    }

    private void mergeLists(List<Integer> ans, List<Integer> list1, List<Integer> list2){
        int i = 0, j = 0;
        while(i < list1.size() && j < list2.size()){
            if(list1.get(i) <= list2.get(j)){
                ans.add(list1.get(i));
                i++;
            }
            else {
                ans.add(list2.get(j));
                j++;
            }
        }

        while(i < list1.size()){
            ans.add(list1.get(i));
            i++;
        }

        while(j < list2.size()){
            ans.add(list2.get(j));
            j++;
        }
    }

    private void dfs(TreeNode node, List<Integer> ans){
        if(node == null) return;
        dfs(node.left, ans);
        ans.add(node.val);
        dfs(node.right, ans);
    }
}
```

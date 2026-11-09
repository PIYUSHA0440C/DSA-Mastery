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
    private int min1;
    private long ans = Long.MAX_VALUE;

    public int findSecondMinimumValue(TreeNode root) {
        min1 = root.val;
        dfs(root);

        return ans < Long.MAX_VALUE ? (int) ans : -1;
    }

    private void dfs(TreeNode root) {
        if (root == null) return;

        if (min1 < root.val && root.val < ans) ans = root.val;
        else if (min1 == root.val) {
            dfs(root.left);
            dfs(root.right);
        }
    }
}

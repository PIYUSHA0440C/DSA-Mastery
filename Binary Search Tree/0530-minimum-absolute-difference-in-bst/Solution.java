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
    private int ans = Integer.MAX_VALUE;
    private TreeNode prev = null;

    public int getMinimumDifference(TreeNode root) {
        if(root == null) return 0;

        inorder(root);
        return ans;
    }

    private void inorder(TreeNode root) {
        if(root == null) return;

        inorder(root.left);
        if(prev != null) ans = Math.min(ans, Math.abs(prev.val - root.val));
        prev = root;
        inorder(root.right);
    }
}

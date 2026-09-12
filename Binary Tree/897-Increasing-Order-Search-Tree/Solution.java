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
    TreeNode ans = new TreeNode(0);

    public TreeNode increasingBST(TreeNode root) {
        TreeNode head = ans;
        inOrder(root);

        return head.right;        
    }

    private void inOrder(TreeNode root){
        if(root == null) return;

        inOrder(root.left);

        ans.right = root;
        root.left = null;
        ans = ans.right;

        inOrder(root.right);
    }
}

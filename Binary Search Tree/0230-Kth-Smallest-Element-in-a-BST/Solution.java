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
    private int count;
    private int result;

    public int kthSmallest(TreeNode root, int k) {
        this.count = k;
        this.result = -1;

        inorder(root);

        return result;
    }

    private void inorder(TreeNode node){
        if(node == null || count <= 0) return;

        inorder(node.left);
        if(--count == 0){
            result = node.val;
            return;
        }

        inorder(node.right);
    }
}

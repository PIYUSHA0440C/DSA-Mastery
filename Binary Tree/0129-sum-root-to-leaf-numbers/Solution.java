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
    private int sum = 0;
    public int sumNumbers(TreeNode root) {
        sumNumbers(root, 0);

        return sum;
    }

    private void sumNumbers(TreeNode root, int current_num){
        if(root == null) return;
        
        current_num = (current_num * 10) + root.val;

        if(root.left == null && root.right == null) {
            sum += current_num;
        } else {
            sumNumbers(root.left, current_num);
            sumNumbers(root.right, current_num);
        }
    }
}

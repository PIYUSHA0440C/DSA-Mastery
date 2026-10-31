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
    private int count = 0;

    public int pathSum(TreeNode root, int targetSum) {
        findPath(root, targetSum);
        return count;
    }

    private void findPath(TreeNode root, int target) {
        if (root == null) return;

        explore(root, 0, target);

        findPath(root.left, target);
        findPath(root.right, target);
    }

    private void explore(TreeNode root, long sum, int target) {
        if (root == null) return;

        sum += root.val;

        if (sum == target) count++;

        explore(root.left, sum, target);
        explore(root.right, sum, target);
    }
}

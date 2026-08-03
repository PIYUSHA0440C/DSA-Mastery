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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> output = new ArrayList<>();

        if(root == null) return output;

        dfs(root, 0, targetSum, output, new ArrayList<>());

        return output;
    }

    private void dfs(TreeNode node, int currSum, int target, List<List<Integer>> output, List<Integer> currentPath) {
        if (node == null) return;

        currSum += node.val;
        currentPath.add(node.val);

        if (node.left == null && node.right == null && currSum == target) {
            output.add(new ArrayList<>(currentPath));
        } else {
            dfs(node.left, currSum, target, output, currentPath);
            dfs(node.right, currSum, target, output, currentPath);
        }

        currentPath.remove(currentPath.size() - 1);
    }
}

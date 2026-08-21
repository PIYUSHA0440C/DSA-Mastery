/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        TreeNode res = null;

        if(original == target) return cloned;

        if(original.left != null){
            res = getTargetCopy(original.left, cloned.left, target);
            if(res != null) return res;
        }

        if(original.right != null){
            res = getTargetCopy(original.right, cloned.right, target);
        }

        return res;
    }
}

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
    private boolean dfs(TreeNode node, int lowerBound, int upperBound) {
        if (node == null) return true;

        if (!(lowerBound < node.val && node.val < upperBound)) return false;

        boolean leftValid = dfs(node.left, lowerBound, node.val);
        boolean rightValid = dfs(node.right, node.val, upperBound);

        return leftValid && rightValid;
    }

    public boolean isValidBST(TreeNode root) {
        return dfs(root,
            Integer.MIN_VALUE,
            Integer.MAX_VALUE);
    }
}

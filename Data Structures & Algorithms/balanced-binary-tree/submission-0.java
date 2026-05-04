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
    // Return [balanced (1/0), height]
    public int[] dfs(TreeNode node) {
        // Exit recursion if node is null
        if (node == null) {
            return new int[]{1,0};
        }

        int[] left = dfs(node.left);
        int[] right = dfs(node.right);

        boolean balanced = false;
        // A node is balanced if both children are balanced
        // and the height difference is less then 1
        if ((left[0] == 1 && right[0] == 1) &&
            Math.abs(left[1] - right[1]) <= 1) {
                balanced = true;
            }
        
        int height = 1 + Math.max(left[1], right[1]);

        // return balanced and max height of the left or right tree
        return new int[]{balanced ? 1 : 0, height};
    }

    public boolean isBalanced(TreeNode root) {
        return dfs(root)[0] == 1;
    }
}

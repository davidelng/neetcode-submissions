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
    int kCounter = 0;
    int kValue = 0;

    private void dfs(TreeNode node) {
        if (node == null) return;
        dfs(node.left);
        if (kCounter == 0) return;
        kCounter--;
        if (kCounter == 0) {
            kValue = node.val;
            return;
        }
        dfs(node.right);
    }

    public int kthSmallest(TreeNode root, int k) {
        kCounter = k;
        dfs(root);
        return kValue;
    }
}

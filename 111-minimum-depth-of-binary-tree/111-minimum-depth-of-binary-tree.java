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
    public int minDepth(TreeNode root) {
        if(root != null) {
           return dfs(root, 1);
        }else {
            return 0;
        }
    }
    public int dfs(TreeNode node, int depth) {

        if(node == null) return depth - 1;

        int left = dfs(node.left, depth + 1 );
        int right = dfs(node.right, depth + 1 );

        if(node.left != null && node.right != null){
            return Integer.min(left,right);
        }else {
            return Integer.max(left, right);
        }
    }
}
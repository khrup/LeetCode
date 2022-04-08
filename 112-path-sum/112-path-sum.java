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
    boolean answer = false;

    public boolean hasPathSum(TreeNode root, int targetSum) {

        if(root != null)
            dfs(root, 0, targetSum);
        
        return answer;
    }

    public void dfs(TreeNode root, int sum, int targetSum) {
        
        if(root == null) {
            return;
        }

        sum += root.val;
        dfs(root.left, sum, targetSum);
        dfs(root.right, sum, targetSum);

        if(root.left == null && root.right == null){
            if(sum == targetSum) answer = true;
        }    
    }
}
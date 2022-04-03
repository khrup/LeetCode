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
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
class Solution {
    
    public List<Integer> answer = new ArrayList<>();    
    
    public List<Integer> inorderTraversal(TreeNode root) {

        if(root != null) {
            dfs(root);
        }
        return answer;
    }

    public void dfs(TreeNode root) {

        if(root == null) return;
        dfs(root.left);
        answer.add(root.val);
        dfs(root.right);
    }
}
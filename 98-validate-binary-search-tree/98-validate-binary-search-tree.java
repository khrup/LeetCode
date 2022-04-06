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
    List<Integer> valueList = new ArrayList<>();

    public boolean isValidBST(TreeNode root) {

        checkValidBST(root);

        for (int i = 0; i < valueList.size() - 1; i++) {
            int value1 = valueList.get(i);
            int value2 = valueList.get(i+1);
            if(value1 >= value2){
                return false;
            }
        }

        return true;
    }

    public void checkValidBST(TreeNode root) {

        if(root == null) return;

        checkValidBST(root.left);
        valueList.add(root.val);
        checkValidBST(root.right);

    }
}
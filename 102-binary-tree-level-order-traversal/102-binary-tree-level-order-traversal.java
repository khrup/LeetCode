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
    public List<List<Integer>> levelOrder(TreeNode root) {
        dfs(1, root);
        map.keySet().forEach(level -> answer.add(map.get(level)));
        return answer;
    }

    List<List<Integer>> answer = new ArrayList<>();
    Map<Integer, List<Integer>> map = new HashMap<>();

    public void dfs(int level, TreeNode root) {

        if (root == null) {
            return;
        }

        map.merge(level, List.of(root.val), (v1, v2) -> {
            List<Integer> collect =  v1.stream().collect(Collectors.toList());
            collect.add(root.val);
            return collect;
        });

        dfs(level + 1, root.left);
        dfs(level + 1, root.right);

    }
}
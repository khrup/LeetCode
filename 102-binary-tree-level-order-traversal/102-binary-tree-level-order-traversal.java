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

        if (map.containsKey(level)) {
            List<Integer> tmp = map.get(level).stream().collect(Collectors.toList());
            tmp.add(root.val);
            map.put(level, tmp);
        }else{
            map.put(level, List.of(root.val));
        }

//        map.merge(level, List.of(root.val), (v1, v2) -> {
//            v2.add(root.val);
//            return v2;
//        });

        dfs(level + 1, root.left);
        dfs(level + 1, root.right);

    }
}
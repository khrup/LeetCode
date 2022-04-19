class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        dfs(new ArrayList<>(), candidates, target, 0);
        return answer.stream().collect(Collectors.toList());
    }

    Set<List<Integer>> answer = new HashSet<>();

    public void dfs(List<Integer> result, int[] candidates, int target, int sum) {

        if (sum >= target) {
            if (sum == target) {
                answer.add(new ArrayList<>(result.stream().sorted().collect(Collectors.toList())));
            }
            return;
        } else {
            for (int i = 0; i < candidates.length; i++) {

                result.add(candidates[i]);
                dfs(result, candidates, target, sum + candidates[i]);
                result.remove(result.size() - 1);
            }
        }
    }
}
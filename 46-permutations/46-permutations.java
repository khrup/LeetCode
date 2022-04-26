class Solution {
    public List<List<Integer>> permute(int[] nums) {

        for (int i = 0; i < nums.length; i++)
            dfs(nums, i, new ArrayList<>());

        return list;
    }

    List<List<Integer>> list = new ArrayList<>();

    public void dfs(int[] nums, int idx, List<Integer> list2) {

        if(idx == nums.length){
            return;
        }
        list2.add(nums[idx]);

        if (list2.size() == nums.length) {
            list.add(list2.stream().collect(Collectors.toList()));
            return;
        }

        for (int i = 0; i < nums.length; i++) {

            if(!list2.contains(nums[i])) {
                dfs(nums, i, list2);
                list2.remove(list2.size()-1);
            }
        }
    }
}
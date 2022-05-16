class Solution {
    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> list = new ArrayList<>();

//        list.add(new ArrayList<>());
        for (int num : nums) {

            if (!list.isEmpty()) {
                List<List<Integer>> tmpList = new ArrayList<>(list);
                for (int i = 0 ; i < tmpList.size() ; i++) {
                    List<Integer> l1 = new ArrayList<>(tmpList.get(i));
                    l1.add(num);
                    list.add(l1);
                }
            }

            list.add(List.of(num));
        }
        list.add(new ArrayList<>());
        return list;
    }
}
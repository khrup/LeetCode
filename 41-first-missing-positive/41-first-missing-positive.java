class Solution {
    public int firstMissingPositive(int[] nums) {

        int answer = 1;
        int min = Arrays.stream(nums).min().getAsInt();

        min = min <= 0 ? 1 : min;

        int max = Arrays.stream(nums).max().getAsInt();
        Set<Integer> set = Arrays.stream(nums).boxed().collect(Collectors.toSet());

        if(max <= 0) {
            return answer;
        }else if (min == 1) {
            for (int i = min; i < max; i++) {
                if (!set.contains(i)) {
                    return i;
                }
            }
            return max + 1;
        } else {
            return answer;
        }
    }
}
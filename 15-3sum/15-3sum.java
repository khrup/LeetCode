import java.util.*;
import java.util.stream.Collectors;

class Solution {
        public List<List<Integer>> threeSum(int[] nums) {

        Set<List<Integer>> answers = new HashSet<>();

        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int y = nums.length - 1;
            int x = i + 1;
            while (x < y) {

                int sum = nums[i] + nums[x] + nums[y];
                if (sum == 0) {
                    answers.add(Arrays.asList(new Integer[]{nums[i], nums[x], nums[y]}));
                    x++;
                    y--;
                } else if ((sum > 0 && x > y) || (sum < 0 && x < y)) {
                    x++;
                } else if ((sum > 0 && x < y) || (sum < 0 && x > y)) {
                    y--;
                }else {
                    x++;
                    y--;
                }
            }
        }

        return new ArrayList<>(answers);
    }
}
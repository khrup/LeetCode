class Solution {
    
    public int jump(int[] nums) {
        int answer = 0;
        int maxIdx = 0;
        for (int i = 0; i < nums.length && nums.length > 1; i = maxIdx) {

            int max = nums[i] + i;
            if (max >= nums.length - 1) {
                return ++answer;
            }
            for (int j = i + 1; j <= i + nums[i] && j < nums.length; j++) {
                max = Integer.max(nums[j] + j, max);
                if (max == nums[j] + j) {
                    maxIdx = j;
                }
            }

            if (max == nums[i]) maxIdx = max + i;

            answer++;
            if (maxIdx >= nums.length - 1) {
                break;
            }
        }
        return answer;
    }


}
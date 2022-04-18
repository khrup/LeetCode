class Solution {

   public int[] searchRange(int[] nums, int target) {

        int start = 0, end = nums.length - 1;
        int[] answer = {-1, -1};

        while (start <= end) {

            if (start == end) {
                if (nums[start] == target) {
                    return new int[]{start, end};
                } else {
                    return answer;
                }
            }

            if(nums[start] != target || nums[end] != target){

                if(nums[start] == target){
                    end--;
                }else if(nums[end] == target){
                    start++;
                }else{
                    start++;
                    end--;
                }

            }else if (nums[start] == target) {
                if (nums[end] == target) {
                    return new int[]{start, end};
                } else if (nums[start + 1] == target) {
                    return new int[]{start, start + 1};
                } else {
                    return new int[]{start, start};
                }
            } else if (nums[end] == target) {
                if (nums[start] == target) {
                    return new int[]{start, end};
                } else if (nums[end - 1] == target) {
                    return new int[]{end - 1, end};
                } else {
                    return new int[]{end, end};
                }
            }

        }

        return answer;
    }
}
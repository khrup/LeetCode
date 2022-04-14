class Solution {
    public void nextPermutation(int[] nums) {

        int targetIdx = -1;

        for (int i = nums.length - 1; i >= 0; i--) {
            if (i >= 1 && nums[i - 1] < nums[i]) {
                targetIdx = i - 1;
                break;
            }
        }

        if (targetIdx == -1) {
            reverse(nums, 0, nums.length - 1);
        } else {

            int largeTartgetIdx = -1;

            for (int i = targetIdx + 1; i < nums.length; i++) {
                if (nums[targetIdx] < nums[i]) {
                    largeTartgetIdx = i;
                }else{
                    break;
                }
            }

            swap(nums, targetIdx, largeTartgetIdx);
            reverse(nums, targetIdx + 1, nums.length - 1);
        }

    }

    public void reverse(int[] nums, int start, int end) {
        for (int i = start; i <= end; i++) {
            if (i < end - i + start) {
                swap(nums, i, end - i + start);
            } else {
                break;
            }
        }
    }

    public void swap(int[] nums, int left, int right) {
        int tmp = nums[left];
        nums[left] = nums[right];
        nums[right] = tmp;
    }
}
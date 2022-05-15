class Solution {
    public void sortColors(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length - 1; j++) {
                swap(nums, j, j + 1);
            }
        }
    }

    public void swap(int[] nums, int i, int j) {
        if (nums[i] > nums[j]) {
            int tmp = nums[j];
            nums[j] = nums[i];
            nums[i] = tmp;
        }
    }
}
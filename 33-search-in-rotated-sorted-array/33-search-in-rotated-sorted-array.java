class Solution {
    public int search(int[] nums, int target) {
        int pivot;

        int left = 0, right = nums.length - 1;

        while (left <= right) {
            pivot = (right + left) / 2;
            if (nums[pivot] == target) {
                return pivot;
            } else if (target == nums[left]) {
                return left;
            } else if (target == nums[right]) {
                return right;
            } else {
                left++;
                right--;
            }
        }
        return -1;
    }
}
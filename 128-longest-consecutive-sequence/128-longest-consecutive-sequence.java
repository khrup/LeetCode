class Solution {
    public int longestConsecutive(int[] nums) {

        if (nums.length > 0) {
            PriorityQueue<Integer> queue = new PriorityQueue<>();

            for (int i = 0; i < nums.length; i++) {
                queue.add(nums[i]);
            }

            int i = queue.poll();
            int count = 0;
            int maxCount = 0;
            while (!queue.isEmpty()) {

                int j = queue.poll();

                if (j - i == 1) {
                    count++;
                    if (count > maxCount) {
                        maxCount = count;
                    }
                } else if(j != i){
                    count = 0;
                }

                i = j;
            }

            return maxCount + 1;
        } else {
            return 0;
        }
    }
}
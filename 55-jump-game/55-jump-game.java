class Solution {
    public boolean canJump(int[] nums) {
        boolean[] visit = new boolean[nums.length];
        dfs(nums, 0, visit);
        return answer;
    }

    boolean answer = false;
    public void dfs(int[] nums, int index, boolean[] visit) {
        if(nums.length - 1 <= index){
            answer = true;
            return;
        }

        visit[index] = true;
        int jump = index + nums[index];
        for(int i = index ; i <= jump ; i++){

            if(!visit[i])
                dfs(nums, i, visit);
            if(answer)
                return;            
        }
    }
}
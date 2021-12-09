import java.util.Arrays;
class Solution {
    public int arrayPairSum(int[] nums) {

        //1. 오름차순으로 정렬
        //2. for돌려서 짝수 index를 합산
        Arrays.sort(nums);
        int result = 0;
        for(int i = 0 ; i < nums.length ; i++){
            if(i%2 == 0){
                result += nums[i];
            }
        }

        return result;
    }
}
class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int arithmeticNumber = 0;

        for(int i = 0 ; i < nums.length ; i++){

            int diff = 0;

            for(int j = i ; j < nums.length ; j++){
                if(j+1 < nums.length){
                    if(j != i && diff == (nums[j+1] - nums[j])){
                        arithmeticNumber++;
                    }else if(j != i && diff != (nums[j+1] - nums[j])){
                        break;
                    }
                    diff = nums[j+1] - nums[j];
                }

            }
        }

        return arithmeticNumber;
    }
}
class Solution {
    public int trap(int[] height) {

        //height를 sort
        //작은 값부터 시작하여 start , end index를 구한다.
        //start부터 시작하여 기준값이 안되는 애들은 값을 더해 채워준다.
        int answer = 0;

        for (int pivot : height) {
            int startIdx = -1;
            int endIdx = -1;

            for (int i = 0; i < height.length; i++) {
                if (pivot <= height[i]) {
                    startIdx = i;
                    break;
                }
            }

            if (startIdx == -1) break;

            for (int i = height.length - 1; i >= 0; i--) {
                if (pivot <= height[i]) {
                    endIdx = i;
                    break;
                }
            }

            if (endIdx == -1) break;


            for (int i = startIdx; i < endIdx; i++) {
                if (pivot > height[i]) {
                    answer += pivot - height[i];
                    height[i] += (pivot - height[i]);
                }
            }
        }


        return answer;
    }
}
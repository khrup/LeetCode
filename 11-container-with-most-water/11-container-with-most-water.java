class Solution {
    public int maxArea(int[] height) {

        int maxSection = -1;
        int x = 0, y = height.length - 1;
        
        while(x != y){
            maxSection = Math.max(maxSection, section(x, y, height[x], height[y]));
            if(height[x] < height[y]){
                x++;
            }else{
                y--;
            }
        }

        return maxSection;
    }

    public int section(int i, int j, int heighti, int heightj) {
        return Math.abs(j - i) * Math.min(heighti, heightj);
    }
}
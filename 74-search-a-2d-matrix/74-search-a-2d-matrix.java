class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        return Arrays.stream(matrix).flatMapToInt(innerArray -> Arrays.stream(innerArray))
                .filter(o -> o == target).count() >= 1;
    }
}
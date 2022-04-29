class Solution {
    public void rotate(int[][] matrix) {
        int[] array = new int[matrix.length * matrix.length];

        int index = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = matrix.length - 1; j >= 0; j--) {
                int tmp = matrix[j][i];
                array[index++] = tmp;
            }
        }

        index = 0;
        for (int i = 0; i < array.length / matrix.length; i++) {
            for (int j = 0; j < array.length / matrix.length; j++) {
                int i1 = array[index++];
                matrix[i][j] = i1;
            }
        }
    }
}
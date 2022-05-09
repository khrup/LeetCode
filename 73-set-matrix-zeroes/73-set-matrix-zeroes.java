class Solution {
    public void setZeroes(int[][] matrix) {

        int flag = Integer.MIN_VALUE;
        boolean tmp;
        while (true) {
            tmp = true;
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    if (flag == matrix[i][j]) {
                        flag++;
                        tmp = false;
                    }
                }
            }
            if (tmp) break;
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    for (int x = 0; x < matrix[i].length; x++) {
                        if(matrix[i][x] != 0)
                            matrix[i][x] = flag;
                    }

                    for (int x = 0; x < matrix.length; x++) {
                        if(matrix[x][j] != 0)
                        matrix[x][j] = flag;
                    }
                }
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == flag) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
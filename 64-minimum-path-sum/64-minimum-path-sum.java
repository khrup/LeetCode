class Solution {
    public int minPathSum(int[][] grid) {

        for (int i = 0; i < grid.length; i++) {

            for (int j = 0; j < grid[i].length; j++) {

                if (i == 0 || j == 0) {
                    if (i > 0) {
                        grid[i][j] += grid[i - 1][j];
                    } else if (j > 0) {
                        grid[i][j] += grid[i][j - 1];
                    }
                } else {
                    grid[i][j] += Integer.min(grid[i - 1][j], grid[i][j - 1]);
                }

            }
        }

        return grid[grid.length - 1][grid[0].length - 1];
    }
}
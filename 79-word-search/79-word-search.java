class Solution {
    public boolean exist(char[][] board, String word) {


        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                boolean[][] isVisited = new boolean[board.length][board[i].length];
                isVisited[i][j] = true;
                dfs(board, word, board[i][j] + "", i, j, isVisited);
            }
        }

        return answer;
    }

    boolean answer = false;

        public void dfs(char[][] board, String word, String test, int i, int j, boolean[][] isVisited) {



        if (word.equals(test)) {
            answer = true;
            return;
        } else if (word.charAt(test.length() - 1) != test.charAt(test.length() - 1)) {
            return;
        } else if (!answer) {

            if (i + 1 < board.length && !isVisited[i + 1][j]) {
                isVisited[i + 1][j] = true;
                dfs(board, word, test + board[i + 1][j], i + 1, j, isVisited);
                isVisited[i + 1][j] = false;
            }

            if (0 <= i - 1 && !isVisited[i - 1][j]) {
                isVisited[i - 1][j] = true;
                dfs(board, word, test + board[i - 1][j], i - 1, j, isVisited);
                isVisited[i - 1][j] = false;
            }

            if (j + 1 < board[i].length && !isVisited[i][j + 1]) {
                isVisited[i][j + 1] = true;
                dfs(board, word, test + board[i][j + 1], i, j + 1, isVisited);
                isVisited[i][j + 1] = false;
            }

            if (0 <= j - 1 && !isVisited[i][j - 1]) {
                isVisited[i][j - 1] = true;
                dfs(board, word, test + board[i][j - 1], i, j - 1, isVisited);
                isVisited[i][j - 1] = false;
            }
        }

    }
}
class Solution {
    public boolean exist(char[][] board, String word) {

        int rows = board.length;
        int cols = board[0].length;

        boolean[][] visited = new boolean[rows][cols];

        // Try every cell as a starting point
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {

                if (solve(i, j, 0, board, word, visited)) {
                    return true;
                }
            }
        }

        return false;
    }

    boolean solve(int row, int col, int index,
                  char[][] board, String word,
                  boolean[][] visited) {

        // Base case
        if (index == word.length()) {
            return true;
        }

        // Boundary check
        if (row < 0 || row >= board.length ||
            col < 0 || col >= board[0].length) {
            return false;
        }

        // Character mismatch or already visited
        if (board[row][col] != word.charAt(index) ||
            visited[row][col]) {
            return false;
        }

        // Mark visited
        visited[row][col] = true;

        // Explore four directions
        boolean found =
            solve(row - 1, col, index + 1, board, word, visited) ||
            solve(row + 1, col, index + 1, board, word, visited) ||
            solve(row, col - 1, index + 1, board, word, visited) ||
            solve(row, col + 1, index + 1, board, word, visited);

        // Backtracking
        visited[row][col] = false;

        return found;
    }
}
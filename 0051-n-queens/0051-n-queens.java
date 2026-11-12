class Solution {
    public List<List<String>> solveNQueens(int n) {

        List<List<String>> ans = new ArrayList<>();

        char[][] board = new char[n][n];

        // Initialize empty board
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }

        solve(0, board, ans, n);

        return ans;
    }

    void solve(int row, char[][] board,
               List<List<String>> ans, int n) {

        // All queens placed
        if (row == n) {

            List<String> temp = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                temp.add(new String(board[i]));
            }

            ans.add(temp);
            return;
        }

        // Try every column in current row
        for (int col = 0; col < n; col++) {

            if (isSafe(row, col, board, n)) {

                // Place queen
                board[row][col] = 'Q';

                // Move to next row
                solve(row + 1, board, ans, n);

                // Backtracking
                board[row][col] = '.';
            }
        }
    }

    boolean isSafe(int row, int col, char[][] board, int n) {

        // Check upper column
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }

        // Check upper-left diagonal
        int r = row - 1;
        int c = col - 1;

        while (r >= 0 && c >= 0) {
            if (board[r][c] == 'Q') {
                return false;
            }

            r--;
            c--;
        }

        // Check upper-right diagonal
        r = row - 1;
        c = col + 1;

        while (r >= 0 && c < n) {
            if (board[r][c] == 'Q') {
                return false;
            }

            r--;
            c++;
        }

        return true;
    }
}
package dev.intermediatebox.array;

public class CountNumberOfTicTacToeGames {
  int totalWins = 0;
  int totalDraws = 0;

  // 0 is 0; 1 is X
  public int computeTotal(int[][] board, int currentMove, int totalMoves) {
    if (isWin(board)) {
      totalWins += 1;
      return 1;
    }

    if (totalMoves == 9) {
      totalDraws += 1;
      return 1;
    }

    int total = 0;
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        if (board[i][j] == -1) {
          board[i][j] = currentMove;

          int nextMove = currentMove == 0 ? 1 : 0;
          total += computeTotal(board, nextMove, totalMoves + 1);

          board[i][j] = -1;
        }
      }
    }

    return total;
  }

  private boolean isWin(int[][] board) {
    for (int i = 0; i < 3; i++) {
      // row win
      if (board[i][0] != -1 && board[i][0] == board[i][1] && board[i][1] == board[i][2]) {
        return true;
      }

      // column win
      if (board[0][i] != -1 && board[0][i] == board[1][i] && board[1][i] == board[2][i]) {
        return true;
      }
    }

    // diagonal win
    if (board[0][0] != -1 && board[0][0] == board[1][1] && board[1][1] == board[2][2]) {
      return true;
    }

    // the other diagonal win
    if (board[0][2] != -1 && board[0][2] == board[1][1] && board[1][1] == board[2][0]) {
      return true;
    }

    return false;
  }
}

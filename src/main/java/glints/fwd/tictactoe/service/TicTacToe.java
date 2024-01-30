package glints.fwd.tictactoe.service;

public class TicTacToe {
  private char[][] board;
  private int rows;
  private int cols;
  private char currentPlayer;
  private boolean gameOver;

  public TicTacToe(int rows, int cols) {
    this.rows = rows;
    this.cols = cols;
    this.board = new char[rows][cols];
    this.currentPlayer = 'X'; // Player X mulai duluan
    this.gameOver = false;
    initializeBoard();
  }

  private void initializeBoard() {
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        board[i][j] = '-';
      }
    }
  }

  public boolean makeMove(int row, int col) {
    if (!gameOver && isValidMove(row, col)) {
      board[row][col] = currentPlayer;
      if (checkWin(row, col)) {
        gameOver = true;
      } else if (checkDraw()) {
        gameOver = true;
      } else {
        switchPlayer();
      }
      return true;
    }
    return false;
  }

  private boolean isValidMove(int row, int col) {
    return row >= 0 && row < rows && col >= 0 && col < cols && board[row][col] == '-';
  }

  private boolean checkWin(int row, int col) {
    boolean win = true;
    for (int i = 0; i < cols; i++) {
      if (board[row][i] != currentPlayer) {
        win = false;
        break;
      }
    }
    if (win) return true;

    win = true;
    for (int i = 0; i < rows; i++) {
      if (board[i][col] != currentPlayer) {
        win = false;
        break;
      }
    }
    if (win) return true;

    if (row == col) {
      win = true;
      for (int i = 0; i < rows; i++) {
        if (board[i][i] != currentPlayer) {
          win = false;
          break;
        }
      }
      if (win) return true;
    }

    if (row + col == rows - 1) {
      win = true;
      for (int i = 0; i < rows; i++) {
        if (board[i][rows - 1 - i] != currentPlayer) {
          win = false;
          break;
        }
      }
      if (win) return true;
    }

    return false;
  }

  private boolean checkDraw() {
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        if (board[i][j] == '-') {
          return false;
        }
      }
    }
    return true;
  }

  private void switchPlayer() {
    currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
  }

  public boolean isGameOver() {
    return gameOver;
  }

  public char[][] getBoard() {
    return board;
  }

  public char getCurrentPlayer() {
    return currentPlayer;
  }

  // Reset permainan untuk memulai permainan baru
  public void resetGame() {
    initializeBoard();
    currentPlayer = 'X';
    gameOver = false;
  }
}

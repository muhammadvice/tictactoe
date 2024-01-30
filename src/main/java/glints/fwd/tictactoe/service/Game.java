package glints.fwd.tictactoe.service;

import glints.fwd.tictactoe.model.Board;
import glints.fwd.tictactoe.model.Player;

public class Game {

  private Board board;
  private Player currentPlayer;
  private boolean gameEnd;

  public Game(int rows, int cols) {
    board = new Board(rows, cols);
    currentPlayer = new Player('X');
    gameEnd = false;
  }

  public void resetGame() {
    board = new Board(board.getGrid().length, board.getGrid()[0].length);
    currentPlayer = new Player('X');
    gameEnd = false;
  }

  public boolean makeMove(int row, int col) {
    if (row < 0 || row >= board.getGrid().length || col < 0 || col >= board.getGrid()[0].length || board.getGrid()[row][col] != '-') {
      return false;
    }

    board.getGrid()[row][col] = currentPlayer.getSymbol();
    if (checkWin(row, col)) {
      gameEnd = true;
      return true;
    }
    if (checkDraw()) {
      gameEnd = true;
    }
    switchPlayer();
    return true;
  }

  public boolean isGameEnd() {
    return gameEnd;
  }

  private void switchPlayer() {
    currentPlayer = (currentPlayer.getSymbol() == 'X') ? new Player('O') : new Player('X');
  }

  private boolean checkWin(int row, int col) {
    char symbol = board.getGrid()[row][col];

    boolean win = true;
    for (int i = 0; i < board.getGrid().length; i++) {
      if (board.getGrid()[i][col] != symbol) {
        win = false;
        break;
      }
    }
    if (win) return true;

    win = true;
    for (int j = 0; j < board.getGrid()[0].length; j++) {
      if (board.getGrid()[row][j] != symbol) {
        win = false;
        break;
      }
    }
    if (win) return true;

    if (row == col) {
      win = true;
      for (int i = 0; i < board.getGrid().length; i++) {
        if (board.getGrid()[i][i] != symbol) {
          win = false;
          break;
        }
      }
      if (win) return true;
    }

    if (row + col == board.getGrid().length - 1) {
      win = true;
      for (int i = 0; i < board.getGrid().length; i++) {
        if (board.getGrid()[i][board.getGrid().length - 1 - i] != symbol) {
          win = false;
          break;
        }
      }
      return win;
    }
    return false;
  }

  private boolean checkDraw() {
    for (int i = 0; i < board.getGrid().length; i++) {
      for (int j = 0; j < board.getGrid()[0].length; j++) {
        if (board.getGrid()[i][j] == '-') {
          return false;
        }
      }
    }
    return true;
  }

  public char[][] getBoardGrid() {
    return board.getGrid();
  }
}

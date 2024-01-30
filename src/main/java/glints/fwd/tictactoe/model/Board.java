package glints.fwd.tictactoe.model;

import java.util.Arrays;

public class Board {
  private char[][] grid;

  public Board(int rows, int cols) {
    grid = new char[rows][cols];
    initializeBoard();
  }

  private void initializeBoard() {
    for (char[] chars : grid) {
      Arrays.fill(chars, '-');
    }
  }

  public char[][] getGrid() {
    return grid;
  }

  public void setGrid(char[][] grid) {
    this.grid = grid;
  }
}


package glints.fwd.tictactoe.model;

public class Board {
  private char[][] grid;

  public Board(int rows, int cols) {
    grid = new char[rows][cols];
    initializeBoard();
  }

  private void initializeBoard() {
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[i].length; j++) {
        grid[i][j] = '-';
      }
    }
  }

  public char[][] getGrid() {
    return grid;
  }

  public void setGrid(char[][] grid) {
    this.grid = grid;
  }
}


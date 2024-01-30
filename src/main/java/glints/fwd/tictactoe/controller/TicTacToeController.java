package glints.fwd.tictactoe.controller;

import glints.fwd.tictactoe.dto.BoardForm;
import glints.fwd.tictactoe.service.Game;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TicTacToeController {

  private Game game;

  @GetMapping("/")
  public String welcome(Model model) {
    model.addAttribute("boardForm", new BoardForm());
    return "welcome";
  }

  @PostMapping("/start")
  public String startGame(@ModelAttribute BoardForm boardForm) {
    int rows = boardForm.getRows();
    int cols = boardForm.getCols();
    if (rows < 3 || cols < 3) {
      return "redirect:/";
    }
    game = new Game(rows, cols);
    return "redirect:/game";
  }

  @GetMapping("/game")
  public String playGame(Model model) {
    if (game == null) {
      return "redirect:/";
    }
    model.addAttribute("board", game.getBoardGrid());
    return "game";
  }

  @PostMapping("/move")
  public String makeMove(@RequestParam int row, @RequestParam int col) {
    if (game.makeMove(row, col) && !game.isGameEnd()) {
      return "redirect:/game";
    } else if (game.isGameEnd()) {
      game.resetGame();
      return "redirect:/";
    } else {
      return "redirect:/game";
    }
  }
}

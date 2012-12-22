import org.junit.*;
import static org.junit.Assert.*;

import org.hexgame.core.PieceType;
import org.hexgame.core.Player;
import org.hexgame.core.Move;
import org.hexgame.core.Game;

public class GameTest {
  @Test
  public void testInitializing() {
    Player playerA = new Player(PieceType.WHITE);
    Player playerB = new Player(PieceType.WHITE);
    Game game = new Game(10, playerA, playerB);
    assertEquals(game.getBoard().getSize(), 10);
    assertEquals(game.getPlayerA(), playerA);
    assertEquals(game.getPlayerB(), playerB);
  }

  @Test
  public void testPerformingMove() {
    Player playerA = new Player(PieceType.WHITE);
    Player playerB = new Player(PieceType.WHITE);
    Game game = new Game(10, playerA, playerB);
    Move move = new Move(game.getBoard(), PieceType.WHITE, 1, 1);
    game.performMove(move);
    assertEquals(game.getBoard().getPiece(1, 1), PieceType.WHITE);
  }

  @Test
  public void testCurrentPlayerAtBeginningOfGame() {
    Player playerA = new Player(PieceType.WHITE);
    Player playerB = new Player(PieceType.WHITE);
    Game game = new Game(10, playerA, playerB);
    assertEquals(game.currentPlayer(), playerA);
  }

  @Test
  public void testCurrentPlayerAfterOneMove() {
    Player playerA = new Player(PieceType.WHITE);
    Player playerB = new Player(PieceType.WHITE);
    Game game = new Game(10, playerA, playerB);
    game.performMove(new Move(game.getBoard(), PieceType.WHITE, 1, 1));
    assertEquals(game.currentPlayer(), playerB);
  }

  @Test
  public void testCurrentPlayerAfterSeveralMoves() {
    Player playerA = new Player(PieceType.WHITE);
    Player playerB = new Player(PieceType.WHITE);
    Game game = new Game(10, playerA, playerB);
    game.performMove(new Move(game.getBoard(), PieceType.WHITE, 1, 1));
    game.performMove(new Move(game.getBoard(), PieceType.BLACK, 2, 1));
    assertEquals(game.currentPlayer(), playerA);
  }
}

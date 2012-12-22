import org.junit.*;
import static org.junit.Assert.*;

import org.hexgame.core.PieceType;
import org.hexgame.core.Player;
import org.hexgame.core.Move;
import org.hexgame.core.Game;

public class GameTest {
  Game game;
  Player playerA, playerB;

  @Before
  public void setUp() {
    playerA = new Player(PieceType.WHITE);
    playerB = new Player(PieceType.WHITE);
    game = new Game(10, playerA, playerB);
  }

  @Test
  public void testInitializing() {
    assertEquals(game.getBoard().getSize(), 10);
    assertEquals(game.getPlayerA(), playerA);
    assertEquals(game.getPlayerB(), playerB);
  }

  @Test
  public void testPerformingMove() {
    Move move = new Move(game.getBoard(), PieceType.WHITE, 1, 1);
    game.performMove(move);
    assertEquals(game.getBoard().getPiece(1, 1), PieceType.WHITE);
  }

  @Test
  public void testCurrentPlayerAtBeginningOfGame() {
    assertEquals(game.currentPlayer(), playerA);
  }

  @Test
  public void testCurrentPlayerAfterOneMove() {
    game.performMove(new Move(game.getBoard(), PieceType.WHITE, 1, 1));
    assertEquals(game.currentPlayer(), playerB);
  }

  @Test
  public void testCurrentPlayerAfterSeveralMoves() {
    game.performMove(new Move(game.getBoard(), PieceType.WHITE, 1, 1));
    game.performMove(new Move(game.getBoard(), PieceType.BLACK, 2, 1));
    assertEquals(game.currentPlayer(), playerA);
  }
}

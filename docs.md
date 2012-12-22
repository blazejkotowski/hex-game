Classes:

* Game
 - Game(size, playerA, playerB)
 - isFinished(): Boolean
 - getWinner(): Player
 - performMove(Move): void
 - undoMove(): void
 - getBoard(): Board
 - currentPlayer(): Player
* Board
 - getPiece(xCoordinate, yCoordinate): PieceType
* PieceType
 - invert()
* Player
 - isHuman(): Boolean
 - getPieceType(): PieceType
  - AIPlayer
* Move
 - coordinateX
 - coordinateY
 - getPieceType(): PieceType
 - isValid(): Boolean

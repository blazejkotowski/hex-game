Classes:

* Game
 - Game(size, playerA, playerB)
 - isFinished(): Boolean
 - getWinner(): Player
 - performMove(Move): void
 - backMove(): void
 - getBoard(): Board
 - currentPlayer(): Player
* Board
 - getPiece(coordinateX, coordinateY): PieceType
* PieceType
 - invert()
* Player
 - isHuman(): Boolean
 - getPieceType(): PieceType
  - AIPlayer
* Move
 - coordinateX
 - coordinateY
 - pieceType
 - isValid(): Boolean

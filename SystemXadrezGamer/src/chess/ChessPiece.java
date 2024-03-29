package chess;

import boardgamer.Board;
import boardgamer.Piece;
import boardgamer.Position;

public abstract class ChessPiece extends Piece{
	//Atributo da class
	private Color color;
	//Construtor com superClass passando a chamada do board"
	public ChessPiece(Board board, Color color) {
		super(board);
		this.color = color;
	}

	public Color getColor() {
		return color;
	}

	public ChessPosition getChessPosition() {
		return ChessPosition.fromPosition(position);
		//converte a posição da peça
	}
	
	protected boolean isThereOpponentPiece(Position position) {
		ChessPiece p = (ChessPiece)getBoard().piece(position);
		return p != null && p.getColor() != color;
	}
}

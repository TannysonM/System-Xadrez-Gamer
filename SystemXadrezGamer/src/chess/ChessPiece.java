package chess;

import boardgamer.Board;
import boardgamer.Piece;

public class ChessPiece extends Piece{
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

	
}

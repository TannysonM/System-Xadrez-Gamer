package chess.pieces;

import boardgamer.Board;
import chess.ChessPiece;
import chess.Color;

public class Rook extends ChessPiece{

	//Está informando o tabuleiro e a cor da peça do tabuleiro e repassa para o construtor da superClass
	public Rook(Board board, Color color) {
		super(board, color);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "R";
	}

	@Override
	public boolean[][] possibleMoves() {
		boolean[][] mat = new boolean[getBoard().getRow()][getBoard().getColumn()];
		return mat;
	}
}
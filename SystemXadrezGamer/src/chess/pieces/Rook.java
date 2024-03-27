package chess.pieces;

import boardgamer.Board;
import boardgamer.Position;
import chess.ChessPiece;
import chess.Color;

public class Rook extends ChessPiece {

	// Está informando o tabuleiro e a cor da peça do tabuleiro e repassa para o
	// construtor da superClass
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

		Position p = new Position(0, 0);

		// above
		// Verifica a posição da peça e demanda o tipo de movimento que ela poderá fazer
		p.setValues(position.getRow() - 1, position.getColumn());
		// Testando a existencia de uma peça e se na rota de locomação dela, não tem
		// outra peça
		while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
			p.setRow(p.getRow() - 1);
			// Verificar se tem uma peça adversaria na rota de movimento e validando ela
			// como true
			if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
				mat[p.getRow()][p.getColumn()] = true;
			}
		}
			// left
			// Verifica a posição da peça e demanda o tipo de movimento que ela poderá fazer
			p.setValues(position.getRow(), position.getColumn() - 1);
			// Testando a existencia de uma peça e se na rota de locomação dela, não tem
			// outra peça
			if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
				mat[p.getRow()][p.getColumn()] = true;
				p.setColumn(p.getColumn() - 1);
			} // Verificar se tem uma peça adversaria na rota de movimento e validando ela
				// como true
			if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
				mat[p.getRow()][p.getColumn()] = true;
			}

			// right
			// Verifica a posição da peça e demanda o tipo de movimento que ela poderá fazer
			p.setValues(position.getRow(), position.getColumn() + 1);
			// Testando a existencia de uma peça e se na rota de locomação dela, não tem
			// outra peça
			if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
				mat[p.getRow()][p.getColumn()] = true;
				p.setColumn(p.getColumn() + 1);
			} // Verificar se tem uma peça adversaria na rota de movimento e validando ela
				// como true
			if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
				mat[p.getRow()][p.getColumn()] = true;
			}

			// below
			// Verifica a posição da peça e demanda o tipo de movimento que ela poderá fazer
			p.setValues(position.getRow() + 1, position.getColumn());
			// Testando a existencia de uma peça e se na rota de locomação dela, não tem
			// outra peça
			if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
				mat[p.getRow()][p.getColumn()] = true;
				p.setRow(p.getRow() + 1);
			} // Verificar se tem uma peça adversaria na rota de movimento e validando ela
				// como true
			if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
				mat[p.getRow()][p.getColumn()] = true;
			}
		return mat;

	}
}
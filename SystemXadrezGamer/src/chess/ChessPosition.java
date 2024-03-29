package chess;

import boardgamer.Position;

public class ChessPosition {

	private char column;
	private int row;

	public ChessPosition(char column, int row) {
		//Programação Defensiva
		if ( column < 'a' || column > 'h' || row < 1 || row > 8) {
			throw new ChessException("Error instantiating ChessPosition. Valid values are from a1 at h8");
		}
		this.column = column;
		this.row = row;

	}

	public char getColumn() {
		return column;
	}

	public int getRow() {
		return row;
	}

	//metodo para organizar a posição... "#" significa que o metodo/variavel... são Protected
	protected Position toPosition() {
		return new Position(8 - row, column - 'a');
	}
	//Quando um metodo estiver sublinhado, significa que ele é "static"
	protected static ChessPosition fromPosition(Position position) {
		//Precisamos sempre converter para Char, porque ela não é automatica no java
		return new ChessPosition((char)('a' + position.getColumn()), 8 - position.getRow());
	}

	@Override
	public String toString() {
		return "" + column + row;
		//O espaço vazio e um macete para fazer o compilador aceitar o comando
	}
}
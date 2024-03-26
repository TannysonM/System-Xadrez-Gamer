package boardgamer;

public class Board {

	// Variaveis
	private int rows;
	private int columns;
	// Matriz das peças
	private Piece[][] pieces;

	public Board(int rows, int columns) {
		// Programação defensiva
		if (rows < 1 || columns < 1) {
			throw new BoardException("Error creating board: The must be at least 1 row and 1 columns");
		}
		this.rows = rows;
		this.columns = columns;
		// Instanciando a matriz de peças com a Class Piece, acrescentando a quantidade
		// de
		// linhas e colunas informadas
		pieces = new Piece[rows][columns];
	}

	public int getRow() {
		return rows;
	}

	public int getColumn() {
		return columns;
	}
	//Metodo que vai retornar linha e coluna da class Piece e implementar na matiz "pieces"
	public Piece piece(int row, int column) {
		//Programação defensiva
		if (!positionExists(row, column)) {
			throw new BoardException("Position not on the board!");
		}
		return pieces [row][column];
	}
	//Sobrecarga que vai retornar a peça pela posição
	public Piece piece(Position position) {
		if (!positionExists(position)) {
			throw new BoardException("Position not on the board!");
		}
		return pieces[position.getRow()][position.getColumn()];
	}
	//Metodo para acrescentar peças ao tabuleiro - Etapa 2 do projeto
	//Não se esquecer que sempre terá que chamar as varaveis, matriz ou class para que
	//O metodo entenda o que aquele "argumento" está recebendo
	public void PlacePiece(Piece piece, Position position) {
		if(thereIsAPiece(position)) {
			throw new BoardException("The is already a piece on position " + position);
		}
		//Terá que ir na matriz de peças do tabuleiro na linha e coluna marcada 
		//E atribuir a essa posição uma peça que retornou como argumento
		pieces [position.getRow()][position.getColumn()] = piece;
		piece.position = position;
	}
	
	public Piece removePiece(Position position) {
		//Caso não tenha peça naquela posição, retornar um mensagem avisando.
		if(!positionExists(position)) {
			throw new BoardException("Position not on the board");
		}
		//Verifica se existe peça naquela posição
		if(piece(position) == null) {
			return null;
		}
		//Procedimento para retirar a peça do tabuleiro
		Piece aux = piece(position);
		aux.position = null;
		pieces[position.getRow()][position.getColumn()] = null;
		return aux;
	}
	//Metodo auxiliar
	private boolean positionExists(int row, int column) {
		//Mais facil para testar a linha e coluna. Condição para vê se aquela posição existe
		return row >= 0 && row < rows && column >= 0 && column< columns;
	}
	//Implementando a função
	public boolean positionExists(Position position) {
		//Comando que irá reaproveitar o metodo de cima
		return positionExists(position.getRow(), position.getColumn());
	}

	public boolean thereIsAPiece(Position position) {
		if (!positionExists(position)) {
			throw new BoardException("Position not on the board!");
		}
		return piece(position) != null;

	}
}

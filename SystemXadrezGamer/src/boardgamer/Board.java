package boardgamer;

public class Board {

	//Variaveis
		private int row;
		private int column;
		//Matriz das peças
		private Piece[][] pieces;
		
		public Board(int row, int column) {
			this.row = row;
			this.column = column;
			//Instanciando a matriz de peças com a Class Piece, acrescentando a quantidade de 
			//linhas e colunas informadas
			pieces = new Piece[row][column];
		}

		public int getRow() {
			return row;
		}

		public void setRow(int row) {
			this.row = row;
		}

		public int getColumn() {
			return column;
		}

		public void setColumn(int column) {
			this.column = column;
		}
		//Metodo que vai retornar linha e coluna da class Piece e implementar na matiz "pieces"
		public Piece piece(int row, int column) {
			return pieces [row][column];
		}
		//Sobrecarga que vai retornar a peça pela posição
		public Piece piece(Position position) {
			return pieces[position.getRow()][position.getColumn()];
		}
}

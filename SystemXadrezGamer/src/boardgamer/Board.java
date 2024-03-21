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
}

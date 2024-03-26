package boardgamer;

public abstract class Piece {

	//Criando varivavel

		protected Position position;
		private Board board;


		public Piece(Board board) {
			this.board = board;
			position = null;
		}

	//Permitindo o acesso para apenas class e subclass
	//Não terá Set porque não queremos que seja alterada a position do tabuleiro.
	//Limitação importante para deixar a class mais protegida e que programadores cometam erros	
		protected Board getBoard() {
			return board;
		}
		
		//metodo absract
		public abstract boolean[][] possibleMoves();
		
		//metodo concreto
		public boolean possibleMove(Position position) {
			return possibleMoves()[position.getRow()][position.getColumn()];
		}
		
		public boolean isThereAnyPossibleMoves() {
			boolean [][] mat = possibleMoves();
			for (int i=0; i<mat.length; i++) {
				for(int j=0; j<mat.length; j++) {
					if(mat[i][j]) {
						return true;
					}
				}
			}
			return false;
		}
	}

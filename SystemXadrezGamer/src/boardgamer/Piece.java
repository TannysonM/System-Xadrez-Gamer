package boardgamer;

public class Piece {

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
}

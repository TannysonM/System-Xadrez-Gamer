package chess;

import boardgamer.Board;
import boardgamer.Piece;
import boardgamer.Position;
import chess.pieces.King;
import chess.pieces.Rook;

//Importando o BOARD
public class ChessMatch {
	// Importando o BOARD
	private Board board;

	/*
	 * private int turn; private Color currentPlay; private boolean check; private
	 * boolean checkMate; private ChessPiece enPassantVulnerable; private ChessPiece
	 * promoted;
	 */
//Construtor para designar o tamanho do tabuleiro
	public ChessMatch() {
		board = new Board(8, 8);
		initialSetup();
	}

	// Metodo que ira retornar a matriz de pieces(peças) correspondente a ChessMatch
//Vamos liberar apenas a camada de peças e não de tabuleiro para o programa reconhecer	  
	public ChessPiece[][] getPieces() {
		// Criando variavel temporaria e matriz que ira receber a linha e coluna
		ChessPiece[][] mat = new ChessPiece[board.getRow()][board.getColumn()];
		// Construiremos um sistema de repetição que irá percorrer as linhas e colunas
		// da matriz
		for (int i = 0; i < board.getRow(); i++) {
			for (int j = 0; j < board.getColumn(); j++) {
				// para cada posição da "i""j" do meu tabuleiro receba...
				// Porem, precisamos fazer um DOWNCATCHS para interpretar como uma peça de
				// xadrez
				mat[i][j] = (ChessPiece) board.piece(i, j);
			}
		}
		return mat;
	}
	// Metodo to toPosition que irá instanciar as peças de xadrez informando a
	// coordenada
	// no sistema do xadrez
	
	//Possibilita a impressão das posições possiveis atraves da posição de origem da peça
	public boolean [][] possibleMoves(ChessPosition sourcePosition){
		Position position = sourcePosition.toPosition();
		ValidateSourcePosition(position);
		return board.piece(position).possibleMoves();
	}
	

	public ChessPiece performChessMove(ChessPosition sourcePosition, ChessPosition targetPosition) {
		Position source = sourcePosition.toPosition();
		Position target = targetPosition.toPosition();
		ValidateSourcePosition(source);// validar posição de origem da peça
		ValidateTargetPosition(source, target);
		Piece capturedPiece = makeMove(source, target);
		return (ChessPiece) capturedPiece; // down-cast.
	}

	private Piece makeMove(Position source, Position target) {
		Piece p = board.removePiece(source);//remove a peça capiturada do local 
		Piece capturedPiece = board.removePiece(target);// remove a peça do destino
		board.PlacePiece(p, target);//coloca a peça capiturada e coloca o local de destino
		return capturedPiece;
	}
	
	//Validador da posição de origem
	private void ValidateSourcePosition(Position position) {
		if (!board.thereIsAPiece(position)) {
			throw new ChessException("there is no piece on source position");
		}
		if (!board.piece(position).isThereAnyPossibleMoves()) {
			throw new ChessException("There is no possibles moves for the chosen piece");
		}
	}
	
	private void ValidateTargetPosition(Position source, Position target) {
		if (!board.piece(source).possibleMove(target)) {
			throw new ChessException("The chosen piece can't move to target position");
		}
	}
	private void placeNewPiece(char column, int row, ChessPiece piece) {
		board.PlacePiece(piece, new ChessPosition(column, row).toPosition());
	}

	// Metodo responsavel por iniciar a partida de xadrez
	private void initialSetup() {
		//BLACK
		placeNewPiece('e', 8, new King(board, Color.BLACK));
		placeNewPiece('c', 8, new King(board, Color.BLACK));
		placeNewPiece('d', 8, new King(board, Color.BLACK));
		
	
		//WHITE
		placeNewPiece('c', 1, new Rook(board, Color.WHITE));
		placeNewPiece('d', 1, new Rook(board, Color.WHITE));
		placeNewPiece('e', 1, new Rook(board, Color.WHITE));
	}
}
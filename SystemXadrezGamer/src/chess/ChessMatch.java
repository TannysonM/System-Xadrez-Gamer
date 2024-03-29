package chess;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import boardgamer.Board;
import boardgamer.Piece;
import boardgamer.Position;
import chess.pieces.King;
import chess.pieces.Rook;

//Importando o BOARD
public class ChessMatch {
	// Importando o BOARD
	private int turn;
	private Color currentPlayer;
	private Board board;
	private boolean check;
	private boolean checkMate;

	private List<Piece> piecesOnTheBoard = new ArrayList<>();
	private List<Piece> capturedPieces = new ArrayList<>();
	
	
//Construtor para designar o tamanho do tabuleiro
	public ChessMatch() {
		board = new Board(8, 8);
		turn = 1;
		currentPlayer = Color.WHITE;
		initialSetup();
	}
	
	public int getTurn() {
		return turn;
	}
	
	public Color getCurrentPlayer() {
		return currentPlayer;
	}
	
	public boolean getCheck() {
		return check;
	}
	
	public boolean getCheckMate() {
		return checkMate;
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
		
		if (testCheck(currentPlayer)) {
			undoMove(source, target, capturedPiece);
			throw new ChessException("You can't put yourself in check");
		}
		
		check = (testCheck(opponent(currentPlayer))) ? true : false;
		
		if(testCheckMate(opponent(currentPlayer))) {
			checkMate = true;
		}
		else {
		nextTurn();
		}
		return (ChessPiece) capturedPiece; // down-cast.
	}

	private Piece makeMove(Position source, Position target) {
		Piece p = board.removePiece(source);//remove a peça capiturada do local 
		Piece capturedPiece = board.removePiece(target);// remove a peça do destino
		board.PlacePiece(p, target);//coloca a peça capiturada e coloca o local de destino
		
		if(capturedPiece != null) {
			piecesOnTheBoard.remove(capturedPiece);
			capturedPieces.add(capturedPiece); 
		}
		
		return capturedPiece;
	}

	private void undoMove(Position source,Position target, Piece capturedPiece) {
		Piece p = board.removePiece(target);
		board.PlacePiece(p, source);//Tira a peça capturada e reponhe ela no local de destino
	
		if(capturedPiece != null) {
			board.PlacePiece(capturedPiece, target);
			capturedPieces.remove(capturedPiece);
			piecesOnTheBoard.add(capturedPiece);
		}
	}
	
	//Validador da posição de origem
	private void ValidateSourcePosition(Position position) {
		if (!board.thereIsAPiece(position)) {
			throw new ChessException("there is no piece on source position");
		}
		if (currentPlayer != ((ChessPiece)board.piece(position)).getColor()) {
			throw new ChessException("The chosen piece is not yours");
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
	
	private void nextTurn() {
		turn++;
		currentPlayer = (currentPlayer == Color.WHITE) ? Color.BLACK : Color.WHITE;
	}
	
	private Color opponent(Color color) {
		return (color == Color.WHITE) ? Color.BLACK : Color.WHITE;
	}
	
	private ChessPiece king(Color color) {
		List<Piece> list = piecesOnTheBoard.stream().filter(x -> ((ChessPiece)x).getColor()== color).collect(Collectors.toList());
		for(Piece p: list) {
			if(p instanceof King) {
				return (ChessPiece)p;
			}
		}
		throw new IllegalStateException("There is no " + color + "king on the board");
	}
	
	private boolean testCheck(Color color) {
		Position kingPosition = king(color).getChessPosition().toPosition();
		List<Piece> opponentPieces = piecesOnTheBoard.stream().filter(x -> ((ChessPiece)x).getColor()== opponent(color)).collect(Collectors.toList());
		for (Piece p : opponentPieces) {
			boolean[][] mat = p.possibleMoves();
			if(mat[kingPosition.getRow()][kingPosition.getColumn()]) {
				return true;
			}
		}
		return false;
	}
	
	private boolean testCheckMate(Color color) {
		if(!testCheck(color)) {
			return false;
		}
		List<Piece> list = piecesOnTheBoard.stream().filter(x -> ((ChessPiece)x).getColor()== color).collect(Collectors.toList());
		for( Piece p : list) {
			boolean[][] mat = p.possibleMoves();
			for(int i=0; i<board.getRow(); i++) {
				for(int j=0; j<board.getColumn(); j++) {
					if(mat[i][j]) {
						Position source = ((ChessPiece)p).getChessPosition().toPosition();
						Position target = new Position(i, j);
						Piece capturedPiece = makeMove(source, target);
						boolean testCheck = testCheck(color);
						undoMove(source, target, capturedPiece);
						if(!testCheck) {
							return false;
						}
					}
				}
			}
		}
		return true;
	}
	
	private void placeNewPiece(char column, int row, ChessPiece piece) {
		board.PlacePiece(piece, new ChessPosition(column, row).toPosition());
		piecesOnTheBoard.add(piece);
	}

	// Metodo responsavel por iniciar a partida de xadrez
	private void initialSetup() {
		//BLACK
		placeNewPiece('e', 8, new Rook(board, Color.BLACK));
		placeNewPiece('c', 8, new Rook(board, Color.BLACK));
		placeNewPiece('d', 8, new King(board, Color.BLACK));
		
	
		//WHITE
		placeNewPiece('c', 1, new Rook(board, Color.WHITE));
		placeNewPiece('d', 1, new King(board, Color.WHITE));
		placeNewPiece('e', 1, new Rook(board, Color.WHITE));
	}
}
package chess;

import boardgamer.Board;
import boardgamer.Position;
import chess.pieces.King;
import chess.pieces.Rook;

 //Importando o BOARD
public class ChessMatch {
	//Importando o BOARD
	  private Board board;
	  /*
	  private int turn;
	  private Color currentPlay;
	  private boolean check;
	  private boolean checkMate;
	  private ChessPiece enPassantVulnerable;
	  private ChessPiece promoted;
	  */
//Construtor para designar o tamanho do tabuleiro
	  public ChessMatch() {
		  board = new Board(8, 8);
		  initialSetup();
	  }
 //Metodo que ira retornar a matriz de pieces(peças) correspondente a ChessMatch
//Vamos liberar apenas a camada de peças e não de tabuleiro para o programa reconhecer	  
	  public ChessPiece[][] getPieces(){
		  //Criando variavel temporaria e matriz que ira receber a linha e coluna
		  ChessPiece[][] mat = new ChessPiece[board.getRow()][board.getColumn()];
		  //Construiremos um sistema de repetição que irá percorrer as linhas e colunas da matriz
		  for(int i=0; i<board.getRow();i++) {
			  for(int j=0; j<board.getColumn(); j++) {
				  //para cada posição da "i""j" do meu tabuleiro receba... 
				  //Porem, precisamos fazer um DOWNCATCHS para interpretar como uma peça de xadrez
				  mat[i][j] = (ChessPiece)board.piece(i, j);
			  }
		  }
		  return mat;
	  } 
	  //Metodo responsavel por iniciar a partida de xadrez
	  private void initialSetup() {
		  board.PlacePiece(new Rook(board, Color.WHITE), new Position(2,1));
		  board.PlacePiece(new King(board, Color.BLACK), new Position(0,4));
		  board.PlacePiece(new King(board, Color.WHITE), new Position(7,4));

	  }
}
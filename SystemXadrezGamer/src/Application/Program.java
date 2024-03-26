package Application;

import java.util.Scanner;

import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		/*
		 * //Criando um OBJETO que irá receber a Class = Position Position pos = new
		 * Position(5, 3); System.out.println(pos); //Criando um OBJETO que irá receber
		 * a Class = Board Board bo = new Board(8, 8);
		 * 
		 */
		// instanciando um ChessMatch
		// Class que ira apresentar uma Class grafica para imprimir a tabela
		// Esse metodo vai receber a matriz de peças da minha partida
		ChessMatch chessmatch = new ChessMatch();
		
		while (true) {
			   //Mostrará o tabulerio
		    	UI.printBoard(chessmatch.getPieces());
		    	//Pedirá a peça que o usuario deseja movimentar
		    	System.out.println();
		    	System.out.print("Source: ");
		    	ChessPosition source = UI.readChessPosition(sc);
		    	
		    	//Pedirá a posição para a onde o usuario deseja alocar a peça
		    	System.out.println();
		    	System.out.print("Target: ");
		    	ChessPosition target = UI.readChessPosition(sc);
		    	
		    	ChessPiece capturedPiece = chessmatch.performChessMove(source, target);
		}
	}

}

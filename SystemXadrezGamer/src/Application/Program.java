package Application;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import chess.ChessException;
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
		List<ChessPiece> captured = new ArrayList<>();
		
		while (!chessmatch.getCheckMate()) {
			try {	
					//Sempre que retorna, limpará a tela antes de tratar as exceções
					UI.clearScreen();
					//Mostrará o tabulerio
			    	UI.printMatch(chessmatch, captured);
			    	//Pedirá a peça que o usuario deseja movimentar
			    	System.out.println();
			    	System.out.print("Source: ");
			    	ChessPosition source = UI.readChessPosition(sc);
			    	
			    	boolean[][] possibleMoves = chessmatch.possibleMoves(source);
			    	UI.clearScreen();
			    	UI.printBoard(chessmatch.getPieces(),possibleMoves);
			    	
			    	//Pedirá a posição para a onde o usuario deseja alocar a peça
			    	System.out.println();
			    	System.out.print("Target: ");
			    	ChessPosition target = UI.readChessPosition(sc);
			    	
			    	ChessPiece capturedPiece = chessmatch.performChessMove(source, target);
			
			    	if(capturedPiece != null) {
			    		captured.add(capturedPiece);
			    	}
			    	
			}
			catch(ChessException c) {
				System.out.println(c.getMessage());
				sc.nextLine();
			}
			catch(InputMismatchException i) {
				System.out.println(i.getMessage());
				sc.nextLine();
			}
		}
		UI.clearScreen();
		UI.printMatch(chessmatch, captured);
	}

}

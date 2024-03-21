package Application;

import chess.ChessMatch;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		//Criando um OBJETO que irá receber a Class = Position
		Position pos = new Position(5, 3);
		System.out.println(pos);
		//Criando um OBJETO que irá receber a Class = Board
		Board bo = new Board(8, 8);

		*/
		//instanciando um ChessMatch
		ChessMatch chessmatch = new ChessMatch();
		//Class que ira apresentar uma Class grafica para imprimir a tabela
		//Esse metodo vai receber a matriz de peças da minha partida	
		UI.printBoard(chessmatch.getPieces());
	}

}

package Application;

import boardgamer.Board;
import boardgamer.Position;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Criando um OBJETO que irá receber a Class = Position
		Position pos = new Position(5, 3);
		System.out.println(pos);
		// Criando um OBJETO que irá receber a Class = Board
		Board bo = new Board(8, 8);

	}

}

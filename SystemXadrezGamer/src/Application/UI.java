package Application;

import chess.ChessPiece;

public class UI {

	public static void printBoard(ChessPiece[][] pieces) {
		// Comando que irá imprimir na tela a quantidade de linhas e colunas do
		// tabuleiro
		// Esta sendo colocado "piece.length" porque estamos considerando que a matriz
		// sera quadrada
		System.out.println("-----JOGO DE XADREZ-----");
		System.out.println();
		for (int i = 0; i < pieces.length; i++) {
			// para imprimir a numeração de cada linha em ordem descrescente
			System.out.print((8 - i) + " ");
			for (int j = 0; j < pieces.length; j++) {
				// Comando que ira imprimir a peça conforme a posição desejada pelo usuario
				printPiece(pieces[i][j]);
			}
			System.out.println();// quebra de linha
		}
		System.out.println("  a b c d e f g h");
	}

	// Criando um metodo auxiliar para imprimir uma peça
	private static void printPiece(ChessPiece piece) {
		if (piece == null) {
			// Se não houver nenhuma peça no campo, apresentar um "-"
			System.out.print("-");
		} else {
			// Caso tenha, mostrar qual peça é.
			System.out.print(piece);
		}
		// Acrescenta um espaço entre os campos
		System.out.print(" ");
	}
}

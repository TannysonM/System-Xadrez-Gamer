package boardgamer;

public class Position {
 
	private int row;
	private int column;

	//Construtor padrao
	public Position() {

	}
	//Construtor com argumentos
	public Position(int row, int column) {
		this.row = row;
		this.column = column;
	}
	//GETs e SETs
	public int getRow() {
		return row;
	}
	public void setRow(int row) {
		this.row = row;
	}
	public int getColumn() {
		return column;
	}
	public void setColumn(int column) {
		this.column = column;
	}
	//ToString para teste e organiza a impressao que será feita no PROGRAM
	@Override
	public String toString() {
		return row + ", " + column;
	}

}

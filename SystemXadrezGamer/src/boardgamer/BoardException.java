package boardgamer;

//Para ser uma opção de exceção para ser tratada
public class BoardException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public BoardException(String msg) {
		super(msg);
	}
}
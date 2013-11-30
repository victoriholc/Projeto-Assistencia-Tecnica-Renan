package br.com.assistenciaTecnica.cadastral.exception.piece;

public class PieceAlreadyExistsException extends Exception{
	private static final String message = "J� existe!!!";

	public PieceAlreadyExistsException() {
		super(message);
	}
	
	public String getMessage(){
		return message;
	}
}

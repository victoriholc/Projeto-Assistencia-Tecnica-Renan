package br.com.assistenciaTecnica.cadastral.exception;

public class AlreadyExisteException extends Exception{
	private static final String message = "J� existe!!!";

	public AlreadyExisteException() {
		super(message);
	}
	
	public String getMessage(){
		return message;
	}
}

package br.com.assistenciaTecnica.cadastral.exception;

public class NoSearchResultException extends Exception{
	private static final String message = "ProductAlreadyExistsException";
	
	public NoSearchResultException() {
		super(message);
	}
	
	public String getMessage(){
		return message;
	}
}

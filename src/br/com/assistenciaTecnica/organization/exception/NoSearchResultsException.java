package br.com.assistenciaTecnica.organization.exception;

public class NoSearchResultsException extends Exception {
	private static final String message = "nao ha resultado para sua pesquisa!";
	
	public NoSearchResultsException(){
		super(message);
	}
	public String getMessage(){
		return message;
	}
}

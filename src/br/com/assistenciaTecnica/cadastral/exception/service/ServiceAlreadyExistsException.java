package br.com.assistenciaTecnica.cadastral.exception.service;

public class ServiceAlreadyExistsException extends Exception {
	private static final String message ="Este servico ja existe!";
	
	public ServiceAlreadyExistsException(){
		super(message);
	}

	public String getMessage() {
		return message;
	}
}

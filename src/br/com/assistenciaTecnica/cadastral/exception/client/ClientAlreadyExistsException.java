package br.com.assistenciaTecnica.cadastral.exception.client;

public class ClientAlreadyExistsException extends Exception 
{
	private static final String Message = "Cliente já existe!";

	public ClientAlreadyExistsException() 
	{
		super(Message);
	}
}

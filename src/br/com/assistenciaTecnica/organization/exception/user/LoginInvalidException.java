package br.com.assistenciaTecnica.organization.exception.user;

public class LoginInvalidException extends Exception {
	private static String message = "Login ou Senha invalido!";
	
	public LoginInvalidException(){
		super(message);
	}
	
	public  String getMessage() {
		return message;
	}
}

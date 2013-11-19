package br.com.assistenciaTecnica.organization.exception.functionary.function;

public class FunctionAlreadyExistsException extends Exception{
	private static final String message = "Esta funcao ja existe!";
	
	public FunctionAlreadyExistsException(){  
	      super(message);  
	    }

	 public String getMessage(){  
	      return message;  
	 }  
}

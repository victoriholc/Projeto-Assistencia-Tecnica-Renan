package br.com.assistenciaTecnica.organization.exception.functionary.schooling;

public class SchoolingAlreadyExistsException extends Exception{
	private static final String message = "Esta Escolaridade ja existe!";
	
	public SchoolingAlreadyExistsException(){  
	      super(message);  
	    }

	 public String getMessage(){  
	      return message;  
	 }  
}
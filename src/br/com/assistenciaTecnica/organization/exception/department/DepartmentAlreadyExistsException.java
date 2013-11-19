package br.com.assistenciaTecnica.organization.exception.department;

public class DepartmentAlreadyExistsException extends Exception{
	private static final String message = "Este departamento ja existe!";
	
	public DepartmentAlreadyExistsException(){  
	      super(message);  
	    }

	 public String getMessage(){  
	      return message;  
	 }  
}

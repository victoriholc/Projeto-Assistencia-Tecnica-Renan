package br.com.assistenciaTecnica.cadastral.exception.product;

public class ProductAlreadyExistsException extends Exception{
	private static final String message = "Product j� existe!!!";

	public ProductAlreadyExistsException(){
		super();
	}

	public String getMessage(){
		return message;
	}
}
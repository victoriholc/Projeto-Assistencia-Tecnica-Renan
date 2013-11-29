package br.com.assistenciaTecnica.cadastral;

import java.util.List;

import br.com.assistenciaTecnica.cadastral.bo.client.ClientBO;
import br.com.assistenciaTecnica.cadastral.bo.client.IClientBO;
import br.com.assistenciaTecnica.cadastral.bo.piece.PieceBO;
import br.com.assistenciaTecnica.cadastral.bo.product.ProductBO;
import br.com.assistenciaTecnica.cadastral.bo.service.ServiceBO;
import br.com.assistenciaTecnica.cadastral.exception.NoSearchResultException;
import br.com.assistenciaTecnica.cadastral.exception.piece.PieceAlreadyExistsException;
import br.com.assistenciaTecnica.cadastral.exception.product.ProductAlreadyExistsException;
import br.com.assistenciaTecnica.cadastral.model.Piece;
import br.com.assistenciaTecnica.cadastral.model.Product;
import br.com.assistenciaTecnica.cadastral.model.Service;

public class Facade 
{
	private static Facade facade;
	
	private ServiceBO serviceBO;
	private ProductBO productBO;
	private PieceBO pieceBO;
	private IClientBO clientBO;
	
	private Facade()
	{
		this.serviceBO = new ServiceBO();
		this.productBO = new ProductBO();
		this.pieceBO = new PieceBO();
		this.clientBO = new ClientBO();
	}
	
	public static Facade getInstace(){
		if(facade == null){
			facade = new Facade();
		}
		return facade;
	}
	
	public void insertService(Service service) throws Exception{
		serviceBO.insertService(service);
	}
	
	public void removeService(Service service) {
		serviceBO.removeService(service);
	}
	
	public List<Service>seeAllService() {
		return serviceBO.seeAll();
	}
	public List<Service>findBySimilarNameService(String name) {
		return serviceBO.findBySimilarName(name);
	}
	
	public void insertProduct(Product p) throws ProductAlreadyExistsException{
		this.productBO.insertProduct(p);
	}
	
	public void removeProduct(Product p){
		this.productBO.removeProduct(p);
	} 

	public void updateProduct(Product p){
		this.productBO.updateProduct(p);
	}
	
	public Product queryById(int i) throws Exception{
		return productBO.queryById(i);
	}
	
	public List<Product> seeAllProduct() throws Exception{
		return productBO.seeAll();
	}
	
	public void insertPiece(Piece piece) throws PieceAlreadyExistsException
	{
		this.pieceBO.insertPiece(piece);
	}
	
	public void removerPiece(Piece piece){
		this.pieceBO.removePiece(piece);
	}
	
	public void updatePiece(Piece piece){
		this.pieceBO.updatePiece(piece);
	}
	
	public List<Piece> seeAllPiece() throws NoSearchResultException{
		return pieceBO.seeAllPeice();
	}
	
	
}


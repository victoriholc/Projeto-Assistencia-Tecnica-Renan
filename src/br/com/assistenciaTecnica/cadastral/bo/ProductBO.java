package br.com.assistenciaTecnica.cadastral.bo;

import java.util.List;

import br.com.assistenciaTecnica.cadastral.dao.IProductDAO;
import br.com.assistenciaTecnica.cadastral.dao.ProductDAO;
import br.com.assistenciaTecnica.cadastral.model.Product;

public class ProductBO{
	private IProductDAO productDAO;

	public ProductBO(){
		this.productDAO = new ProductDAO();
	}

	
	public void insertProduct(Product p) {
		try{
			this.productDAO.insert(p);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public void removeProduct(Product p) {
		try{
			this.productDAO.remove(p);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public void refreshProduct(Product p) {
		try{
			this.productDAO.refresh(p);
		}catch(Exception e){
			e.printStackTrace();
		}	
	}

	public Product queryById(int i) {
		try{
			return productDAO.queryById(i);
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}


	public List<Product> seeAll() {
		try{
			return productDAO.seeAll();
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
}

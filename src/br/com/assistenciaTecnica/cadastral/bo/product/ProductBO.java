package br.com.assistenciaTecnica.cadastral.bo.product;

import java.util.ArrayList;
import java.util.List;

import br.com.assistenciaTecnica.cadastral.dao.product.IProductDAO;
import br.com.assistenciaTecnica.cadastral.dao.product.ProductDAO;
import br.com.assistenciaTecnica.cadastral.exception.NoSearchResultException;
import br.com.assistenciaTecnica.cadastral.exception.product.ProductAlreadyExistsException;
import br.com.assistenciaTecnica.cadastral.model.Product;

public class ProductBO{
	private IProductDAO productDAO;

	public ProductBO(){
		this.productDAO = new ProductDAO();
	}

	
	public void insertProduct(Product p) throws ProductAlreadyExistsException{
		this.productDAO.insert(p);
	}

	public void removeProduct(Product p) {
		try{
			this.productDAO.remove(p);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public void updateProduct(Product p) {
		try{
			this.productDAO.refresh(p);
		}catch(Exception e){
			e.printStackTrace();
		}	
	}

	public Product queryById(int i) throws NoSearchResultException{
		return productDAO.queryById(i);	
	}

	public List<Product> seeAll() throws Exception{
		List<Product> listProduct;
		listProduct = productDAO.seeAll();
		
		if(listProduct == null || listProduct.isEmpty()){
			listProduct = new ArrayList<Product>();
		}
		return productDAO.seeAll();	
	}
}

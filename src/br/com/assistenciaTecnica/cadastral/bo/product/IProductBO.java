package br.com.assistenciaTecnica.cadastral.bo.product;

import java.util.List;

import br.com.assistenciaTecnica.cadastral.exception.NoSearchResultException;
import br.com.assistenciaTecnica.cadastral.exception.product.ProductAlreadyExistsException;
import br.com.assistenciaTecnica.cadastral.model.Product;

public interface IProductBO {
	public void insertProduct(Product p) throws ProductAlreadyExistsException;
	public void removeProduct(Product p);
	public void updateProduct(Product p);
	public Product queryById (int i) throws NoSearchResultException;
	public List<Product> seeAll() throws Exception;
}

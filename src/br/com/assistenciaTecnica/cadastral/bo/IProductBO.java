package br.com.assistenciaTecnica.cadastral.bo;

import java.util.List;
import br.com.assistenciaTecnica.cadastral.model.Product;

public interface IProductBO {
	public void insertProduct(Product p);
	public void removeProduct(Product p);
	public void refreshProduct(Product p);
	public Product queryById (int i);
	public List<Product> seeAll();
}

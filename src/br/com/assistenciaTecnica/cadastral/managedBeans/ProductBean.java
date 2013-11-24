package br.com.assistenciaTecnica.cadastral.managedBeans;

import java.util.ArrayList;
import java.util.Collection;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import br.com.assistenciaTecnica.cadastral.Facade;
import br.com.assistenciaTecnica.cadastral.exception.product.ProductAlreadyExistsException;
import br.com.assistenciaTecnica.cadastral.model.Product;


@ManagedBean
public class ProductBean {
	private Product product;
	private String searchField = "";
	private Collection listProduct = new ArrayList<Product>();
	
	
	public ProductBean(Product product, String searchField, Collection listProduct) {
		super();
		this.product = new Product();
		this.searchField = searchField;
		this.listProduct = new ArrayList<Product>();
	}
	
	public String getSearchField() {
		return searchField;
	}

	public void setSearchField(String searchField) {
		this.searchField = searchField;
	}

	public Collection getListProduct() {
		return listProduct;
	}

	public void setListProduct(Collection listProduct) {
		this.listProduct = listProduct;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	
	public void insertProduct(){
		try{
			if(product.getId() == 0){
				Facade.getInstace().insertProduct(this.product);
			}else{
				Facade.getInstace().updateProduct(this.product);
			}
		}catch(ProductAlreadyExistsException e){
			FacesContext.getCurrentInstance().addMessage(null , new FacesMessage("Produto já existe" + 
			this.product.getNumberSerial()));
			e.getMessage();
			System.out.println("Produto já existe");
		}		
	}
	
	public void removeProduct(Product product){
		try{ 
			Facade.getInstace().removeProduct(product);
		}catch(Exception e){
			FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("Produto não pode ser removido" +
			product.getModel()));
			
			System.out.println("Produto não pode ser removido");
		}
	}
	
	public void seeAllProduct(){
		try{
			if(searchField != null && !searchField.isEmpty()){
				this.listProduct = Facade.getInstace().seeAllProduct();
			}
		}catch(Exception e){
			e.getMessage();
		}	
	}
}

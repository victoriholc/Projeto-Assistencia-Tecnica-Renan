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
	private Collection<Product> listProduct = new ArrayList<Product>();
	private String selectedObject;
	
	public ProductBean() {
	}
	
	
	public String getSelectedObject() {
		return selectedObject;
	}

	public void setSelectedObject(String selectedObject) {
		this.selectedObject = selectedObject;
	}


	public String getSearchField() {
		return searchField;
	}

	public void setSearchField(String searchField) {
		this.searchField = searchField;
	}

	public Collection<Product> getListProduct() {
		return listProduct;
	}

	public void setListProduct(Collection<Product> listProduct) {
		this.listProduct = listProduct;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	
	public String insertProduct(){
		try{
			if(product.getId() == 0){
				//product.setId(null);
				Facade.getInstace().insertProduct(product);
			}else{
				Facade.getInstace().updateProduct(product);
			}
		}catch(ProductAlreadyExistsException e){
			FacesContext.getCurrentInstance().addMessage(null , new FacesMessage("Produto ja existe" + 
			this.product.getNumberSerial()));
			e.getMessage();
			System.out.println("Produto ja existe");
		}
		return "/cadastral/product/view_product.xhtml";
	}
	
	public String removeProduct(Product produto){
		try{ 
			Facade.getInstace().removeProduct(produto);
		}catch(Exception e){
			FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("Produto nao pode ser removido" +
			produto.getModel()));
			
			System.out.println("Produto nao pode ser removido");
		}
		return "/cadastral/product/view_product.xhtml";
	}
	
	public String updateProduct(Product param){
		this.product = param;
		this.selectedObject = param.getMark();
		return "/cadastral/product/save_product.xhtml";
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
	
	public String viewProduct() {//metodo de redirecionamento para voltar pagina
		return "/cadastral/product/view_product.xhtml?faces-redirect=true";
	}

}

package br.com.assistenciaTecnica.organization.managedBeans.functionary.function;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import br.com.assistenciaTecnica.organization.Facade;
import br.com.assistenciaTecnica.organization.exception.NoSearchResultsException;
import br.com.assistenciaTecnica.organization.exception.functionary.function.FunctionAlreadyExistsException;
import br.com.assistenciaTecnica.organization.model.department.Department;
import br.com.assistenciaTecnica.organization.model.functionary.function.Function;

@ManagedBean
public class FunctionBean {
	private String searchField ="";
	private Function function = new Function();
	private List<Function> listFunction = new ArrayList<Function>();

	//gets and sets
	public Function getFunction() {
		return this.function;
	}
	public void setFunction(Function function) {
		this.function = function;
	}
	public List<Function> getListFunction() {
		if (searchField != null && !searchField.isEmpty()) {
				this.listFunction = Facade.getInstace()
						.findBySimilarNameFunction(searchField);
		}
		if(this.listFunction.isEmpty()){
			seeAll();
		}
		return listFunction;
	}
	public String getSearchField() {
		return searchField;
	}
	public void setSearchField(String searchField) {
		this.searchField = searchField;
	}
	
	//metodos de mudanca
	public String insert() {
		try {

			Facade.getInstace().insertFunction(this.function);
			FacesMessage msg = new FacesMessage("funcao Salva com sucesso!");
			FacesContext.getCurrentInstance().addMessage(null,msg);
			seeAll();
			
			if(function.getId() != 0){
				return view();
			}else{
				this.function = new Function();
			}

		} catch (FunctionAlreadyExistsException e) {
			e.printStackTrace();
			
			FacesMessage msg = new FacesMessage(e.getMessage());
			FacesContext.getCurrentInstance().addMessage(null, msg);

		} catch (Exception e) {

			e.printStackTrace();
			FacesMessage msg = new FacesMessage(e.getMessage());
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}
		return "function";
	}
	public void remove(Function function){
		Facade.getInstace().removeFunction(function);
		seeAll();
	}

	//metodos de busca
	public void seeAll(){
			this.listFunction = Facade.getInstace().seeAllFunction();
	}
	public String findBySimilarName(){
			this.listFunction = Facade.getInstace().findBySimilarNameFunction(searchField);
		return "/organization/functionary/function/view_function.xhtml";
	}
	
	//metodos de redirecionamento
	public String newFunction() {
		return "function.xhtml?faces-redirect=true";
	}
	public String view() {
		
		return "/organization/functionary/function/view_function.xhtml?faces-redirect=true";
	}
	public String loadFunction(Function function) {
		this.function = function;
		return "function.xhtml";
	}

}


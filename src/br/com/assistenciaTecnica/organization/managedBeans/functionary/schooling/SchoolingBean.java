package br.com.assistenciaTecnica.organization.managedBeans.functionary.schooling;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import br.com.assistenciaTecnica.organization.Facade;
import br.com.assistenciaTecnica.organization.exception.NoSearchResultsException;
import br.com.assistenciaTecnica.organization.exception.functionary.schooling.SchoolingAlreadyExistsException;
import br.com.assistenciaTecnica.organization.model.department.Department;
import br.com.assistenciaTecnica.organization.model.functionary.schooling.Schooling;

@ManagedBean
public class SchoolingBean {
	private String searchField ="";
	private Schooling schooling = new Schooling();
	private List<Schooling> listSchooling = new ArrayList<Schooling>();

	//gets and sets
	public Schooling getSchooling() {
		return this.schooling;
	}
	public void setSchooling(Schooling schooling) {
		this.schooling = schooling;
	}
	public List<Schooling> getListSchooling() {
		if (searchField != null && !searchField.isEmpty()) {
				this.listSchooling = Facade.getInstace()
						.findBySimilarNameSchooling(searchField);
		}
		if(this.listSchooling.isEmpty()){
			seeAll();
		}
		return listSchooling;
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

			Facade.getInstace().insertSchooling(this.schooling);
			FacesMessage msg = new FacesMessage("Escolaridade Salva com sucesso!");
			FacesContext.getCurrentInstance().addMessage(null,msg);
			seeAll();
			
			if(schooling.getId() != 0){
				return view();
			}else{
				this.schooling = new Schooling();
			}

		} catch (SchoolingAlreadyExistsException e) {
			e.printStackTrace();
			
			FacesMessage msg = new FacesMessage(e.getMessage());
			FacesContext.getCurrentInstance().addMessage(null, msg);

		} catch (Exception e) {

			e.printStackTrace();
			FacesMessage msg = new FacesMessage(e.getMessage());
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}
		return "schooling";
	}
	public void remove(Schooling schooling){
		Facade.getInstace().removeSchooling(schooling);
		seeAll();
	}

	//metodos de busca
	public void seeAll(){
			this.listSchooling = Facade.getInstace().seeAllSchooling();
	}
	public String findBySimilarName(){
			this.listSchooling = Facade.getInstace().findBySimilarNameSchooling(searchField);
			
		return "/organization/functionary/schooling/view_schooling.xhtml";
	}
	
	//metodos de redirecionamento
	public String newSchooling() {
		return "schooling.xhtml?faces-redirect=true";
	}
	public String view() {
		
		return "/organization/functionary/schooling/view_schooling.xhtml?faces-redirect=true";
	}
	public String loadSchooling(Schooling schooling) {
		this.schooling = schooling;
		return "schooling.xhtml";
	}

}


package br.com.assistenciaTecnica.organization.managedBeans.department;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import br.com.assistenciaTecnica.organization.Facade;
import br.com.assistenciaTecnica.organization.exception.department.DepartmentAlreadyExistsException;
import br.com.assistenciaTecnica.organization.model.department.Department;

@ManagedBean
public class DepartmentBean {

	private String searchField = "";
	private Department department = new Department();
	private List<Department> listDepartment = new ArrayList<Department>();

	// gets and sets
	public Department getDepartment() {
		return this.department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public List<Department> getListDepartment() {
		if (searchField != null && !searchField.isEmpty()) {
				this.listDepartment = Facade.getInstace()
						.findBySimilarNameDepartment(searchField);
		}
		if (this.listDepartment.isEmpty()) {
			seeAll();
		}
		return listDepartment;
	}

	public String getSearchField() {
		return searchField;
	}

	public void setSearchField(String searchField) {
		this.searchField = searchField;
	}

	// metodos de mudanca
	public String insert() {
		try {

			Facade.getInstace().insertDepartment(this.department);
			FacesMessage msg = new FacesMessage(
					"Departamento Salvo com sucesso!");
			FacesContext.getCurrentInstance().addMessage(null, msg);
			seeAll();
			
			if(department.getId() != 0){
				return view();
			}else{
				this.department = new Department();
			}

		} catch (DepartmentAlreadyExistsException e) {
			e.printStackTrace();

			FacesMessage msg = new FacesMessage(e.getMessage());
			FacesContext.getCurrentInstance().addMessage(null, msg);

		} catch (Exception e) {

			e.printStackTrace();
			FacesMessage msg = new FacesMessage(e.getMessage());
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}
		return "department";
	}

	public void remove(Department department) {
		Facade.getInstace().removeDepartment(department);
		seeAll();
	}

	// metodos de busca
	public void seeAll() {
			this.listDepartment = Facade.getInstace().seeAllDepartment();
	}

	public String findBySimilarName() {
			this.listDepartment = Facade.getInstace()
					.findBySimilarNameDepartment(searchField);
			
		return "/organization/department/view_department.xhtml";
	}

	// metodos de redirecionamento
	public String newDepartment() {
		return "department.xhtml?faces-redirect=true";
	}

	public String view() {

		return "/organization/department/view_department.xhtml?faces-redirect=true";
	}

	public String loadDepartment(Department department) {
		this.department = department;
		return "department.xhtml";
	}

}

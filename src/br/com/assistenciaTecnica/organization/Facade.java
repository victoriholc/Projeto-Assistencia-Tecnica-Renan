package br.com.assistenciaTecnica.organization;

import java.util.List;

import br.com.assistenciaTecnica.organization.bo.department.DepartmentBO;
import br.com.assistenciaTecnica.organization.bo.functionary.FunctionaryBO;
import br.com.assistenciaTecnica.organization.bo.functionary.function.FunctionBO;
import br.com.assistenciaTecnica.organization.bo.functionary.schooling.SchoolingBO;
import br.com.assistenciaTecnica.organization.bo.user.UserBO;
import br.com.assistenciaTecnica.organization.exception.user.LoginInvalidException;
import br.com.assistenciaTecnica.organization.model.department.Department;
import br.com.assistenciaTecnica.organization.model.functionary.Functionary;
import br.com.assistenciaTecnica.organization.model.functionary.function.Function;
import br.com.assistenciaTecnica.organization.model.functionary.schooling.Schooling;
import br.com.assistenciaTecnica.organization.model.user.User;

public class Facade {
	private static Facade facade = null;
	private DepartmentBO departmentBO = null;
	private FunctionBO functionBO = null;
	private SchoolingBO schoolingBO = null;
	private UserBO userBO = null;
	private FunctionaryBO functionaryBO = null;
	
	private Facade(){
		this.departmentBO = new DepartmentBO();
		this.functionBO = new FunctionBO();
		this.schoolingBO = new SchoolingBO();
		this.userBO = new UserBO();
		this.functionaryBO = new FunctionaryBO();
	}
	
	public static Facade getInstace(){
		if(facade == null){
			facade = new Facade();
		}
		return facade;
	}
	
	public void insertDepartment(Department department) throws Exception{
			departmentBO.insertDepartment(department);
	}
	
	public void removeDepartment(Department department){
		departmentBO.removeDepartment(department);
	}
	
	public List<Department>seeAllDepartment() {
		return departmentBO.seeAll();
	}
	public List<Department>findBySimilarNameDepartment(String name) {
		return departmentBO.findBySimilarName(name);
	}
	
	public void insertFunction(Function function) throws Exception{
		functionBO.insertFunction(function);
	}

	public void removeFunction(Function function){
		functionBO.removeFunction(function);
	}
	
	public List<Function>seeAllFunction() {
		return functionBO.seeAll();
	}
	public List<Function>findBySimilarNameFunction(String name) {
		return functionBO.findBySimilarName(name);
	}
	
	public void insertSchooling(Schooling schooling) throws Exception{
		schoolingBO.insertSchooling(schooling);
	}

	public void removeSchooling(Schooling schooling){
		schoolingBO.removeSchooling(schooling);
	}
	
	public List<Schooling>seeAllSchooling(){
		return schoolingBO.seeAll();
	}
	public List<Schooling>findBySimilarNameSchooling(String name){
		return schoolingBO.findBySimilarName(name);
	}

	public User login(String login, String pass) throws LoginInvalidException {
		return userBO.login(login,pass);
	}
	
	public void insertFunctionary(Functionary functionary) throws Exception{
		functionaryBO.insertFunctionary(functionary);
	}

	public void removeFunction(Functionary functionary){
		functionaryBO.removeFunctionary(functionary);
	}
	
	public List<Functionary>seeAllFunctionary() {
		return functionaryBO.seeAll();
	}
	
}

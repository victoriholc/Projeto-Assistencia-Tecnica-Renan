package br.com.assistenciaTecnica.organization.bo.functionary.function;

import java.util.ArrayList;
import java.util.List;

import br.com.assistenciaTecnica.organization.dao.functionary.function.FunctionDAO;
import br.com.assistenciaTecnica.organization.dao.functionary.function.IFunctionDAO;
import br.com.assistenciaTecnica.organization.exception.NoSearchResultsException;
import br.com.assistenciaTecnica.organization.exception.functionary.function.FunctionAlreadyExistsException;
import br.com.assistenciaTecnica.organization.model.functionary.function.Function;

public class FunctionBO {
	
	public void insertFunction(Function function) throws Exception{
		IFunctionDAO dao = new FunctionDAO(); 
		
		try{
			Function f = dao.findByName(function);
			throw new FunctionAlreadyExistsException();
			
		}catch(javax.persistence.NoResultException e){
			
			validation(function);
			
			dao.insert(function);
			
		}
	}
	
	public void removeFunction(Function function){
		IFunctionDAO dao = new FunctionDAO(); 
		
		dao.remove(function);
//		dao.refresh(department);
	}
	public List<Function> seeAll() {
		IFunctionDAO dao = new FunctionDAO(); 
		List<Function> listFunction;
		
		listFunction = dao.seeAll();
		if(listFunction == null || listFunction.isEmpty()){
			listFunction = new ArrayList<Function>();
		}
		
		return listFunction;
	}
	
	public List<Function> findBySimilarName(String name) {
		IFunctionDAO dao = new FunctionDAO(); 
		List<Function> listFunction;
		
		listFunction = dao.findBySimilarName(name);
		
		if(listFunction == null || listFunction.isEmpty()){
			listFunction = new ArrayList<Function>();
		}
		
		return listFunction;
	}
	
	private final void validation(Function function) throws Exception{
		if(function.getName() == null || function.getName().isEmpty()){
			throw new Exception("Informe o nome da funcao!");
		}
	}
	
}

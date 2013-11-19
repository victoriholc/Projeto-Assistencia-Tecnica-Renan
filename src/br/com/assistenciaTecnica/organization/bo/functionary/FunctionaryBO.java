package br.com.assistenciaTecnica.organization.bo.functionary;

import java.util.ArrayList;
import java.util.List;

import br.com.assistenciaTecnica.organization.dao.functionary.FunctionaryDAO;
import br.com.assistenciaTecnica.organization.dao.functionary.IFunctionaryDAO;
import br.com.assistenciaTecnica.organization.model.functionary.Functionary;


public class FunctionaryBO {
	public void insertFunctionary(Functionary functionary) throws Exception{
		IFunctionaryDAO dao = new FunctionaryDAO(); 
		
			dao.insert(functionary);
	}
	
	public void removeFunctionary(Functionary functionary){
		IFunctionaryDAO dao = new FunctionaryDAO();
		
		dao.remove(functionary);
		
	}
	
	public List<Functionary> seeAll() {
		IFunctionaryDAO dao = new FunctionaryDAO(); 
		List<Functionary> listFunctionary;
		
		listFunctionary = dao.seeAll();
		if(listFunctionary == null || listFunctionary.isEmpty()){
			listFunctionary = new ArrayList<Functionary>();
		}
		
		return listFunctionary;
	}
	
}

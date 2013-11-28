package br.com.assistenciaTecnica.cadastral.bo.client;

import java.util.ArrayList;
import java.util.List;

import br.com.assistenciaTecnica.cadastral.dao.client.ClientDAO;
import br.com.assistenciaTecnica.cadastral.dao.client.IClientDAO;
import br.com.assistenciaTecnica.cadastral.model.client.Client;

public interface IClientBO 
{
	public void insertClient(Client client) throws Exception{
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

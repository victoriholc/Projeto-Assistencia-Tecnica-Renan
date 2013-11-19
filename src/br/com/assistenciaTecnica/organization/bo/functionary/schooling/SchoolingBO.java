package br.com.assistenciaTecnica.organization.bo.functionary.schooling;

import java.util.ArrayList;
import java.util.List;

import br.com.assistenciaTecnica.organization.dao.functionary.schooling.ISchoolingDAO;
import br.com.assistenciaTecnica.organization.dao.functionary.schooling.SchoolingDAO;
import br.com.assistenciaTecnica.organization.exception.NoSearchResultsException;
import br.com.assistenciaTecnica.organization.exception.functionary.schooling.SchoolingAlreadyExistsException;
import br.com.assistenciaTecnica.organization.model.functionary.schooling.Schooling;

public class SchoolingBO {
	
	public void insertSchooling(Schooling schooling) throws Exception{
		ISchoolingDAO dao = new SchoolingDAO(); 
		
		try{
			Schooling f = dao.findByName(schooling);
			throw new SchoolingAlreadyExistsException();
			
		}catch(javax.persistence.NoResultException e){
			
			validation(schooling);
			
			dao.insert(schooling);
			
		}
	}
	
	public void removeSchooling(Schooling schooling){
		ISchoolingDAO dao = new SchoolingDAO(); 
		
		dao.remove(schooling);
//		dao.refresh(department);
	}
	public List<Schooling> seeAll() {
		ISchoolingDAO dao = new SchoolingDAO(); 
		List<Schooling> listSchooling;
		
		listSchooling = dao.seeAll();
		if(listSchooling == null || listSchooling.isEmpty()){
			listSchooling = new ArrayList<Schooling>();
		}
		
		return listSchooling;
	}
	
	public List<Schooling> findBySimilarName(String name) {
		ISchoolingDAO dao = new SchoolingDAO(); 
		List<Schooling> listSchooling;
		
		listSchooling = dao.findBySimilarName(name);
		
		if(listSchooling == null || listSchooling.isEmpty()){
			listSchooling = new ArrayList<Schooling>();
		}
		
		
		return listSchooling;
	}
	
	private final void validation(Schooling schooling) throws Exception{
		if(schooling.getName() == null || schooling.getName().isEmpty()){
			throw new Exception("Informe o nome da escolaridade!");
		}
	}
	
}

package br.com.assistenciaTecnica.cadastral.bo;

import java.util.ArrayList;
import java.util.List;

import br.com.assistenciaTecnica.cadastral.dao.IServiceDAO;
import br.com.assistenciaTecnica.cadastral.dao.ServiceDAO;
import br.com.assistenciaTecnica.cadastral.exception.service.ServiceAlreadyExistsException;
import br.com.assistenciaTecnica.cadastral.model.Service;

public class ServiceBO {
	public void insertService(Service service) throws Exception{
		IServiceDAO dao = new ServiceDAO(); 
		
		try{
			Service s = dao.findByName(service);
			throw new ServiceAlreadyExistsException();
			
		}catch(javax.persistence.NoResultException e){
			
			validation(service);
			
			dao.insert(service);
			
		}
	}
	
	public void removeService(Service service){
		IServiceDAO dao = new ServiceDAO();  
		
		dao.remove(service);
	}
	
	public List<Service> seeAll(){
		IServiceDAO dao = new ServiceDAO(); 
		List<Service> listService;
		
		listService = dao.seeAll();
		if(listService == null || listService.isEmpty()){
			listService = new ArrayList<Service>();
		}
		
		return listService;
	}
	
	public List<Service> findBySimilarName(String name){
		IServiceDAO dao = new ServiceDAO(); 
		List<Service> listService;
		
		listService = dao.findBySimilarName(name);
		
		if(listService == null || listService.isEmpty()){
			listService = new ArrayList<Service>();
		}
		
		return listService;
	}
	
	private final void validation(Service service) throws Exception{
		if(service.getName() == null || service.getName().isEmpty()){
			throw new Exception("Informe o nome do servico !");
		}
	}
	
}

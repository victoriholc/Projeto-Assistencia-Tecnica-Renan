package br.com.assistenciaTecnica.cadastral.bo.service;

import java.util.ArrayList;
import java.util.List;

import br.com.assistenciaTecnica.cadastral.dao.service.IServiceDAO;
import br.com.assistenciaTecnica.cadastral.dao.service.ServiceDAO;
import br.com.assistenciaTecnica.cadastral.exception.service.ServiceAlreadyExistsException;
import br.com.assistenciaTecnica.cadastral.model.Service;

public class ServiceBO implements IServiceBO
{
	@Override
	public void insertService(Service service) throws Exception{
		IServiceDAO dao = new ServiceDAO(); 
		
		try{
			dao.findByName(service);
			throw new ServiceAlreadyExistsException();
			
		}catch(javax.persistence.NoResultException e){
			
			validation(service);
			
			dao.insert(service);
			
		}
	}
	
	@Override
	public void removeService(Service service){
		IServiceDAO dao = new ServiceDAO();  
		
		dao.remove(service);
	}
	
	@Override
	public List<Service> seeAll(){
		IServiceDAO dao = new ServiceDAO(); 
		List<Service> listService;
		
		listService = dao.seeAll();
		if(listService == null || listService.isEmpty()){
			listService = new ArrayList<Service>();
		}
		
		return listService;
	}
	
	@Override
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

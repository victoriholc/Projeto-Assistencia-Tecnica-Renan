package br.com.assistenciaTecnica.cadastral;

import java.util.List;

import br.com.assistenciaTecnica.cadastral.bo.ServiceBO;
import br.com.assistenciaTecnica.cadastral.model.Service;

public class Facade {
	private static Facade facade = null;
	private ServiceBO serviceBO = null;
	
	private Facade(){
		this.serviceBO = new ServiceBO();
	}
	
	public static Facade getInstace(){
		if(facade == null){
			facade = new Facade();
		}
		return facade;
	}
	
	public void insertService(Service service) throws Exception{
		serviceBO.insertService(service);
	}
	
	public void removeService(Service service) {
		serviceBO.removeService(service);
	}
	
	public List<Service>seeAllService() {
		return serviceBO.seeAll();
	}
	public List<Service>findBySimilarNameService(String name) {
		return serviceBO.findBySimilarName(name);
	}
}

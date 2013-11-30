package br.com.assistenciaTecnica.cadastral.bo.service;

import java.util.List;

import br.com.assistenciaTecnica.cadastral.model.Service;

public interface IServiceBO 
{
	public void insertService(Service service) throws Exception;
	
	public void removeService(Service service);
	
	public List<Service> seeAll();
	
	public List<Service> findBySimilarName(String name);
}

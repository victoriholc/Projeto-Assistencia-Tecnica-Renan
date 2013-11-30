package br.com.assistenciaTecnica.cadastral.bo.client;

import java.util.ArrayList;
import java.util.List;

import br.com.assistenciaTecnica.cadastral.dao.client.ClientDAO;
import br.com.assistenciaTecnica.cadastral.dao.client.IClientDAO;
import br.com.assistenciaTecnica.cadastral.model.client.Client;
import br.com.assistenciaTecnica.organization.exception.department.DepartmentAlreadyExistsException;

public class ClientBO implements IClientBO 
{
	IClientDAO clientDAO;
	
	public ClientBO () 
	{
		this.clientDAO = new ClientDAO();
	}
	
	@Override
	public void insertClient(Client client) throws Exception
	{
		try
		{
			this.clientDAO.findByName(client);
			throw new DepartmentAlreadyExistsException();
			
		}
		catch(javax.persistence.NoResultException e)
		{
			
			this.validation(client);
			
			this.clientDAO.insert(client);
			
		}
	}
	
	@Override
	public void removeClient(Client client)
	{
		this.clientDAO.remove(client);
//		dao.refresh(department);
	}
	
	@Override
	public List<Client> seeAll()
	{	 
		List<Client> listClient;
		
		listClient = this.clientDAO.seeAll();
		if(listClient == null || listClient.isEmpty()){
			listClient = new ArrayList<Client>();
		}
		
		return listClient;
	}
	@Override
	public List<Client> findBySimilarName(String name)
	{
		List<Client> listClient;
		
		listClient = this.clientDAO.findBySimilarName(name);
		
		if(listClient == null || listClient.isEmpty()){
			listClient = new ArrayList<Client>();
		}
		
		return listClient;
	}
	
	private final void validation(Client department) throws Exception{
		if(department.getName() == null || department.getName().isEmpty()){
			throw new Exception("Informe o nome do departamento!");
		}
	}
}

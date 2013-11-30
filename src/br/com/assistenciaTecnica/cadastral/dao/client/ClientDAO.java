package br.com.assistenciaTecnica.cadastral.dao.client;

import java.util.List;

import javax.persistence.TypedQuery;

import br.com.assistenciaTecnica.cadastral.model.client.Client;
import br.com.assistenciaTecnica.generic.dao.DAO;

public class ClientDAO extends DAO<Client> implements IClientDAO
{
	@Override
	public Client findByName(Client client)
	{
		TypedQuery<Client> query = entityManager.createQuery("SELECT c FROM Client c WHERE c.name = :name", Client.class);
		query.setParameter("name", client.getName());
		
		Client c = query.getSingleResult();
		
		return c;		
	}

	@Override
	public List<Client> findBySimilarName(String name) 
	{
		TypedQuery<Client> query = entityManager.createQuery("SELECT c FROM Client c WHERE c.name like :name", Client.class);
		query.setParameter("name", "%"+name+"%");
		
		List<Client> c = query.getResultList();
		
		return c;		
	}
}

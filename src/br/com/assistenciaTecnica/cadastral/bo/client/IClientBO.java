package br.com.assistenciaTecnica.cadastral.bo.client;

import java.util.List;

import br.com.assistenciaTecnica.cadastral.model.client.Client;

public interface IClientBO 
{
	public void insertClient (Client client) throws Exception;
	
	public void removeClient (Client client);
	
	public List<Client> seeAll ();
	
	public List<Client> findBySimilarName (String name);
}

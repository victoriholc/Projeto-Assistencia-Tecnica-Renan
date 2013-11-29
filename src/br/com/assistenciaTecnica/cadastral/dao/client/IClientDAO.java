package br.com.assistenciaTecnica.cadastral.dao.client;

import java.util.List;

import br.com.assistenciaTecnica.cadastral.model.client.Client;
import br.com.assistenciaTecnica.generic.dao.IDAO;

public interface IClientDAO extends IDAO<Client>
{
	public Client findByName(Client client);	

	public List<Client> findBySimilarName(String name);
	
}

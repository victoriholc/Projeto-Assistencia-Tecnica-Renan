package br.com.assistenciaTecnica.cadastral.dao;

import java.util.List;

import br.com.assistenciaTecnica.cadastral.model.Service;
import br.com.assistenciaTecnica.generic.dao.IDAO;

public interface IServiceDAO extends IDAO<Service>{
	public Service findByName(Service service);
	public List<Service> findBySimilarName(String name);
}

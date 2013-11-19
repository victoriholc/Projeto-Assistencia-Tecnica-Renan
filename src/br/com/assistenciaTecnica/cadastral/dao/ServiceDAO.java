package br.com.assistenciaTecnica.cadastral.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import br.com.assistenciaTecnica.cadastral.model.Service;
import br.com.assistenciaTecnica.organization.dao.DAO;

public class ServiceDAO extends DAO<Service> implements IServiceDAO{

	@Override
	public Service findByName(Service service) {
		TypedQuery<Service> query = entityManager.createQuery("SELECT s FROM Service s WHERE s.name = :name",Service.class);
		query.setParameter("name", service.getName());
		
		 Service s = query.getSingleResult();
		
		return s;
	}

	@Override
	public List<Service> findBySimilarName(String name) {
		TypedQuery<Service> query = entityManager.createQuery("SELECT s FROM Service s WHERE s.name like :name",Service.class);
		query.setParameter("name", "%"+name+"%");
		
		 List<Service> s = query.getResultList();
		
		return s;
	}

}

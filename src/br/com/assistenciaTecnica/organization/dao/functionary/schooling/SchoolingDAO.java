package br.com.assistenciaTecnica.organization.dao.functionary.schooling;


import java.util.List;

import javax.persistence.TypedQuery;

import br.com.assistenciaTecnica.generic.dao.DAO;
import br.com.assistenciaTecnica.organization.model.functionary.schooling.Schooling;

public class SchoolingDAO extends DAO<Schooling> implements ISchoolingDAO{
	
	@Override
	public Schooling findByName(Schooling schooling) {
		TypedQuery<Schooling> query = entityManager.createQuery("SELECT s FROM Schooling s WHERE s.name = :name",Schooling.class);
		query.setParameter("name", schooling.getName());
		
		Schooling s = query.getSingleResult();
		
		return s;		
	}

	@Override
	public List<Schooling> findBySimilarName(String name) {
		TypedQuery<Schooling> query = entityManager.createQuery("SELECT s FROM Schooling s WHERE s.name like :name",Schooling.class);
		query.setParameter("name", "%"+name+"%");
		
		 List<Schooling> s = query.getResultList();
		
		return s;		
	}

}

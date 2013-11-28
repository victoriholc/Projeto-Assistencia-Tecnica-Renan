package br.com.assistenciaTecnica.organization.dao.functionary.function;


import java.util.List;

import javax.persistence.TypedQuery;

import br.com.assistenciaTecnica.generic.dao.DAO;
import br.com.assistenciaTecnica.organization.model.functionary.function.Function;

public class FunctionDAO extends DAO<Function> implements IFunctionDAO{
	
	@Override
	public Function findByName(Function function) {
		TypedQuery<Function> query = entityManager.createQuery("SELECT f FROM Function f WHERE f.name = :name",Function.class);
		query.setParameter("name", function.getName());
		
		Function f = query.getSingleResult();
		
		return f;		
	}

	@Override
	public List<Function> findBySimilarName(String name) {
		TypedQuery<Function> query = entityManager.createQuery("SELECT f FROM Function f WHERE f.name like :name",Function.class);
		query.setParameter("name", "%"+name+"%");
		
		 List<Function> f = query.getResultList();
		
		return f;		
	}

}

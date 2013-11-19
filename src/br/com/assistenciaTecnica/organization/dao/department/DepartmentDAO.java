package br.com.assistenciaTecnica.organization.dao.department;


import java.util.List;

import javax.persistence.TypedQuery;

import br.com.assistenciaTecnica.organization.dao.DAO;
import br.com.assistenciaTecnica.organization.model.department.Department;

public class DepartmentDAO extends DAO<Department> implements IDepartmentDAO{
	
	@Override
	public Department findByName(Department department) {
		TypedQuery<Department> query = entityManager.createQuery("SELECT d FROM Department d WHERE d.name = :name",Department.class);
		query.setParameter("name", department.getName());
		
		 Department d = query.getSingleResult();
		
		return d;		
	}

	@Override
	public List<Department> findBySimilarName(String name) {
		TypedQuery<Department> query = entityManager.createQuery("SELECT d FROM Department d WHERE d.name like :name",Department.class);
		query.setParameter("name", "%"+name+"%");
		
		 List<Department> d = query.getResultList();
		
		return d;		
	}

}

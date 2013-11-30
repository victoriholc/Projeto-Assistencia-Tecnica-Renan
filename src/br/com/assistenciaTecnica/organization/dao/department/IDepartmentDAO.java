package br.com.assistenciaTecnica.organization.dao.department;

import java.util.List;

import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import br.com.assistenciaTecnica.generic.dao.IDAO;
import br.com.assistenciaTecnica.organization.dao.*;
import br.com.assistenciaTecnica.organization.model.department.Department;

public interface IDepartmentDAO extends IDAO<Department>{
	public Department findByName(Department department);
	public List<Department> findBySimilarName(String name);
}

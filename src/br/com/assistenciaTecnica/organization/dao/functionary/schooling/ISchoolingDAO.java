package br.com.assistenciaTecnica.organization.dao.functionary.schooling;

import java.util.List;

import br.com.assistenciaTecnica.organization.dao.IDAO;
import br.com.assistenciaTecnica.organization.model.functionary.schooling.Schooling;

public interface ISchoolingDAO extends IDAO<Schooling>{
	public Schooling findByName(Schooling schooling);
	public List<Schooling> findBySimilarName(String name);
}

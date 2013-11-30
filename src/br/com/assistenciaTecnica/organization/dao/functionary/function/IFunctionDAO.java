package br.com.assistenciaTecnica.organization.dao.functionary.function;

import java.util.List;

import br.com.assistenciaTecnica.generic.dao.IDAO;
import br.com.assistenciaTecnica.organization.model.functionary.function.Function;

public interface IFunctionDAO extends IDAO<Function>{
	public Function findByName(Function function);
	public List<Function> findBySimilarName(String name);
}

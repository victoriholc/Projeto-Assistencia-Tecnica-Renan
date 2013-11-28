package br.com.assistenciaTecnica.organization.dao.user;

import br.com.assistenciaTecnica.generic.dao.IDAO;
import br.com.assistenciaTecnica.organization.exception.user.LoginInvalidException;
import br.com.assistenciaTecnica.organization.model.user.User;

public interface IUserDAO extends IDAO<User>{
	public User login(String login,String pass) throws LoginInvalidException;
}

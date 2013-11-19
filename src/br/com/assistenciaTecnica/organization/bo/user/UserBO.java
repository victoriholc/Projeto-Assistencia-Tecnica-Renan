package br.com.assistenciaTecnica.organization.bo.user;

import br.com.assistenciaTecnica.organization.dao.user.UserDAO;
import br.com.assistenciaTecnica.organization.exception.user.LoginInvalidException;
import br.com.assistenciaTecnica.organization.model.user.User;

public class UserBO {
	
	public User login(String login, String pass) throws LoginInvalidException{	
		return new UserDAO().login(login, pass);
	}
}

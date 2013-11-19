package br.com.assistenciaTecnica.organization.dao.user;

import javax.persistence.TypedQuery;

import br.com.assistenciaTecnica.organization.dao.DAO;
import br.com.assistenciaTecnica.organization.exception.user.LoginInvalidException;
import br.com.assistenciaTecnica.organization.model.user.User;

public class UserDAO extends DAO<User> implements IUserDAO{

	@Override
	public User login(String login, String pass) throws LoginInvalidException {
		try {
			TypedQuery<User> query = entityManager.createNamedQuery("user.login", User.class);
			query.setParameter("log", login);
			query.setParameter("pass", pass);
			return query.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
			throw new LoginInvalidException();
		}
	}

}

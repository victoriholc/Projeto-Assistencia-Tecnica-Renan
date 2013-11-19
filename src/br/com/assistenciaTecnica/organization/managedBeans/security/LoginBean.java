package br.com.assistenciaTecnica.organization.managedBeans.security;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import br.com.assistenciaTecnica.organization.Facade;
import br.com.assistenciaTecnica.organization.exception.user.LoginInvalidException;
import br.com.assistenciaTecnica.organization.model.user.User;

@ManagedBean
@SessionScoped
public class LoginBean {

	private String login;
	private String pass;
	private User user;
	
	public String makeLogin(){
		try {
			user = Facade.getInstace().login(login, pass);
		} catch (LoginInvalidException e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(e.getMessage()));
		}
		return "/home.xhtml?faces-redirect=true";
	}
	public String logout(){
		this.user = null;
		return "/index.xhtml?faces-redirect=true";
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	
}

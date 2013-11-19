package br.com.assistenciaTecnica.organization.model.user;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

import br.com.assistenciaTecnica.organization.model.person.address.Address;
import br.com.assistenciaTecnica.organization.model.person.phone.Phone;

@Entity
@NamedQuery(name="user.login", query="SELECT u FROM User u WHERE u.login = :log and u.password = :pass")
public class User {
	@Id @GeneratedValue
	private int id;
	
	@Column(nullable=false,length=15)
	private String login;
	
	@Column(nullable=false,length=15)
	private String password;
	
	private String passwordReminder;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable=false)
	private Status status;

	@Version
	private long version;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPasswordReminder() {
		return passwordReminder;
	}

	public void setPasswordReminder(String passwordReminder) {
		this.passwordReminder = passwordReminder;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public long getVersion() {
		return version;
	}

	public void setVersion(long version) {
		this.version = version;
	}
	
	

}

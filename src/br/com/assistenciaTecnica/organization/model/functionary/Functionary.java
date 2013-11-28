package br.com.assistenciaTecnica.organization.model.functionary;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Cascade;

import br.com.assistenciaTecnica.generic.model.person.Person;
import br.com.assistenciaTecnica.organization.model.department.Department;
import br.com.assistenciaTecnica.organization.model.functionary.function.Function;
import br.com.assistenciaTecnica.organization.model.functionary.schooling.Schooling;
import br.com.assistenciaTecnica.organization.model.user.User;

@Entity
public class Functionary extends Person{
	@Id @GeneratedValue
	private int id;
	
	@OneToOne
	private User user;
	
	@ManyToOne
	private Department department;
	
	@ManyToOne
	private Schooling schooling;

	@ManyToOne
	private Function function;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public User getUser() {
		if(user == null){
			this.user = new User();
		}
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Department getDepartment() {
		if(department == null){
			this.department = new Department();
		}
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Schooling getSchooling() {
		if(schooling == null){
			this.schooling = new Schooling();
		}
		return schooling;
	}

	public void setSchooling(Schooling schooling) {
		this.schooling = schooling;
	}

	public Function getFunction() {
		if(function == null){
			this.function = new Function();
		}
		return function;
	}

	public void setFunction(Function function) {
		this.function = function;
	}
	
	
}

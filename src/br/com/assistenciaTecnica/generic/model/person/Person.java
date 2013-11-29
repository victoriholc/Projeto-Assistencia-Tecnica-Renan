package br.com.assistenciaTecnica.generic.model.person;

import java.util.Calendar;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

import br.com.assistenciaTecnica.generic.model.person.address.Address;
import br.com.assistenciaTecnica.generic.model.person.phone.Phone;

@MappedSuperclass
public class Person {
	@Column(nullable=false)
	protected String name;
	
	@Enumerated(EnumType.STRING)
	protected typePerson typePerson;
	
	@Column(nullable=false)
	protected String numberDocument;
	
	@Temporal(TemporalType.DATE)
	protected Calendar birthDate;
	
	protected Address address;
	
	protected String email;
	
	@OneToMany
	protected List<Phone> phones;

	@Version
	protected long version;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public typePerson getTypePerson() {
		return typePerson;
	}

	public void setTypePerson(typePerson typePerson) {
		this.typePerson = typePerson;
	}

	public String getNumberDocument() {
		return numberDocument;
	}

	public void setNumberDocument(String numberDocument) {
		this.numberDocument = numberDocument;
	}

	public Calendar getBirthDate() {
		if(birthDate == null){
			birthDate = Calendar.getInstance();
		}
		return birthDate;
	}

	public void setBirthDate(Calendar birthDate) {
		this.birthDate = birthDate;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Phone> getPhones() {
		return phones;
	}

	public void setPhones(List<Phone> phones) {
		this.phones = phones;
	}

	public long getVersion() {
		return version;
	}

	public void setVersion(long version) {
		this.version = version;
	}
	
	
}

package br.com.assistenciaTecnica.cadastral.managedBeans.client;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import br.com.assistenciaTecnica.cadastral.model.client.Client;
import br.com.assistenciaTecnica.organization.Facade;
import br.com.assistenciaTecnica.cadastral.exception.client.ClientAlreadyExistsException;

@ManagedBean
public class ClientBean 
{
	private String searchField = "";
	private Client client = new Client();
	private List<Client> listClient = new ArrayList<Client>();

	// gets and sets
	public Client getClient() {
		return this.client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public List<Client> getListClient() {
		if (searchField != null && !searchField.isEmpty()) {
				this.listClient = Facade.getInstace()
						.findBySimilarNameClient(searchField);
		}
		if (this.listClient.isEmpty()) {
			seeAll();
		}
		return listClient;
	}

	public String getSearchField() {
		return searchField;
	}

	public void setSearchField(String searchField) {
		this.searchField = searchField;
	}

	// metodos de mudanca
	public String insert() {
		try {

			Facade.getInstace().insertClient(this.client);
			FacesMessage msg = new FacesMessage(
					"Departamento Salvo com sucesso!");
			FacesContext.getCurrentInstance().addMessage(null, msg);
			seeAll();
			
			if(client.getId() != 0){
				return view();
			}else{
				this.client = new Client();
			}

		} catch (ClientAlreadyExistsException e) {
			e.printStackTrace();

			FacesMessage msg = new FacesMessage(e.getMessage());
			FacesContext.getCurrentInstance().addMessage(null, msg);

		} catch (Exception e) {

			e.printStackTrace();
			FacesMessage msg = new FacesMessage(e.getMessage());
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}
		return "client";
	}

	public void remove(Client client) {
		Facade.getInstace().removeClient(client);
		seeAll();
	}

	// metodos de busca
	public void seeAll() {
			this.listClient = Facade.getInstace().seeAllClient();
	}

	public String findBySimilarName() {
			this.listClient = Facade.getInstace()
					.findBySimilarNameClient(searchField);
			
		return "/organization/client/view_client.xhtml";
	}

	// metodos de redirecionamento
	public String newClient() {
		return "client.xhtml?faces-redirect=true";
	}

	public String view() {

		return "/organization/client/view_client.xhtml?faces-redirect=true";
	}

	public String loadClient(Client client) {
		this.client = client;
		return "client.xhtml";
	}

}

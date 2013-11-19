package br.com.assistenciaTecnica.cadastral.managedBeans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import br.com.assistenciaTecnica.cadastral.Facade;
import br.com.assistenciaTecnica.cadastral.exception.ServiceAlreadyExistsException;
import br.com.assistenciaTecnica.cadastral.model.Service;

@ManagedBean
public class ServiceBean {
	private String searchField = "";
	private Service service = new Service();
	private List<Service> listService = new ArrayList<Service>();
	
	public String getSearchField() {
		return searchField;
	}
	
	public void setSearchField(String searchField) {
		this.searchField = searchField;
	}
	
	public Service getService() {
		return service;
	}
	
	public void setService(Service service) {
		this.service = service;
	}
	
	public List<Service> getListService() {
		if (searchField != null && !searchField.isEmpty()) {
			this.listService = Facade.getInstace()
					.findBySimilarNameService(searchField);
		}
		if (this.listService.isEmpty()) {
			seeAll();
		}
		return listService;
	}
	
	public void setListService(List<Service> listService) {
		this.listService = listService;
	}
	
	// metodos de mudanca
		public String insert() {
			try {

				Facade.getInstace().insertService(this.service);
				FacesMessage msg = new FacesMessage(
						"Servico Salvo com sucesso!");
				FacesContext.getCurrentInstance().addMessage(null, msg);
				seeAll();
				
				if(service.getId() != 0){
					return view();
				}else{
					this.service = new Service();
				}

			} catch (ServiceAlreadyExistsException e) {
				e.printStackTrace();

				FacesMessage msg = new FacesMessage(e.getMessage());
				FacesContext.getCurrentInstance().addMessage(null, msg);

			} catch (Exception e) {

				e.printStackTrace();
				FacesMessage msg = new FacesMessage(e.getMessage());
				FacesContext.getCurrentInstance().addMessage(null, msg);
			}
			return "service";
		}

		public void remove(Service service) {
			Facade.getInstace().removeService(service);
			seeAll();
		}
	// metodos de busca
		public void seeAll() {
				this.listService = Facade.getInstace().seeAllService();
		}

		public String findBySimilarName() {
				this.listService = Facade.getInstace()
						.findBySimilarNameService(searchField);
				
			return "/cadastral/service/view_service.xhtml";
		}
	
		
	// metodos de redirecionamento
		public String newService() {
			return "service.xhtml?faces-redirect=true";
		}

		public String view() {

			return "/cadastral/service/view_service.xhtml?faces-redirect=true";
		}

		public String loadService(Service service) {
			this.service = service;
			return "service.xhtml";
		}
}

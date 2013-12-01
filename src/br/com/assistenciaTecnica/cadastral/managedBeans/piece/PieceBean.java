package br.com.assistenciaTecnica.cadastral.managedBeans.piece;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import br.com.assistenciaTecnica.cadastral.Facade;
import br.com.assistenciaTecnica.cadastral.exception.NoSearchResultException;
import br.com.assistenciaTecnica.cadastral.exception.piece.PieceAlreadyExistsException;
import br.com.assistenciaTecnica.cadastral.model.Piece;

@ManagedBean
public class PieceBean {
	private Piece piece = new Piece();
	private List<Piece> listPiece = new ArrayList<Piece>();
	private String searchField;
	
	
	public String insertPiece(){
		try{
			Facade.getInstace().insertPiece(piece);
			System.out.println("Salvo com Sucesso");
			if(piece.getId() != 0){
				viewPiece();
			}else{
				Facade.getInstace().updatePiece(piece);
			}
		}catch(PieceAlreadyExistsException e){
			FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("Piece Already Exists" + this.piece.getName()));
			e.getMessage();
		}
		return viewPiece();
	}
	
	public void removePiece(Piece piece){
		try{ 
			Facade.getInstace().removerPiece(piece);
		}catch(Exception e){
			FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("Piece can not be removed" + this.piece.getName()));
			e.getMessage();
			System.out.println("Produto nao pode ser removido");
		}
	}
	
	public void seeAllProduct() throws NoSearchResultException{
		this.listPiece = Facade.getInstace().seeAllPiece();
	}

	public Piece getPiece() {
		return piece;
	}

	public void setPiece(Piece piece) {
		this.piece = piece;
	}

	public List<Piece> getListPiece() {
		return listPiece;
	}

	public void setListPiece(List<Piece> listPiece) {
		this.listPiece = listPiece;
	}

	public String getSearchField() {
		return searchField;
	}

	public void setSearchField(String searchField) {
		this.searchField = searchField;
	}
	
	public String viewPiece(){
		return "/cadastral/piece/view.xhtml?faces-redirect=true";
	}
}

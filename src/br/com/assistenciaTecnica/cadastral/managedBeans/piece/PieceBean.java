package br.com.assistenciaTecnica.cadastral.managedBeans.piece;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import br.com.assistenciaTecnica.cadastral.Facade;
import br.com.assistenciaTecnica.cadastral.exception.piece.PieceAlreadyExistsException;
import br.com.assistenciaTecnica.cadastral.model.Piece;
@ManagedBean
public class PieceBean {
	private Piece piece;
	private List<Piece> listPiece;
	private String searchField;
	
	public PieceBean(Piece piece, List<Piece> listPiece, String searchField) {
		super();
		this.piece = piece;
		this.listPiece = new ArrayList<Piece>();
		this.searchField = searchField;
	}
	
	public void insertPiece(Piece piece){
		try{
			if(piece.getId() == 0){
				Facade.getInstace().insertPiece(piece);
			}else{
				Facade.getInstace().updatePiece(piece);
			}
		}catch(PieceAlreadyExistsException e){
			FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("Piece Already Exists" + this.piece.getName()));
			e.getMessage();
		}
	}
	
	public void removePiece(Piece piece){
		try{ 
			Facade.getInstace().removerPiece(piece);
		}catch(Exception e){
			FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("Piece can not be removed" + this.piece.getName()));
			e.getMessage();
			System.out.println("Produto n�o pode ser removido");
		}
	}
	
	public void seeAllProduct(){
		try{
			if(this.searchField != null && !searchField.isEmpty()){
				this.listPiece = Facade.getInstace().seeAllPiece();
			}
		}catch(Exception e){
			e.getMessage();
		}	
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
	
}

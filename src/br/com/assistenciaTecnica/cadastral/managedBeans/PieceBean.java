package br.com.assistenciaTecnica.cadastral.managedBeans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import br.com.assistenciaTecnica.cadastral.Facade;
import br.com.assistenciaTecnica.cadastral.exception.AlreadyExisteException;
import br.com.assistenciaTecnica.cadastral.model.Piece;

@ManagedBean
public class PieceBean {
	private Piece piece;
	private List<Piece> listPiece;
	private String searchField;
	private int selectedObject;
	
	public PieceBean() {
	}
	
	public String insertPiece(){
		try{
			Facade.getInstace().insertPiece(piece);
			if(piece.getId() != 0){
				
				return "/cadastral/piece/view_piece.xhtml";
			}else{
				this.piece = new Piece();
			}
		}catch(AlreadyExisteException e){
			FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("Piece Already Exists" + this.piece.getName()));
			e.getMessage();
		}
		return "/cadastral/piece/save_piece.xhtml";
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
	
	public String updateProduct(Piece param){
		this.piece = param;
		this.selectedObject = param.getId();
		return "/cadastral/peca/save_peca.xhtml";
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
		if(piece==null){
			this.piece =  new Piece();
		}
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
	
	public int getSelectedObject() {
		return selectedObject;
	}

	public void setSelectedObject(int selectedObject) {
		this.selectedObject = selectedObject;
	}

}

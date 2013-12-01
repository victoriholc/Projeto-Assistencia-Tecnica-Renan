package br.com.assistenciaTecnica.cadastral.bo.piece;

import java.util.ArrayList;
import java.util.List;

import br.com.assistenciaTecnica.cadastral.dao.piece.IPieceDAO;
import br.com.assistenciaTecnica.cadastral.dao.piece.PieceDAO;
import br.com.assistenciaTecnica.cadastral.exception.NoSearchResultException;
import br.com.assistenciaTecnica.cadastral.exception.piece.PieceAlreadyExistsException;
import br.com.assistenciaTecnica.cadastral.model.Piece;

	
public class PieceBO implements IPieceBO{
	private IPieceDAO pieceBO = new PieceDAO();
	private List<Piece> listPiece = new ArrayList<Piece>();

	@Override
	public void insertPiece(Piece piece) throws PieceAlreadyExistsException{
			this.pieceBO.insert(piece);		
	}

	@Override
	public void removePiece(Piece piece) {
		try{
			this.pieceBO.remove(piece);
		}catch(Exception e){
			e.printStackTrace();
		}
			
	}

	@Override
	public void updatePiece(Piece piece){
		this.pieceBO.refresh(piece);
	}

	@Override
	public List<Piece> seeAllPeice() throws NoSearchResultException {
		listPiece = pieceBO.seeAll();
		return listPiece;
	}
}

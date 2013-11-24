package br.com.assistenciaTecnica.cadastral.bo;

import java.util.List;

import br.com.assistenciaTecnica.cadastral.dao.IPieceDAO;
import br.com.assistenciaTecnica.cadastral.dao.PieceDAO;
import br.com.assistenciaTecnica.cadastral.exception.AlreadyExisteException;
import br.com.assistenciaTecnica.cadastral.exception.NoSearchResultException;
import br.com.assistenciaTecnica.cadastral.model.Piece;

	
public class PieceBO implements IPieceBO{
	private IPieceDAO piece = new PieceDAO();

	@Override
	public void insertPiece(Piece piece) throws AlreadyExisteException{
			this.piece.insert(piece);		
	}

	@Override
	public void removePiece(Piece piece) {
		try{
			this.piece.remove(piece);
		}catch(Exception e){
			e.printStackTrace();
		}
			
	}

	@Override
	public void updatePiece(Piece piece){
		this.piece.refresh(piece);
	}

	@Override
	public List<Piece> seeAllPeice() throws NoSearchResultException {
		return piece.seeAll();
	}
}

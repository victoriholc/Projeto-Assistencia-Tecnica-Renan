package br.com.assistenciaTecnica.cadastral.bo;

import java.util.List;

import br.com.assistenciaTecnica.cadastral.exception.AlreadyExisteException;
import br.com.assistenciaTecnica.cadastral.exception.NoSearchResultException;
import br.com.assistenciaTecnica.cadastral.model.Piece;

public interface IPieceBO {
	public void insertPiece(Piece piece) throws AlreadyExisteException;
	public void removePiece(Piece piece);
	public void updatePiece(Piece piece);
	public List<Piece> seeAllPeice()throws NoSearchResultException ;
	
}

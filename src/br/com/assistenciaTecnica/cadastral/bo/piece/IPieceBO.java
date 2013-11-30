package br.com.assistenciaTecnica.cadastral.bo.piece;

import java.util.List;

import br.com.assistenciaTecnica.cadastral.exception.NoSearchResultException;
import br.com.assistenciaTecnica.cadastral.exception.piece.PieceAlreadyExistsException;
import br.com.assistenciaTecnica.cadastral.model.Piece;

public interface IPieceBO {
	public void insertPiece(Piece piece) throws PieceAlreadyExistsException;
	public void removePiece(Piece piece);
	public void updatePiece(Piece piece);
	public List<Piece> seeAllPeice()throws NoSearchResultException ;
	
}

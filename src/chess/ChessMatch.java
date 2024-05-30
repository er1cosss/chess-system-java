package chess;

import boardgame.Board;
import boardgame.Position;
import chess.pieces.King;
import chess.pieces.Rook;

public class ChessMatch {
	
	private Board board;
	
	//informando que o tabuleiro vai ser de 8x8
	public ChessMatch() {
		board = new Board(8, 8);
		initialSetup();
	}
	
	//metodo para pegar matriz das peças de xadrez
	public ChessPiece[][] getPieces(){
		
		//instanciando a matriz
		ChessPiece[][] mat = new ChessPiece[board.getRows()][board.getColumns()];
		
		//percorrendo as linhas = i | percorrendo as colunas = j | adicionando a matriz
		for(int i = 0;i<board.getRows();i++) {
			for(int j = 0;j<board.getColumns();j++) {
				//downcasting pra diferenciar a ''ChessPiece'' da ''Piece'' ChessPiece diferente de Piece
				mat[i][j] = (ChessPiece) board.piece(i,j);
			}
		}
		return mat;
	}
	
	private void placeNewPiece(char column, int row, ChessPiece piece) {
		board.placePiece(piece, new ChessPosition(column,row).toPosition());
	}
	
	private void initialSetup() {
		placeNewPiece('b', 6, new Rook(board,Color.WHITE));
		placeNewPiece('e', 8, new King(board, Color.BLACK));
		placeNewPiece('e', 1, new King(board, Color.WHITE));
	}
	
	}
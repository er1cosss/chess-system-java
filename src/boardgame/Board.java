package boardgame;

public class Board {
	
	private int rows;
	private int columns;
	private Piece[][] pieces;
	
	/*public Board(int rows, int columns) {
		
		this.rows = rows;
		this.columns = columns;
		pieces = new Piece[rows][columns];
	}*/
	
	//construtor com programação defensiva: não faz sentido instanciar o tabuleiro com o numero de linhas e colunas negativas < 1
	public Board(int rows, int columns) {
		if(rows< 1 || columns < 1) {
			throw new BoardException("Error creating board: There must be at least 1 row and 1 column");
		}
		this.rows = rows;
		this.columns = columns;
		pieces = new Piece[rows][columns];
	}
	
//programação defensiva nos setts: não faz sentido mecher no número de linhas e colunas apos a instanciação do tabuleiro
	public int getRows() {
		
		return rows;
	}

	/*public void setRows(int rows) {
		this.rows = rows;
	}
	*/
	
	public int getColumns() {
		
		return columns;
	}

	/*public void setColumns(int columns) {
		this.columns = columns;
	}
	*/
	
	public Piece piece (int row, int column) {
		
		if(!positionExists(row,column)) {
			throw new BoardException("Position not on the board");
		}
		
		return pieces [row][column];
	} 
	
	public Piece piece (Position position) {
		
		if(!positionExists(position)) {
			
			throw new BoardException("Position not on the board");
		}
		return pieces[position.getRow()][position.getColumn()];
	}
	//metodo para colocar uma peça em determinada posição
	public void placePiece (Piece piece, Position position) {
		if(thereIsAPiece(position)) {
			throw new BoardException("There is already a piece on position" + position);
		}
		pieces[position.getRow()][position.getColumn()] = piece;
		piece.position = position;
	}
	
	//metodos para conferir se a posição existe
	public boolean positionExists(int row,int column) {
		
		return row >= 0 && row<rows && column >=0 && column < columns;
	}

	public boolean positionExists(Position position) {
		
		return positionExists(position.getRow(),position.getColumn());
	}
	
	//metodo para saber se existe uma peça em determinada posição
	public boolean thereIsAPiece (Position position) {
		
		if(!positionExists(position)) {
			throw new BoardException("Position not on the board");
		}
		
		return piece(position) != null;
	}
}

package tetris_game;




public class Filed {
	private int width;
	private int height;
	private Cell[][] field;
	//定义宽高
	public Filed( int height,int width) {
		this.width = width;
		this.height = height;
		field = new Cell[height][width];
	}
	
	public int getWidth() { return width; }
	public int getHeight() { return height; }
	//放置方块
	public Cell place(int row, int col, Cell o) {
		Cell ret = field[row][col];
		o.isalive = false;
		field[row][col] = o;
		return ret;
	}
	
	public Cell get(int row, int col) {
		return field[row][col];
	}
	
	
	
	public void clear() {
		for ( int i=0; i<height; i++ ) {
			for ( int j=0; j<width; j++ ) {
				field[i][j] = null;
			}
		}
	}
}

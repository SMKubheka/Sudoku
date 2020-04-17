
public class Sudoku {
	public static int[][] GRID_TO_SOLVE ={
			{8,0,0,0,0,0,0,0,0},
			{0,0,3,6,0,0,0,0,0},
			{0,7,0,0,9,0,2,0,0},
			{0,5,0,0,0,7,0,0,0},
			{0,0,0,0,4,5,7,0,0},
			{0,0,0,1,0,0,0,3,0},
			{0,0,1,0,0,0,0,6,8},
			{0,0,8,5,0,0,0,1,0},
			{0,9,0,0,0,0,4,0,0},
	};
		
	private int[][] board;
	public static final int SIZE = 9;
	public static final int EMPTY = 0;
		
	public Sudoku(int[][] board) {
		this.board = new int[SIZE][SIZE];
			
		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				this.board[i][j] = board[i][j];
			}
		}
	}
		
		
	public boolean possible(int y, int x, int number) {
			
			//we check the column
		for (int i = 0; i < SIZE; i++) {
			if (board[i][x] == number) {
				return false;
			}
		}
			
			// we check the row
		for (int i = 0; i < SIZE; i++) {
			if (board[y][i] == number) {
				return false;				}
			}
			
			//we check block 
		int x0 = (x/3)*3;
		int y0 = (y/3)*3;
			
		for (int i = y0; i < y0+3; i++) {
			for (int j = x0; j<x0+3; j++) {
				if (board[i][j] == number) {
					return false;
				}
			}
		}
			
		return true;
	}
		
	public boolean solver(){
		for (int y = 0; y < SIZE; y++) {
			for (int x = 0; x < SIZE; x++) {
				if (board[y][x] == EMPTY){
					for (int n = 0; n < 10; n++) {
						if (possible(y,x,n)) {
							board[y][x] = n;
								
							if (solver()) { // we start backtracking recursively
								return true;
							}
							else { // if not a solution, we empty the cell and we continue 
								board[y][x] = EMPTY;
							}
						}
					}
					return false;
				}
			}
		}
			
		return true; // sudoku solved
			
	}
	
	public void display() {
		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				System.out.print(" " + board[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}
		
	public static void main(String[] args) {
		Sudoku sudoku = new Sudoku(GRID_TO_SOLVE);
		System.out.println("Sudoku grid to solve: ");
		sudoku.display();
			
		if (sudoku.solver()) {
			System.out.println("Sudoku Grid Solved");
			sudoku.display();
		}
		else {
			System.out.println("Unsolvable");
		}
	}
}

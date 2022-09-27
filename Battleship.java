public class Battleship {
	private String[][] board;
	private String ship;
	private int hits;
	private String name;
	private String[][] map;
	private boolean end;
	private int placedShips;

	public Battleship(String n) {
		board = new String[5][5];
		map = new String[5][5];
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				board[i][j] = ("[ ]");
				map[i][j] = ("[ ]");
			}
		}
		name = n;
		hits = 5;
		end = false;
		placedShips = 0;
	}
	public void shoot(int row, int col) {
		
		if (map[row-1][col-1].equals("[S]") && board[row-1][col-1] != "[H]") { 
			board[row-1][col-1] = "[H]";
			System.out.println("You hit a ship!");
			map[row-1][col-1] = "[ ]";
		} else if (board[row-1][col-1].equals("[ ]")) {
			board[row-1][col-1] = "[*]";
			System.out.println("You missed!");
		}
		else {
			System.out.println("Please hit a valid space");
		}
	}
	public void showBoard() {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				System.out.print(board[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}
	public void showMap() {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}
	public String isWinner() {
		int count = 0;
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				if (map[i][j].equals("[S]")) {
					count++;
				}
			}
		}
		if (count == 0) {
			end = true;
			return (getName() + " loses!");
		}
		count = 0;
		return "";
	}
	public int getHits() {
		return hits;
	}
	public String getName() {
		return name;
	}
	public void inputShip(int row, int col) {
		if (map[row-1][col-1].equals("[ ]")) {
			map[row-1][col-1] = ("[S]");
			placedShips++;
		} else {
			System.out.println("Please enter a valid space!");
		}
	}
	public boolean getEnd() {
		return end;
	}
	public String[][] getMap() {
		return map;
	}
	public int getPlacedShips() {
		return placedShips;
	}
}
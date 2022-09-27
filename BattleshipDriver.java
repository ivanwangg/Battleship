import java.util.Scanner;
public class BattleshipDriver {
	public static void main(String[] args) {
		String p1;
		String p2;
		Scanner input = new Scanner(System.in);
		int row;
		int col;
		int count1 = 0;
		int count2 = 0;
		boolean end = false;

		System.out.print("Please enter player 1's name: ");
		p1 = input.next();
		System.out.print("Please enter player 2's name: ");
		p2 = input.next();

		Battleship b1 = new Battleship(p1);
		Battleship b2 = new Battleship(p2);

		System.out.println("Let the game begin");

		System.out.println(b1.getName() + ", enter your ships: ");
		while(count1 < 5) {
		System.out.print("Input the row you want your ship: ");
		row = input.nextInt();
		System.out.print("Input the col you want your ship: ");
		col = input.nextInt();
		b1.inputShip(row, col);
		if (b1.getPlacedShips() == count1 + 1) {
			count1++;
		}
		b1.showMap();
		} 

		System.out.println(b2.getName() + ", enter your ships: ");
		while(count2 < 5) {
		System.out.print("Input the row you want your ship: ");
		row = input.nextInt();
		System.out.print("Input the col you want your ship: ");
		col = input.nextInt();
		b2.inputShip(row, col);
		if (b2.getPlacedShips() == count2 + 1) {
			count2++;
		}
		b2.showMap();
		} 

		while (!b1.getEnd() && !b2.getEnd()) {

			System.out.println(b1.getName() + "'s turn");
			System.out.print("Input the row you want to shoot: ");
			row = input.nextInt();
			System.out.print("Input the col you want to shoot: ");
			col = input.nextInt();
			b2.shoot(row, col);
			System.out.println(b2.getName() + "'s board: ");
			b2.showBoard();

			System.out.println(b2.getName() + "'s turn");
			System.out.print("Input the row you want to shoot: ");
			row = input.nextInt();
			System.out.print("Input the col you want to shoot: ");
			col = input.nextInt();
			b1.shoot(row, col);
			System.out.println(b1.getName() + "'s board: ");
			b1.showBoard();
	
			System.out.println(b2.isWinner());
			System.out.println(b1.isWinner());
		}
	}
}
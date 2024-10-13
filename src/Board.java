import java.util.Scanner;

public class Board {
	static Scanner scan = new Scanner(System.in);
	static char board[][] = new char[3][3];
	static Player player = new Player();

	public static void main(String[] args) {

		startGame();
		setBoard();
		renderBoard();
		player.play();
	}

	private static void startGame() {
		System.out.println("==========================");
		System.out.println("       TIC TAC TOE         ");
		System.out.println("==========================");
		player.inputPlayerNames();

	}

	public static void setBoard() {
		System.out.println("\nThe boxes are numbered as below:");
		System.out.println("Fill your box by entering its number");
		board = new char[][] { { '1', '2', '3' }, { '4', '5', '6' }, { '7', '8', '9' } };

	}

	public static void renderBoard() {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				System.out.print("[" + board[i][j] + "]  ");
			}
			System.out.println();
			System.out.println();
		}
	}
}

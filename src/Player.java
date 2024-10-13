import java.util.Scanner;

public class Player extends Board {
	static Scanner scan = new Scanner(System.in);

	int takenBoxes[] = new int[9];
	int takenBoxesCounter = 0;
	int boxNum;

	String playerOneName;
	String playerTwoName;

	public void play() {
		for (int i = 0; i <= 8; i++) {
			playerOne();
			playerTwo();
		}
	}

	private void playerOne() {
		playerInstructions(playerOneName);
		inputBoxNum();
		fillBox('X');
		checkResult('X', playerOneName);
		renderBoard();

	}

	private void playerTwo() {
		playerInstructions(playerTwoName);
		inputBoxNum();
		fillBox('O');
		checkResult('O', playerTwoName);
		renderBoard();
	}

	private void playerInstructions(String playerName) {
		System.out.println(playerName + "'s turn");
	}

	private void inputBoxNum() {
		boxNum = scan.nextInt();
		for (int i = 0; i < takenBoxes.length; i++) {
			if (takenBoxes[i] == boxNum) {
				System.out.println("The box No. " + boxNum + " is already taken!");
				System.out.println("Choose another box");
				inputBoxNum();
			}
		}

	}

	private void fillBox(char XorO) {
		int key = boxNum;
		switch (key) {
		case 1: {
			board[0][0] = XorO;
			break;
		}
		case 2: {
			board[0][1] = XorO;
			break;
		}
		case 3: {
			board[0][2] = XorO;
			break;
		}
		case 4: {
			board[1][0] = XorO;
			break;
		}
		case 5: {
			board[1][1] = XorO;
			break;
		}
		case 6: {
			board[1][2] = XorO;
			break;
		}
		case 7: {
			board[2][0] = XorO;
			break;
		}
		case 8: {
			board[2][1] = XorO;
			break;
		}
		case 9: {
			board[2][2] = XorO;
			break;
		}
		default:
			System.out.println("Invalid box number! try again");
		}

		takenBoxes[takenBoxesCounter] = boxNum;
		takenBoxesCounter++;

	}

	private void checkResult(char XorO, String playerName) {
		boolean winner = false;

		// rows
		if (board[0][0] == XorO && board[0][1] == XorO && board[0][2] == XorO) {
			winner = true;
		} else if (board[1][0] == XorO && board[1][1] == XorO && board[1][2] == XorO) {
			winner = true;
		} else if (board[2][0] == XorO && board[2][1] == XorO && board[2][2] == XorO) {
			winner = true;

			// colms
		} else if (board[0][0] == XorO && board[1][0] == XorO && board[2][0] == XorO) {
			winner = true;
		} else if (board[0][1] == XorO && board[1][1] == XorO && board[2][1] == XorO) {
			winner = true;
		} else if (board[0][2] == XorO && board[1][2] == XorO && board[2][2] == XorO) {
			winner = true;
		}

		// cross
		else if (board[0][0] == XorO && board[1][1] == XorO && board[2][2] == XorO) {
			winner = true;
		} else if (board[2][0] == XorO && board[1][1] == XorO && board[0][2] == XorO) {
			winner = true;
		}

		if (winner == true) {
			printResult(playerName);
			renderBoard();
			System.exit(0);
		}

		isTie();

	}

	private void isTie() {
		boolean isTie = false;

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (board[i][j] == '1' || board[i][j] == '2' || board[i][j] == '3' || board[i][j] == '4'
						|| board[i][j] == '5' || board[i][j] == '6' || board[i][j] == '7' || board[i][j] == '8'
						|| board[i][j] == '9') {
					isTie = false;
					break;
				} else
					isTie = true;
			}
			if (isTie == false)
				break;
		}
		if (isTie) {
			printResult();
			renderBoard();
			System.exit(0);
		}

	}

	private void printResult(String playerName) {
		System.out.println("**** " + playerName + " is the winner *****");
	}

	private void printResult() {
		System.out.println("**** It's a tie *****");
	}

	public void inputPlayerNames() {
		while (true) {
			System.out.println("Choose X or O: ");
			char key = scan.next().toLowerCase().charAt(0);
			switch (key) {
			case 'x': {
				System.out.println("Enter player X name: ");
				playerOneName = scan.next();
				System.out.println("Enter player O name: ");
				playerTwoName = scan.next();
				break;
			}
			case 'o': {
				System.out.println("Enter player O name: ");
				playerTwoName = scan.next();
				System.out.println("Enter player X name: ");
				playerOneName = scan.next();
				break;
			}

			default:
				System.out.println("Invalid choice! Try again");
				break;
			}

			if (key == 'x' || key == 'o') {
				break;
			}
		}
	}

}

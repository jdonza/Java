import java.util.Scanner;
import java.util.Arrays;
import java.util.*;

public class Battleship{

	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		char[][] p1 = new char [5][5];
		char[][] p2 = new char [5][5];
		char[][] fieldOne = new char[5][5];
		char[][] fieldTwo = new char[5][5];
		createBoard(p1);
		createBoard(p2);
		userinputMethod(p1, 1, input);
		userinputMethod(p2, 2, input);
		createBoard(fieldOne);
		createBoard(fieldTwo);
		int count = 1;
		do {
			if (count % 2 == 0){
				if (attack(p1, fieldOne, 2, input) != 0){
					count++;
				}
			}
			else {
				if (attack(p2, fieldTwo, 1, input) != 0){
					count++;
				}
			}
		} while ((charSearch(p1, '@') == 1) && (charSearch(p2, '@') == 1));

		if (charSearch(p1,'@') == 0){
			System.out.printf("PLAYER 2 WINS! YOU SUNK ALL OF YOUR OPPONENT’S SHIPS!\n");	
		}
		else if (charSearch(p2,'@') == 0){
			System.out.printf("PLAYER 1 WINS! YOU SUNK ALL OF YOUR OPPONENT’S SHIPS!\n");
		}
		System.out.printf("\nFinal boards: \n");
		System.out.println();
		printBattleShip(p1);
		printBattleShip(p2);	
	}		
	
	private static int attack(char[][] player, char[][] field, int num, Scanner input){

		System.out.printf("Player %d, enter hit row/column:\n",num);
		String[] current = input.nextLine().split(" ");
		int row = Integer.parseInt(current[0]);
		int col = Integer.parseInt(current[1]);
		if (row < 0 || row >= 5 || col < 0 || col >= 5){
			System.out.printf("Invalid coordinates. Choose different coordinates.\n");
			return(0);
		} 
		else if (player[row][col] == '@'){
			if (num == 1){
				System.out.printf("PLAYER 1 HIT PLAYER 2’s SHIP!\n");
			}
			else{
				System.out.printf("PLAYER 2 HIT PLAYER 1’s SHIP!\n");
			}
			field[row][col] = 'X';
			player[row][col] = 'X';
			printBattleShip(field);
			return(1);
		} 
		else if (field[row][col] == 'O'){
			System.out.printf("You already fired on this spot. Choose different coordinates.\n");
			return(0);
		}
		else {
			System.out.printf("PLAYER %d MISSED!\n", num);
			field[row][col] = 'O';
			player[row][col] = 'O';
			printBattleShip(field);
			return(1);
		}
	}

	private static void createBoard(char[][] player){
		for (int i = 0; i <= 4; i++){
			for (int j = 0; j <=4; j++){
				player[i][j] = '-';
			}
		}
	}
	
	private static void printBattleShip(char[][] player) {
		System.out.print("  ");
		for (int row = -1; row < 5; row++) {
			if (row > -1) {
				System.out.print(row + " ");
			}
			for (int column = 0; column < 5; column++) {
				if (row == -1) {
					System.out.print(column + " ");
				} else {
					System.out.print(player[row][column] + " ");
				}
			}
			System.out.println("");
		}
		System.out.println();
	}
	
	private static int charSearch(char[][] player, char ch){
		for (int i = 0; i < 5; i++){
			for (int j = 0; j < 5; j++){
				if (player[i][j] == '@'){
					return (1);
				}
			}
		}
		return (0);
	}

	private static void userinputMethod(char[][] player, int num, Scanner input){
		
		if (num == 1){
			System.out.printf("Welcome to Battleship!\n");
			System.out.println();
		}
		
		System.out.printf("PLAYER %d, ENTER YOUR SHIPS' COORDINATES.\n",num);
		for (int i = 1; i <=5; i++){
			System.out.printf("Enter ship %d location:\n",i);
			String[] current = input.nextLine().split(" ");
			int ship_row = Integer.parseInt(current[0]);
			int ship_col = Integer.parseInt(current[1]);
			if (ship_row < 0 || ship_row >= 5 || ship_col < 0 || ship_col >= 5){
				System.out.printf("Invalid coordinates. Choose different coordinates.\n");
				i--;
			}
			else if (player[ship_row][ship_col] == '@'){
				System.out.printf("You already have a ship there. Choose different coordinates.\n");
				i--;
			}
			else{
				player[ship_row][ship_col] = '@';
			}
		}
		printBattleShip(player);
		for (int k = 0; k < 100; k++){
			System.out.println();
		}			
	}
}




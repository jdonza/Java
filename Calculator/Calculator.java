import java.util.Scanner;
import java.util.*;

public class Calculator{
	public static void main(String[] args){
		
		// Creates and object of Scanner
		Scanner input = new Scanner(System.in);
		
		System.out.println("List of operations: add subtract multiply divide alphabetize");
		System.out.println("Enter an operation:");

		// Takes input from user
		String operation = input.nextLine().toLowerCase();
		

		// Check if input from user is a valid operation
		String[] operation_array = {"add", "subtract", "multiply", "divide", "alphabetize"};
		List operation_list = Arrays.asList(operation_array);
		Boolean bool_condition = operation_list.contains(operation);
		if (bool_condition == true){
			// Set up switch case 
			switch (operation){
				case "add":
					System.out.println("Enter two integers:");
					String add_1 = input.next();
					String add_2 = input.next();
					try{
						Integer.parseInt(add_1);
						Integer.parseInt(add_2);
						int add_answer = Integer.parseInt(add_1) + Integer.parseInt(add_2);	
						System.out.println("Answer:" + add_answer);
						break;
					}
					catch (NumberFormatException ex){
						System.out.println("Invalid input entered. Terminating...");
						break;	
					}
				case "subtract":
					System.out.println("Enter two integers:");
					String subtract_1 = input.next();
					String subtract_2 = input.next();
					try{
						Integer.parseInt(subtract_1);
						Integer.parseInt(subtract_2);
						int subtract_answer = Integer.parseInt(subtract_1) - Integer.parseInt(subtract_2);	
						System.out.println("Answer:" + subtract_answer);
						break;
					}
					catch (NumberFormatException ex){
						System.out.println("Invalid input entered. Terminating...");
						break;	
					}
				case "multiply":
					System.out.println("Enter two doubles:");
					String multiply_1 = input.next();
					String multiply_2 = input.next();
					try{
						Double.parseDouble(multiply_1);
						Double.parseDouble(multiply_2);
						Double multiply_answer = Double.parseDouble(multiply_1) * Double.parseDouble(multiply_2);	
						System.out.printf("Answer: %.2f\n", multiply_answer);
						break;
					}
					catch (NumberFormatException ex){
						System.out.println("Invalid input entered. Terminating...");
						break;	
					}
				case "divide":
					System.out.println("Enter two doubles:");
					String divide_1 = input.next();
					String divide_2 = input.next();
					try{
						Double.parseDouble(divide_1);
						Double.parseDouble(divide_2);
						if (Double.parseDouble(divide_2) == 0){
							System.out.println("Invalid input entered. Terminating...");
							break;
						}
						else{
							Double divide_answer = Double.parseDouble(divide_1) / Double.parseDouble(divide_2);
							System.out.printf("Answer: %.2f\n", divide_answer);
							break;
						}
					}
					catch (NumberFormatException ex){
						System.out.println("Invalid input entered. Terminating...");
						break;
					}				
				case "alphabetize":
					System.out.println("Enter two words:");
					String Word_1 = input.next();
					String Word_2 = input.next();
					try{
						Double.parseDouble(Word_1);
						Double.parseDouble(Word_2);
						System.out.println("Invalid input entered. Terminating...");	
					}
					catch (NumberFormatException ex){
						String word_1 = Word_1.toLowerCase();
						String word_2 = Word_2.toLowerCase();
						int word_answer = word_1.compareTo(word_2);
						if (word_answer < 0){
							System.out.printf("Answer: %s comes before %s alphabetically.",Word_1,Word_2);
							break;
						}
						else if (word_answer > 0){
							System.out.printf("Answer: %s comes before %s alphabetically.",Word_2,Word_1);
							break;
						}
						else if (word_answer == 0){
							System.out.println("Answer: Both words are the same.");
							break;
						}
						break;
					}
			}
		}
		else {
		System.out.println("Invalid input entered. Terminating...");
		}
	}
}
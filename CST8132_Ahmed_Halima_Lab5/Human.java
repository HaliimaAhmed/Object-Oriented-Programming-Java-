package rps;

import java.util.Scanner;
/* 
 * Name: Halima Ahmed
 * Student ID:040825884
 * Course & Section: CST8132_302
 * Assignment: Lab 5
 * Date: October 26, 2018  
 */

public class Human extends Player {

	public Scanner in;
	
	public Human(Scanner in) {
		super(in.next());
		this.in = in;
	}
	 /*** This class uses the takeTurn method from the player class
	  * Prompts the users name and options of the game    
	  * @return true when the game is successful
	  * @return false if there is a Invalid input
	  * @author Halima Ahmed
	  * @version 1.0
	  * @since 1.8
	  */
	
	public boolean takeTurn() {
		// Question:answer: What happens if the Human class does not implement the takeTurn method?
		// Answer: There wont be a game since every player has a turn. The Human class takeTurn method is the user inputs. without it you cant play

		boolean rps = false;

		do {

			System.out.println(name + " it’s your turn (Enter R for Rock, P for Paper, S for Scissors, or Q to quit): ");
			
			/**Converting string to upper case using the String method substring **/
			String string1 = in.next();
			string1 = Character.toUpperCase(string1.charAt(0)) + string1.substring(1);

			

			switch (string1.charAt(0)) {
			case 'Q':
				rps = false;
				/**If user chooses Q the program will end **/
				System.exit(0);
				break;

			case 'S':
			case 'P':
			case 'R':
				/**return value of HandSign **/
				lastMove = HandSign.getHandSign(string1);

				System.out.println(name + " played " + lastMove);
				rps = true;
				break;

			default:
				/**@return false exit **/
				System.out.println(" Invalid input, please try again…");
				rps = false;

				break;
			}
		} while (rps != true);
		/**@Returns true the loop was successful **/
		System.out.println();
		System.out.println("good game!");

		return true;
	}
}
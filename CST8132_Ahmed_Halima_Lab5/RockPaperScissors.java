package rps;

/* 
 * Name: Halima Ahmed
 * Student ID:040825884
 * Course & Section: CST8132_302
 * Assignment: Lab 5
 * Date: October 26, 2018  
 */
public class RockPaperScissors extends Game {

	public RockPaperScissors(int numRounds) {
		
		super(numRounds);

	}
	 /***
	  * Displays the winner, and if there is a tie, also the end of the game.
	  * since there is only two players the value of winner can only be 0 or 1 
	  * @author Halima Ahmed
	  * @version 1.0
	  * @since 1.8
	  */
	
	public void initPlayers() {
		
		System.out.println("Enter player’s name");
		/** Player Human passes scanner, to allow user inputs**/
		/** Player zero is Human **/
		players[0] = new Human(in);
		/** Player one is the computer **/
		players[1] = new Computer();

	}

	public void play() {
		/**for loop to go through the rounds of the game **/
		for (int i = 0; i < super.numRounds; i++) {
			/** Player zero starts if they quite the loop ends **/
			if (!players[0].takeTurn()) {
				break;
			}
			/** Player zero had their turn, so the computers turn **/
			players[1].takeTurn();
			/** invoked evaluateRound method from Playable**/
			evaluateRound();
		}

	}

	public void evaluateRound() {
		
		HandSign[] moves = new HandSign[] { players[0].getLastMove(), players[1].getLastMove() };

		/** Declared winner **/
		int winner = HandSign.getWinner(moves);
		
		/** if the winner equals to -1 then its a tie 
		 * displays tie, and invokes from getTies**/
		if (winner == -1) {
			Player.ties();
			System.out.println("It’s a tie! Ties:  " + Player.getTies());
		} else {
			/** The loser is equal to the Math.abs value **/
			int loser = Math.abs(winner - 1);
			/** index array move  **/
			System.out.println(moves[winner] + " beats " + moves[loser]); 
			
			players[winner].wins();
			

		}
	}

	public void displayResults() {
		/** winner initialized to null **/
		Player winner = null;
		/** both players output by implicitly using its toString method
		 * Override toString
		 *  **/
		System.out.println(players[0]);
		System.out.println(players[1]);

		/** if player zero wins more than 2/2 games they win the game **/
		if (players[0].getWins() > (numRounds / 2)) {
			winner = players[0];
			/** if they dont player one wins the game**/
		} else {
			winner = players[1];
		}
		/** the total number of ties**/
		System.out.println("Total number of ties  " + Player.getTies());
		/** winner was initialized to null, so if winner is null its a tie **/
		if (winner == null) {
			System.out.println("It's a tie game!");
		} else {
			/** if not the winner is a player **/
			System.out.println("The winner is  " + winner.getName() + "!");
		}
		/** End Game **/
		System.out.println("Thanks for playing Rock, Paper, Scissors. Bye!");
	}

	
}

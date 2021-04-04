package rps;
import java.util.Scanner;

/* 
 * Name: Halima Ahmed
 */

public abstract class Game implements Playable{
	
	/**Properties to be inherited by concrete child classes **/
	public int numRounds;
	public static Player[] players;
	public  Scanner in;
	
	 /*** 
	  * This class sets the number of rounds(players) in the game, and Initializing the scanner 
	  * @author Halima Ahmed
	  * @version 1.0
	  * @since 1.8
	  */
	
	/**Setting the number of players in each round  
	 * invoke intPlayers **/
	public Game(int numRounds) {
		
		this.numRounds = numRounds;
		players = new Player[2];
		
		in = new Scanner(System.in);
		
		initPlayers(); 
		
		//Question:How can the Game class invoke the method initPlayers without getting an error, if it has not yet been defined?
		//Answer: the Game class it implemented the interface method initPlayers. We are just using the the elements of the interface. It doesn't need to be defined. 
		
		
	}
}


package rps;
/* 
 * Name: Halima Ahmed
 * Student ID:040825884
 * Course & Section: CST8132_302
 * Assignment: Lab 5
 * Date: October 26, 2018  
 */
public class PlayGame {
	
	/*** Declared and implemented the Java main method */
	
	public static void main(String[] args) {
		
		/***
		  * method main 
		  * Invoked play, and displayResults methods from the interface 
		  * @author Halima Ahmed
		  * @version 1.0
		  * @since 1.8
		  */
		
		Playable games = new RockPaperScissors(3); 
		
		games.play();
		games.displayResults();
		
	}
}

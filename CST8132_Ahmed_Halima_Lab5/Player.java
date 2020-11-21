package rps;
/* 
 * Name: Halima Ahmed
 * Student ID:040825884
 * Course & Section: CST8132_302
 * Assignment: Lab 5
 * Date: October 26, 2018  
 */

public abstract class Player {
	 /**The players name cannot be modified **/
	protected  String name;
	 /**Players last move (R,P,S)  **/
	public HandSign lastMove;
	 /**The number of wins **/
	public  int wins;
	 /**The number of ties(must be static) declared at zero **/
	public static int ties = 0;
	
	/*** The purpose of this class is to define the players in the game, also to be able to inherit all properties and methods of this class 
	  * @param name representing the name value, and the number of wins (0) 
	  * getters return the value 
	  * @author Halima Ahmed
	  * @version 1.0
	  * @since 1.8
	  */
	
	 /**Players name and number of wins set at zero **/
	public Player(String name) {
		
		this.name = name;
		this.wins = 0;
	}
	 /**Getter method that return name **/
	public  String getName() {
		return name;
	}	
	/**Getter method that return lastMove **/
	public HandSign getLastMove() {
		return lastMove;
	}
	/**Getter method that return wins **/
	public int getWins() {
		return wins;
	}
	/**getter method property is static **/
	/**Getter method that return ties **/
	public static int getTies() {
		return ties;
	}
	/**Increments wins by 1  **/
	public void wins() { 
	
		wins = wins + 1;
	}
	/**Increments ties by 1 **/
	public static void ties() {
		
		ties = ties + 1;
	}
	/**@override toString method to return the player concatenated with the number of wins **/
	 public String toString(){ 
	    
		 return (name+ " , "+wins); 
	     
	 }
	 /** Abstract method
	  * @returns boolean value **/	
	 public abstract boolean takeTurn();

}

package rps;
/* 
 * Name: Halima Ahmed
 */
public interface Playable {
	
	/**Integer NUM_PLAYER with the value 2 **/ 
	int NUM_PLAYERS = 2;
	 
	 //Question: What is the access level of this property? Is it a class or instance property?
	//Answer: The access level is implied public. It is an instance property.
	 
	 /*** Declared NUM_PLAYERS and initialize it with a value of 2 
	  * Declared four Public abstract methods 
	  * @author Halima Ahmed
	  * @version 1.0
	  * @since 1.8
	  */
	 
	 /**Public abstract methods **/
	 public void initPlayers();
	 public void play();
	 public void evaluateRound();
	 public void displayResults();
	 
	 // Question: What is the access level of these methods? Are they abstract or concrete?
	// Answer: In an interface they are only 2 types of methods and properties allowed, so access levels are not necessary, but they can be used.  they are abstract methods.

}

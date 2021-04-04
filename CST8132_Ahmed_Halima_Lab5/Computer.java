package rps;

import java.util.Random;

/* 
 * Name: Halima Ahmed
 */
public  class Computer extends Player {
	
	/**Named Computer HAL **/
	public Computer() {
		super("HAL");
	}
	 /*** This class displays the computer's name and lastMove, also using random it displays the computers HandSigns  
	  * @return true statement  
	  * @author Halima Ahmed
	  * @version 1.0
	  * @since 1.8
	  */
	
	/**Computer is set to randomly use the 3 options from HandSign
	 * Prints the name and lastMove to let the user know the computer played
	 * @return true if it was completed successfully  **/	
public boolean takeTurn() {
	
	Random random = new Random();
	lastMove = HandSign.values()[random.nextInt(3)];

	System.out.println(name + " it's your turn!");
	super.getName(); 
	
	System.out.println(name + " played " + lastMove); 

			return true;
}
	// Question:What type of variable is this? What is the scope of this variable? Does it require Javadoc – why or why not?
	// Answer: its a boolean. In a boolean the that only takes true or false. Yes it does, since every non-private method requires a Javadoc

}

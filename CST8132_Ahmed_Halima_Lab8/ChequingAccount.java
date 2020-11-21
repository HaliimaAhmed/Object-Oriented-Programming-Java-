import java.util.Random;

/* 
 * Name: Halima Ahmed
 * Student ID:040825884
 * Course & Section: CST8132_302
 * Assignment: Lab 8
 * Date: November 19th, 2018  
 */

public class ChequingAccount extends Account {

	/***
	 * The purpose of this class is the Chequing Account for the user
	 * @author Halima Ahmed
	 * @version 1.0
	 * @since 1.8
	 */

	public ChequingAccount(Client client, double balance) {
		super(client, balance);
	}

	// initializing monthlyFee property to a random value between $5 - $10
	Random rand = new Random();
	int low = 5;
	int high = 11;
	double monthlyFee = rand.nextInt(high - low) + low;

	// Checking account monthlyFee property
	private double fee = monthlyFee;

	// Override the toString method
	public String toString() {
		// Invoke the toString method of the parent class
		// Append the monthly fee
		return super.toString() + " | " + monthlyFee + "\n";
	}

	// The ChequingAccount monthlyProcess method attempts to withdraw the monthly
	// fee from the balance.
	public void monthlyProcess() {
		if (monthlyFee > balance)
			// If the balance is insufficient, an Exception should be thrown indicating the
			// account number, balance, and fee in the message.
			System.err.println(
					"insufficient balance: " + accountNum + " . balance is: " + balance + " and fee is: " + fee);
		else
			monthlyFee -= fee;
	}
}

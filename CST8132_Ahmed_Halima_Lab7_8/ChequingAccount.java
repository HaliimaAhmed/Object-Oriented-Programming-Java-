import java.util.Random;
/* 
 * Name: Halima Ahmed
 * Student ID:040825884
 * Course & Section: CST8132_302
 * Assignment:Lab7/Lab8
 * Date: November 19th,2018
 * Updated on: December 8th,2018 
 */

public class ChequingAccount extends Account {

	Random rand = new Random();
	int low = 5;
	int high = 11;
	double monthlyFee = rand.nextInt(high - low) + low;

	// Checking account monthlyFee property
	private double fee = monthlyFee;

	public ChequingAccount(Client client, double balance) {
		super(client, balance);
	}

	// Override the toString method
	public String toString() {
		// Invoke the toString method of the parent class
		// Append the monthly fee
		return super.toString() + " | " + monthlyFee + "\n";
	}

	// The ChequingAccount monthlyProcess method attempts to withdraw the monthly
	// fee from the balance.
	public void monthlyProcess() {
		if (monthlyFee > getBalance())
			// If the balance is insufficient, an Exception should be thrown indicating the
			// account number, balance, and fee in the message.
			System.err.println("insufficient balance: " + getAccountNum() + " balance is: " + getBalance() + " and fee is: " + fee);
		else
			monthlyFee -= fee;
	}
}

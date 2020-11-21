import java.util.Random;
/* 
 * Name: Halima Ahmed
 * Student ID:040825884
 * Course & Section: CST8132_302
 * Assignment:Lab7/Lab8
 * Date: November 19th,2018
 * Updated on: December 8th,2018 
 */

public class SavingsAccount extends Account {
	/***
	 * The purpose of this class is the Savings Account for the user
	 * 
	 * @author Halima Ahmed
	 * @version 1.0
	 * @since 1.8
	 */
	// Initialized to a random value between 3% - 5%.
	Random rand = new Random();
	int low = 3;
	int high = 6;
	int monthlyFee = rand.nextInt(high - low) + low;

	// The SavingsAccount has an annual interest rate property
	private double interestRate = monthlyFee;
	double balance;

	public SavingsAccount(Client client, double balance) {
		super(client, balance);
	}

	// Override the toString method
	public String toString() {
		// Invoke the toString method of the parent class
		// Append the annual interest rate
		return super.toString() + " | " + interestRate + "\n";
	}

	// Adds the calculated monthly interest to the balance.
	public void monthlyProcess() {
		balance = balance + ((interestRate / 100) * getBalance());
	}
}

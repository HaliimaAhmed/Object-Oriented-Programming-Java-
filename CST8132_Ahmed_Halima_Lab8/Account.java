import java.util.Random;

/* 
 * Name: Halima Ahmed
 * Student ID:040825884
 * Course & Section: CST8132_302
 * Assignment: Lab 8
 * Date: November 19th, 2018  
 */

//Account class abstract  
public abstract class Account {

	/***
	 * This class is the clients personal Account
	 * @author Halima Ahmed
	 * @version 1.0
	 * @since 1.8
	 */

	protected long accountNum;
	private Client client;
	protected double balance;

	public Account(Client client, double balance) {
		this.client = client;
		this.balance = balance;

		this.accountNum = new Random().nextLong();
	}

	// Override the Object toString method
	public String toString() {
		// Return a String containing all the properties of an Account and its Client
		return accountNum + " | " + client.getName() + " | " + client.getPhoneNum() + " | " + client.getEmail() + " | "
				+ balance;
	}

	public void deposit(double amt) {
		balance += amt;
	}

	public boolean withdraw(double amt) {
		if (amt > balance) {
			return false;
		} else {
			balance -= amt;
			return true;
		}
	}

	public long getAccountNum() {
		return accountNum;
	}

	public Client getClient() {
		return client;
	}

	public double getBalance() {
		return balance;
	}

	public String getName() {
		return client.getName();
	}

	//abstract void method with no parameters
	public abstract void monthlyProcess();
}

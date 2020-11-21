import java.io.IOException;
import java.lang.IllegalStateException;
import java.nio.file.Paths;
import java.text.DecimalFormat;
import java.util.NoSuchElementException;
import java.util.Scanner;

/* 
 * Name: Halima Ahmed
 * Student ID:040825884
 * Course & Section: CST8132_302
 * Assignment:Lab7/Lab8
 * Date: November 19th,2018
 * Updated on: December 8th,2018 
 */

public class Bank {

	/***
	 * This class is the Clients Bank Account where they can access all their
	 * information
	 * 
	 * @author Halima Ahmed
	 * @version 1.0
	 * @since 1.8
	 */

	private GenericArray<Account> accounts;
	private int numAccounts;
	private String bankName;
	private Scanner in;
	private Scanner Input;
	private Scanner Output;

	public Bank() {

		// Store four Account instances
		accounts = new GenericArray<Account>(4);
		in = new Scanner(System.in);

		System.out.print("What is the name of this bank? ");
		bankName = in.next();
		System.out.print("How many accounts will be in the bank? ");
		in.nextInt();
	}

	/** BANK MENU **/
	public static void main(String[] args) {

		Bank myBank = new Bank();

		boolean quitProgram = false;

		do {

			System.out.println("Please enter one of the following options:");
			System.out.println("P: Print all accounts");
			System.out.println("D: Deposit");
			System.out.println("W: Withdraw");
			System.out.println("M: MonthlyFee amount");
			System.out.println("R: Records");
			System.out.println("Q: quit");

			char opt = myBank.in.next().toUpperCase().charAt(0);
			int acc;
			double amt;

			switch (opt) {
			case 'Q':
				quitProgram = true;
				break;

			case 'R':
				System.out.print("Enter Records: ");
				amt = myBank.in.nextDouble();
				// invoke the readRecords method
				myBank.openInputFile();
				myBank.readRecord();
				myBank.closeInputFile();
				break;

			case 'M':
				System.out.print("Enter the monthlyFee amount:  ");
				amt = myBank.in.nextDouble();
				// invoke the monthlyProcess method
				myBank.monthlyProcess();
				break;

			case 'D':
				System.out.print("Enter the index of the account: ");
				acc = myBank.in.nextInt();
				System.out.print("Enter the amount to deposit: ");
				amt = myBank.in.nextDouble();
				myBank.accounts.get(acc).deposit(amt);
				break;

			case 'W':
				System.out.print("Enter the index of the account: ");
				acc = myBank.in.nextInt();
				System.out.print("Enter the amount to withdraw: ");
				amt = myBank.in.nextDouble();

				if (!myBank.accounts.get(acc).withdraw(amt)) {
					DecimalFormat df = new DecimalFormat("#,###.##");
					System.out.println("Insufficient funds! Balance is $" + df.format(myBank.accounts.get(acc).getBalance()));
				}
				break;

			case 'P':
				myBank.printAccounts();
				break;

			default:
				System.out.println("I'm sorry, I didn't understand you.");
			}

		} while (quitProgram == false);

		System.out.println();
		System.out.println("Bye! Have a nice day!");

	}

	/**
	 * UPDATED to use the toString method of each Account, rather than outputting
	 * all the details individually new existing printAccounts method to output the
	 * bank records to the text file in addition to printing them to the console
	 */
	public void printAccounts() {
		System.out.println("    Bank System     ");
		for (int i = 0; i < accounts.size(); i++)
			System.out.println(accounts.get(i).toString());
	}

	/**
	 * Loop through all Account objects in your GenericArray to invoke the
	 * MonthlyProcess of each account
	 */

	public void monthlyProcess() {
		for (int i = 0; i < accounts.size(); i++)
			((Account) accounts.get(i)).monthlyProcess();
	}

	/** Opens the Bankinput.txt file **/
	public void openInputFile() {
		try {
			Input = new Scanner(Paths.get("Bankinput.txt"));

		} catch (IOException ioExeption) {
			System.err.println("Write permission denied. Terminating");
			System.exit(1);
		}
	}

	/** Read records for each record in the file **/
	public void readRecord() {
		
		try {
			while (Input.hasNext()) {
					
					
				System.out.print("Enter the client's first name: ");
				String fName = Input.next();
				
				System.out.print("Enter the client's last name: ");
				String lName = Input.next();
				
				System.out.print("Enter the client's telephone number: ");
				long phNum = Input.nextLong();
				
				System.out.print("Enter the client's email address: ");
				String email = Input.next();
				
				System.out.print("Enter the opening balance of the account: ");
				double balance = Input.nextDouble();
				
				System.out.print("Enter 'c' to access Chequing Account: ");
				String ChequingAccount = Input.next();
				
				System.out.print("Enter 's' to access Savings Account: ");
				String SavingsAccount = Input.next();

				// Read clients Checking and Savings account
				Client client = new Client(fName, lName, phNum, email);
				
				if (ChequingAccount.equals("c")) {
					accounts.add(new ChequingAccount(client, balance));
				}
				if (SavingsAccount.equals("s")) {
					accounts.add(new SavingsAccount(client, balance));
				}
			 
			}
		} catch (NoSuchElementException elementException) {
			System.err.println("File improperly fromatted. Terminating");
		} catch (IllegalStateException stateException) {
			System.err.println("Error reading from file. Terminating");
		}
	}

	/** Closing file */
	public void closeInputFile() {
		if (Input != null) {
			Input.close();
		}
	}

	/** Open Output file */
	public void openOutputFile() {
		try {
			// open the output file
			Output = new Scanner(Paths.get("bankinput.txt"));

		} catch (IOException ioExeption) {
			System.err.println("Error opening file. Terminating");
		}
		return;
	}

	/** Close output file */
	public void closeOutputFile() {
		if (Output != null) {
			Output.close();
		}
	}
}

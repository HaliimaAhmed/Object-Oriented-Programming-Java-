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
 * Assignment: Lab 8
 * Date: November 19th, 2018  
 */

public class Bank {

	/***
	 * This class is the Clients Bank Account where they can access all their information
	 * @author Halima Ahmed
	 * @version 1.0
	 * @since 1.8
	 */
	
	//GenericArray
	private GenericArray<Account> accounts;
	private int numAccounts;
	private String bankName;
	private Scanner input;
	private static Scanner in;

	public Bank() {
		// store four Account instances
		GenericArray<Account> csAccounts = new GenericArray<Account>(null, 4);

		input = new Scanner(System.in);

		System.out.print("What is the name of this bank? ");
		bankName = input.next();

		System.out.print("How many accounts will be in the bank? ");
		int accounts = input.nextInt();
	}

	public static void main(String[] args) {
		
		Bank myBank = new Bank();

		boolean quitProgram = false;
		do {

			System.out.println("Please enter one of the following options:");
			System.out.println("A: add account ");
			// option to run the monthlyProcess
			System.out.println("M: print monthlyFee amount ");
			// option to run the readRecords
			System.out.println("R:Records  ");
			System.out.println("P: print all accounts");
			System.out.println("D: deposit");
			System.out.println("W: withdraw");
			System.out.println("Q: quit");

			char opt = myBank.input.next().toUpperCase().charAt(0);
			int acc;
			double amt;

			switch (opt) {
			case 'Q':
				quitProgram = true;
				break;

			case 'A':
				System.out.print("Add account:");
				acc = myBank.input.nextInt();
				myBank.addAccount();
				break;

			case 'M':
				System.out.print("Enter the monthlyFee amount:  ");
				amt = myBank.input.nextDouble();
				myBank.monthlyProcess();
				break;

			case 'R':
				System.out.print("Enter Records:  ");
				amt = myBank.input.nextDouble();
				// invoke the readRecords method
				Bank.readRecords();
				break;

			case 'D':
				System.out.print("Enter the index of the account: ");
				acc = myBank.input.nextInt();
				System.out.print("Enter the amount to deposit: ");
				amt = myBank.input.nextDouble();

				((Account) myBank.accounts.get(acc)).deposit(amt);
				break;

			case 'W':
				System.out.print("Enter the index of the account: ");
				acc = myBank.input.nextInt();
				System.out.print("Enter the amount to withdraw: ");
				amt = myBank.input.nextDouble();

				if (!((Account) myBank.accounts.get(acc)).withdraw(amt)) {
					DecimalFormat df = new DecimalFormat("#,###.##");
					System.out.println("Insufficient funds! Balance is $"
							+ df.format(((Account) myBank.accounts.get(acc)).getBalance()));
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

	// UPDATED to use the toString method of each Account, rather than outputting
	// all the details individually
	// new existing printAccounts method to output the bank records to the
	// text file in addition to printing them to the console
	public void printAccounts() {
		System.out.println("    Bank System     ");
		for (int i = 0; i < numAccounts; i++)
			System.out.println(accounts.get(i).toString());
	}

	// Loop through all Account objects in your GenericArray to invoke the
	// monthlyProcess of each account
	public void monthlyProcess() {
		for (int i = 0; i < numAccounts; i++)
			((Account) accounts.get(i)).monthlyProcess();
	}

	// Add accounts
	public void addAccount() {
		Bank banks = new Bank();
		char account = banks.input.nextLine().charAt(0);
		int accs;

		
		System.out.println("Size: " + accounts.size());
		accs = input.nextInt();
		System.out.println("Enter account type: S for Savings ");
		accs = input.nextInt();
		System.out.println("Enter account type: C for Chequing ");
		accs = input.nextInt();

		Account tempObject = null;

		if (account == 'C' || account == 'c') {
			// Add ChequingAccount
			tempObject = new ChequingAccount(null, numAccounts);
			tempObject.toString();
			accounts.get(numAccounts);

		} else if (account == 'S' || account == 's') {
			// Add SavingsAccount
			tempObject = new SavingsAccount(null, numAccounts);
			tempObject.toString();
			accounts.get(numAccounts);
		}
		numAccounts++;
		return;
	}

	// Open the Bankinput.txt file
	public static Scanner openInputFile() {
		Scanner in = null;
		try {
			// open the file
			in = new Scanner(Paths.get("bankinput.txt"));
			
		} catch (IOException ioException) {
			System.err.println("Write permission denied. Terminating");
		}
		return in;
	}

	// Create a new account for each record in the file
	public static void readRecords() {

		Scanner read = openInputFile();
		if (read == null) {
			return;
		}

		System.out.printf("#$^^*($#$$", "Account", "First Name", "Last Name", "Balance");

		try {
			while (in.hasNext()) {
				System.out.printf("#$^^*($#$$", in.nextInt(), in.nextInt(), in.nextInt(), in.nextDouble());
			}
		} catch (NoSuchElementException elementException) {
			System.err.println("File improperly fromatted. Terminating");
		} catch (IllegalStateException stateException) {
			System.err.println("Error reading from file. Terminating");
		}

	}

	// close file
	public static void closeInputFile() {
		if (in != null)
			in.close();
	}

	// open Output file
	public static void openOutputFile() {

		try {
			//open the output file
			in = new Scanner(Paths.get("bankinput.txt"));

		} catch (IOException ioExeption) {
			System.err.println("Error opening file. Terminating");
		}
		return;
	}

	// Close output file
	public static void closeOutputFile() {
		if (in != null)
			in.close();
	}
}
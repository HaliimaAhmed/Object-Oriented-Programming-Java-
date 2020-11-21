/* 
 * Name: Halima Ahmed
 * Student ID:040825884
 * Course & Section: CST8132_302
 * Assignment:Lab7/Lab8
 * Date: November 19th,2018
 * Updated on: December 8th,2018 
 */

public class Client {

	/***
	 * This class holds the clients information (Created from previous lab)
	 * @author Halima Ahmed
	 * @version 1.0
	 * @since 1.8
	 */

	private String firstName;
	private String lastName;
	private long phoneNum;
	private String email;

	public Client(String firstName, String lastName, long phoneNum, String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNum = phoneNum;
		this.email = email;
	}

	public String getName() {
		return firstName + " " + lastName;
	}

	public long getPhoneNum() {
		return phoneNum;
	}

	public String getEmail() {
		return email;
	}

}

/* 
 * Name: Haliima Ahmed
 * Student ID:040825884
 * Course & Section: CST8132
 * Assignment: Lab 1
 * Date: September 20th, 2018 
 */
public class Patterns {

	public static void main(String[] args) {
		// Variable
		// Count is the single Value that can change the code
		int count = 5;

		// First Loop Pattern
		
		for (int x=1; x<= count; x++) {
			for (int y=1; y<= x; y++) {
				System.out.print("$");
			}
			// "$" will print all in the same line without this 
			System.out.println(" ");
		}
		// added (" ") at the end to separate the loops 
		System.out.println();

		// Second Loop Pattern
		
		for (int x=count; x>= 1; x--) {
			for (int z = 1; z <= x; z++) {
				System.out.print("$");
			}
			// "$" will print all in the same line without this 
			System.out.println(" ");
		}
		// adds space in between the second and third pattern 
		System.out.println();
		
		// Third Loop Pattern
		 
		for (int x=count; x>= 1; x--) {
			for (int a = 0; a < count - x; a++) {
				System.out.print(' ');
			}
			for (int y=1; y<= x; y++) {
				System.out.print("$");
			}
			System.out.println(" ");
		}
		System.out.println();

		// Fourth Loop Pattern
		
		for (int x=1; x <= count; x++) {
			for (int a = 0; a < count - x; a++) {
				System.out.print(' ');
			}

			for (int y=1; y <= x; y++) {
				System.out.print("$");

			}
			System.out.println(" ");
		}
	}
}

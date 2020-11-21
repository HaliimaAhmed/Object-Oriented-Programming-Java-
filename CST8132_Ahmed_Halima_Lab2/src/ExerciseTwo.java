/* 
 * Name: Halima Ahmed
 * Student ID:
 * Course & Section: CST8132_302
 * Assignment: Lab 2
 * Date: September 20, 2018 
 */
public class ExerciseTwo {
	// instance varible for 2DArray
	
	int[][] Array;

	// constructor
	public ExerciseTwo() {
		Array = new int[6][10];

		for (int x = 0; x < Array.length; x++) {
			for (int y = 0; y < Array[x].length; y++) {
				Array[x][y] = x * 10 + y;
			}
		}
	}

// Used nested for-loops to prints the values of the elements of the array and also put it in the 2DArray 
	
	public void printArrayValues() {
		
		System.out.println("myArray = ");
		for (int x = 0; x < Array.length; x++) {
			
			System.out.print("{");
			
			for (int y = 0; y < Array[x].length; y++) {
				
				System.out.print(Array[x][y]);
				
				if (y <= 10) {
					
					System.out.print(",");
					
				} else {
					
					System.out.print("}");	
				}
			}
			// puts the two-dimensional array in a 6 rows and 10 columns
			System.out.println(" ");
		}
	}
	// decided to add a private method
	// used an enhanced for-loops that calculates the total sum of all elements of the 2- dimensional array
	private int calculations(int[] z) {
		int calc = 0;
		for (int value : z) {
			calc = value + calc;
		}
		return calc/1;
	}
	// used an enhanced for-loops to display the sum of the array 
	public void displayArrayTotal() {
		System.out.println();
		int total = 0;
		for (int[] z : Array) {
			total += calculations(z);
		}
		System.out.println("The sum of all elements of myArray is  " + total + ".");
	}
	
// main method 
	public static void main(String[] args) {
		ExerciseTwo ExerciseTwo = new ExerciseTwo();
		ExerciseTwo.printArrayValues();
		ExerciseTwo.displayArrayTotal();
	}
}

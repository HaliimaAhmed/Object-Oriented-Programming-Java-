/* 
 * Name: Halima Ahmed
 * Student ID:
 * Course & Section: CST8132_302
 * Assignment: Lab 2
 * Date: September 20, 2018 
 */

public class ExerciseOne {
	// instance varible
	int[] myArray;

	// constructor
	public ExerciseOne() {
		myArray = new int[10];

		for (int x = 0; x < myArray.length; x++) {
			myArray[x] = x + 1;
		}
	}

// prints the values of the elements of the array
	public void printArrayValues() {
		System.out.print(" MyArray =  ");

		for (int x = 0; x < myArray.length; x++) {
			System.out.print(myArray[x]);
			if (x <= 10) {
				// adds a comma after the numerical value
				System.out.print(",");
			}
		}
	}

// uses enhanced for loop to calcualte the values and print out statement 
	public void displayArrayProduct() {
		int display = 1;
		for (int value : myArray) {
			display = value * display;
		}
		System.out.print("\nThe product of all elements of " + display);
	}

// main method 
	public static void main(String[] args) {
		ExerciseOne ExerciseOne = new ExerciseOne();
		ExerciseOne.printArrayValues();
		ExerciseOne.displayArrayProduct();
	}

}

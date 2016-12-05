/**
 * 
 */
package dayone_array;

import java.util.Scanner;

/**
 * @author vinmar
 *
 */
public class Single {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = null;
		int input_number = 0;
		String[] single = null;
		try {
			/*Enable keyboard inputs*/
			sc = new Scanner(System.in);
			
			/*Ask user*/
			System.out.print("Please enter the preferred length of the array: ");
			
			/*User specifies array length*/
			input_number = getUserInputInteger(sc, 2);
			
			/*Creates the array*/
			single = new String[input_number];
			
			/*Prints the length of the array*/
			System.out.println("Array length: " + single.length);
			
			/*Populate the array*/
			populateArray(sc, single, 25);
			
			/*Print*/
			printArray(single);
			
			/*Delete index 2 and move everything down*/
			single = delete(single, 2);
			
			/*Print*/
			printArray(single);
		} catch (Exception e) {
			try {
				sc.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			} finally {
				sc.close();
			}
		}

	}
	
	/**
	 * Print all the elements for each of the array index
	 * @param array The array of Strings to print
	 */
	public static void printArray(String[] array){
		try {
			System.out.format("%5s%8s", "Index", "Value\n");
			for (int i = 0; i < array.length; i++) {
				System.out.format("%3d%5s%5s", i, " ", read(array, i));
				System.out.println();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Allows the user to populate the array.
	 * Note: Strings are used as value for each of the element in the array
	 * @param sc The Scanner object
	 * @param array The array of strings to populate
	 * @param max The maximum number of characters allowed
	 */
	public static void populateArray(Scanner sc, String[] array, int max){
		try {
			String value = null;
			for (int i = 0; i < array.length; i++) {
				System.out.print("Enter any value to the array element at index " + i + ": ");
				value = sc.next();
				insertAndUpdate(array, value, i);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Get user input as length of array
	 * @param sc The Scanner object
	 * @param min The minimum value allowed
	 * @return userInput The number the user entered
	 */
	public static int getUserInputInteger(Scanner sc, int min){
		boolean stopper = false;
		int userInput = 0;
		try {
			while(!stopper){
				
				/*Checks for non-numeric value*/
				/*Will keep in loop unless integer was entered*/
				while(!sc.hasNextInt()){
					System.out.print("Please enter a whole number: ");
					sc.next();
				}
				
				/*Takes the input*/
				userInput = sc.nextInt();
				
				/*Validates against minimum value allowed*/
				if (userInput >= min) {
					stopper = true;
				}else{
					System.out.print("Please enter minimum " + min + " or greater: ");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return userInput;
		
	}
	
	/**
	 * Create and Update Operation
	 * @param array The array of Strings
	 * @param value The new value
	 * @param index The index of the array to be manipulated
	 */
	public static void insertAndUpdate(String[] array, String value, int index){
		array[index] = value;
	}
	
	/**
	 * Read Operation
	 * @param array The array of Strings
	 * @param index The index of the array to be read
	 * @return The String value in the given index within the array
	 */
	public static String read(String[] array, int index){
		return array[index];
	}
	
	/**
	 * Delete Operation
	 * @param array The array of Strings
	 * @param index The index of the array to be deleted
	 * @return New array of String without the deleted element
	 */
	public static String[] delete(String[] array, int index){
		String[] newArray = new String[array.length-1]; //Create new array with reduced length
		
		/*The first element will be removed*/
		if (index == array.length-array.length) {
			for (int i = 1; i < array.length; i++) {
				newArray[i-1] = array[i];
			}
			
		/*The last element will be removed*/
		}else if (index == array.length-1) {
			for (int i = 0; i < newArray.length; i++) {
				newArray[i] = array[i];
			}
		
		/*Anything in between*/
		}else{
			boolean jumped = false; //This makes sure that after deletion, the remaining values will still be copied
			for (int i = 0; i < array.length; i++) {
				if (index != i && !jumped) {
					newArray[i] = array[i];
				}else if (index == i && !jumped) {
					jumped = true; //performs the skip
				}else if (jumped) {
					newArray[i-1] = array[i]; //skipped 1 from old array
				}
			}
		}
		return newArray;
		
	}

}

// Mostapha A
// Lab 3

import java.util.Arrays;
import java.util.Scanner;

/**
 * * 
 * This class contains the main method and menu 
 * Student Name: Mostapha A
 * Course: CST8130 - Data Structures CET-CS-Level 3
 * 
 * 
 */
public class Lab2BinLinSearchTest {
	// scanner
	private static Scanner input = new Scanner(System.in);
	
	/**
	 * Main method for printing menu and processing.
	 * 
	 * @param args Default needed for main method
	 */
	public static void main(String[] args) {
		// var for menu input
		int menu = -1;
		// array values
		// change this for array size
		int size = 1000;
		int firstIndex = 0;
		int lastIndex = (size - 1);
		int searchValue;
		// searching object
		BinaryLinearSearch search = new BinaryLinearSearch(size);
		// error for printing message
		int error = 0;
		// array
		int[] array = new int[size];
		int[] sortedArray = new int[size];

		// loop through menu
		do {
			// set menu to -1 
			menu = -1;

			// print menu
			printMenus(1);
			
			// if input is an int, store
			if (input.hasNextInt()) {
				menu = input.nextInt();
				error = 0;
			} else {
				// clear input
				input.next();
				error = 1;
			}

			// if it is out of range print error and loop again
			if (menu < 1 || menu > 5) {
				// print error and loop through again
				if (error == 0) {
				System.err.println("Please choose the option 1 to 5.");
				} else {
					System.err.println("******Input Mismatch Exception******");
				}
			} else {
				// case structure for menu options
				switch (menu) {
				case 1:
					System.out.println("Array of randomly generated integers:");
					// initialize and populate an array
					array = search.generateRandomInts();
					System.out.println(Arrays.toString(array)+"\n");
					
					// sort
					sortedArray = Arrays.copyOf(array, size);
					Arrays.sort(sortedArray);
										
					break;
				case 2:				
					// perform recursive searches, get input
					searchValue = searchValue();
					
					// print array
					System.out.println(Arrays.toString(array)+"\n");
					
					// call array for accurate time readings
					search.callArray(sortedArray);
					
					// perform search
					search.recursiveBinarySearch(sortedArray, firstIndex, lastIndex, searchValue);
					
					// perform search
					search.recursiveLinearSearch(sortedArray, size, searchValue);
					
					break;
				case 3:
					// perform iterative searches, get input
					searchValue = searchValue();
					
					// print array
					System.out.println(Arrays.toString(array)+"\n");
					
					// call array for accurate time readings
					search.callArray(array);
					
					// perform search
					search.iterativeBinarySearch(sortedArray, searchValue);
					
					// perform search
					search.iterativeLinearSearch(sortedArray, searchValue);
					
					break;
				case 4:
					// Sorting algorithms
					secondaryMenu(array, firstIndex, lastIndex);
					break;
				case 5:
					// print exiting message
					System.out.println("\nExiting...");
					break;
				}
			}

		} while (menu != 5);
	}
	
	/**
	 * Asks for an integer search value and validates it.
	 * @return The validated input
	 */
	public static int searchValue() {
		int search = -1;
		int error = 0;

		// ask for size, validate input with loop
		do {
			System.out.print("Please enter an integer value to search: ");

			if (input.hasNextInt()) {
				// store if an int
				search = input.nextInt();
				error = 0;
			} else {
				// clear input
				input.next();
				error = 1;
			}

			// if its not greater than 0 print error message
			if (search <= 0) {
				if (error == 0) {
				System.err.println("Please enter a positive integer.");
				} else {
					System.err.println("******Input Mismatch Exception******");
				}
			}

		} while (search <= 0);
		
		return search;
	}
	
	/**
	 * Prints one of two menus
	 * @param menu The first or second menu to print
	 */
	public static void printMenus(int menu) {
		if (menu == 1) {
			System.out.print("Select your option in the menu:\n" + 
					"1: Initialize and populate an array of 1000 random integers.\n" + 
					"2: Perform recursive binary and linear search.\n" + 
					"3: Perform iterative binary and linear search.\n" + 
					"4: Sort the array - Go to submenu\n" + 
					"5: Quit \n\n" + 
					">");
		} else {
			System.out.print(
					"\nSelect a sorting algorithm to sort the data array\n\n" +
					"     B. Bubble Sort \n" + 
					"     I. Insertion Sort \n" + 
					"     S. Selection Sort \n" + 
					"     M. Merge Sort \n" + 
					"     Q. Quick Sort \n" + 
					"     R. Return to Main Menu\n\n"+ 
					">");
		}
	}

	/**
	 * Implements the sub-menu and it's sorting functions
	 * @param array The array that will be sorted with the various methods
	 * @param firstIndex The first index of the array
	 * @param lastIndex The last index of the array
	 */
	public static void secondaryMenu(int[] array, int firstIndex, int lastIndex) {
		String menu;
		int[] sortedArray;
		// timing variables
		long initialNanoTime;
		long initialMilliTime;
		long totalNano = 0;
		long totalMilli = 0;
				
		// loop through menu
				do {
					// set menu to invalid value, reset array
					menu = "A";
					sortedArray = Arrays.copyOf(array, array.length);

					// print menu
					printMenus(2);
					menu = input.next();

					// if it is out of range print error and loop again
					if (!menu.equalsIgnoreCase("B")  && !menu.equalsIgnoreCase("I") && !menu.equalsIgnoreCase("S") && !menu.equalsIgnoreCase("M") && !menu.equalsIgnoreCase("Q") && !menu.equalsIgnoreCase("R")) {
						// print error and loop through again
						System.err.println("Please choose a valid menu option.");						
					} else {
						menu = menu.toUpperCase();
						// implement the menu choices
						switch (menu) {
						case "B":
							// print array and sort method
							System.out.println("\n" +
									Arrays.toString(sortedArray) + "\n\nBubble Sort: Simple sorting algorithm  - O(n2) Complexity - \n");
							
							// take the initial time
							initialNanoTime = System.nanoTime();
							initialMilliTime = System.currentTimeMillis();
							
							// bubble sort
							SortingAlgorithms.bubbleSort(sortedArray);
							
							// calculate and add total times
							totalNano = totalNano + (System.nanoTime() - initialNanoTime);
							totalMilli = totalMilli + (System.currentTimeMillis() - initialMilliTime);

							// print sorted array
							System.out.println(Arrays.toString(sortedArray)+"\n");

							// print calculated time
							System.out.println(
									"Time taken in nanoseconds: " + totalNano + "\n" + "Time taken in milliseconds: " + totalMilli);

							// set total times to 0
							totalNano = 0;
							totalMilli = 0;
							break;
						case "I":
							// print array and sort method
							System.out.println("\n" +
									Arrays.toString(sortedArray) + "\n\nInsertion Sort: Simple sorting algorithm - O(n2) Complexity - \n");
							
							// take the initial time
							initialNanoTime = System.nanoTime();
							initialMilliTime = System.currentTimeMillis();
							
							// insertion sort
							SortingAlgorithms.insertionSort(sortedArray);
							
							// calculate and add total times
							totalNano = totalNano + (System.nanoTime() - initialNanoTime);
							totalMilli = totalMilli + (System.currentTimeMillis() - initialMilliTime);

							// print sorted array
							System.out.println(Arrays.toString(sortedArray)+"\n");

							// print calculated time
							System.out.println(
									"Time taken in nanoseconds: " + totalNano + "\n" + "Time taken in milliseconds: " + totalMilli);

							// set total times to 0
							totalNano = 0;
							totalMilli = 0;
							break;
						case "S":
							// print array and sort method
							System.out.println("\n" +
									Arrays.toString(sortedArray) + "\n\nSelection Sort: Simple sorting algorithm - O(n2) Complexity - \n");
							
							// take the initial time
							initialNanoTime = System.nanoTime();
							initialMilliTime = System.currentTimeMillis();
							
							// selection sort
							SortingAlgorithms.selectionSort(sortedArray);
							
							// calculate and add total times
							totalNano = totalNano + (System.nanoTime() - initialNanoTime);
							totalMilli = totalMilli + (System.currentTimeMillis() - initialMilliTime);

							// print sorted array
							System.out.println(Arrays.toString(sortedArray)+"\n");

							// print calculated time
							System.out.println(
									"Time taken in nanoseconds: " + totalNano + "\n" + "Time taken in milliseconds: " + totalMilli);

							// set total times to 0
							totalNano = 0;
							totalMilli = 0;
							break;
						case "M":
							// print array and sort method
							System.out.println("\n" +
									Arrays.toString(sortedArray) + "\n\nMerge Sort: Recursive Divide-And-Conquer - O(n log n) Complexity - \n");
							
							// take the initial time
							initialNanoTime = System.nanoTime();
							initialMilliTime = System.currentTimeMillis();
							
							// merge sort
							SortingAlgorithms.mergeSort(sortedArray);
							
							// calculate and add total times
							totalNano = totalNano + (System.nanoTime() - initialNanoTime);
							totalMilli = totalMilli + (System.currentTimeMillis() - initialMilliTime);

							// print sorted array
							System.out.println(Arrays.toString(sortedArray)+"\n");

							// print calculated time
							System.out.println(
									"Time taken in nanoseconds: " + totalNano + "\n" + "Time taken in milliseconds: " + totalMilli);

							// set total times to 0
							totalNano = 0;
							totalMilli = 0;
							break;
						case "Q":
							// print array and sort method
							System.out.println("\n" +
									Arrays.toString(sortedArray) + "\n\nQuick Sort: Recursive Divide-And-Conquer - O(n log n) Complexity - \n");
							
							// take the initial time
							initialNanoTime = System.nanoTime();
							initialMilliTime = System.currentTimeMillis();
							
							// quick sort
							SortingAlgorithms.quickSort(sortedArray, firstIndex, lastIndex);
							
							// calculate and add total times
							totalNano = totalNano + (System.nanoTime() - initialNanoTime);
							totalMilli = totalMilli + (System.currentTimeMillis() - initialMilliTime);

							// print sorted array
							System.out.println(Arrays.toString(sortedArray)+"\n");

							// print calculated time
							System.out.println(
									"Time taken in nanoseconds: " + totalNano + "\n" + "Time taken in milliseconds: " + totalMilli);

							// set total times to 0
							totalNano = 0;
							totalMilli = 0;
							break;
						case "R":
							// return to main menu
							System.out.println("\nReturning to main menu...\n");
							break;
						}
					}
				} while (!menu.equalsIgnoreCase("R"));
	}

}

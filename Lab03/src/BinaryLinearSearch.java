// Mostapha A
// Lab 3

import java.security.SecureRandom;

/**
 * * 
 * This class contains the binary and linear search methods 
 * Student Name: Mostapha A
 * Course: CST8130 - Data Structures CET-CS-Level 3
 * 
 */
public class BinaryLinearSearch {
	/** Default size to create an array if default constructor is used */
	private int defaultSize = 30;
	/** Takes the initial time in nano seconds */
	private long initialNanoTime;
	/** Takes the initial time in milli seconds */
	private long initialMilliTime;
	/** Takes the total time in nano seconds */
	private long totalNano = 0;
	/** Takes the total time in milli seconds */
	private long totalMilli = 0;

	/**
	 * No argument constructor
	 */
	public BinaryLinearSearch() {
	}

	/**
	 * Constructor that sets specified array sizes
	 * 
	 * @param size The array size
	 */
	public BinaryLinearSearch(int size) {
		defaultSize = size;
	}

	/**
	 * Generates an array of random numbers
	 * 
	 * @return An array of random integers
	 */
	public int[] generateRandomInts() {
		int[] array = new int[defaultSize];
		SecureRandom random = new SecureRandom();

		// fill array with random numbers
		for (int i = 0; i < defaultSize; i++) {
			// random value greater than 20 and less than 1000
			array[i] = random.nextInt(979) + 21;
		}

		return array;
	}
	
	/**
	 * Uses a binary search method on a provided array to find the index of the
	 * provided value
	 * 
	 * @param array  The array to search through
	 * @param search The value to find
	 * @return The index value where the search value is
	 */
	int iterativeBinarySearch(int array[], int search) {
		// set variables
		int firstIndex = 0;
		int lastIndex = array.length - 1;

		// loop until the range is just one number
		while (firstIndex <= lastIndex) {
			// take the initial time
			initialNanoTime = System.nanoTime();
			initialMilliTime = System.currentTimeMillis();
			
			// calculate middle index
			int middleIndex = (firstIndex + lastIndex + 1) / 2;

			// check if the value is at the middle index
			if (array[middleIndex] == search) {
				// calculate and add total times
				totalNano = totalNano + (System.nanoTime() - initialNanoTime);
				totalMilli = totalMilli + (System.currentTimeMillis() - initialMilliTime);
				// print where it was found
				System.out.println(search + " was found at index position " + middleIndex + ": Iterative Binary Search\n");
				// print calculated time
				System.out.println("Time taken in nanoseconds: " +totalNano + "\n" +
				"Time taken in milliseconds: " +totalMilli+"\n");

				// set total times to 0
				totalNano = 0;
				totalMilli = 0;
				
				// return the index
				return middleIndex;
			}
			
			// calculate and add total times
			totalNano = totalNano + (System.nanoTime() - initialNanoTime);
			totalMilli = totalMilli + (System.currentTimeMillis() - initialMilliTime);
			
			// if the array value is smaller than search value, drop the lesser half of the array
			if (array[middleIndex] < search) {
				firstIndex = middleIndex + 1;
			}else {
				lastIndex = middleIndex - 1;
			}
		}

		// calculate and add total times
		totalNano = totalNano + (System.nanoTime() - initialNanoTime);
		totalMilli = totalMilli + (System.currentTimeMillis() - initialMilliTime);
		
		// print it was not found
		System.out.println(search + " was not found: Iterative Binary Search\n");
		
		// print calculated time
		System.out.println("Time taken in nanoseconds: " +totalNano + "\n" +
		"Time taken in milliseconds: " +totalMilli+"\n");

		// set total times to 0
		totalNano = 0;
		totalMilli = 0;
		
		// return -1 because it was not found
		return -1;
	}

	/**
	 * Uses a recursive search method on a provided array to find the index of the
	 * provided value
	 * 
	 * @param array      The array to search through
	 * @param firstIndex The first index of the array
	 * @param lastIndex  The last index of the array
	 * @param search     The value to search for
	 * @return The index value of the value location
	 */
	public int recursiveBinarySearch(int array[], int firstIndex, int lastIndex, int search)
	{
		// take the initial time
		initialNanoTime = System.nanoTime();
		initialMilliTime = System.currentTimeMillis();

		// if the range is not just one number
		if (lastIndex >= firstIndex) {
			int middleIndex = (firstIndex + lastIndex + 1) / 2;

			// if the search value is at the middle index
			if (array[middleIndex] == search) {
				// calculate and add total times
				totalNano = totalNano + (System.nanoTime() - initialNanoTime);
				totalMilli = totalMilli + (System.currentTimeMillis() - initialMilliTime);
				
				// print where it was found
				System.out.println(search + " was found at index position " + middleIndex + ": Recursive Binary Search\n");

				// print calculated time
				System.out.println(
						"Time taken in nanoseconds: " + totalNano + "\n" + "Time taken in milliseconds: " + totalMilli+"\n");

				// set total times to 0
				totalNano = 0;
				totalMilli = 0;

				// return found index
				return middleIndex;
			}
			
			// calculate and add total times
			totalNano = totalNano + (System.nanoTime() - initialNanoTime);
			totalMilli = totalMilli + (System.currentTimeMillis() - initialMilliTime);
			
			// if the array value is greater than search value recursive method with redefined range
			if (array[middleIndex] > search) {
				return recursiveBinarySearch(array, firstIndex, (middleIndex - 1), search);
			} 
				return recursiveBinarySearch(array, (middleIndex + 1), lastIndex, search);
			
		}
		
		// calculate and add total times
		totalNano = totalNano + (System.nanoTime() - initialNanoTime);
		totalMilli = totalMilli + (System.currentTimeMillis() - initialMilliTime);

		// print it was not found
		System.out.println(search + " was not found: Iterative Binary Search\n");

		// print calculated time
		System.out.println(
				"Time taken in nanoseconds: " + totalNano + "\n" + "Time taken in milliseconds: " + totalMilli+"\n");

		// set total times to 0
		totalNano = 0;
		totalMilli = 0;

		// return -1 if not found
		return -1;
	}
	

	/**
	 * Uses an iterative linear search method to find the index position of a
	 * provided array
	 * 
	 * @param array  The array to search in
	 * @param search The value to be looked for
	 * @return The index value the search value is in
	 */
	public int iterativeLinearSearch(int[] array, int search) {
		int index = -1;

		// take the initial time
		initialNanoTime = System.nanoTime();
		initialMilliTime = System.currentTimeMillis();
		
		// loop through array until found
		for (int i = 0; i < array.length; i++) {
			if (array[i] == search) {
				index = i;
				i = array.length;
			}
		}
		
		// calculate and add total times
		totalNano = totalNano + (System.nanoTime() - initialNanoTime);
		totalMilli = totalMilli + (System.currentTimeMillis() - initialMilliTime);

		// print result
		if (index == -1) {
			System.out.println(search + " was not found: Iterative Linear Search\n");
		} else {
			System.out.println(search + " was found at index position " + index + ": Iterative Linear Search\n");
		}
		
		// print calculated time
		System.out.println("Time taken in nanoseconds: " + totalNano + "\n" + 
		"Time taken in milliseconds: " + totalMilli+"\n");

		// set total times to 0
		totalNano = 0;
		totalMilli = 0;

		return index;
	}

	/**
	 * Uses a recursive linear search method to find a provided value in the
	 * provided array
	 * 
	 * @param array  The array of numbers to search through
	 * @param size   The size of the provided array
	 * @param search The value to search for
	 * @return The index value of the search value
	 */
	public int recursiveLinearSearch(int[] array, int size, int search) {

		// take the initial time
		initialNanoTime = System.nanoTime();
		initialMilliTime = System.currentTimeMillis();
		
		int index = -1;
		int initial = (array.length - size);

		// check if value is at index otherwise decrease size and recursive call
		if (array[initial] == search) {
			index = initial;
		} 
		
		if (index == -1 && size > 1) {
			// calculate and add total times
			totalNano = totalNano + (System.nanoTime() - initialNanoTime);
			totalMilli = totalMilli + (System.currentTimeMillis() - initialMilliTime);
			
			size--;
			index = recursiveLinearSearch(array, size, search);
		} else {
			// calculate and add total times
			totalNano = totalNano + (System.nanoTime() - initialNanoTime);
			totalMilli = totalMilli + (System.currentTimeMillis() - initialMilliTime);
			
			if (index == -1) {
				System.out.println(search + " was not found: Recursive Linear Search\n");
			} else {
				System.out.println(search + " was found at index position " + index + ": Recursive Linear Search\n");
			}
			
			// print calculated time
			System.out.println("Time taken in nanoseconds: " + totalNano + "\n" + 
			"Time taken in milliseconds: " + totalMilli+"\n");

			// set total times to 0
			totalNano = 0;
			totalMilli = 0;
		}

		return index;
	}
	
	/**
	 * Prints the remaining elements in the array after half is dropped.
	 * @param array Array to print from
	 * @param firstIndex First index to begin printing from
	 * @param lastIndex Last index to print until
	 */
	public void remainingElements(int[] array, int firstIndex, int lastIndex) {
		// print initial spaces
		for (int i = 0; i < firstIndex; i++) {
			System.out.print("   ");
		}
		// print values
		for (int i = firstIndex ; i <= lastIndex ; i++) {
			System.out.printf("%-3d", array[i]);
		}
		// print new line
		System.out.println();
	}
	
	/*
	 * Brings array into memory for accurate timings
	 */
	public void callArray(int[] array) {
		// bring array into memory for accurate time readings

		// calculate middle index
		int middleIndex = (0 + defaultSize) / 2;

		// take the initial time
		initialNanoTime = System.nanoTime();
		initialMilliTime = System.currentTimeMillis();

		// check middle index otherwise change range
		if (55 == array[middleIndex]) {
			middleIndex = 55;
		} else {
		}

		// calculate and add total times
		totalNano = totalNano + (System.nanoTime() - initialNanoTime);
		totalMilli = totalMilli + (System.currentTimeMillis() - initialMilliTime);

		// set total times to 0
		totalNano = 0;
		totalMilli = 0;

	}
}

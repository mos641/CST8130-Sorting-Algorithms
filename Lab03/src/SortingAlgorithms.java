// Mostapha A
// Lab 3

/**
 * * 
 * This class contains the various sorting algorithms  
 * Student Name: Mostapha A
 * Course: CST8130 - Data Structures CET-CS-Level 3
 *  
 */
public class SortingAlgorithms {

	/**
	 * Sorts a provided array using a bubble sort method
	 * @param array The array to be sorted
	 */
	public static void bubbleSort(int[] array) {
		int temp;
		boolean changed = true;
		
		// sort array using bubble method
		do {
			changed = false;
			for (int i = 0; i < array.length - 1; i++) {
				// check the index value and the one after it, replace if applicable
				if (array[i] > array[i + 1]) {
					temp = array[i];
					array[i] = array[i+1];
					array[i+1] = temp;
					changed = true;
				}
			}
		} while (changed == true);
		}

	public static void insertionSort(int[] array) {
		int temp;
		
		// sort array using insertion sort method
		for (int i = 0; i < array.length ; i++) {
			// set element
			temp = array[i];
			for (int j = 0; j <= i; j++) {
				// check element values, shift array
				if (array[j] >= temp) {
					// shift elements
					for (int k = i; k > j; k--) {
						array[k] = array[k-1];
					}
					// insert new element, exit j loop
					array[j] = temp;
					j = i+1;
				}
			}
		}
	}

	/**
	 * Sorts an array using the selection sort method
	 * @param array The array to be sorted
	 */
	public static void selectionSort(int[] array) {
		int temp;
		int index;
		temp = array[0];
		
		// sort array using selection method - check for smallest value, swap with 0, next swap with 1 etc
		for (int i = 0; i < array.length; i++) {
			index = i;
			temp = array[i];
			// check for smallest value
			for (int j = i+1; j < array.length; j++) {
				if (temp > array[j]) {
					temp = array[j];
					index = j;
				}				
			}
			// swap values
			array[index] = array[i];
			array[i] = temp;
		}
	}

	/**
	 * Sorts an array using the merge sort method recursively
	 * @param array The array to be sorted
	 */
	public static void mergeSort(int[] array) {
		int length = array.length;

		// if array can not be split return
		if (length < 2) {
			return;
		}

		// sort array using merge sort, split array
		int midPoint = length / 2;
		// create two arrays from the original array
		int[] array1 = new int[midPoint];
		int[] array2 = new int[length - midPoint];

		// loop to fill first array then second
		for (int i = 0; i < midPoint; i++) {
			array1[i] = array[i];
		}
		for (int i = 0; i < length - midPoint; i++) {
			array2[i] = array[i + midPoint];
		}

		// recursively call method to further split
		mergeSort(array1);
		mergeSort(array2);

		// return split arrays into one based on which index is smaller
		int array1Index = 0;
		int array2Index = 0;
		int arrayIndex = 0;
		
		while (array1Index < array1.length && array2Index < array2.length) {
			// check which index position of which array is smaller
			if (array1[array1Index] <= array2[array2Index]) {
				array[arrayIndex] = array1[array1Index];
				arrayIndex++;
				array1Index++;
			} else {
				array[arrayIndex] = array2[array2Index];
				arrayIndex++;
				array2Index++;
			}
		}
		
		// deal with remainder of the array if there is any left
		while (array1Index < array1.length) {
			array[arrayIndex] = array1[array1Index];
			arrayIndex++;
			array1Index++;
		}
		
		while (array2Index < array2.length) {
			array[arrayIndex] = array2[array2Index];
			arrayIndex++;
			array2Index++;
		}
	}

	/**
	 * Sorts an array using the quick sort method recursively
	 * @param array The array to be sorted
	 * @param start The start of the values to compare the pivot
	 * @param end The Last value to be compared to the pivot
	 */
	public static void quickSort(int[] array, int start, int end) {
		// if all values have been compared
		if (start >= end) {
			return;
		}

		// set pivot to first element
		int pivot = start;
		// skip pivot
		int left = start + 1;
		int right = end;
		int temp;

		// while left side of array ( less than pivot) doesn't overlap right side
		while (left < right) {// partition

			// skip already sorted values
			while (array[left] < array[pivot] && left < right) {
				left++;
			}

			while (array[right] > array[pivot] && left < right) {
				right--;
			}

			// swap the values that are on the wrong side
			temp = array[left];
			array[left] = array[right];
			array[right] = temp;

			// if swapped values were not the last in the array
			if (left < right) {
				left++;
				right--;
			}
		}

		// if the overlap value greater than pivot value, swap pivot and left of overlap
		if (array[left] > array[pivot]) {
			temp = array[pivot];
			array[pivot] = array[left - 1];
			array[left - 1] = temp;

			// recursively call method to further split and sort
			quickSort(array, start, left - 2);
			quickSort(array, left, end);
		} else {
			// otherwise swap pivot and overlap
			temp = array[pivot];
			array[pivot] = array[left];
			array[left] = temp;

			// recursively call method to further split and sort
			quickSort(array, start, left - 1);
			quickSort(array, left + 1, end);
		}
	}
}

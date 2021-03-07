import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

// -------------------------------------------------------------------------

/**
 *  This class contains static methods that implementing sorting of an array of numbers
 *  using different sort algorithms.
 *
 *  @author Ben Vaughan
 *  @version HT 2020
 */

 class SortComparison {

	 
    /**
     * Sorts an array of doubles using InsertionSort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     * @param a: An unsorted array of doubles.
     * @return array sorted in ascending order.
     *
     */
    static double[] insertionSort (double a[]){
    	int n = a.length;
    	double[] sorted = a;
    	for(int i = 1; i < n; i++) {
    		for(int j = i; j > 0; j--) {
    			if(sorted[j] < sorted[j-1]) {
    				swap(sorted, j, j - 1);
    			}
    		}
    	}
    	return sorted;
    }	
    //end insertionsort
	

    
	 /**
     * Sorts an array of doubles using Selection Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     * @param a: An unsorted array of doubles.
     * @return array sorted in ascending order
     *
     */
    static double [] selectionSort (double a[]){
    	for(int i = 0; i < a.length; i++) {
    		int currMin = i;
    		for(int j = i + 1; j < a.length; j++) {
    			if(a[j] < a[currMin]) {
    				currMin = j;
    			}
    		}
    		if(currMin != i) {
    			swap(a, i, currMin);
    		}
    	} 
    	return a;
    }
    //end selectionsort

    
    
    /**
     * Sorts an array of doubles using Quick Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     * @param a: An unsorted array of doubles.
     * @return array sorted in ascending order
     *
     */
    static double [] quickSort (double a[]){
    	quickSortRepeat(a, 0, (a.length - 1));
    	return a;
    }
    
    static void quickSortRepeat(double[] arr, int lowerBound, int upperBound) {
    	if (upperBound <= lowerBound) {
    		return;
    	}
    	
    	int pivot = partition(arr, lowerBound, upperBound);
    	quickSortRepeat(arr, lowerBound, pivot - 1);
    	quickSortRepeat(arr, pivot + 1, upperBound);
    }
    
    static int partition(double[] arr, int lowerWall, int upperWall) {
    	double pivot = arr[upperWall];
    	int i = lowerWall - 1;
    	
    	for(int j = lowerWall; j < upperWall; j++) {
    		if(arr[j] <= pivot) {
    			i += 1;
    			swap(arr, i, j);
    		}
    	}
    	int output = i + 1;
    	swap(arr, output, upperWall);
    	return output;
    }
    //end quicksort

    
    
    /**
     * Sorts an array of doubles using Merge Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     * @param a: An unsorted array of doubles.
     * @return array sorted in ascending order
     *
     */
    /**
     * Sorts an array of doubles using iterative implementation of Merge Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     *
     * @param a: An unsorted array of doubles.
     * @return after the method returns, the array must be in ascending sorted order.
     */

    static double[] mergeSort (double a[]) {
    	int lowerBound = 0;
    	int upperBound = a.length - 1;
    	recursiveMerge(a, lowerBound, upperBound);
    	return a;
    }
    
    static void merge(double arr[], int lowerBound, int middle, int upperBound) {
    	int n1 = middle - lowerBound + 1;
    	int n2 = upperBound - middle;
    	
    	double left[] = new double [n1];
    	double right[] = new double [n2];
    	
    	for(int i = 0; i < n1; ++i) {
    		left[i] = arr[lowerBound + i];
    	}
    	for(int j = 0; j < n2; ++j) {
    		right[j] = arr[middle + 1 +j];
    	}
    	
    	/* Merging Temporary Arrays */
    	int i = 0;
    	int j = 0;
    	
    	int k = lowerBound;
    	while(i < n1 && j < n2) {
    		if(left[i] <= right[j]) {
    			arr[k] = left[i];
    			i++;
    		}
    		else {
    			arr[k] = right[j];
    			j++;
    		}
    		k++;
    	}
    	
    	while (i < n1) {
    		arr[k] = left[i];
    		i++;
    		k++;
    	}
    	
    	while (j < n2) {
    		arr[k] = right[j];
    		j++;
    		k++;
    	}
    }
    
    static void recursiveMerge(double arr[], int lowerBound, int upperBound) {
    	if (lowerBound < upperBound) {
    		int middle = (upperBound + lowerBound) / 2;
    		recursiveMerge(arr, lowerBound, middle);
    		recursiveMerge(arr, middle + 1, upperBound);
    		merge(arr, lowerBound, middle, upperBound);
    	}
    }
    
    
    
    /** Swaps two values in an array
     * 
     * @param arr: Array to be affected.
     * @param indexOne: Index of the first value to be swapped.
     * @param indexTwo: Index of the second value to be swapped.
     */
    
    static void swap(double[] arr, int indexOne, int indexTwo) {
    	double temp = arr[indexOne];
    	arr[indexOne] = arr[indexTwo];
    	arr[indexTwo] = temp;
    }
    
    
    /** Reads in a file and parses it to a double[] array
     * 
     * @param filePath: path of file
     * @param n: length of lines in file.
     * @return parsed file
     */
    
    public static double[] parseFile(String filePath, int n) {
    	File input = new File(filePath);
    	double[] output = new double[n];
    	
    	try {
    		Scanner readIn = new Scanner(input);
    		for(int i = 0; (i < n) && (readIn.hasNextLine()); i++) {
    			Double dataPoint = Double.parseDouble(readIn.nextLine());
    			output[i] = dataPoint;
    		}
    	}
    	catch (FileNotFoundException e) {
    		System.out.println(e);
    	}
    	return output;
    }
    
    
    /** 
     * Determine time between start and finish
     * @param args
     */
    
    public static long[] stopWatch(double[] arr) {
    	int trials = 50;
    	long[] results = new long[4];
    	
    	for(int i = 0; i < trials; i++) {
    		
    		// insertionSort
    		long start = System.nanoTime();
    		insertionSort(arr);
    		long end = System.nanoTime();
    		results[0] = end - start;
    		
    		// selectionSort
    		start = System.nanoTime();
    		selectionSort(arr);
    		end = System.nanoTime();
    		results[1] = end - start;
    		
    		// quickSort
    		start = System.nanoTime();
    		quickSort(arr);
    		end = System.nanoTime();
    		results[2] = end - start;
    		
    		// mergeSort
    		start = System.nanoTime();
    		mergeSort(arr);
    		end = System.nanoTime();
    		results[3] = end - start;
    	}
    	results[0] = results[0] / trials;
    	results[1] = results[1] / trials;
    	results[2] = results[2] / trials;
    	results[3] = results[3] / trials;
    	return results;
    }
    
    

    public static void main(String[] args) {
    	double[] numbers1000 = parseFile("numbers1000.txt", 1000);
    	double[] numbers1000Duplicates = parseFile("numbers1000Duplicates.txt", 1000);
    	double[] numbers10000 = parseFile("numbers10000.txt", 10000);
    	double[] numbersNearlyOrdered1000 = parseFile("numbersNearlyOrdered1000.txt", 1000);
    	double[] numbersReverse1000 = parseFile("numbersReverse1000.txt", 1000);
    	double[] numbersSorted1000 = parseFile("numbersSorted1000.txt", 1000);
    	
    	// numbers1000
    	long[] numbers1000Results = stopWatch(numbers1000);
    	System.out.println("numbers1000 insertionSort: " + numbers1000Results[0] + " nanoseconds");
    	System.out.println("numbers1000 selectionSort: " + numbers1000Results[1] + " nanoseconds");
    	System.out.println("numbers1000 quickSort: " + numbers1000Results[2] + " nanoseconds");
    	System.out.println("numbers1000 mergeSort: " + numbers1000Results[3] + " nanoseconds");
    	System.out.println("-------------------------");
    	
    	// numbers1000Duplicates
    	long[] numbers1000DuplicatesResults = stopWatch(numbers1000Duplicates);
    	System.out.println("numbers1000Duplicates insertionSort: " + numbers1000DuplicatesResults[0] + " nanoseconds");
    	System.out.println("numbers1000Duplicates selectionSort: " + numbers1000DuplicatesResults[1] + " nanoseconds");
    	System.out.println("numbers1000Duplicates quickSort: " + numbers1000DuplicatesResults[2] + " nanoseconds");
    	System.out.println("numbers1000 mergeSort: " + numbers1000Results[3] + " nanoseconds");
    	System.out.println("-------------------------");

    	// numbers10000
    	long[] numbers10000Results = stopWatch(numbers1000);
    	System.out.println("numbers10000 insertionSort: " + numbers10000Results[0] + " nanoseconds");
    	System.out.println("numbers10000 selectionSort: " + numbers10000Results[1] + " nanoseconds");
    	System.out.println("numbers10000 quickSort: " + numbers10000Results[2] + " nanoseconds");
    	System.out.println("numbers10000 mergeSort: " + numbers1000Results[3] + " nanoseconds");
    	System.out.println("-------------------------");
    	
    	// numbersNearlyOrdered1000
    	long[] numbersNearlyOrdered1000Results = stopWatch(numbers1000);
    	System.out.println("numbersNearlyOrdered1000 insertionSort: " + numbersNearlyOrdered1000Results[0] + " nanoseconds");
    	System.out.println("numbersNearlyOrdered1000 selectionSort: " + numbersNearlyOrdered1000Results[1] + " nanoseconds");
    	System.out.println("numbersNearlyOrdered1000 quickSort: " + numbersNearlyOrdered1000Results[2] + " nanoseconds");
    	System.out.println("numbersNearlyOrdered1000 mergeSort: " + numbers1000Results[3] + " nanoseconds");
    	System.out.println("-------------------------");
    	
    	// numbersReverse1000
    	long[] numbersReverse1000Results = stopWatch(numbers1000);
    	System.out.println("numbersReverse1000 insertionSort: " + numbersReverse1000Results[0] + " nanoseconds");
    	System.out.println("numbersReverse1000 selectionSort: " + numbersReverse1000Results[1] + " nanoseconds");
    	System.out.println("numbersReverse1000 quickSort: " + numbersReverse1000Results[2] + " nanoseconds");
    	System.out.println("numbersReverse1000 mergeSort: " + numbers1000Results[3] + " nanoseconds");
    	System.out.println("-------------------------");
    	
    	// numbersSorted1000
    	long[] numbersSorted1000Results = stopWatch(numbers1000);
    	System.out.println("numbersSorted1000 insertionSort: " + numbersSorted1000Results[0] + " nanoseconds");
    	System.out.println("numbersSorted1000 selectionSort: " + numbersSorted1000Results[1] + " nanoseconds");
    	System.out.println("numbersSorted1000 quickSort: " + numbersSorted1000Results[2] + " nanoseconds");
    	System.out.println("numbersSorted1000 mergeSort: " + numbers1000Results[3] + " nanoseconds");
    	System.out.println("-------------------------");

    }

 }//end class


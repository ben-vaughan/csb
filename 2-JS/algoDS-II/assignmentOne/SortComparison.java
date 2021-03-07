import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/*							Insert			Selection		Quick			Merge
 * 	1000 Random				6026			4596			4700			1024
 * 	1000 Duplicates			6032			4476			5652			1024
 * 	10000 Random			6028			4476			4706			1024
 * 	1000 Nearly Ordered		6028			4486			4708			1024
 * 	1000 Reversed			6120			4440			4710			1024
 * 	1000 Sorted				6056			4422			4754			1024
 * 
 * 
 *  @author Ben Vaughan
 */

//-------------------------------------------------------------------------
/**
 *  Test class for SortComparison.java
 *
 *  @author Ben Vaughan
 *  @version HT 2020
 */
@RunWith(JUnit4.class)
public class SortComparisonTest
{
    //~ Constructor ........................................................
    @Test
    public void testConstructor()
    {
        new SortComparison();
    }
    
    // ----------------------------------------------------------
    /**
     *  Main Method.
     *  Use this main method to create the experiments needed to answer the experimental performance questions of this assignment.
     *
     */
    public static void main(String[] args)
    {
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

    
    //~ Public Methods ........................................................

    // ----------------------------------------------------------
    /**
     * Check that the methods work for empty arrays
     */
    @Test
    public void testEmpty()
    {
    	double[] test = new double[0];
    	// insertionSort
    	assertEquals("[]", Arrays.toString(SortComparison.insertionSort(test)));
    	// selectionSort
    	assertEquals("[]", Arrays.toString(SortComparison.selectionSort(test)));
    	// quickSort
    	assertEquals("[]", Arrays.toString(SortComparison.quickSort(test)));
    	// mergeSort
    	assertEquals("[]", Arrays.toString(SortComparison.mergeSort(test)));
    }
    
    @Test
    public void testInsertionSort() 
    {	  
    	// Test unsorted array
    	double[] sorted = {2.3, 4.21, 5.53, 7.23, 33.43};
    	double[] toSort = {4.21, 5.53, 33.43, 7.23, 2.3};
    	assertEquals(Arrays.toString(sorted), Arrays.toString(SortComparison.insertionSort(toSort)));

    	// Test already sorted array
    	assertEquals(Arrays.toString(sorted), Arrays.toString(SortComparison.insertionSort(sorted)));
    }
    
    @Test
    public void testSelectionSort() 
    {
    	double[] sorted = {2.3, 4.21, 5.53, 7.23, 33.43};
    	double[] toSort = {4.21, 5.53, 33.43, 7.23, 2.3};
    	assertEquals(Arrays.toString(sorted), Arrays.toString(SortComparison.selectionSort(toSort)));
    	
    	assertEquals(Arrays.toString(sorted), Arrays.toString(SortComparison.insertionSort(toSort)));
    }
    
    @Test
    public void testQuickSort() 
    {
    	// Test unsorted array
    	double[] sorted = {2.3, 4.21, 5.53, 7.23, 33.43};
    	double[] toSort = {4.21, 5.53, 33.43, 7.23, 2.3};
    	assertEquals(Arrays.toString(sorted), Arrays.toString(SortComparison.quickSort(toSort)));

    	// Test already sorted array
    	assertEquals(Arrays.toString(sorted), Arrays.toString(SortComparison.quickSort(sorted)));
    }
    
    @Test
    public void testMergeSort() {
    	// Test unsorted array
    	double[] sorted = {2.3, 4.21, 5.53, 7.23, 33.43};
    	double[] toSort = {4.21, 5.53, 33.43, 7.23, 2.3};
    	assertEquals(Arrays.toString(sorted), Arrays.toString(SortComparison.mergeSort(toSort)));

    	// Test already sorted array
    	assertEquals(Arrays.toString(sorted), Arrays.toString(SortComparison.mergeSort(sorted)));
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
    		SortComparison.insertionSort(arr);
    		long end = System.nanoTime();
    		results[0] = end - start;
    		
    		// selectionSort
    		start = System.nanoTime();
    		SortComparison.selectionSort(arr);
    		end = System.nanoTime();
    		results[1] = end - start;
    		
    		// quickSort
    		start = System.nanoTime();
    		SortComparison.quickSort(arr);
    		end = System.nanoTime();
    		results[2] = end - start;
    		
    		// mergeSort
    		start = System.nanoTime();
    		SortComparison.mergeSort(arr);
    		end = System.nanoTime();
    		results[3] = end - start;
    	}
    	results[0] = results[0] / trials;
    	results[1] = results[1] / trials;
    	results[2] = results[2] / trials;
    	results[3] = results[3] / trials;
    	return results;
    }  
    

}


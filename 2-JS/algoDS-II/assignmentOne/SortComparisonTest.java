import static org.junit.Assert.assertEquals;

import java.util.Arrays;

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
 *  @author
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
    	
    // ----------------------------------------------------------
    /**
     *  Main Method.
     *  Use this main method to create the experiments needed to answer the experimental performance questions of this assignment.
     *
     */
    public static void main(String[] args)
    {
        //TODO: implement this method
    }
    
    

}


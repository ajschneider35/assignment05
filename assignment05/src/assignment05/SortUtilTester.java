package assignment05;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;

import org.junit.Test;

/**
 * JUnit Test class for the SortUtil class.
 * 
 * @author Andrew Schneider
 * @author Connor Ottenbacher
 * @version 2/18/2016
 *
 */
public class SortUtilTester {

	@Test
	public void testQuickSort() {
		ArrayList<Integer> result = SortUtil.generateAverageCase(200);
		ArrayList<Integer> list = SortUtil.generateAverageCase(200);
		Collections.sort(result);

		SortUtil.quicksort(list, new sortInteger());
		
		for(int i = 0; i < list.size(); i++)
			assertEquals(result.get(i), list.get(i));
	}
	
	@Test
	public void QuicksortEmptyList() {
		ArrayList<Integer> result = new ArrayList<Integer>();
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		SortUtil.quicksort(list, new sortInteger());
		
		assertEquals(result.size(), list.size());
		assertEquals(0, list.size());
	}
	
	@Test
	public void QuicksortAlreadySorted() {
		ArrayList<Integer> result = SortUtil.generateBestCase(200);
		ArrayList<Integer> list = SortUtil.generateBestCase(200);
		
		SortUtil.quicksort(list, new sortInteger());
		
		for(int i = 0; i < list.size(); i++)
			assertEquals(result.get(i), list.get(i));
	}
	
	@Test
	public void QuicksortReverseSorted() {	
		ArrayList<Integer> result = SortUtil.generateBestCase(200);
		ArrayList<Integer> list = SortUtil.generateWorstCase(200);
		
		SortUtil.quicksort(list, new sortInteger());
		
		for(int i = 0; i < list.size(); i++)
			assertEquals(result.get(i), list.get(i));
	}
	
	@Test
	public void QuicksortAllTheSameItemsInList() {
		ArrayList<Integer> result = new ArrayList<Integer>();
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int i = 0; i < 200; i++) {
			result.add(1);
			list.add(1);
		}
		
		SortUtil.quicksort(list, new sortInteger());
		
		for(int i = 0; i < list.size(); i++)
			assertEquals(result.get(i), list.get(i));
	}

	@Test
	public void testMergeSort() {
		ArrayList<Integer> result = SortUtil.generateAverageCase(200);
		ArrayList<Integer> list = SortUtil.generateAverageCase(200);
		Collections.sort(result);

		SortUtil.mergesort(list, new sortInteger());
		
		for(int i = 0; i < list.size(); i++)
			assertEquals(result.get(i), list.get(i));

	}
	
	@Test
	public void MergesortEmptyList() {
		ArrayList<Integer> result = new ArrayList<Integer>();
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		SortUtil.mergesort(list, new sortInteger());
		
		assertEquals(result.size(), list.size());
		assertEquals(0, list.size());
	}
	
	@Test
	public void MergesortAlreadySorted() {
		ArrayList<Integer> result = SortUtil.generateBestCase(200);
		ArrayList<Integer> list = SortUtil.generateBestCase(200);
		
		SortUtil.mergesort(list, new sortInteger());
		
		for(int i = 0; i < list.size(); i++)
			assertEquals(result.get(i), list.get(i));
	}
	
	@Test
	public void MergesortReverseSorted() {	
		ArrayList<Integer> result = SortUtil.generateBestCase(200);
		ArrayList<Integer> list = SortUtil.generateWorstCase(200);
		
		SortUtil.mergesort(list, new sortInteger());
		
		for(int i = 0; i < list.size(); i++)
			assertEquals(result.get(i), list.get(i));
	}
	
	@Test
	public void MergesortAllTheSameItemsInList() {
		ArrayList<Integer> result = new ArrayList<Integer>();
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int i = 0; i < 200; i++) {
			result.add(1);
			list.add(1);
		}
		
		SortUtil.mergesort(list, new sortInteger());
		
		for(int i = 0; i < list.size(); i++)
			assertEquals(result.get(i), list.get(i));
	}

	@Test
	public void testFindPivot() {
		ArrayList<Integer> test = new ArrayList<Integer>();
		test.add(1);
		test.add(2000);
		test.add(2000);

		Random rand = new Random();

		assertEquals((Integer) 2000, SortUtil.findPivot(test, 0, test.size() - 1,
				"Median", new sortInteger(), rand));

	}
	
	public class sortInteger implements Comparator<Integer> {

		public int compare(Integer int1, Integer int2) {
			return int1.compareTo(int2);
		}
	}

}

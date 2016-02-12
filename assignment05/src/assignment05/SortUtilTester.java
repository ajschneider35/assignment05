package assignment05;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import org.junit.Test;

/**
 * JUnit Test class for the SortUtil class.
 * 
 * @author Andrew Schneider
 * @author Connor Ottenbacher
 * @version 2/11/2016
 *
 */
public class SortUtilTester {

	@Test
	public void testQuickSort() {
		ArrayList<Integer> result = SortUtil.generateAverageCase(15);
		ArrayList<Integer> list = SortUtil.generateAverageCase(15);
		Collections.sort(result);

		class sortInteger implements Comparator<Integer> {

			public int compare(Integer int1, Integer int2) {
				return int1.compareTo(int2);
			}
		}
		SortUtil.quicksort(list, 0, list.size() - 1, new sortInteger());

		assertEquals(result, list);

	}

	@Test
	public void testMergeSort() {
		ArrayList<Integer> result = SortUtil.generateAverageCase(15);
		ArrayList<Integer> list = SortUtil.generateAverageCase(15);
		Collections.sort(result);

		class sortInteger implements Comparator<Integer> {

			public int compare(Integer int1, Integer int2) {
				return int1.compareTo(int2);
			}
		}
		SortUtil.mergesort(list, new sortInteger());

		assertEquals(result, list);

	}

}

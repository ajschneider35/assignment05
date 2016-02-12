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
		SortUtil.quicksort(list, new sortInteger());

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

	@Test
	public void testFindPivot() {
		ArrayList<Integer> test = new ArrayList<Integer>();
		test.add(1);
		test.add(2000);
		test.add(2000);
		class sortInteger implements Comparator<Integer> {

			public int compare(Integer int1, Integer int2) {
				return int1.compareTo(int2);
			}
		}
		Random rand = new Random();

		assertEquals((Integer) 2000, SortUtil.findPivot(test, 0, test.size() - 1,
				"Median", new sortInteger(), rand));

	}

}

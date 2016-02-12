package assignment05;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

/**
 * FILL IN
 * @author Andrew Schneider
 * @author Connor Ottenbacher
 * @version 2/18/2016
 *
 */
public class SortUtil {
	
	/**
	 * This method performs a mergesort on the generic ArrayList given as input.
	 * Driver method.
	 * @param list
	 * @param cmp
	 */
	public static <T> void mergesort(ArrayList<T> list, Comparator<? super T> cmp) {
		//TODO
	}
	
	/**
	 * This method performs a quicksort on the generic ArrayList given as input.
	 * Driver method.
	 * @param list
	 * @param cmp
	 */
	public static <T> void quicksort(ArrayList<T> list, Comparator<? super T> cmp) {
		//TODO
	}
	
	/**
	 * This method generates and returns an ArrayList of integers 1 to size in ascending order.
	 * @param size
	 * @return
	 */
	public static ArrayList<Integer> generateBestCase(int size) {
		
		ArrayList<Integer> intList = new ArrayList<Integer>();
		for(int i = 1; i <= size; i++)
			intList.add(i);
		return intList;
	}
	
	/**
	 * This method generates and returns an ArrayList of integers 1 to size in permuted order 
	 * (i,e., randomly ordered). 
	 * @param size
	 * @return
	 */
	public static ArrayList<Integer> generateAverageCase(int size) {
		
		Random r = new Random();
		ArrayList<Integer> intList = generateBestCase(size);
		int randomIndex;
		int temp;
		
		for(int i = 0; i < size; i++) {
			randomIndex = r.nextInt(size);
			temp = intList.get(i);
			intList.set(i, intList.get(randomIndex));
			intList.set(randomIndex, temp);
		}
		return intList;
	}
	
	/**
	 * This method generates and returns an ArrayList of integers 1 to size in descending order.
	 * @param size
	 * @return
	 */
	public static ArrayList<Integer> generateWorstCase(int size) {
		
		ArrayList<Integer> intList = new ArrayList<Integer>();
		for(int i = size; i >= 1; i--)
			intList.add(i);
		return intList;
	}

}
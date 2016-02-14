package assignment05;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

/**
 * A class that executes a merge sort and a quicksort. Also generates a sorted list, reverse sorted list,
 * and a randomly ordered list of Integers.
 * 
 * @author Andrew Schneider
 * @author Connor Ottenbacher
 * @version 2/18/2016
 *
 */
public class SortUtil {

	private static final int THRESHOLD = 100;
	
	private static Random rand = new Random();

	/**
	 * This method performs a mergesort on the generic ArrayList given as input.
	 * Driver method.
	 * 
	 * @param list
	 * @param cmp
	 */
	public static <T> void mergesort(ArrayList<T> list,
			Comparator<? super T> cmp) {

		ArrayList<T> tempList = new ArrayList<T>();
		tempList.addAll(list);
		mergesort(list, tempList, 0, list.size() - 1, cmp);
	}

	/**
	 * Internal method that makes recursive calls.
	 * 
	 * @param list
	 *            a list of items
	 * @param tempList
	 *            a list to place the merged result
	 * @param left
	 *            left-most index of the subarray
	 * @param right
	 *            right-most index of the subarray
	 * @param cmp
	 */
	private static <T> void mergesort(ArrayList<T> list, ArrayList<T> tempList,
			int left, int right, Comparator<? super T> cmp) {

		// Insertion Sort if size of data is below threshold
		if (list.size() <= THRESHOLD) {
			for (int i = 1; i < list.size(); i++) {
				T temp = list.get(i);
				int j;
				for (j = i - 1; j >= 0 && cmp.compare(temp, list.get(j)) < 0; j--) {
					list.set(j + 1, list.get(j));
				}
				list.set(j + 1, temp);
			}
		} else {

			if (left < right) {

				int center = (left + right) / 2;
				mergesort(list, tempList, left, center, cmp);
				mergesort(list, tempList, center + 1, right, cmp);
				merge(list, tempList, left, center + 1, right, cmp);
			}
		}
	}

	/**
	 * Internal method that merges two sorted halves of a subarray.
	 * 
	 * @param list
	 *            a list of items
	 * @param tempList
	 *            a list to place the merged result
	 * @param leftPos
	 *            left-most index of the subarray
	 * @param rightPos
	 *            index of the start of the second half
	 * @param rightEnd
	 *            right-most index of the subarray
	 * @param cmp
	 */
	private static <T> void merge(ArrayList<T> list, ArrayList<T> tempList,
			int leftPos, int rightPos, int rightEnd, Comparator<? super T> cmp) {

		int leftEnd = rightPos - 1;
		int tempPos = leftPos;
		int numElements = rightEnd - leftPos + 1;

		// Main Loop
		while (leftPos <= leftEnd && rightPos <= rightEnd) {

			if (cmp.compare(list.get(leftPos), list.get(rightPos)) <= 0)
				tempList.set(tempPos++, list.get(leftPos++));
			else
				tempList.set(tempPos++, list.get(rightPos++));
		}
		// Copy the rest of the left half
		while (leftPos <= leftEnd)
			tempList.set(tempPos++, list.get(leftPos++));

		// Copy the rest of the right half
		while (rightPos <= rightEnd)
			tempList.set(tempPos++, list.get(rightPos++));

		// Copy tempList back
		for (int i = 0; i < numElements; rightEnd--) {
			list.set(rightEnd, tempList.get(rightEnd));
			i++;
		}
	}

	/**
	 * This method performs a quicksort on the generic ArrayList given as input.
	 * Driver method.
	 * 
	 * @param list
	 * @param cmp
	 */
	// driver
	public static <T> void quicksort(ArrayList<T> list,
			Comparator<? super T> cmp) {
		if(list.size()!=0){
			quicksort(list, 0, list.size() - 1, cmp);
		}

	}

	// search
	public static <T> void quicksort(ArrayList<T> list, int left, int right,
			Comparator<? super T> cmp) {

		int index = partition(list, left, right, cmp);
		if (left < index - 1)
			quicksort(list, left, index - 1, cmp);
		if (index < right)
			quicksort(list, index, right, cmp);
	}

	// helper
	public static <T> int partition(ArrayList<T> list, int left, int right,
			Comparator<? super T> cmp) {
		int i = left, j = right;
		T tmp;
		T pivot = findPivot(list, left, right, "Median", cmp, rand);

		while (i <= j) {
			while (cmp.compare(list.get(i), pivot) < 0)
				i++;
			while (cmp.compare(list.get(j), pivot) > 0)
				j--;
			if (i <= j) {
				tmp = list.get(i);
				list.set(i, list.get(j));
				list.set(j, tmp);
				i++;
				j--;
			}
		}
		;

		return i;
	}

	// pivot selection
	public static <T> T findPivot(ArrayList<T> list, int left, int right,
			String choice, Comparator<? super T> cmp, Random rand) {
		T pivot;
		switch (choice) {
		// center element
		case "Center": {
			pivot = list.get((left + right) / 2);
			break;
		}
		// Random element in the list
		case "Random": {
			pivot = list.get(left + rand.nextInt(right - left));
			break;
		}
		// median of first, middle, and last elements
		case "Median": {
			T mid = list.get(left + rand.nextInt(right - left));
			T top = list.get(left + rand.nextInt(right - left));
			T bot = list.get(left + rand.nextInt(right - left));
			if (cmp.compare(mid, top)>=0) {
				  if (cmp.compare(top, bot)>=0) {
				    pivot = top;
				  } else if (cmp.compare(mid, bot)>=0) {
				    pivot = bot;
				  } else {
				    return pivot = mid;
				  }
				} else {
				  if (cmp.compare(mid, bot)>=0) {
				    pivot = mid;
				  } else if (cmp.compare(top, bot)>=0) {
				    pivot = bot;
				  } else {
				    pivot = top;
				  }
				}
			break;
		}
		default: {
			pivot = list.get((left + right) / 2);
			break;
		}
		}
		return pivot;
	}

	/**
	 * This method generates and returns an ArrayList of integers 1 to size in
	 * ascending order.
	 * 
	 * @param size
	 * @return
	 */
	public static ArrayList<Integer> generateBestCase(int size) {

		ArrayList<Integer> intList = new ArrayList<Integer>();
		for (int i = 1; i <= size; i++)
			intList.add(i);
		return intList;
	}

	/**
	 * This method generates and returns an ArrayList of integers 1 to size in
	 * permuted order (i,e., randomly ordered).
	 * 
	 * @param size
	 * @return
	 */
	public static ArrayList<Integer> generateAverageCase(int size) {

		Random r = new Random();
		ArrayList<Integer> intList = generateBestCase(size);
		int randomIndex;
		int temp;

		for (int i = 0; i < size; i++) {
			randomIndex = r.nextInt(size);
			temp = intList.get(i);
			intList.set(i, intList.get(randomIndex));
			intList.set(randomIndex, temp);
		}
		return intList;
	}

	/**
	 * This method generates and returns an ArrayList of integers 1 to size in
	 * descending order.
	 * 
	 * @param size
	 * @return
	 */
	public static ArrayList<Integer> generateWorstCase(int size) {

		ArrayList<Integer> intList = new ArrayList<Integer>();
		for (int i = size; i >= 1; i--)
			intList.add(i);
		return intList;
	}

}

package assignment05;

import java.util.Comparator;

/**
 * Timing code for the SortUtil class.
 * @author Andrew Schneider
 * @author Connor Ottenbacher
 * @version 2/18/2016
 *
 */
public class SortUtilTiming {
	
	/**
	 * Initiates a timing analysis
	 * @param args
	 */
	public static void main(String[] args) {
		timeQuicksort(100000, 2000000, 100000, 500, "Quicksort");
		
		//Adjust threshold of mergesort here, 5th parameter
		timeMergesort(1000, 20000, 1000, 75, 1000, "Mergesort");
	}

	/**
	 * Initiates a timing analysis on the Quicksort method in the SortUtil class
	 * 
	 * @param nStart The starting problem size
	 * @param nStop The ending problem size
	 * @param nStep The amount with which to increase the problem size on each iteration
	 * @param timesToLoop The number of times to average the timing measurement at each problem size
	 * @param methodName The name of the method being tested
	 */
	public static void timeQuicksort(int nStart, int nStop, int nStep, int timesToLoop, String methodName) {
		// try computing T(N)/F(N), see if it converges
		long startTime, midpointTime, stopTime;
		System.out.println("\nMethod: " + methodName + " timesToLoop: " + timesToLoop);
		System.out.println("\nN\t\tT(N)");
		System.out.println("---------------------");

		for (int N = nStart; N <= nStop; N += nStep) {
			startTime = System.nanoTime();
			// Run n times to get average time
			//Manually go into SortUtil and change the pivot selection to test all three
			for (int i = 0; i < N; i++) {
				SortUtil.quicksort(SortUtil.generateAverageCase(N), new sortInteger());
			}

			midpointTime = System.nanoTime();

			// Run an empty loop to capture the cost of running the loop
			for (long i = 0; i < timesToLoop; i++) { // empty block
				SortUtil.generateAverageCase(N);
				new sortInteger();
			}

			stopTime = System.nanoTime();

			// Compute the time, subtract the cost of running the loop
			// from the cost of running the loop and doing the lookups.
			// Average it over the number of runs.
			double averageTime = ((midpointTime - startTime) - (stopTime - midpointTime)) / timesToLoop;
			
			System.out.print(N + "\t\t" + averageTime + "\t\t\n");
		}
	}

	/**
	 * Initiates a timing analysis on the Mergesort method in the SortUtil class
	 * 
	 * @param nStart The starting problem size
	 * @param nStop The ending problem size
	 * @param nStep The amount with which to increase the problem size on each iteration
	 * @param timesToLoop The number of times to average the timing measurement at each problem size
	 * @param methodName The name of the method being tested
	 */
	public static void timeMergesort(int nStart, int nStop, int nStep, int timesToLoop, int threshold,
			String methodName) {
		// try computing T(N)/F(N), see if it converges
		long startTime, midpointTime, stopTime;
		System.out.println("\nMethod: " + methodName + " timesToLoop: " + timesToLoop);
		System.out.println("\nN\t\tT(N)");
		System.out.println("---------------------");

		for (int N = nStart; N <= nStop; N += nStep) {
			startTime = System.nanoTime();
			// Run n times to get average time
			for (int i = 0; i < N; i++) {
				SortUtil.mergesort(SortUtil.generateAverageCase(N), new sortInteger());
			}

			midpointTime = System.nanoTime();

			// Run an empty loop to capture the cost of running the loop
			for (long i = 0; i < timesToLoop; i++) { // empty block
				SortUtil.generateAverageCase(N);
				new sortInteger();
			}

			stopTime = System.nanoTime();

			// Compute the time, subtract the cost of running the loop
			// from the cost of running the loop and doing the lookups.
			// Average it over the number of runs.
			double averageTime = ((midpointTime - startTime) - (stopTime - midpointTime)) / timesToLoop;
			
			System.out.print(N + "\t\t" + averageTime + "\t\t\n");
		}
	}
	
	private static class sortInteger implements Comparator<Integer> {

		public int compare(Integer int1, Integer int2) {
			return int1.compareTo(int2);
		}
	}
}

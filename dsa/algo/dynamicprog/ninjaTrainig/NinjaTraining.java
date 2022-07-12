package dsa.algo.dynamicprog.ninjaTrainig;
/*
 * Problem Statement
Ninja is planing this ‘N’ days-long training schedule. Each day, he can perform any one of these three activities. 
(Running, Fighting Practice or Learning New Moves). Each activity has some merit points on each day. 
As Ninja has to improve all his skills, he can’t do the same activity in two consecutive days. 
Can you help Ninja find out the maximum merit points Ninja can earn?

You are given a 2D array of size N*3 ‘POINTS’ with the points corresponding to each day and activity. 
Your task is to calculate the maximum number of merit points that Ninja can earn.
 */


public class NinjaTraining {

	public static void main(String[] args) {
		
	}
	/*
	 * Task done on last day ->
	 * 0 -> task 0
	 * 1 -> task 1
	 * 2 -> task 2
	 * 3 -> No task done
	 */
	private static int ninjaTrainigRecusion(int index, int points[][], int last) {
		int maxi = Integer.MIN_VALUE;

		//base case
		if(index == 0 ) {
			for(int i = 0; i < points[index].length; i++) {
				if(i != last) {
					maxi = Math.min(maxi, points[index][i]);					
				}
			}
			return maxi;
		}
		
		for(int i = 0; i < points[index].length; i++) {
			if(i != last) {
				maxi = Math.max(maxi, points[index][i] + ninjaTrainigRecusion(index-1, points, i));
			}
		}
		
		return maxi;
		
	}
	 public static int ninjaTraining(int n, int points[][]) {
		 
	 }
	 
}

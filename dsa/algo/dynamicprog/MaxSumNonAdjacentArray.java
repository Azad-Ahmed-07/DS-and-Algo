package dsa.algo.dynamicprog;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MaxSumNonAdjacentArray {
	/*
	 * Maximum sum such that no two elements are not adjacent
	 */
	public static void main(String[] args) {
		int[] arr = {-1, -1, 11, -1, 9, 0, 0,11};
		System.out.println(maxNonAdjacentArrayRecusrion(arr));
		System.out.println(maxNonAdjacentArrayMemoization(arr));
		System.out.println(maxNonAdjacentTabulation(arr));
		System.out.println(maxNonAdjacentTabulationSpaceOptimized(arr));
	}
	
	// Non Adjacent Element using Recursion
	private static int maxNonAdjacentArrayRecusrion(int[] arr) {
		return maxNonAdjacentArrayRecusrion(arr.length - 1, arr);
	}
	
	private static int maxNonAdjacentArrayRecusrion(int index, int[] arr) {
		if(index == 0) {
			return arr[index];
		}
		if(index < 0) {
			return 0;
		}
		
		int pick = Math.max( arr[index] + maxNonAdjacentArrayRecusrion(index - 2,arr), arr[index]);
		int notPick = 0 + maxNonAdjacentArrayRecusrion(index-1,arr);
		return Math.max(pick, notPick);
	}
	
	// Max non-adjacent element using Dp - Memoization
	private static int maxNonAdjacentArrayMemoization(int[] arr) {
		int size = arr.length;
		int[] dp = new int[size];
		for(int i = 0; i < dp.length; i++) {
			dp[i] = -1;
		}
		
		return maxNonAdjacentArrayMemoization(arr.length - 1, arr, dp);		
	}
	private static int maxNonAdjacentArrayMemoization(int index,int[] arr, int[] dp) {
		if(index == 0) {
			return arr[index];
		}
		if(index < 0) {
			return 0;
		}
		//return from Dp if already exist in Dp
		if(dp[index] != -1) {
			return dp[index];
		}
		// if the result is decreasing then just pick only the current index value
		int pick = Math.max( arr[index] + maxNonAdjacentArrayMemoization(index - 2,arr,dp), arr[index]);  
		int notPick = 0 + maxNonAdjacentArrayMemoization(index-1,arr,dp);
		
		return dp[index] = Math.max(pick, notPick);
	}
	
	//Dp Tabulation
	private static int maxNonAdjacentTabulation(int[] arr) {
		int[] dp = new int[arr.length];
		for(int i = 0; i < dp.length; i++) {
			dp[i] = -1;
		}
		return maxNonAdjacentTabulation(arr, dp);
	}
	private static int maxNonAdjacentTabulation(int[] arr, int[] dp) {
		dp[0] = arr[0];
		int neg = 0;
		for(int i = 1; i < arr.length; i++) {
			int take = arr[i];
			if(i > 1) {
				take += dp[i-2];
			}
			take = Math.max(take, arr[i]);
			int notTake = 0 + dp[i-1];
			dp[i] = Math.max(take, notTake);
		}
		return dp[arr.length - 1];
	}
	
	// Dp Tabulation Space optimization
	private static int maxNonAdjacentTabulationSpaceOptimized(int[] arr)
	{
		int prev = arr[0];  // Initially prev is at index 0
		int prev2 = 0;      // Initially prev2 is at index -1 
		
		for(int i = 1; i < arr.length;i++) {
			int pick = arr[i] + prev2;
			int notPick = 0 + prev;
			pick = Math.max(pick, arr[i]);
			int curr = Math.max(pick, notPick);
			prev2 = prev;
			prev = curr;
		}
		return prev;
	}
	
}

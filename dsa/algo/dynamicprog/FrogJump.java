package dsa.algo.dynamicprog;
/*
 PROBLEM STATEMENT
 There is a frog on the 1st step of an N stairs long staircase. The frog wants to reach the Nth stair.
 HEIGHT[i] is the height of the (i+1)th stair.If Frog jumps from ith to jth stair,
 the energy lost in the jump is given by |HEIGHT[i-1] - HEIGHT[j-1] |.In the Frog is on ith staircase, 
 he can jump either to (i+1)th stair or to (i+2)th stair. 
 
 Your task is to find the minimum total energy used by the frog to reach from 1st stair to Nth stair.
 
 For Example
	If the given ‘HEIGHT’ array is [10,20,30,10], the answer 20 as the frog can jump from 1st stair to 2nd stair (|20-10| = 10 energy lost) 
	and then a jump from 2nd stair to last stair (|10-20| = 10 energy lost). So, the total energy lost is 20.
 */
public class FrogJump {

	public static void main(String[] args) {
		int[] height = {10,20,30,10};
		
		// Recursion
		System.out.println(frogJumpRecursion(height));
		
		//Memoization
		System.out.println(frogJumpMemoization(height));
		
		//Tabulation
		System.out.println(frogJumpTabulation(height));
		
		// Tabulation - Space Optimized
		System.out.println(frogJumpTabulationSpaceOptimized(height));
	}
	
	// ************  Recursion  ************
	private static int frogJumpRecursion(int[] height) {
		int lIndex = height.length - 1;
		return frogJumpRecursion(lIndex, height);
	}
	private static int frogJumpRecursion(int n, int[] height) {
		//Base case
		if(n == 0) return 0;   // f(n) -> means total cost to go 0 from n   // total cost of 0 -> 0 is 0
		int left = frogJumpRecursion(n-1,height) + Math.abs(height[n] - height[n-1]);
		int right = Integer.MAX_VALUE;
		if(n > 1) {
			right = frogJumpRecursion(n-2,height) + Math.abs(height[n] - height[n-2]);
		}
		
		return Math.min(left, right);
	}
	//************* Memoization *************
	private static int frogJumpMemoization(int[] height) {
		int index = height.length - 1;
		int[] dp = new int[index+1];
		for(int i = 0; i <= index; i++) {
			dp[i] = -1;
		}
		return frogJumpMemoization(index, height, dp);
	}
	private static int frogJumpMemoization(int ind, int[] height, int[] dp) {
		if(dp[ind] != -1) {
			return dp[ind];
		}
		if(ind == 0) return 0;
		int left = frogJumpMemoization(ind-1, height, dp) + Math.abs(height[ind] - height[ind-1]);
		int right = Integer.MAX_VALUE;
		if(ind > 1) {
			right = frogJumpMemoization(ind-2, height, dp) + Math.abs(height[ind] - height[ind - 2]);
		}
		return dp[ind] = Math.min(left, right);
	}
	
	//************ Tabulation ***************
	private static int frogJumpTabulation(int[] height) {
		int n = height.length;
		
		int[] dp = new int[n];
		
		dp[0] = 0;
		for(int i = 1; i < n; i++) {
			int left = Math.abs(height[i] - height[i - 1]) + dp[i-1];
			int right = Integer.MAX_VALUE;
			if(i > 1) {
				right = Math.abs(height[i] - height[i-2]) + dp[i-2];
			}
			dp[i] = Math.min(left, right);
		}
		return dp[n-1];
	}
	
	//**************** Tabulation Space Optimized *******************
	private static int frogJumpTabulationSpaceOptimized(int[] height) {
		int prev1 = 0;
		int prev2 = Math.abs(height[1] - height[0]);
		
		int curri = Math.min(prev1, prev2);
		for(int i = 2; i < height.length; i++) {
			int left = prev1 + Math.abs(height[i] - height[i-1]);
			int right = prev2 + Math.abs(height[i] - height[i-2]);
			
			curri = Math.min(left, right);
			prev1 = prev2;
			prev1 = curri;
			
		}
		return curri;
	}
}

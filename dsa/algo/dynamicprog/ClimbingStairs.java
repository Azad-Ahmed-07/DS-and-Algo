package dsa.algo.dynamicprog;
/*
 You are climbing a staircase. It takes n steps to reach the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 */
public class ClimbingStairs {

	public static void main(String[] args) {
		int n = 3;
		System.out.println(climbStairsRecursion(n));
		
		//memoization
		int[] dp = new int[n+1];
		System.out.println(climbStairsmemoization(n, dp));
		
		//Tabulation
		System.out.println(climbStairsTabulation(n));
		
		//Tabulation
		System.out.println(climbStairsTabSpaceOptimization(n));
		

	}
	
	private static int climbStairsRecursion(int n) {
		if(n == 0) return 0;
        if(n == 1 ) return 1;
        if(n == 2) return 2;
        
        return climbStairsRecursion(n-1) + climbStairsRecursion(n-2);
	}
	
	private static int climbStairsmemoization(int n, int[] memo) {
		if(memo[n] != 0) return memo[0];
		if(n == 0) return 0;
		if(n == 1) return 1;
		if(n == 2) return 2;
		
		return memo[n] = climbStairsmemoization(n-1,memo) + climbStairsmemoization(n-2,memo);
	}
	
	private static int climbStairsTabulation(int n) {
		int[] dp = new int[n+1];
		for(int i = 0; i <= n; i++) {
			if(i == 0) dp[i] = 0;
			else if(i == 1) dp[i] = 1;
			else if(i == 2) dp[i] = 2;
			else {
				dp[i] = dp[i-1] + dp[i-2];
			}
		}
		return dp[n];
	}

	private static int climbStairsTabSpaceOptimization(int n) {
		int prev1 = 0;
		int prev2 = 1;
		int res = 0;
		if( n == 2) return 2;
		for(int i = 1; i <= n; i++) {
			res = prev1 + prev2;
			prev1 = prev2;
			prev2 = res;
		}
		return res;
	}
}

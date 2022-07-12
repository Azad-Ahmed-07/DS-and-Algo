package dsa.algo.dynamicprog.dp_gid.TotalUniquePath;
/*
 * https://leetcode.com/problems/unique-paths/
 * 
 * There is a robot on an m x n grid. The robot is initially located at the top-left corner (i.e., grid[0][0]). 
 * The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]). The robot can only move either down or right at 
 * any point in time.

   Given the two integers m and n, return the number of possible unique paths that the robot can take to reach the bottom-right corner.
 */
public class TotalUniquePath {

	public static void main(String[] args) {
		int m = 3, n = 7;
		int recursionAns = totalUniquePathRecursion(m-1, n-1);
		System.out.println(recursionAns);
		
		System.out.println(totalUniquePathMemoization(m-1,n-1));
		
		System.out.println(totalUniquePathTabulation(m-1,n-1));
		
		System.out.println(totalUniquePathTabulationSpaceOpt(m-1,n-1));
	}
	// m and n is the index of bottom-bottom right corner
	private static int totalUniquePathRecursion(int m, int n ) {
		if( m == 0 && n == 0) {
			return 1;
		}
		if( m < 0 || n < 0) {
			return 0;
		}
		int up = totalUniquePathRecursion( m -1, n);
		int left = totalUniquePathRecursion(m, n-1);
		return up + left;
	}
	
	// Memoization
	private static int totalUniquePathMemoization(int i, int j) {
		int[][] dp = new int[i+1][j+1];
		//Initialize dp with -1
		for(int r = 0; r < i+1; r++) {
			for(int c = 0; c < j+1; c++) {
				dp[r][c] = -1;
			}
		}
		return totalUniquePathMemoization(i, j, dp);
		
	}
	private static int totalUniquePathMemoization(int i, int j, int[][] dp) {
		if( i == 0 && j == 0) {
			return 1;
		}
		if( i < 0 || j < 0) {
			return 0;
		}
		if(dp[i][j] != -1) {
			return dp[i][j];
		}
		int up = totalUniquePathMemoization( i -1, j, dp);
		int left = totalUniquePathMemoization(i, j-1, dp);
		return dp[i][j] = up + left;
	}
	// Tabulation
	private static int totalUniquePathTabulation(int i, int j) {
		int[][] dp = new int[i+1][j+1];
		
		// Base case
		dp[0][0] = 1;
		for(int r = 0; r <= i; r++) {
			for(int c = 0; c <= j; c++) {
				if(r == 0 && c == 0 ) {
					dp[r][c] = 1 ;
					continue;
				}else {
					int up = 0;
					int left = 0;
					if(r > 0)  up = dp[r-1][c];
					if(c > 0)  left = dp[r][c-1];
					dp[r][c] = up + left;
				}
				
			}
		}
		return dp[i][j];
	}
	
	//Tabulation - Space Optimized
	/*
	 * @param1 and @param2 are index
	 */
	private static int totalUniquePathTabulationSpaceOpt(int i, int j) {
		int[] dp = new int[j+1];
		
		for(int r = 0; r <= i; r++) {
			int prev = 0;
			for(int c = 0; c <= j; c++) {
				if(r == 0 && c == 0) {
					dp[c] = 1;
				}else {
					int up = 0;
					int left = 0;
					if(r > 0)  up = dp[c];
					if(c > 0)  left = dp[c-1];
					dp[c] = up + left;
				}
			}
		}
		return dp[j];
	}
}

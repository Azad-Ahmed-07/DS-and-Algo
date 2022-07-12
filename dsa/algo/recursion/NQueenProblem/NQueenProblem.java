package dsa.algo.recursion.NQueenProblem;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/*
 * The n-queens puzzle is the problem of placing n queens on an n x n chess board such that no two queens attack each other.
 */
public class NQueenProblem {

	public static void main(String[] args) {
		int n;
		System.out.println("Enter Board size");
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		
		printMatrix(solveNQueens(n));
		
	}
	
	// TC -> N! ( Combination Check ) X N ( For loop ) X 3N (isSafeToPlaceQueen)
	private static List<List<String>> solveNQueens(int n){
		List<List<String>> ans = new ArrayList<>();
		List<String> board = new ArrayList<>();
		//Poulate Empty Board
		String rowString = "";
		for(int i =0; i < n; i++) {
			rowString += "_";
		}
		for(int i = 0; i < n; i++) {
			board.add(rowString);
		}
		solve(0, ans, board, n);
		System.out.println("Total combination possible -> "+ans.size());
		return ans;
	}
	private static void solve(int col, List<List<String>> ans, List<String> board, int size ) {
		if(col == size) {
			ans.add(new ArrayList<String>(board));
			return;
		}
		
		for(int row = 0; row < size; row++) {
			if(isSafeToPlaceQueen(row,col,board,size)) {
				board.set(row,placeQueen(board.get(row), col ));
				solve(col+1, ans, board, size);
				board.set(row,removeQueen(board.get(row), col ) );
			}
		}
		
	}
	private static String placeQueen(String str, int index) {
		char[] charArr = str.toCharArray();
		charArr[index] = 'Q';
		
		return new String(charArr);
	}
	private static String removeQueen(String str, int index) {
		char[] charArr = str.toCharArray();
		charArr[index] = '_';
		return new String(charArr);
	}
	private static boolean isSafeToPlaceQueen(int row, int col, List<String> board, int size) {
		int dupRow = row, dupCol = col;
		//Check current row
		String rowString = board.get(row);
		while(dupCol >= 0) {
			if(rowString.charAt(dupCol) == 'Q') {
				return false;
			}
			dupCol--;
		}
		
		//check upper diagonal
		dupCol = col - 1;
		dupRow = row - 1;
		while(dupRow >=0 && dupCol >= 0) {
			if(board.get(dupRow).charAt(dupCol) == 'Q') {
				return false;
			}
			dupRow--;
			dupCol--;
		}
		
		//Check lower diagonal
		dupCol = col - 1;
		dupRow = row + 1;
		while( dupCol > 0 && dupRow < size ) {
			if(board.get(dupRow).charAt(dupCol) == 'Q') {
				return false;
			}
			dupRow++;
			dupCol--;
		}
		
		return true;
	}
	private static void printMatrix(List<List<String>> mtrx) {
		for(List<String> list : mtrx){
			System.out.println("<--------------------------------------->");
			for(String str : list) {
				char[] charArr = str.toCharArray();
				for(char c : charArr) {
					System.out.print(" "+c+" ");
				}
				System.out.println();
			}
			System.out.println("<--------------------------------------->");
		}
	}
	
}

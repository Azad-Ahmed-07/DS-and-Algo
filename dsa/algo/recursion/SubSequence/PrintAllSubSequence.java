package dsa.algo.recursion.SubSequence;

import java.util.*;

public class PrintAllSubSequence {
	/*
	 * Sub-sequence - A contigious/Non-contigious sequence which follows the order.
	 */
	public static void main(String[] args) {
		int[] arr = new int[]{3, 1, 2};
		printAllSubSequence(arr, arr.length);
		
	}
	private static void printAllSubSequence(int[] arr, int n) {
		List<Integer> ds = new ArrayList<>();
		printAllSubSequenec(0, ds, arr, n);
		
	}
	private static void printAllSubSequenec(int index, List<Integer> ds, int[] arr, int n) {
		if(index == n) {  // If index has reached the size(n) iteration is done over arr
			if(ds.size() == 0) {
				System.out.println("{}");
			}
			for(int i : ds) {
				System.out.print(i+" ");
			}
			System.out.print("\n");
			return;
		}
		
		//Pick the current index to the sub-sequence
		ds.add(arr[index]);
		printAllSubSequenec(index+1, ds, arr, n);
		ds.remove(ds.size() - 1);   // remove for backtrack
		
		// Not Pick the current index to the sub-sequence
		printAllSubSequenec(index+1, ds, arr, n);
		
	}

}

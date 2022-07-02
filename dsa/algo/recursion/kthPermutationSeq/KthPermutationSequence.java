package dsa.algo.recursion.kthPermutationSeq;

import java.util.*;

/*
 * The set [1, 2, 3, ..., n] contains a total of n! unique permutations.

By listing and labeling all of the permutations in order, we get the following sequence for n = 3:

"123"
"132"
"213"
"231"
"312"
"321"
Given n and k, return the kth permutation sequence.
 */

public class KthPermutationSequence {

	public static void main(String[] args) {
		
		System.out.println(getPermutation(3, 3));
	}
	
	 public static String getPermutation(int n, int k) {
	        int fact = 1;
	        List<Integer> nums = new ArrayList<>();
	        for(int i = 1; i <=n; i++ ){
	            nums.add(i);
	            fact = fact * i;
	        }
	        k = k - 1; // As the number is zero based index
	        String ans = "";
			while(nums.size()>0) {
				int secLength = fact / n;
				int index = k / secLength;
				ans += nums.get(index);
				nums.remove(index);
				fact = fact/n;
				n -= 1;
				k = k % secLength;
			}
	        return ans;
	    }

}

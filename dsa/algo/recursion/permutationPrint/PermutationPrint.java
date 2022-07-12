package dsa.algo.recursion.permutationPrint;

import java.util.*;

public class PermutationPrint {

	public static void main(String[] args) {
		int[] nums = {3, 2, 1};
		List<List<Integer>> retArr = permute(nums);
		for( List<Integer> var : retArr) {
			String res = "";
			for(int num : var) {
				res += num;
			}
			System.out.println(res);
		}

	}
	private static void recurPermute(int[] nums, List<Integer> ds, List<List<Integer>> ans, boolean []freq) {
		//Base condition - check ds is full or not
		if(ds.size() == nums.length) {
			ans.add(new ArrayList<>(ds));
			return;
		}
		for(int i = 0; i < nums.length; i++) {
			if(!freq[i]) {
				// Adding picked number and true in the frq.
				freq[i] = true;
				ds.add(nums[i]);
				recurPermute(nums, ds, ans, freq);
				// removing picked number and set picked false in freq[] - After backtrack
				ds.remove(ds.size() - 1);
				freq[i] = false;
			}
		}
	}
	
	public static List<List<Integer>> permute(int[] nums){
		List<List<Integer>> ans = new ArrayList<>();
		List<Integer> ds = new ArrayList<>();
		boolean freq[] = new boolean[nums.length];
		recurPermute(nums, ds, ans, freq);
		return ans;
	}

}

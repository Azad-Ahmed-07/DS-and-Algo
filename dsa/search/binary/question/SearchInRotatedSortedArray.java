package dsa.search.binary.question;
/*
 33. Search in Rotated Sorted Array
Medium

Add to List

Share
There is an integer array nums sorted in ascending order (with distinct values).

Prior to being passed to your function, nums is possibly rotated at an unknown pivot index k (1 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].

Given the array nums after the possible rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.

You must write an algorithm with O(log n) runtime complexity.
 */

public class SearchInRotatedSortedArray {

	public static void main(String[] args) {
		int[] arr = {6, 5, 3, 2, 1};
		System.out.println(findPivot(arr));
	}
	
	private static int searchInRotatedArray(int[] arr, int target) {
		int start = 0;
		int end = arr.length - 1;
		
		//find Pivot point (Index where array is rotated )
		return -1;
		
	}
	
	private static int findPivot(int[] arr) {
		int start = 0;
		int end = arr.length - 1;
		
		while(start < end) {
			int mid = start + ( end - start)/2;
			if(arr[mid ] > arr[mid + 1 ]) {  //if next element of mid is bigger, then mid will be pivot
				return mid;
			}else {
				start = mid + 1;
			}
		}
		return start;
	}
}

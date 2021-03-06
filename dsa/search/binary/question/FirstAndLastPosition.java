package dsa.search.binary.question;
//https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
/*
 * 34. Find First and Last Position of Element in Sorted Array
Medium
Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.

If target is not found in the array, return [-1, -1].

You must write an algorithm with O(log n) runtime complexity.

 

Example 1:

Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]
Example 2:

Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]
Example 3:

Input: nums = [], target = 0
Output: [-1,-1]
 

Constraints:

0 <= nums.length <= 105
-109 <= nums[i] <= 109
nums is a non-decreasing array.
-109 <= target <= 109
 */

public class FirstAndLastPosition {

	public static void main(String[] args) {
		
		
	}
	public static int[] search(int[] nums, int target) {
		int[] ans = {-1, -1 };
		// check the first occurenace 
		ans[0] = searchInArray(nums, target, true);
		if(ans[0] != -1 ) {
			ans[1] = searchInArray(nums, target, false);
		}
		return ans;
	}
	
	private static int searchInArray(int[] nums, int target, boolean isFirstOccurance) {
		int start = 0;
		int end = nums.length - 1;
		int ansIndex = -1;
		
		while(start <= end) {
			int mid = start + (end - start)/2;
			
			if(nums[mid] < target) {
				start = mid + 1;
			}else if(nums[mid] > target) {
				end = mid -1;
			}else { // target == nums[mid]
				//Possible ans found
				ansIndex = mid;
				
				if(isFirstOccurance) {
					end = mid - 1;
				}else {
					start = mid + 1;
				}
			}
		}
		return ansIndex;
	}

}

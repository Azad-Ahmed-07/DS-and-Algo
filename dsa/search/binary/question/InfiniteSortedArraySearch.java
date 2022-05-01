package dsa.search.binary.question;
/*
Find position of an element in a sorted array of infinite numbers

Suppose you have a sorted array of infinite numbers, how would you search an element in the array?
*/
public class InfiniteSortedArraySearch {

	public static void main(String[] args) {
		int arr[] = {3, 5, 7, 9, 10, 90, 100, 130, 140, 160, 170};
		System.out.println(infiniteArraySearch(arr, 100));
		
		// Target more than 170 will return index out of bound exception 

	}
	
	private static int infiniteArraySearch(int[] nums, int target) {
		// As the array is infinite we can not use array length function 
		int start = 0;
		int end = 1;
		
		// As the array is sorted, Have to detemine the rannge ( i.e end is < target )
		while(nums[end] < target) {
			int newStart = end + 1;
			end = newStart + (end-start)*2;
			start = newStart;
		}
		
		return binarySearch(nums, start, end, target);
	}
	
	private static int binarySearch(int[] nums, int start, int end, int target) {
		
		while(start <= end) {
			int mid = start + (end - start)/2;
			if(nums[mid] > target) {
				end = mid -1 ;
			}else if(nums[mid] < target) {
				start = mid + 1;
			}else {
				return mid;
			}
		}
		return -1;
	}

}

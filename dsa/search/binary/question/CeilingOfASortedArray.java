package dsa.search.binary.question;

/*
 * For example, let the input array be {1, 2, 8, 10, 10, 12, 19}
 * For x = 0:    floor doesn't exist in array,  ceil  = 1
 * For x = 1:    floor  = 1,  ceil  = 1
 * For x = 5:    floor  = 2,  ceil  = 8
 * For x = 20:   floor  = 19,  ceil doesn't exist in array
 */

public class CeilingOfASortedArray {

	public static void main(String[] args) {
		int[] arr = {1, 2, 8, 10, 10, 12, 19};
		
		int ans = ceilSearch(arr, 11);
		System.out.println(ans);
		
	}
	
	private static int ceilSearch(int[] arr, int target) {
		int start = 0;
		int end = arr.length - 1;
		// Boundery condition 
		
		// If target is smaller than or equal to first element
		// then return the first element
		
		if(target <= arr[start])
			return start;
		
		// If target is greater than last element than return -1 
		if(target > arr[end])
			return -1;
		
		while(start < end ) {
			
			//midle of the element
			int mid = start + (end - start)/2;
			
			if(arr[mid] == target) {
				return mid;
			}else if(arr[mid] > target) {
				end = mid + 1;
			}else {
				start = mid + 1;
			}
		}
		// If not found then return end, As we already checked boundary condition 
		return end;
		
	}
	
	private static int floorSearch(int[] arr, int target) {
		int start = 0;
		int end = arr.length - 1;
		// Boundery condition 
		
		// If target is smaller than or equal to first element
		// then return the first element
		
		if(target <= arr[start])
			return start;
		
		// If target is greater than last element than return -1 
		if(target > arr[end])
			return -1;
		
		while(start < end ) {
			
			//midle of the element
			int mid = start + (end - start)/2;
			
			if(arr[mid] == target) {
				return mid;
			}else if(arr[mid] < target) {
				start = mid;
			}else {
				end = mid - 1;
			}
		}
		return start;
	}

}

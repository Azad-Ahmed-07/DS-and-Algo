package dsa.search.binary.code;

public class BinarySearch {

	public static void main(String[] args) {
		 int[] arr = {-18, -12, -4, 0, 2, 3, 4, 15, 16, 18, 22, 45, 89};
		 int target = 22;
		 int ans = binarySearch(arr, target);
		 
		 System.out.println(ans);
	}
	/**
	 * Return the target index
	 * @param arr
	 * @param target
	 * @return Return the index or return -1 if does not exist
	 */
	private static int binarySearch(int[] arr, int target) {
		int start = 0;
		int end = arr.length ;
		
		while(start <= end ) {
			// Find the middle element 
			// int mid = (start + end )/2; // might be possible that (start + end ) exceeds the range of int in java
			int mid = start + (end - start ) / 2;
			
			if(target < arr[mid]) {
				end = mid -1;
			}else if ( target > arr[mid]) {
				start = mid + 1;
			}else {
				//ans found
				return mid;
			}
		}
		// If not found 
		return -1;
	}

}

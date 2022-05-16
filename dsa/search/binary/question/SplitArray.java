package dsa.search.binary.question;

public class SplitArray {

	public static void main(String[] args) {
		
	}

	public int splitArray(int[] nums, int m) {
		int start = 0;
		int end = 0;
		
		for(int num : nums) {
			start = Math.max(start, num);  //At the end of the loop, Start will store the max in the Array
			end += num;
		}  // Start is the if the array is divided to one element in per chunks
		// end the if the Array is not divided
		
		// Binary Search
		while(start < end) {
			//try for the middle as the potential answer
			int mid = start + (end-start)/2;
			
			// Return how many pieces you can break to get the max sum
			int sum = 0;
			int piece = 1;
			for(int num : nums) {
				if(sum + num > mid) { 
					// Can not add to that Sub array, make new one and sum = num
					sum = num;
					piece++;
				}else {
					sum += num;
				}
			}
			
			if(piece > m) {
				start = mid + 1;
			}else {
				end = mid;
			}
		}
		return end;
	}
}

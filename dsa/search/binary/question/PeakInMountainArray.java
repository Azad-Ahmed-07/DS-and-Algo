package dsa.search.binary.question;

public class PeakInMountainArray {

	public static void main(String[] args) {
		int[] arr = {1, 5,4,3,2,1,0};
		System.out.println(searchInMountainArray(arr));

	}
	private static int searchInMountainArray(int[] arr ) {
		int start = 0;
		int end = arr.length - 1;
		
		while(start <= end) {
			int mid = start + (end - start)/2;
			
			if(arr[mid] > arr[mid+1]) {
				end = mid -1 ;
			}else {
				start = mid + 1;
			}
		}
		return start;
	}
}

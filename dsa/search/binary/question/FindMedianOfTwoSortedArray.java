package dsa.search.binary.question;
/*
 * Median of two sorted Arrays different size
 * 
 * Given two sorted arrays, a[] and b[], the task is to find the median of these sorted arrays, 
 * in O(log n + log m) time complexity, when n is the number of elements in the first array, 
 * and m is the number of elements in the second array.
 */
public class FindMedianOfTwoSortedArray {

	public static void main(String[] args) {
		int[] arr1 = {1};
		int[] arr2 = {2,3,4,5,6};
		
		System.out.println(new FindMedianOfTwoSortedArray().findMedianSortedArrays(arr1,arr2));
	}
	
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
	        
		if(nums1.length > nums2.length) {
			return findMedianSortedArrays(nums2, nums1);
		}
        
		
		int size1 = nums1.length;
		int size2 = nums2.length;
		
		int total = size1 + size2;
		
		int low1 = 0;
		int high1 = size1 - 1;

		while(true) {
			int mid1 = (low1 <= high1) ? (low1 + high1)/2 : -1;
			int mid2 = total/2 - (mid1 + 1)  - 1;
			
			int left1 = (mid1 < 0 ) ? Integer.MIN_VALUE : nums1[mid1];
			int left2 = (mid2 < 0 ) ? Integer.MIN_VALUE : nums2[mid2];
			
			int right1 = (mid1 >= nums1.length - 1) ? Integer.MAX_VALUE : nums1[mid1+1];
			int right2 = (mid2 >= nums2.length - 1) ? Integer.MAX_VALUE : nums2[mid2+1];
			
			if(left1 <= right2 && left2 <= right1) {
				if(total % 2 == 0) {
					// Total merge Array is even
					return (float) ((Math.max(left1, left2) + Math.min(right1, right2))/2.0);
				}else {
					return Math.min(right1,right2);
				}
			}else if(left1 >= right2) {
				high1 = mid1 - 1;
			}else {
				low1 = mid1 + 1;
			}
 		}
	
    }
	
/*
 * Time Complexity: O(min(log m, log n)): Since binary search is being applied on the smaller of the 2 arrays
 * Auxiliary Space: O(1)
 * 
 */
}

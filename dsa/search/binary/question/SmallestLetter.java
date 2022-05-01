package dsa.search.binary.question;
// https://leetcode.com/problems/find-smallest-letter-greater-than-target/
public class SmallestLetter {

	public static void main(String[] args) {
		
		

	}
	public static char nextGreatestLetter(char[] letters, char target) {
		int start = 0;
		int end = letters.length - 1;
		 
		while(start <= end) {
			int mid = start + (end - start)/2;
			
			if(target < letters[mid]) {
				start = mid + 1;
			}else {
				end = mid - 1;
			}
		}
		
		//We can not return only start as, start may be greater than last index
		//eg. [ c , f, j ] and target id j . Letter is wrap around in the condition of question
		//i.e have to return first index iff doesn't exist greater element in that array
		return letters[start % letters.length];
	}
}

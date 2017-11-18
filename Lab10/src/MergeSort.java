/*
 * Purpose: Data Structure and Algorithms Lab 10
 * Status: Complete and thoroughly tested
 * Last update: 11/18/17
 * @author: Conor J. Mahoney
 */
public class MergeSort {
	private int[] array;
	
	public MergeSort() {
	}//empty default constructor
	
	public int[] sort(int[] array) { //iterative merge sort
		if(array.length > 1) {
			int middle = array.length / 2; //Finds middle of array
			
			int[] left = new int[middle]; //splits array in half
			for(int i = 0; i < middle; i++) {
				left[i] = array[i];
			} //Fills the left array with all items up to the middle of original array
			
			int[] right = new int[array.length - middle]; //Other half of array
			for(int i = middle; i < array.length; i++) {
				right[i - middle] = array[i];
			} //Same as left, except starting from middle and ending at length
			sort(left);
			sort(right);
			
			int lpos = 0; //left position
			int rpos = 0; //right position
			int apos = 0; //main array position
			
			while(lpos < left.length && rpos < right.length) {
				if(left[lpos] < right[rpos]) { //If the current item in the left array is lesser than the current item in the right array
					array[apos] = left[lpos]; //Set the current item in the main array to the current item in the left array
					lpos++;
				} else {
					array[apos] = right[rpos]; //opposite as above (right > left, set array[apos] = right[rpos]
					rpos++;
				}
				apos++;
			}//end first while
			
			while(lpos < left.length) { //If right is shorter than left, collect leftovers from left
				array[apos] = left[lpos];
				lpos++;
				apos++;
			}// end left while
			while(rpos < right.length) { //If left is shorter than right, collect leftovers from right
				array[apos] = right[rpos];
				rpos++;
				apos++;
			}//end right while
		} //end if
		return array;
	}//end sort
}

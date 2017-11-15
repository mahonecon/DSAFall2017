
public class Sort {
	private int[] array; 
	private int comparisons;
	private int swaps;
	public Sort() {
	} //end default constructor
	
	public int[] BubbleSort(int[] array, int arrayPos) { //BubbleSort algorithm
		this.array = array;
		comparisons = 0;
		swaps = 0;
		int n = arrayPos;
		int temp;
		for(int i = 0; i < n - 1; i++) {
			for(int j = 0; j < n - i - 1; j++) {
				if(array[j + 1] < array[j]) {
					swaps++;
					temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
				}
				comparisons++;
			}
		}
		return array;
	}//end bubbleSort
	
	public int[] impBubbleSort(int[] array, int arrayPos) { //Improved BubbleSort algorithm
		this.array = array;
		comparisons = 0;
		swaps = 0;
		int n = arrayPos; //uses arrayPos as a passed parameter to ensure that unassigned positions in the array are not used.
		int temp;
		int lastSwap = arrayPos - 1; //lastSwap starts at the end of the array to ensure the j for loop checks every element at least once.
		for(int i = 0; i < n - 1; i++) {
			boolean swap = false; //Keeps track of whether or not a swap occurs
			int currentSwap = -1; //no current swap
			for(int j = 0; j < lastSwap; j++) {
				if(array[j + 1] < array[j]) { //If the next item is less than the current, begin swap.
					swaps++;
					temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
					swap = true; //Swap occurred
					currentSwap = j; //j was swapped, makes j currentSwap.
				}
				comparisons++; //increment comparisons counter
			}
			if(!swap) { //checks to see if a swap occurred
				return array; //if no swap occurred during this pass, return the array.
			}
			lastSwap = currentSwap; //stop j from iterating past the point we know it has already swapped the largest value into.
		} 
		return array;
	} //end impBubblesort
	
	public int[] selectionSort(int[] array, int arrayPos) { //SelectionSort
		this.array = array;
		comparisons = 0;
		swaps = 0;
		int n = arrayPos;
		int temp;
		for(int i = 0; i < n - 1; i++) {
			int minimum = i; //sets the minimum equal to i to avoid re-check
			boolean swap = false;
			for(int j = i + 1; j < n; j++) {
				if(array[j] < array[minimum]) { //if a lower value than the current minimum has been found.
					minimum = j; //set minimum to the lower value.
					swap = true; //tells the original for loop to swap since a minimum has been found.
				}
				comparisons++;
			}
			if(swap) { //checks if a swap is necessary and swaps if true
				swaps++;
				temp = array[minimum];
				array[minimum] = array[i];
				array[i] = temp;
			}
		}
		return array;
	}//end selectionSort
	
	public int[] impSelectionSort(int[] array, int arrayPos) {
		this.array = array;
		comparisons = 0;
		swaps = 0;
		int n = arrayPos;
		int temp;
		
		return array;
	}//end impSelectionSort
	
	public int[] insertionSort(int[] array, int arrayPos) {
		this.array = array;
		comparisons = 0;
		swaps = 0;
		int n = arrayPos;
		int temp;
		
		return array;
	}
	
	public int swaps() {
		return swaps;
	}
	
	public int comps() {
		return comparisons;
	}
}//End BubbleSort

import java.util.Random;

/*
 * Purpose: Data Structure and Algorithms Lab 10
 * Status: Complete and thoroughly tested
 * Last update: 11/18/17
 * @author: Conor J. Mahoney
 */
public class Quicksort {
	private Random randy = new Random();
	
        //Breaks the array into partitions, and sorts the partitions
	private int partition(int[] array, int min, int max) {
		int pivotIndex = randy.nextInt(max - min + 1) + min; //random pivot each time
		int pivot = array[pivotIndex];
		int a = min;
                int b = max;
		
		while(a <= b) { //while the iterating and decrementing values are not equal to each other
                    while(array[a] < pivot) { //if the item at array[a] is less than the pivot, increment a
                        a++;
                    }
                    while(array[b] > pivot) { //if the item at array[b] is greater than the pivot, increment b
                        b--;
                    }
                    if(a <= b) {
                        //swap array[a] and array[b]
                        int temp = array[a];
                        array[a] = array[b];
                        array[b] = temp;
                        a++; //increment a
                        b--; //decrement b
                    }
                }		
		return a; //return a as the new index
	}//end partition
	
	public int[] sort(int[] array, int min, int max) {
            int index = partition(array, min, max);
            
            if(min < index - 1) { //If the minimum is below index - 1, send the array to be partitioned and sorted again
                sort(array, min, index - 1);
            }
            if(index < max) { //If the maximum is greater than the index, send the array to be sorted again.
                sort(array, index, max);
            }
            return array;
	}//end sort
}

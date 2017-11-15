import java.util.Random;

public class Quicksort {
	private Random randy = new Random();
	
	private int partition(int[] array, int min, int max) {
		
		int pivotIndex = randy.nextInt(max-min) + min;
		int pivot = array[pivotIndex];
		int a = pivotIndex;
		int b = pivotIndex;
		
		for(int i = min; i < max; i++) {
			if(array[i] <= pivot && a > 0) {
				a--;
				int temp = array[a];
				array[a] = array[i];
				array[i] = temp;
			}
			if(array[i] > pivot && b < max) {
				b++;
				int temp = array[b];
				array[b] = array[i];
				array[i] = temp;
			}
		}
		
		return pivotIndex;
	}
	
	public int[] sort(int[] array, int min, int max) {
		
		if(min < max) {
			
			int pivot = partition(array, min, max);
			
			sort(array, min, pivot - 1);
			sort(array, pivot + 1, max);
		}
		return array;
	}
}

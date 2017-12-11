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

    public int[] sort(int[] array) {
        this.array = array;
        for (int i = 1; i <= (array.length / 2) + 2; i *= 2) {
            for (int j = i; j < array.length; j += 2 * i) {
                merge(array, j - i, j, Math.min(j + i, array.length)); //Breaks the array into sub arrays and then re-merges them together in the correct ordered positions
            }
        }
        return array;
    }//end sort

    //Merges arrays together in ordered position.
    public void merge(int[] array, int start, int mid, int end) {
        int[] temp = new int[end - start]; //temporary merge array
        int j = 0;
        int r = 0;
        int i = 0;

        while (j < mid - start && r < end - mid) {
            if (array[start + j] < array[mid + r]) {
                temp[i] = array[start + j];
                j++;
                i++;
            } else {
                temp[i] = array[mid + r];
                r++;
                i++;
            }//end if/else
        }//end while

        //cleans up remaining items from the right array
        while (r < end - mid) {
            temp[i] = array[mid + r];
            i++;
            r++;
        }//end while

        //Cleans up remaining items from the left array
        while (j < mid - start) {
            temp[i] = array[start + j];
            j++;
            i++;
        }//end while

        //Manual Array Copy from *start* to *temp.length*
        for (i = 0; i < temp.length; i++) {
            array[start + i] = temp[i];
        }
    }//end merge
}

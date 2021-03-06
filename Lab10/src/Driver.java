
import java.io.*;

/*
 * Purpose: Data Structure and Algorithms Lab 10
 * Status: Complete and thoroughly tested
 * Last update: 11/18/17
 * @author: Conor J. Mahoney
 */
public class Driver {

    public static BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
    public static int[] array;
    public static int pos;
    public static MergeSort merger = new MergeSort();
    public static Quicksort quickie = new Quicksort();

    public static void main(String[] args) throws IOException {

        int code = 0;

        while (code != 5) {
            System.out.println("Menu! Input number to reach menu option!");
            System.out.println("\t" + "1. Initialize array");
            System.out.println("\t" + "2. Add to array");
            System.out.println("\t" + "3. Merge Sort array");
            System.out.println("\t" + "4. Quick Sort array");
            System.out.println("\t" + "5. Exit");
            System.out.print("Make your menu selection now: ");
            code = Integer.valueOf(stdin.readLine());
            System.out.print(code + "\n");

            switch (code) {

                case 1:
                    one();
                    break;

                case 2:
                    two();
                    break;

                case 3:
                    three();
                    break;

                case 4:
                    four();
                    break;

            } //end switch
        }//end while
    }//end main

    public static void one() throws IOException {
        System.out.print("Input desired size of array: ");
        int temp = Integer.valueOf(stdin.readLine());
        System.out.print(temp + "\n");
        array = new int[temp];
        pos = 0;
        System.out.println("Array of size " + temp + " created.");
    }//end one

    public static void two() throws IOException {
        if (pos != array.length) {
            System.out.print("Add item to array: ");
            int temp = Integer.valueOf(stdin.readLine());
            System.out.print(temp + "\n");
            array[pos++] = temp;
            System.out.println(temp + " added to array! there are " + (array.length - pos) + " positions left in the array!");
        } else {
            System.out.println("Cannot add to array! Array is full!");
        }
    }//end two

    public static void three() {
        System.out.print("Array before sort: [");
        for (int i = 0; i < pos - 1; i++) {
            System.out.print(array[i] + ", ");
        }
        System.out.print(array[pos - 1] + "] \n");
        array = merger.sort(array);
        System.out.print("Array after sort: [");
        for (int i = 0; i < pos - 1; i++) {
            System.out.print(array[i] + ", ");
        }
        System.out.print(array[pos - 1] + "] \n");
    }//end three

    public static void four() throws IOException {
        System.out.print("Choose minimum index for sort (can choose from " + 0 + " - " + (pos - 1) + "): ");
        int min = Integer.valueOf(stdin.readLine());
        System.out.print(min + "\n");
        System.out.print("Choose maximum index for sort (can choose from " + min + " - " + (pos - 1) + "): ");
        int max = Integer.valueOf(stdin.readLine());
        System.out.print(max + "\n");
        System.out.print("Array before sort: [");
        for (int i = 0; i < pos - 1; i++) {
            System.out.print(array[i] + ", ");
        }
        System.out.print(array[pos - 1] + "] \n");
        array = quickie.sort(array, min, max);
        System.out.print("Array after sort: [");
        for (int i = 0; i < pos - 1; i++) {
            System.out.print(array[i] + ", ");
        }
        System.out.print(array[pos - 1] + "] \n");
    }//end four
}

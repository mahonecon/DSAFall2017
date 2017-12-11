
import java.io.*;

public class Driver {

    public static BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
    public static Sort sorter = new Sort();
    public static int[] array;
    public static int arrayPos = 0;
    public static int arrayPositionsLeft = 0;

    public static void main(String[] args) throws IOException {

        int code = 0;

        while (code != 9) {
            System.out.println("Menu! Input number to reach menu option!");
            System.out.println("\t" + "1. Create new Array (overwrites previous Array)");
            System.out.println("\t" + "2. Add item to Array.");
            System.out.println("\t" + "3. BubbleSort");
            System.out.println("\t" + "4. Improved Bubblesort");
            System.out.println("\t" + "5. Selection Sort");
            System.out.println("\t" + "6. Improved Selection Sort");
            System.out.println("\t" + "7. Insertion Sort");
            System.out.println("\t" + "8. Improved Insertion Sort");
            System.out.println("\t" + "9. Exit.");
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

                case 5:
                    five();
                    break;

                case 6:
                    six();
                    break;

                case 7:
                    seven();
                    break;

                case 8:
                    eight();
                    break;

            } //end switch
        }//end while
    }//end main

    public static void one() throws IOException {
        System.out.print("Input size of array: ");
        int temp = Integer.valueOf(stdin.readLine());
        array = new int[temp];
        arrayPos = 0;
        arrayPositionsLeft = array.length;
        System.out.print(temp + "\n");
    }//end one

    public static void two() throws IOException {
        System.out.print("Integer to add to Array: ");
        int temp = Integer.valueOf(stdin.readLine());
        array[arrayPos++] = temp;
        arrayPositionsLeft--;
        System.out.print(temp + "\n");
        System.out.println("There are " + arrayPositionsLeft + " positions left unfilled in the Array.");
    }//end two

    public static void three() {
        System.out.print("Array before sort: [");
        for (int i = 0; i < arrayPos; i++) {
            if (i == arrayPos - 1) {
                System.out.print(array[i] + "]" + "\n");
            } else {
                System.out.print(array[i] + ", ");
            }
        }
        System.out.print("Array after sort: [");
        array = sorter.BubbleSort(array, arrayPos);
        for (int i = 0; i < arrayPos; i++) {
            if (i == arrayPos - 1) {
                System.out.print(array[i] + "]" + "\n");
            } else {
                System.out.print(array[i] + ", ");
            }
        }
        System.out.println("Number of comparisons: " + sorter.comps());
        System.out.println("Number of swaps: " + sorter.swaps());
    }

    public static void four() {
        System.out.print("Array before sort: [");
        for (int i = 0; i < arrayPos; i++) {
            if (i == arrayPos - 1) {
                System.out.print(array[i] + "]" + "\n");
            } else {
                System.out.print(array[i] + ", ");
            }
        }
        System.out.print("Array after sort: [");
        array = sorter.impBubbleSort(array, arrayPos);
        for (int i = 0; i < arrayPos; i++) {
            if (i == arrayPos - 1) {
                System.out.print(array[i] + "]" + "\n");
            } else {
                System.out.print(array[i] + ", ");
            }
        }
        System.out.println("Number of comparisons: " + sorter.comps());
        System.out.println("Number of swaps: " + sorter.swaps());
    }

    public static void five() {
        System.out.print("Array before sort: [");
        for (int i = 0; i < arrayPos; i++) {
            if (i == arrayPos - 1) {
                System.out.print(array[i] + "]" + "\n");
            } else {
                System.out.print(array[i] + ", ");
            }
        }
        System.out.print("Array after sort: [");
        array = sorter.selectionSort(array, arrayPos);
        for (int i = 0; i < arrayPos; i++) {
            if (i == arrayPos - 1) {
                System.out.print(array[i] + "]" + "\n");
            } else {
                System.out.print(array[i] + ", ");
            }
        }
        System.out.println("Number of comparisons: " + sorter.comps());
        System.out.println("Number of swaps: " + sorter.swaps());
    }

    public static void six() {
    }

    public static void seven() {
    }

    public static void eight() {
    }

}


import java.io.*;

public class DriverP1 {

    public static BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
    public static ListArrayBasedPlus<Integer> list = new ListArrayBasedPlus<Integer>();

    public static void main(String[] args) throws IOException {

        int code = 0;

        while (code != 7) {
            System.out.println("Menu! Input number to reach menu option!");
            System.out.println("\t" + "1. Insert item into list.");
            System.out.println("\t" + "2. Remove item from list.");
            System.out.println("\t" + "3. Get item from list.");
            System.out.println("\t" + "4. Search for a specified item in the list.");
            System.out.println("\t" + "5. Clear List.");
            System.out.println("\t" + "6. Print size and content of list.");
            System.out.println("\t" + "7. Exit program.");
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

            } //end switch
        }//end while
    }//end main

    public static void one() throws IOException {
        int temp = 0;
        int n = 0;
        System.out.print("Item to insert: ");
        temp = Integer.valueOf(stdin.readLine());
        System.out.print(temp + "\n");
        System.out.print("Index to insert item at: ");
        n = Integer.valueOf(stdin.readLine());
        System.out.print(n + "\n");
        list.add(n, temp);
        System.out.println(temp + " inserted at index " + n);
    }//end one

    public static void two() throws IOException {
        int n = 0;
        System.out.print("Index to remove from list: ");
        n = Integer.valueOf(stdin.readLine());
        System.out.print(n + "\n");
        list.remove(n);
        System.out.println("Item at index " + n + " removed from list.");
    }//end two

    public static void three() throws IOException {
        int temp = 0;
        int n = 0;
        System.out.print("Index of item to retrieve from list: ");
        n = Integer.valueOf(stdin.readLine());
        temp = list.get(n);
        System.out.print(n + "\n");
        System.out.println("Item at index " + n + ": " + temp);
    }//end three

    public static void four() throws IOException {
        int key = 0;
        int pos = 0;
        boolean found = false;
        System.out.print("Item to search for: ");
        key = Integer.valueOf(stdin.readLine());
        System.out.print(key + "\n");
        for (int i = 0; i < list.size(); i++) {
            if (key == list.get(i)) {
                pos = i;
                found = true;
                i = list.size();
            }
        }
        if (found) {
            System.out.println("Item located at index: " + pos);
        } else {
            System.out.println("Item not found in list.");
        }
    }

    public static void five() {
        list.removeAll();
        System.out.println("List cleared.");
    }//end five

    public static void six() {
        System.out.println("Size of list: " + list.size());
        System.out.println("Contents of list: " + list.toString());
    }//end six
}//end Driver


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DeqTest {

    public static BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
    public static Deq<Integer> num = new Deq<Integer>();

    public static void main(String[] args) throws IOException {

        int code = 0;

        while (code != 9) {
            System.out.println("Menu! Input number to reach menu option!");
            System.out.println("\t" + "1. Insert item at back of Deq.");
            System.out.println("\t" + "2. Insert item at front of Deq.");
            System.out.println("\t" + "3. Remove item from front of Deq.");
            System.out.println("\t" + "4. Remove item from back of Deq.");
            System.out.println("\t" + "5. Display front item of Deq.");
            System.out.println("\t" + "6. Display last item of Deq.");
            System.out.println("\t" + "7. Clear Deq.");
            System.out.println("\t" + "8. Display content of Deq.");
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
        System.out.print("Integer to insert to back of Deq: ");
        int temp = Integer.valueOf(stdin.readLine());
        System.out.println(temp);
        num.enqueue(temp);
    }//end one

    public static void two() throws IOException {
        System.out.println("Integer to inser to front of Deq: ");
        int temp = Integer.valueOf(stdin.readLine());
        System.out.println(temp);
        num.enqueueFirst(temp);
    }//end two

    public static void three() {
        System.out.println("Integer removed from front of Deq: " + num.dequeue());
    }//end three

    public static void four() {
        System.out.println("Integer removed from back of Deq: " + num.dequeueLast());
    }//end four

    public static void five() {
        System.out.println("Front item of Deq: " + num.peek());
    }//end five

    public static void six() {
        System.out.println("Back item of Deq: " + num.peekLast());
    }//end six

    public static void seven() {
        num.dequeueAll();
        System.out.println("Deq cleared");
    }//end seven

    public static void eight() {
        System.out.println("Contents of Deq: " + num.toString());
    }//end eight

}//end of class


/*
 * Purpose: Data Structure and Algorithms Lab 5
 * Status: Complete and thoroughly tested
 * Last update: 10/09/17
 * Submitted: 10/10/2017
 * Comment: test suite and sample run attached
 * @author: Conor J. Mahoney
 * @version: 2017.10.09
 */
import java.io.*;

public class Driver {

    private static BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
    private static Stack<Layer> bag = new Stack<Layer>();
    private static Stack<Double> sampleBag = new Stack<Double>();
    private static int bagSize = 0;
    private static double bagWeight = 0;
    private static int sampleBagSize = 0;
    private static double sampleBagWeight = 0;

    public static void main(String[] args) throws IOException {

        int code = 0;

        while (code != 8) {
            System.out.println("Menu! Input number to reach menu option!");
            System.out.println("\t" + "1. Place a layer of item(s) in the bag.");
            System.out.println("\t" + "2. Remove a layer of item(s) from the bag.");
            System.out.println("\t" + "3. Display the weight of the bag.");
            System.out.println("\t" + "4. Display the number of layers in the bag.");
            System.out.println("\t" + "5. Display the number of items and the weight of the sample bag.");
            System.out.println("\t" + "6. Remove an item from the sample bag.");
            System.out.println("\t" + "7. Empty the sample bag.");
            System.out.println("\t" + "8. Exit.");
            System.out.print("Make your menu selection now: ");
            code = Integer.valueOf(stdin.readLine());
            System.out.print(code + "\n");

            switch (code) {

                case 1:
                    place();
                    break;

                case 2:
                    remove();
                    break;

                case 3:
                    bagWeight();
                    break;

                case 4:
                    numLayers();
                    break;

                case 5:
                    numItemsSample();
                    break;

                case 6:
                    removeItemSample();
                    break;

                case 7:
                    emptySampleBag();
                    break;
            } //end switch
        }//end while
    }//end main

    public static void place() throws IOException {
        int items;
        double weight;
        System.out.println("Enter number of items: ");
        items = Integer.valueOf(stdin.readLine());
        System.out.println(items);
        System.out.println("Enter weight of item: ");
        weight = Double.valueOf(stdin.readLine());
        System.out.println(weight);
        Layer l = new Layer(items, weight);
        bag.push(l);
        bagSize++;
        bagWeight += l.totalWeight();
    }//end place

    public static void remove() throws IOException {
        try {
            Layer l = bag.pop();
            System.out.println(l.items() + " have been removed from the bag");
            System.out.println("Would you like to store a sample? (Y/N)");
            String s = stdin.readLine().toUpperCase();
            System.out.println(s);
            if (s.equals("Y")) {
                sampleBag.push(l.weight());
                sampleBagSize++;
                sampleBagWeight += l.weight();
                System.out.println("Sample stored.");
            }//end if
            bagSize--;
            bagWeight -= l.totalWeight();
        } catch (StackException x) {
            System.out.println("Error: empty bag");
        }

    }//end remove

    public static void bagWeight() {
        System.out.println("The weight of the bag is " + bagWeight + " lbs.");
    }//end bagWeight

    public static void numLayers() {
        System.out.println("There are " + bagSize + " layers in the bag");
    }//end numLayers

    public static void numItemsSample() {
        System.out.println("There are " + sampleBagSize + " items in the sample bag.");
        System.out.println("The sample bag weighs " + sampleBagWeight + " lbs.");
    }//end numItemsSample

    public static void removeItemSample() {
        double weight = 0;
        try {
            weight = sampleBag.pop();
            System.out.println("An item weighing " + weight + "has been removed from the sample bag.");
            sampleBagSize--;
            sampleBagWeight -= weight;
        } catch (StackException x) {
            System.out.println("Error: sample bag is empty");
        }//end try/catch
    }//end removeItemSample

    public static void emptySampleBag() {
        sampleBag.popAll();
        sampleBagSize = 0;
        sampleBagWeight = 0;
        System.out.println("Sample bag has been emptied.");
    }//end emptySampleBag

}//end of class

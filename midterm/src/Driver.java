/*
 * Purpose: Data Structure and Algorithms Midterm
 * Status: Complete and thoroughly tested
 * Last update: 10/18/17
 * Submitted: 10/18/2017
 * Comment: test suite and sample run attached
 * @author: Conor J. Mahoney
 * @version: 2017.10.18
 * 
 * ADT choice: I have chosen to use the ListArrayBasedPlus ADT, and three Queue ADTs to create this driver.
 * I have chosen these two types of ADT because I believe them to be as efficient as possible for maintaining the status of the station.
 * My ListArrayBasedPlus ADT maintains the "guts" of the booths, which is to say that it retains the name of the driver entering the booth.
 * My Queue ADTs maintain the line, e.g., who came to the station first, which booth has been open the longest, and which booth has been inspecting a vehicle the longest.
 */
import java.io.*;

public class Driver {

	public static BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
	public static ListArrayBasedPlus<String> booths = new ListArrayBasedPlus<String>();
	public static Queue<String> station = new Queue<String>();
	public static Queue<Integer> openBooths = new Queue<Integer>();
	public static Queue<Integer> closedBooths = new Queue<Integer>();
	public static int inspected = 0;
	
	public static void main(String[] args) throws IOException {
		
		int code = 0;
		
		System.out.print("Input number of inspection booths desired: ");
		int temp = Integer.valueOf(stdin.readLine().replaceAll("\\s+",""));
		System.out.print(temp + "\n");
		
		for(int i = 0; i < temp; i++) {
			booths.add(i, "");
			openBooths.enqueue(i + 1);
		}
        
        while(code != 7) {
        	System.out.println("Menu! Input number to reach menu option!");
            System.out.println("\t" + "1. A car arrives at the inspection station.");
            System.out.println("\t" + "2. Entrance barrier opened: car inspected at booth.");
            System.out.println("\t" + "3. Exit barrier opened: car leaves DMV.");
            System.out.println("\t" + "4. Display drivers waiting to be inspected.");
            System.out.println("\t" + "5. Display the inspection booths that are idle.");
            System.out.println("\t" + "6. Display # of customers that had their cars inspected.");
            System.out.println("\t" + "7. Exit. ");
        	System.out.print("Make your menu selection now: ");
        	code = Integer.valueOf(stdin.readLine());
        	System.out.print(code + "\n");
		if(code == 7) {
		    System.out.println("DMV station is closing: Good Bye....");
		}
        	
        	switch(code) {
        	
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
		String temp = "";
		System.out.print("Welcome to the DMV station, may we have your name please:  ");
		temp = stdin.readLine();
		System.out.print(temp + "\n");
		System.out.println(temp + " is now waiting to have their car inspected.");
		station.enqueue(temp);
	}//end one
	public static void two() {
		int booth = 0;
		String driver = "";
		if(!openBooths.isEmpty() && !station.isEmpty()) {
			booth = openBooths.dequeue();
			driver = station.dequeue();
			closedBooths.enqueue(booth);
			booths.add(booth - 1, driver);
			System.out.println("Booth number " + booth + " is now inspecting " + driver + "'s car.");
		} else if (station.isEmpty()) {
			System.out.println("No customers are awaiting inspection!");
		} else {
			System.out.println("No booths are currently available to inspect!");
		}
	}//end two
	public static void three() {
		int booth = 0;
		String driver = "";
		if(!closedBooths.isEmpty()) {
			booth = closedBooths.dequeue();
			openBooths.enqueue(booth);
			driver = booths.get(booth - 1);
			inspected++;
			System.out.println("Booth number " + booth + " has finished inspecting " + driver + "'s car.");
		} else {
			System.out.println("No cars are currently being inspected!");
		}
	}//end three
	public static void four() {
		if(!station.isEmpty()){
			System.out.println("The following customers are waiting to have their cars inspected: " + station.toString());
		} else {
			System.out.println("No customers are waiting to have their cars inspected!");
		}
	}//end four
	public static void five() {
	    if(!openBooths.isEmpty()) {
		System.out.println("The following booths are available to inspect cars: " + openBooths.toString());
	    } else {
		System.out.println("No booths are available to inspect cars!");
	    }
	}//end five
	public static void six() {
		System.out.println(inspected + " customers have had their car inspected.");
	}//end six

}

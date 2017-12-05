/*
 * Purpose: DSA Project
 * Status: Complete and tested
 * Last update: 12/3/17
 * Submitted:  12/5/17
 * Comment: This is the Driver containing the main method for our project
 * @author: Nicholas La Sala, CJ Mahoney
 * @version: 2017.12.03
 */

//imported primarily for exceptions.
import java.io.*;

//Class declaration
public class Driver {
    //Static global fields that will used within the program
    //No additional classes of these types will be made during the execution of the program

    public static BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));			//Instance of buffered reader to take user inputs, used for all inputs taken during runtime
    public static ListArrayBasedPlus<Runway<Plane>> airport = new ListArrayBasedPlus<Runway<Plane>>();	//Instance resizable list ADT to store open runways at the airport
    public static ListArrayBasedPlus<Plane> planes = new ListArrayBasedPlus<Plane>();					//Instance resizable list ADT used as a plane lot for planes not cleared to takeoff
    public static ListArrayBasedPlus<String> numbers = new ListArrayBasedPlus<String>();				//Instance resizable list ADT to store the flight number of every plane at the airport

    // static global variables.
    public static int runwayCounter = 0;	//used for option 2, must be consistent
    public static int takeOffs = 0;		//used for option 8, must be be consistent

    //@author Conor Mahoney
    public static void main(String[] args) throws IOException {
        //Initialize Menu code
        int code = 0;
        //User selects starting number of runways open at airport
        System.out.println("Welcome to your new & improved Airport management program!");
        System.out.println("Please enter the number of runways at the airport: ");
        int numRunways = Integer.valueOf(stdin.readLine());
        for (int i = 0; i < numRunways; i++) { //For the specified number of runways
            four(); //calls the method for adding Runways
        }//end for

        while (code != 9) {
            //This menu will be printed every time the user gets to make a choice
            System.out.println("Menu! Input number to reach menu option!");
            System.out.println("\t" + "1. Plane enters the system.");
            System.out.println("\t" + "2. Plane takes off.");
            System.out.println("\t" + "3. Plane is allowed to re-enter a runway.");
            System.out.println("\t" + "4. Runway opens.");
            System.out.println("\t" + "5. Runway closes.");
            System.out.println("\t" + "6. Display info about planes waiting to take off.");
            System.out.println("\t" + "7. Display info about planes waiting to be allowed to re-enter a runway.");
            System.out.println("\t" + "8. Display number of planes who have taken off.");
            System.out.println("\t" + "9. Exit.");
            System.out.print("Make your menu selection now: ");
            code = Integer.valueOf(stdin.readLine());
            System.out.print(code + "\n");
            //End of menu, and user input
            switch (code) {
                //Cases 1-7 call methods that will perform the desired functionality
                //Case 8 performs its function within the case
                //Default case allows the user to renter their choice if they enter a number outside the 1-9 range
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
                    System.out.println(takeOffs + " planes have taken off ");
                    break;

                default:
                    System.out.println("Invalid option.");
                    break;

            } //end switch
        }//end while
        System.out.println("The airport has closed. Good bye!!!");
    }//end main

    /*
     * @author Nic LaSala
     * method one()
     * IOException for buffered reader
     * allows for a new plane to enter the system and be placed on a runway 
     */
    public static void one() throws IOException {
        System.out.print("Enter the flight number for the new plane: ");
        String fnum = stdin.readLine();	// User entered flight number
        System.out.print(fnum + "\n");
        boolean check = false;	// boolean verifies the number is new
        boolean hasNum = false;	// used to stay within loop until a unique number is enter
        // loop begins
        while (!hasNum) {
            for (int n = 0; n < numbers.size(); n++) {
                if (fnum.equalsIgnoreCase(numbers.get(n))) {
                    check = true;
                }
            }
            if (!check) {
                hasNum = true;
            } else {
                System.out.print("Try a new number: ");
                fnum = stdin.readLine();
                System.out.print(fnum + "\n");
                check = false;
            }
        }
        //loop ends
        //Prompts the user to enter destination
        System.out.print("Please enter the destination: ");
        String des = stdin.readLine();
        System.out.print(des + "\n");
        //Prompts the user the enter a runway for the plane to take-off from
        System.out.print("Enter runway name: ");
        String rName = stdin.readLine();
        System.out.print(rName + "\n");
        boolean ar = false;		//boolean so loop continues until a real runway is entered
        boolean real = false;	// verifies that users entered runway is open
        //loop ensure user picks an open runway
        while (ar == false) {
            for (int m = 0; m < airport.size(); m++) {
                if (rName.equalsIgnoreCase(airport.get(m).getName())) {
                    real = true;
                }

            }
            if (real == true) {
                ar = true;
            } else {
                System.out.print("That runway is not open, try a new one: ");
                rName = stdin.readLine();
                System.out.print(rName + "\n");
                real = false;
            }
        }//end of loop
        // calls Plane constructor will user designated parameters 
        Plane plane = new Plane(fnum, des, rName);
        //adds new number into the system
        numbers.add(numbers.size(), fnum);
        //loop finds the planes designated runway and adds the plane to the back of it
        for (int ap = 0; ap < airport.size(); ap++) {
            if (plane.getRunway().equalsIgnoreCase(airport.get(ap).getName())) {
                airport.get(ap).enqueue(plane);
                airport.get(ap).toString();
            }
        }//end of for loop
    }//end of method one

    /*
     * @author Conor Mahoney
     * method two()
     * IOException for buffered reader
     * Allows for a new plane to either take-off or be denied clearance for take-off.
     * If plane is denied clearance it is moved to the plane lot
     */
    public static void two() throws IOException {
        //checks that plane lot is not empty
        if (airportEmpty()) {
            System.out.println("There are no planes at the airport!");
        } else {
            //decides which plane's turn it is
            int tplane = runwayCounter % airport.size();
            boolean toff = false;
            while (!toff) {
                System.out.print("Allow Plane with Flight number " + airport.get(tplane).peek().getFlightNumber() + " to take off from Runway " + airport.get(tplane).getName() + "? (Y/N) : ");
                String choice = stdin.readLine();
                System.out.print(choice + "\n");
                //Take-off sequence
                if (choice.equalsIgnoreCase("Y")) {
                    System.out.println("Plane with Flight number: " + airport.get(tplane).peek().getFlightNumber() + " has taken off from Runway " + airport.get(tplane).getName());
                    takeOffs++;	//adds to the total number of successful take-offs
                    runwayCounter++;	//ensure that the next time the method id called the next runway is used
                    for (int j = 0; j < numbers.size(); j++) {
                        if (airport.get(tplane).peek().getFlightNumber().equalsIgnoreCase(numbers.get(j))) {
                            numbers.remove(j);
                        }
                    }
                    airport.get(tplane).dequeue();
                    toff = true;

                } //Moves to plane to the plane lot
                else if (choice.equalsIgnoreCase("N")) {
                    System.out.println("Plane with Flight number: " + airport.get(tplane).peek().getFlightNumber() + "  denied take-off clearance, added to list of planes awaiting re-entrance to Runway.");
                    planes.add(planes.size(), airport.get(tplane).peek());
                    airport.get(tplane).dequeue();
                    runwayCounter++;
                    toff = true;
                } //Stays in the loop if the user chooses anything other then yes or no
                else {
                    System.out.print("Invalid entry, try again: ");
                    choice = stdin.readLine();
                    System.out.print(choice + "\n");
                }
            }
        }
    }

    /*
     * @author Nic LaSala
     * method three()
     * IOException for buffered reader
     * allows for a new plane to re-enter its previously designated runway.
     */
    public static void three() throws IOException {
        //checks that plane lot is not empty
        if (planes.isEmpty()) {
            System.out.println("No Planes are awaiting re-entry!");
        } else {
            //User entered flight number of plane they wish to allow re-entry
            System.out.print("Please enter flight number for plane re-entering runway: ");
            String rnum = stdin.readLine(); //desired number
            System.out.print(rnum + "\n");
            boolean realNum = false;	// stays in loop until a plane re-enters its runway
            boolean op = false;			// verfies that a valid flight number had been entered
            int pos = 0;				// Initialize variable, Position of plane in the lot
            int run = 0;				// Initialize variable, Position of runway at airport
            boolean reAdded = false;
            while (!reAdded) {
                //loop to find plane of user entered flight number
                for (int e = 0; e < planes.size(); e++) {
                    if (rnum.equalsIgnoreCase(planes.get(e).getFlightNumber())) {
                        pos = e;
                        realNum = true;
                    }
                }
                //plane is found it will it will verify that the planes runway is open.
                if (realNum) {
                    for (int ro = 0; ro < airport.size(); ro++) {
                        if (planes.get(pos).getRunway().equalsIgnoreCase(airport.get(ro).getName())) {
                            run = ro;
                            op = true;
                        }
                    }
                    //once the runway is found the plane will be added to the back of the runway
                    if (op) {
                        airport.get(run).enqueue(planes.get(pos));
                        System.out.println("Plane number: " + rnum + " has re-entered.");
                        reAdded = true;
                        planes.remove(pos);
                    } else {
                        System.out.print("That plane's runway has closed, try another: ");
                        rnum = stdin.readLine();
                        System.out.print(rnum + "\n");
                    }//end if/else

                } //if the plane is not found a new number will be requested
                else {
                    System.out.print("That plane's is not awaiting re-entry, try another: ");
                    rnum = stdin.readLine();
                    System.out.print(rnum + "\n");
                }
            }//end of loop
        }//end of if/else
    }//end of three()

    /*
     * @author Nic LaSala
     * method four()
     * IOException for buffered reader
     * allows for a new runway to be opened 
     */
    public static void four() throws IOException {
        System.out.print("Enter the name of runway number " + (airport.size() + 1) + ": ");
        String runwayName = stdin.readLine();
        System.out.print(runwayName + "\n");
        boolean dup = false;
        boolean added = false;
        //loop ensure that a new runway has been added
        while (!added) {
            for (int i = 0; i < airport.size(); i++) {
                if (runwayName.equalsIgnoreCase(airport.get(i).getName())) {
                    dup = true;
                }
            }//end for
            if (!dup) {
                Runway runway = new Runway(runwayName);
                airport.add(airport.size(), runway);
                //names.add(names.size(), runwayName);
                added = true;
            } else {
                System.out.print("Runway name alreay exists, try a different name: ");
                runwayName = stdin.readLine();
                System.out.print(runwayName + "\n");
                dup = false;
            }//end if/else
        } //end while

    }//end four

    /*
     * @author Conor Mahoney
     * method five()
     * IOException for buffered reader
     * allows for a new plane to enter the system and be placed on a runway 
     */
    public static void five() throws IOException {
        String str;
        String newRun;
        Plane p;
        int index;
        int index2;
        int counter = 0;

        //Select Runway
        System.out.print("Enter runway: ");
        str = stdin.readLine();
        System.out.print(str + "\n");
        index = getRunwayIndex(str); //Retrieve index of runway

        //Verify selected runway as valid
        while (index == -1) { //If the runway does not exist, notify user and continue requesting new runways until given a runway that exists.
            System.out.print("Runway does not exist! Pick another runway: ");
            str = stdin.readLine();
            System.out.print(str + "\n");
            index = getRunwayIndex(str);
        }//end while

        Runway r = airport.get(index); //Set Runway = confirmed existent runway located at index

        //Perform this loop while the selected Runway still has planes awaiting takeoff clearance
        while (!r.isEmpty()) {
            p = (Plane) r.dequeue();
            System.out.print("Enter new runway for plane " + p.getFlightNumber() + ": ");
            newRun = stdin.readLine();
            System.out.print(newRun + "\n");
            index2 = getRunwayIndex(newRun);

            while (index2 == -1 || index2 == index) { //Check that Runway both exists, and is not the runway that is being closed.
                System.out.print("Runway does not exist or is the sames as the Runway that is closing! Pick another runway: ");
                newRun = stdin.readLine();
                System.out.print(newRun + "\n");
                index2 = getRunwayIndex(newRun);
            }//end while

            airport.get(index2).enqueue(p);
            System.out.println("Flight " + p.getFlightNumber() + " is awaiting takeoff at Runway " + airport.get(index2).getName());
            counter++;
        }//end while

        for (int i = 0; i < planes.size(); i++) { //Iterate through the list of planes awaiting re-entrance to find planes with runway assigned to the runway that is closing

            if (index == getRunwayIndex(planes.get(i).getRunway())) { //If a plane is found, verify & then set new runway
                p = planes.get(i);
                System.out.print("Enter new runway for plane " + p.getFlightNumber() + ": ");
                newRun = stdin.readLine();
                System.out.print(newRun + "\n");
                index2 = getRunwayIndex(newRun);

                while (index2 == -1 || index2 == index) { //Verify newRun
                    System.out.print("Runway does not exist or is the same as the Runway that is closing! Pick another runway: ");
                    newRun = stdin.readLine();
                    System.out.print(newRun + "\n");
                    index2 = getRunwayIndex(newRun);
                }//end while

                p.setRunway(newRun); //Set plane's runway to the new Runway
                System.out.println("Flight " + p.getFlightNumber() + " has been assigned a new runway, and is now awaiting re-entry to Runway " + newRun);
                counter++;
            }//end if
        }//end for        
        airport.remove(index);
        System.out.println("Runway " + str + " has been closed. " + counter + " Flights were transferred to new Runways.");
    }//end five()

    /*
     * @author Nic LaSala
     * method six()
     * displays planes at the front of each runway
     */
    public static void six() {
        //tell the user if there is no planes on the runways
        if (airportEmpty()) {
            System.out.println("There are no planes at the airport");
        } else {
            System.out.println("These planes are awaiting take-off");
            //Loops through each runway to display the plane ready for takeoff
            for (int s = 0; s < airport.size(); s++) {
                if (!airport.get(s).isEmpty()) {
                    System.out.println("These planes are waiting for takeoff on Runway " + airport.get(s).getName() + ": ");
                    System.out.println(airport.get(s).toString());
                }
            }//end of loop
        }//end of if/else

    }//end of six()

    /*
     * @author Nic LaSala
     * method 7()
     * allows for a new plane to enter the system and be placed on a runway 
     */
    public static void seven() {
        //Tells the user if there are no planes in the plane lot
        if (planes.isEmpty()) {
            System.out.println("There are no planes awaiting re-entry");
        } else {
            System.out.println("These planes are awaiting re-entry");
            //loops through the plane lot retrieving each flight number
            for (int s = 0; s < planes.size(); s++) {
                if (planes.get(s) != null) {
                    System.out.println("Flight: " + planes.get(s).getFlightNumber() + " to " + planes.get(s).getDestination());
                }
            }//end for loop
        }//end if/else
    }//end of seven()

    /*
     * @author Conor Mahoney
     * method getRunwayIndex()
     * helper method for five(), used to preserve postion of runway within the airport.
     * @param index of runway modified
     * @return return index as an integer
     */
    private static int getRunwayIndex(String str) {
        for (int i = 0; i < airport.size(); i++) {
            Runway r = airport.get(i);
            if (r.getName().equalsIgnoreCase(str)) {
                return i;
            }
        }
        return -1;
    }

    /*
     * @author Nic LaSala
     * method airportEmpty()
     * determines if there are any planes at the runway at all
     * @return true if there are no planes on the runways
     * @return false if there is at least one plane on a runway
     */
    private static boolean airportEmpty() {
        boolean empty = true;
        for (int k = 0; k < airport.size(); k++) {
            if (!airport.get(k).isEmpty()) {
                empty = false;
            }
        }
        return empty;
    }
}

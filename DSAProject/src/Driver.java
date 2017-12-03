/*
 * Purpose: DSA Project
 * Status: Complete and tested
 * Last update: 12/3/17
 * Submitted:  12/5/17
 * Comment: This is Driver containing the main method for our project
 * @author: Nicholas La Sala, Conor Mahoney
 * @version: 2017.12.03
 */

//imported for Input/Output operations
import java.io.*;

//Class declaration
public class Driver {
    //Static global fields that will used within the program
    //No additional classes of these types will be made during the execution of the program

    public static BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));		//Instance of buffered reader to take user inputs, used for all inputs taken during runtime
    public static ListArrayBasedPlus<Runway<Plane>> airport = new ListArrayBasedPlus<Runway<Plane>>();	//Instance resizable list ADT to store open runways at the airport
    public static ListArrayBasedPlus<Plane> planes = new ListArrayBasedPlus<Plane>();			//Instance resizable list ADT used as a plane lot for planes not cleared to take-off
    public static ListArrayBasedPlus<String> names = new ListArrayBasedPlus<String>();			//Instance resizable list ADT to store the names of every runway open
    public static ListArrayBasedPlus<String> numbers = new ListArrayBasedPlus<String>();		//Instance resizable list ADT to store the flight number of every plane at the airport

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
        //
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
            //End of menu
            switch (code) {
                //Cases 1-7 call methods that will perform the desired functionality
                //Case 8 performs its function within the case
                //Default case allows the user to renter their choice if they enter a number outside the 1-9 range
                case 1:
                    one();
                    break;

                case 2:
                    twov2();
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
        System.out.println("The airport has closed. Good bye!!!"); //Message to display on exit
    }//end main

    //@author Nic LaSala
    public static void one() throws IOException {
        System.out.println("Enter the flight number for the new plane");
        String fnum = stdin.readLine().toUpperCase();
        boolean check = false;
        boolean hasNum = false;
        while (hasNum == false) {
            for (int n = 0; n < numbers.size(); n++) {
                if (fnum.equals(numbers.get(n))) {
                    check = true;
                }
            }
            if (check == false) {
                hasNum = true;
            } else {
                System.out.println("Try a new number");
                fnum = stdin.readLine().toUpperCase();
                check = false;
            }
        }
        System.out.println("Please enter the destination: ");
        String des = stdin.readLine().toUpperCase();
        System.out.println("Enter runway name");
        String rName = stdin.readLine().toUpperCase();
        boolean ar = false;
        boolean real = false;
        while (ar == false) {
            for (int m = 0; m < airport.size(); m++) {
                if (rName.equals(airport.get(m).getName()) == true) {
                    real = true;
                }

            }
            if (real == true) {
                ar = true;
            } else {
                System.out.println("That runway is not open, try a new one");
                rName = stdin.readLine().toUpperCase();
                real = false;
            }
        }

        Plane plane = new Plane(fnum, des, rName);
        numbers.add(numbers.size(), fnum);
        for (int ap = 0; ap < airport.size(); ap++) {
            if (plane.getRunway().equals(airport.get(ap).getName())) {
                airport.get(ap).enqueue(plane);
                airport.get(ap).toString();
            }
        }
    }

    //@author Conor Mahoney
    public static void two() throws IOException {
        int emptyRunways = 0;
        boolean takeOff = false;
        Runway run;
        if (airportEmpty()) {
            System.out.println("There are no planes at the airport!");
        } else {
            while (!takeOff && emptyRunways != airport.size() - 1) {
                if (runwayCounter == airport.size()) { //if runwayCounter hits the last runway in the list, start from 0.
                    runwayCounter = 0;
                }//end if
                run = airport.get(runwayCounter); //assign temporary runway value to airport.get(runwayCounter)
                try {
                    Plane p = (Plane) run.dequeue();
                    System.out.println("Allow Plane with Flight number " + p.getFlightNumber() + " to take off from Runway " + run.getName() + "? (Y/N)");
                    String str = stdin.readLine().toUpperCase();
                    if (str.equals("Y")) {
                        System.out.println("Plane with Flight number: " + p.getFlightNumber() + " has taken off from Runway " + run.getName());
                        takeOffs++;
                        takeOff = true;
                        for (int j = 0; j < numbers.size(); j++) {
                            if (p.getFlightNumber().equals(numbers.get(j))) {
                                numbers.remove(j);
                                j = numbers.size();
                            }
                        }
                    } else {
                        planes.add(planes.size(), p);
                        System.out.println("Plane with Flight number: " + p.getFlightNumber() + " denied take-off clearance, added to list of planes awaiting re-entrance to Runway.");
                    }//end if/else
                    airport.remove(runwayCounter); //Remove temp runway from airport
                    airport.add(runwayCounter, run); //add modified runway back to airport at the same position it was removed from.
                    runwayCounter++;
                    if (run.isEmpty()) {
                        runwayCounter++;
                    }
                } catch (QueueException q) {
                    emptyRunways++;
                }//end try/catch
            }//end while
            if (emptyRunways == airport.size() - 1) {
                System.out.println("No plane on any runway!");
            }//end if
        }//end if/else
    }//end two()

    //@author Nic LaSala
    public static void three() throws IOException {

        if (planes.isEmpty()) {
            System.out.println("No Planes are awaiting re-entry!");
        } else {
            System.out.println("Please enter flight number for plane re-entering runway");
            String rnum = stdin.readLine().toUpperCase();
            boolean realNum = false;
            boolean op = false;
            int pos = 0;
            int run = 0;
            boolean reAdded = false;
            while (!reAdded) {
                for (int e = 0; e < planes.size(); e++) {
                    if (rnum.equals(planes.get(e).getFlightNumber())) {
                        pos = e;
                        realNum = true;
                    }
                }
                if (realNum) {
                    for (int ro = 0; ro < airport.size(); ro++) {
                        if (planes.get(pos).getRunway().equals(airport.get(ro).getName())) {
                            run = ro;
                            op = true;
                        }
                    }
                    if (op) {
                        airport.get(run).enqueue(planes.get(pos));
                        System.out.println("Plane number: " + rnum + " has re-entered.");
                        reAdded = true;
                        planes.remove(pos);
                    } else {
                        System.out.println("That plane's runway has closed, try another");
                        rnum = stdin.readLine().toUpperCase();
                    }
                } else {
                    System.out.println("That plane's is not awaiting re-entry, try another");
                    rnum = stdin.readLine().toUpperCase();
                }
            }
        }
    }

    //@author Nic LaSala
    public static void four() throws IOException {
        System.out.println("Enter the name of runway number " + (airport.size() + 1) + ": ");
        String runwayName = stdin.readLine().toUpperCase();
        boolean dup = false;
        boolean added = false;
        while (!added) {
            for (int i = 0; i < airport.size(); i++) {
                if (runwayName.equals(airport.get(i).getName())) {
                    dup = true;
                }
            }//end for
            if (!dup) {
                Runway runway = new Runway(runwayName);
                airport.add(airport.size(), runway);
                //names.add(names.size(), runwayName);
                added = true;
            } else {
                System.out.println("Runway name alreay exists, try a different name");
                runwayName = stdin.readLine().toUpperCase();
                dup = false;
            }//end if/else
        } //end while

    }//end four

    //@author Conor Mahoney
    public static void five() throws IOException {
        String str;
        String newRun;
        Plane p;
        int index;
        int index2;
        int counter = 0;

        //Select Runway
        System.out.print("Enter runway: ");
        str = stdin.readLine().toUpperCase();
        System.out.print(str + "\n");
        index = getRunwayIndex(str); //Retrieve index of runway

        //Verify selected runway as valid
        while (index == -1) { //If the runway does not exist, notify user and continue requesting new runways until given a runway that exists.
            System.out.print("Runway does not exist! Pick another runway: ");
            str = stdin.readLine().toUpperCase();
            System.out.print(str + "\n");
            index = getRunwayIndex(str);
        }//end while

        Runway r = airport.get(index); //Set Runway = confirmed existent runway located at index

        //Perform this loop while the selected Runway still has planes awaiting takeoff clearance
        while (!r.isEmpty()) {
            p = (Plane) r.dequeue();
            System.out.print("Enter new runway for plane " + p.getFlightNumber() + ": ");
            newRun = stdin.readLine().toUpperCase();
            System.out.print(newRun + "\n");
            index2 = getRunwayIndex(newRun);

            while (index2 == -1 || index2 == index) { //Check that Runway both exists, and is not the runway that is being closed.
                System.out.print("Runway does not exist or is the sames as the Runway that is closing! Pick another runway: ");
                newRun = stdin.readLine().toUpperCase();
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
                newRun = stdin.readLine().toUpperCase();
                System.out.print(newRun + "\n");
                index2 = getRunwayIndex(newRun);

                while (index2 == -1 || index2 == index) { //Verify newRun
                    System.out.print("Runway does not exist or is the same as the Runway that is closing! Pick another runway: ");
                    newRun = stdin.readLine().toUpperCase();
                    System.out.print(newRun + "\n");
                    index2 = getRunwayIndex(newRun);
                }//end while

                p.setRunway(newRun); //Set plane's runway to the new Runway
                System.out.println("Flight " + p.getFlightNumber() + " has been assigned a new runway, and is now awaiting re-entry to Runway " + newRun);
                counter++;
            }//end if
        }//end for        
        
        //********************REMOVE FOLLOWING COMMENTED CODE IF FIVE() WORKS!*************************************************
//        for (int j = 0; j < names.size(); j++) {
//            if (names.get(j).equals(str)) {
//                names.remove(j);
//                j = names.size();
//            }
//        }

        airport.remove(index);
        System.out.println("Runway " + str + " has been closed. " + counter + " Flights were transferred to new Runways.");
    }//end five()

    //@author Nic LaSala
    public static void six() {
        if (airportEmpty()) {
            System.out.println("There are no planes at the airport");
        } else {
            System.out.println("These planes are awaiting take-off");
            for (int s = 0; s < airport.size(); s++) {
                if (!airport.get(s).isEmpty()) {
                    System.out.println("Flight: " + airport.get(s).peek().getFlightNumber() + " to " + airport.get(s).peek().getDestination());
                }
            }
        }

    }

    //@author Nic LaSala
    public static void seven() {
        if (planes.isEmpty()) {
            System.out.println("There are no planes awaiting re-entry");
        } else {
            System.out.println("These planes are awaiting re-entry");
            for (int s = 0; s < planes.size(); s++) {
                if (planes.get(s) != null) {
                    System.out.println("Flight: " + planes.get(s).getFlightNumber() + " to " + planes.get(s).getDestination());
                }
            }
        }
    }

    //@author Conor Mahoney
    private static int getRunwayIndex(String str) {
        for (int i = 0; i < airport.size(); i++) {
            Runway r = airport.get(i);
            if (r.getName().equals(str)) {
                return i;
            }
        }
        return -1;
    }

    //@author Nic LaSala
    private static boolean airportEmpty() {
        boolean empty = true;
        for (int k = 0; k < airport.size(); k++) {
            if (!airport.get(k).isEmpty()) {
                empty = false;
            }
        }
        return empty;
    }

    public static void twov2() throws IOException {
        if (airportEmpty()) {
            System.out.println("There are no planes at the airport!");
        } else {
            int tplane = runwayCounter % airport.size();
            boolean toff = false;
            while (!toff) {
                System.out.println("Allow Plane with Flight number " + airport.get(tplane).peek().getFlightNumber() + " to take off from Runway " + airport.get(tplane).getName() + "? (Y/N)");
                String choice = stdin.readLine().toUpperCase();
                if (choice.equals("Y")) {
                    System.out.println("Plane with Flight number: " + airport.get(tplane).peek().getFlightNumber() + " has taken off from Runway " + airport.get(tplane).getName());
                    takeOffs++;
                    runwayCounter++;
                    for (int j = 0; j < numbers.size(); j++) {
                        if (airport.get(tplane).peek().getFlightNumber().equals(numbers.get(j))) {
                            numbers.remove(j);
                        }
                    }
                    airport.get(tplane).dequeue();
                    toff = true;

                } else if (choice.equals("N")) {
                    System.out.println("Plane with Flight number: " + airport.get(tplane).peek().getFlightNumber() + "  denied take-off clearance, added to list of planes awaiting re-entrance to Runway.");
                    planes.add(planes.size(), airport.get(tplane).peek());
                    airport.get(tplane).dequeue();
                    runwayCounter++;
                    toff = true;
                } else {
                    System.out.println("invalid entry, try again");
                    choice = stdin.readLine().toUpperCase();
                }
            }
        }
    }

}

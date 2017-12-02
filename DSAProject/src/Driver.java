
import java.io.*;

public class Driver {

    public static BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
    public static ListArrayBasedPlus<Runway<Plane>> airport = new ListArrayBasedPlus<Runway<Plane>>();
    public static ListArrayBasedPlus<Plane> planes = new ListArrayBasedPlus<Plane>();
    public static ListArrayBasedPlus<String> names = new ListArrayBasedPlus<String>();
    public static ListArrayBasedPlus<String> numbers = new ListArrayBasedPlus<String>();
    public static int runwayCounter = 0;
    public static int takeOffs = 0;

    public static void main(String[] args) throws IOException {

        int code = 0;

        System.out.println("Welcome to your new & improved Airport management program!");
        System.out.println("Please enter the number of runways at the airport: ");
        int numRunways = Integer.valueOf(stdin.readLine());
        for (int i = 0; i < numRunways; i++) { //For the specified number of runways
            four(); //calls the method for adding Runways
        }//end for

        while (code != 9) {
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

    //@author Nic La Sala
    public static void one() throws IOException {
        System.out.println("Enter the flight number for the new plane");
        String fnum = stdin.readLine();
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
                fnum = stdin.readLine();
            }
        }
        System.out.println("Enter runway name");
        String rName = stdin.readLine();
        boolean ar = false;
        boolean real = false;
        while (ar == false) {
            for (int m = 0; m < names.size(); m++) {
                if (rName.equals(names.get(m)) == true) {
                    real = true;
                }
                if (real == true) {
                    ar = true;
                } else {
                    System.out.println("That runway is not open, try a new one");
                    rName = stdin.readLine();
                }
            }
        }
        System.out.println("Please enter the destination: ");
        String des = stdin.readLine();
        Plane plane = new Plane(fnum, des, rName);
        for (int ap = 0; ap < airport.size(); ap++) {
            if (plane.getRunway().equals(airport.get(ap))) {
                airport.get(ap).enqueue(plane);
            }
        }
    }

    //@author Conor Mahoney
    public static void two() throws IOException {
        int takeOffAttempts = 0;
        boolean takeOff = false;
        Runway run;
        while (takeOff == false || takeOffAttempts != airport.size() - 1) {
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
                } else {
                    planes.add(planes.size(), p);
                    System.out.println("Plane with Flight number: " + p.getFlightNumber() + " denied take-off clearance, added to list of planes awaiting re-entrance to Runway.");
                    takeOffAttempts++;
                }
                airport.remove(runwayCounter); //Remove temp runway from airport
                airport.add(runwayCounter, run); //add modified runway back to airport at the same position it was removed from.
                runwayCounter++;
            } catch (QueueException q) {
                runwayCounter++;
                takeOffAttempts++;
            }
        }
        if (takeOffAttempts == airport.size() - 1) {
            System.out.println("No plane on any runway!");
        }
    }

    //@author Nic La Sala
    public static void three() throws IOException {

        if (planes.isEmpty() == true) {
            System.out.println("No Planes are awaiting re-entry!");
        } else {
            System.out.println("Please enter flight number for plane re-entering runway");
            String rnum = stdin.readLine();
            boolean realNum = false;
            boolean op = false;
            int pos = 0;
            int run = 0;
            boolean reAdded = false;
            while (reAdded == false) {
                for (int e = 0; e < planes.size(); e++) {
                    if (rnum.equals(planes.get(e).getFlightNumber())) {
                        pos = e;
                        realNum = true;
                    }
                }
                if (realNum == true) {
                    for (int ro = 0; ro < airport.size(); ro++) {
                        if (planes.get(pos).getRunway().equals(airport.get(ro).getName())) {
                            run = ro;
                            op = true;
                        }
                    }
                    if (op == true) {
                        airport.get(run).enqueue(planes.get(pos));
                        System.out.println("Plane number: " + rnum + " has re-entered.");
                        reAdded = true;
                    } else {
                        System.out.println("That plane's runway has closed, try another");
                        rnum = stdin.readLine();
                    }
                } else {
                    System.out.println("That plane's is not awaiting re-entry, try another");
                    rnum = stdin.readLine();
                }
            }
        }
    }

    //@author Nic La Sala
    public static void four() throws IOException {
        System.out.println("Enter the name of runway number " + (airport.size() + 1) + ": ");
        String runwayName = stdin.readLine();
        boolean dup = false;
        boolean added = false;
        while (added == false) {
            for (int i = 0; i < names.size(); i++) {
                if (runwayName.equals(names.get(i))) {
                    dup = true;
                }
            }//end for
            if (dup == false) {
                Runway runway = new Runway(runwayName);
                airport.add(airport.size(), runway);
                names.add(names.size(), runwayName);
                added = true;
            } else {
                System.out.println("Runway name alreay exists, try a different name");
                runwayName = stdin.readLine();
                dup = false;
            }//end if/else
        } //end while

    }//end four

    public static void five() throws IOException {
        boolean closed = false;
        boolean found = false;
        String str = "";
        while (!closed) {
            System.out.print("Enter runway: ");
            str = stdin.readLine().toUpperCase();
            System.out.print(str + "/n");
            for (int i = 0; i < airport.size(); i++) {
                Runway r = airport.get(i);
                if (r.getName().equals(str)) {
                    found = true;
                    ListArrayBasedPlus<Plane> temp = new ListArrayBasedPlus<Plane>();

                    closed = true;
                }
            }
            if (!found) {
                System.out.println("No such runway!");
            }
        }
        System.out.println("Runway " + str + " has been closed");
    }

    //@author Nic La Sala
    public static void six() {
        System.out.println("These planes are awaiting take-off");
        for (int s = 0; s < airport.size(); s++) {
            if (airport.get(s) != null) {
                System.out.println("Flight: " + airport.get(s).peek().getFlightNumber() + " to" + airport.get(s).peek().getDestination());
            }
        }
    }

    public static void seven() {
    }

    public static void eight() {
    }

}

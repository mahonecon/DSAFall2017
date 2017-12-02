
import java.io.*;

public class Driver {

    public static BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
    public static ListArrayBasedPlus<Runway> airport = new ListArrayBasedPlus<Runway>();
    public static ListArrayBasedPlus<Plane> planes = new ListArrayBasedPlus<Plane>();
    public static ListArrayBasedPlus<String> names = new ListArrayBasedPlus<String>();
    public static ListArrayBasedPlus<Integer> numbers = new ListArrayBasedPlus<Integer>();
    public static int runwayCounter = 0;

    public static void main(String[] args) throws IOException {

        int code = 0;

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

    public static void one() throws IOException {
		System.out.println("Enter the flight number for the new plane");
		int fnum = Integer.valueOf(stdin.readLine());
		boolean check = false;
		boolean hasNum = false;
		while(hasNum == false) {
			for(int n = 0; n< numbers.size(); n++) {
				if(fnum == numbers.get(n)) {
					check = true;
				}
			}
			if(check == false) {
				hasNum = true;
			}
			else{
				System.out.println("Try a new number");
				fnum = Integer.valueOf(stdin.readLine());
			}
		}
		System.out.println("Enter runway name");
		String rName = stdin.readLine();
		boolean ar = false;
		boolean real = false;
		while(ar== false) {
			for(int m =0; m < names.size(); m++) {
				if(rName.equals(names.get(m))== true) {
					real = true;
				}
				if(real == true) {
					ar = true;
				}
				else {
					System.out.println("That runway is not open, try a new one");
					rName = stdin.readLine();
				}
			}
		}
		System.out.println("Please enter the destination: ");
		String des = stdin.readLine();
		Plane plane = new Plane(fnum,des,rName);
		for(int ap =0; ap< airport.size(); ap++) {
			if(plane.getRunway().equals(airport.get(ap))) {
				airport.get(ap).enqueue(plane);
			}
		}
	}

    public static void two() {
    }

    public static void three() {
    }

    public static void four() throws IOException {
        System.out.println("Enter the name of the new runway");
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
            }//end if/else
        } //end while

    }//end four

    public static void five() {
    }

    public static void six() {
    }

    public static void seven() {
    }

    public static void eight() {
    }

}

import java.io.*;

public class Driver {

	public static BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
	public static Queue<Runway> airport = new Queue<Runway>();
	public static ListArrayBasedPlus planes = new ListArrayBasedPlus();
	
	
	public static void main(String[] args) throws IOException {
		
		int code = 0;
		
		System.out.println("Please enter the number of runways at the airport: ");
		int numRunways = Integer.valueOf(stdin.readLine());
                for(int i = 0; i < numRunways; i++) {
                    System.out.print("Name of Runway " + (i+1) + ": ");
                    String str = stdin.readLine();
                    Runway run = new Runway(str);
                    airport.enqueue(run);
                }
        
            while(code != 9) {
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
        		
        	case 7:
        		seven();
        		break;
        	
        	case 8:
        		eight();
        		break;
        		
        	} //end switch
        }//end while
	}//end main
	
	public static void one() {}
	public static void two() {}
	public static void three() {}
	public static void four() {}
	public static void five() {}
	public static void six() {}
	public static void seven() {}
	public static void eight() {}

}

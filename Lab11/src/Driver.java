import java.io.*;

public class Driver {

	public static BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws IOException {
		
		int code = 0;
        
        while(code != 10) {
        	System.out.println("Menu! Input number to reach menu option!");
                System.out.println("\t" + "1.");
                System.out.println("\t" + "2.");
                System.out.println("\t" + "3.");
                System.out.println("\t" + "4.");
                System.out.println("\t" + "5.");
                System.out.println("\t" + "6.");
                System.out.println("\t" + "7.");
                System.out.println("\t" + "8.");
                System.out.println("\t" + "9.");
                System.out.println("\t" + "10. Exit.");
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
                 
                case 9:
                        nine();
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
        public static void nine() {}

}

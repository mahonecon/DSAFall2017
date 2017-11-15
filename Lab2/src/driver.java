import java.io.*;

public class driver {

	public static BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
	public static ListArrayBasedPlus test = new ListArrayBasedPlus();
	
	public static void main(String[] args) throws IOException {
		
		int code = 0;
        
        while(code != 7) {
        	System.out.println("Menu! Input number to reach menu option!");
            System.out.println("\t" + "1. Insert item to list.");
            System.out.println("\t" + "2. Remove item from list.");
            System.out.println("\t" + "3. Get item from list.");
            System.out.println("\t" + "4. Clear list.");
            System.out.println("\t" + "5. Print size and content of list.");
            System.out.println("\t" + "6. Reverse list.");
            System.out.println("\t" + "7. Exit program.");
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
        		
        	} //end switch
        }//end while
	}//end main
	
	public static void one() throws IOException {
		System.out.println("Insert at (index, object):");
        int index = Integer.valueOf(stdin.readLine());
        Object object = stdin.readLine();
        test.add(index, object);
        System.out.println("Object " + object + " added at index " + index);
        System.out.println("");
	}
	public static void two() throws IOException {
		System.out.println("Remove:");
        int tempInt = Integer.parseInt(stdin.readLine());
        test.remove(tempInt);
        System.out.println("Object at index " + tempInt + " has been removed!");
        System.out.println("");
	}
	public static void three() throws IOException {
		System.out.println("Retrieve:");
        int tempInt = Integer.parseInt(stdin.readLine());
        System.out.println("Object at index " + tempInt + " is: " + test.get(tempInt));
        System.out.println("");
	}
	public static void four() {
		System.out.println("List Cleared.");
        test.removeAll();
        System.out.println("");
	}
	public static void five() {
		System.out.println("Printing list.");
        System.out.println(test.toString());
        System.out.println("Size = " + test.size());
        System.out.println("");
	}
	public static void six() {
		System.out.println("List is now reversed!");
        test.reverse();
        System.out.println("");
	}
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Driver {

    static BufferedReader stdin = new BufferedReader (new InputStreamReader(System.in));

    public static void main (String args[]) throws IOException {

        menu();
    }

    public static void menu() throws IOException {
    	ListCDLSBased list = new ListCDLSBased();
        int num = 0;
        int pos;
        Object item;


        while (num != 6){

        System.out.println("Select from the following menu: ");
        System.out.println("1. Insert item to list.");
        System.out.println("2. Remove item from list.");
        System.out.println("3. Get item from list.");
        System.out.println("4. Clear list.");
        System.out.println("5. Print size and content of list.");
        System.out.println("6. Exit program.");
        System.out.println("Make your menu selection now: ");
        num = Integer.parseInt(stdin.readLine().trim());
        System.out.println(num);

        switch (num) {
        case 1:         //adds an item into the node
            System.out.println("You are now inserting an item into the list.");
            System.out.println("Enter item:");
            item = stdin.readLine().trim();
            System.out.println(item);
            System.out.println("Enter position to insert item in : ");
            pos = Integer.parseInt(stdin.readLine().trim());
            System.out.println(pos);
            try {
                list.add(pos, item);
                System.out.println("Item " + item + " inserted in position " + pos + " in the list.");
                System.out.println("");
            } catch (ListIndexOutOfBoundsException e) {
                System.out.println("Position specified is out of range! \n");
            }
            break;
        case 2:         //removes an item from the node
            if (list.isEmpty()) {
                    System.out.println("List is empty");
            }
            else {
                System.out.println("Enter position to remove item from : ");
                pos = Integer.parseInt(stdin.readLine().trim());
                System.out.println(pos);
                try {
                    Object temp = list.get(pos);
                    list.remove(pos);
                    System.out.println("Item " + temp + " removed from position " + pos + " in the list. \n");
                } catch (ListIndexOutOfBoundsException e) {
                    System.out.println("Position specified is out of range! \n");
                }
            }
            break;
        case 3:         //gets and item from the node
            
        	if (list.isEmpty()) {
                System.out.println("List is empty \n");
            }
            else {
                System.out.println("Enter position to retrieve item from : ");
                pos = Integer.parseInt(stdin.readLine().trim());
                System.out.println(pos);
                try {
                    list.get(pos);
                    System.out.println("Item " + list.get(pos) + " retrieved from position " + pos + " in the list. \n");
                } catch (ListIndexOutOfBoundsException e) {
                    System.out.println("Position specified is out of range! \n");
                }
            }
            break;
        case 4:         //removes everything from the node
            if (list.isEmpty()) {
                System.out.println("List is empty. \n");

            }
            else {
                list.removeAll();
                System.out.println("");
            }
            break;
        case 5:         //lists everything in the node
            if (list.isEmpty()) {
                System.out.println("List is empty. \n");
            }
            else {
                System.out.println("List of size " + list.size() + " has the following items : " + list.toString());
                System.out.println("");
                // collection          
              } // end 
            break;
        case 6:		//exits code
			System.out.println("Exiting program...Good Bye");
			break;
			default: System.out.println("");
		}
        }
    }
            } // end ListCDLSBased



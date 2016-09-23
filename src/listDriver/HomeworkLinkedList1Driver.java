package listDriver;

import list.*;

/**
 * Test the List ADT.
 * 
 * @author (sdb) 
 * @version (Jan 2012)
 */
public class HomeworkLinkedList1Driver
{
    public static void main()
    {   
    List <String> names;
    System.out.println ("Testing LinkedLists");
    names = new LinkedList <String> ();
    names.add ("jim");
   names.add ("mary");
   names.add ("joe");
   names.add ("sue");
   
   System.out.println (names.get(2));  // Should be joe
   names.set (2, "Joe");            
   System.out.println (names.get(2));  // Should be Joe
   
   names.add(0,"emmy");
   names.add(5,"zoe");
   System.out.println (names.size());  // Should be 6
   System.out.println (names.get(1));   // should be jim
   names.remove (0);
   System.out.println (names.size());  // Should be 5
   System.out.println (names.get(2));  // Should be Joe
   if (names.isEmpty())
        System.err.println ("Incorrect, error in isEmpty");
   names.clear();
   if (!names.isEmpty())
        System.err.println ("Incorrect, error in isEmpty or clear");
   names.add ("sue");
   System.out.println (names.get(0));   // should be sue
   
   
}
  
}

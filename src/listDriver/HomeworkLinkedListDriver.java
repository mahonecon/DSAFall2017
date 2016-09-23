package listDriver;

import list.*;

/**
 * Test the List ADT.
 * 
 * @author (sdb) 
 * @version (Sep 2016)
 */
public class HomeworkLinkedListDriver
{
    public static void main(String[] args)
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
   System.out.println (names.size());  // Should be 4
   names.remove (0);
   System.out.println (names.size());  // Should be 3
   names.add (2, "Sue");
   System.out.println (names.get(2));  // Should be Sue
   if (names.isEmpty())
        System.err.println ("Incorrect, error in isEmpty");
   names.clear();
   if (!names.isEmpty())
        System.err.println ("Incorrect, error in isEmpty or clear");
   
}
  
}
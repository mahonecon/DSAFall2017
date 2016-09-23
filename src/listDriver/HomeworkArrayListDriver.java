package listDriver;

import list.*;

/**
 * Test the List ADT.
 * 
 * @author (sdb) 
 * @version (Jan 2012)
 */
public class HomeworkArrayListDriver
{
    public static void main(String[] args)
    {   
    List <String> names;
    System.out.println ("Testing ArrayLists");
    names = new ArrayList <String> ();
    names.add ("jim");
   names.add ("mary");
   names.add ("joe");
   names.add ("sue");
   System.out.println (names.get(2));  // Should be joe
   names.set (2, "Joe");            
   System.out.println (names.get(2));  // Should be Joe
   if (names.indexOf (new String("ma" + "ry")) != 1)
        System.err.println ("Incorrect, error in indexOf");
   System.out.println (names.size());  // Should be 4
   names.remove (0);
   System.out.println (names.size());  // Should be 3
   System.out.println (names.get(2));  // Should be sue
   if (names.isEmpty())
        System.err.println ("Incorrect, error in isEmpty");
   names.clear();
   if (!names.isEmpty())
        System.err.println ("Incorrect, error in isEmpty or clear");
   
}
  
}

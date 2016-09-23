package listDriver;

import list.*;

/**
 * Test the List ADT.
 * 
 * @author (sdb) 
 * @version (Sep 2016)
 */
public class HomeworkIteratorDriver
{
    public static void main(String[] args)
    {   
    String name;
    List <String> names;
    System.out.println ("Testing Iterators for ArrayLists");
    names = new ArrayList <String> ();
    names.add ("jim");
   names.add ("mary");
   names.add ("joe");
   names.add ("sue");
   
   System.out.println (names);
   Iterator<String> itty = names.iterator();
   while (itty.hasNext())
    {    name = itty.next();
         if (name.length() > 3) 
            itty.remove();
    }
    System.out.println (names); // should be [jim, joe, sue]
    
    System.out.println ("Testing Iterators for LinkedLists");
    names = new LinkedList <String> ();
    names.add ("jim");
   names.add ("mary");
   names.add ("joe");
   names.add ("sue");
   
   System.out.println (names);
   itty = names.iterator();
   while (itty.hasNext())
    {    name = itty.next();
         if (name.length() > 3) 
            itty.remove();
    }
    System.out.println (names); // should be [jim, joe, sue]
}
  
}
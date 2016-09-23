package listDriver;
import list.*;

/**
 * Lab 2
 * Test methods added to the List interface
 * 
 * @author (sdb) 
 * @version (Feb 2015)
 */
public class DriverLab2addAll
{
/**
 *  This main method tests the List classes
 *  for lab 3, Data Structures and Algorithms
 */
    public static void main (String[] args)
    {   List<String> friends = new LinkedList <String> ();
        List<String> enemies = new ArrayList <String> ();
        
        System.out.println ("Testing problem 1");
        init(friends);
        init(enemies);
        enemies.add("jimmy");
        friends.addAll(enemies);
        System.out.println ("friends are " + friends);
        System.out.println ("enemies are " + enemies);
        init(friends);
        init(enemies);
        friends.add("jimmy");
        enemies.addAll(friends);
        System.out.println ("friends are " + friends);
        System.out.println ("enemies are " + enemies);

        ////////////// Uncomment the following when ready for problem 2
     System.out.println ("\n\n Testing problem 2"); 
     friends.clear();
     enemies.clear();
     if (! friends.equals(enemies))
         System.err.println ("error in equals");
     if (! enemies.equals(friends))
         System.err.println ("error in equals");
     init (friends);
     init (enemies);
     if (! friends.equals(enemies))
         System.err.println ("error in equals");
     if (! enemies.equals(friends))
         System.err.println ("error in equals");
     friends.add(0,"jo");
     enemies.add("jo");
     if (friends.equals(enemies))
         System.err.println ("error in equals");
     if (enemies.equals(friends))
         System.err.println ("error in equals");
     enemies.remove ("jo");
     if (friends.equals(enemies))
         System.err.println ("error in equals");
     if (enemies.equals(friends))
         System.err.println ("error in equals");
     friends.remove("jo");
     if (! friends.equals(enemies))
         System.err.println ("error in equals");
     if (! enemies.equals(friends))
         System.err.println ("error in equals");
     System.out.println ("Testing complete");
    
    }
    
    private static void init (List<String> names)
    {
    names.clear();
    names.add ("joe");
    names.add ("mary");
    names.add ("jim");
    names.add (new String("joe"));                            // Lists may contain duplicate elements
    }
}

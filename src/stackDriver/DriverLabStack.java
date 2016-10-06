package stackDriver;
import stack.*;

/**
 * Lab 3 problem 2
 * Test the Stack implementation
 * 
 * @author (sdb 
 * @version (Sep 2015)
 */
public class DriverLabStack
{
    
    public static void main(String[] args)
    {   
System.out.println ("\n===============================================\nTesting stacks");
        StackADT <String> names = new Stack<String> ();
        names.push ("mary");
        names.push ("joe");
        names.push ("jim");
        names.push ("joe");
        
        System.out.println (names);
        System.out.println (names.peek());      // joe
        System.out.println (names.pop());       // joe
        System.out.println (names);             // mary joe jim
        
        StackADT <String> students = new Stack <String> ();
        students.push ("mary");
        students.push ("joe");
        if (names.equals (students))
            System.out.println ("Not correct 1");
        students.push ("jim");
        if (!names.equals (students))
            System.out.println ("Not correct 2");
        students.pop();
        students.push ("mary");
        if (names.equals (students))
            System.out.println ("Not correct 3");
        if (students.equals (names))
            System.out.println ("Not correct 4");
        
        names.clear();
        if (! names.isEmpty())
            System.out.println ("Not correct 5");
        }
        
}
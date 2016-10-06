package stackDriver;
import stack.*;

/**
 * Test the Stack implementation.
 * 
 * @author (sdb)
 * @version (Feb 2016)
 */
public class HomeworkStackDriver
{
    public static void main(String[] args)
    {    StackADT <String> names = new Stack<String>();
        if (! names.isEmpty())
            System.err.println ("Error in isEmpty");
        names.push ("mary");
        names.push ("joe");
        names.push ("jim");
        names.push ("joe");
        
        if (names.isEmpty())
            System.err.println ("Error in isEmpty");
        System.out.println (names);             // [mary, joe, jim, joe]
        System.out.println (names.peek());      // joe
        System.out.println (names.pop());       // joe
        System.out.println (names);             // mary joe jim
        names.push (names.push (names.push ("al")));            
        System.out.println (names);             // mary joe jim al al al
    }
        
}
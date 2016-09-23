package listDriver;

import list.*;

/**
 * Data Structures, Quiz 1, Problem 2
 * Do  not change this Driver
 * 
 * @author (sdb) 
 * @version (Sep 2016)
 */
public class Quiz1Fall2016
{
    public static void main (String[] args)
    {
    ArrayList <Integer> grades = new ArrayList <Integer> ();
    
    System.out.println (grades);
    System.out.println ("Contains Null: " + grades.containsNull() + "\n");
    
    grades.add(17);
    grades.add(27);
    grades.add(37);
    grades.add(7);
    
    System.out.println (grades);
    System.out.println ("Contains Null: " + grades.containsNull() + "\n");
    
    grades.add(null);           // Add a null reference to the list
    grades.add (17);
    System.out.println (grades);
    System.out.println ("Contains Null: " + grades.containsNull() + "\n");
    
    grades.clear();
    System.out.println (grades);
    System.out.println ("Contains Null: " + grades.containsNull() + "\n");
    
        
    }
    
    
        



}
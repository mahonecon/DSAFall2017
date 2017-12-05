/*
 * Purpose: DSA Project
 * Status: Complete and tested
 * Last update: 12/3/17
 * Submitted:  12/5/17
 * Comment: This is the Runway class called in the driver
 * @author: Nicholas La Sala, CJ Mahoney
 * @version: 2017.12.03
 */

//Runway extends the queue class
//Used to store the planes in the airport system
public class Runway<T> extends Queue<T> {
    // gives every instance of the runway a unique name checked for uniqueness in driver

    protected String name; //Protected name

    /*
	 * Runway Constructor
	 * @param instanstance created with user defined name
     */
    public Runway(String name) {
        super();
        this.name = name;
    }

    /*
	 *  getName
	 *  @return used to return the runways name as a string
     */
    public String getName() {
        return name;
    }
}

/*
 * Purpose: DSA Project
 * Status: Complete and tested
 * Last update: 12/3/17
 * Submitted:  12/5/17
 * Comment: This is the Plane class called in the driver
 * @author: Nicholas La Sala, CJ Mahoney
 * @version: 2017.12.03
 */
public class Plane {
	//fields needed for the planes
	protected String flightNumber;	//Unique flight number, verified for uniqueness within the driver
	protected String destination;	//Destination, provides information about the flight
	protected String runway;	//The runway the plane must take off from
	/*
	 * Constructor for plane
	 * @param allows the user to create the plane with all appropriate fields 
	 */
	public Plane(String flightNumber, String destination, String runway) {
		this.flightNumber = flightNumber;
		this.destination = destination;
		this.runway = runway;
	}
	/*
	 * getFlightNumber
	 * @return method returns the flight number as a string
	 */
	public String getFlightNumber() {
		return flightNumber;
	}
	/*
	 * getDestination
	 * @return method returns the flight number as a string
	 */
	public String getDestination() {
		return destination;
	}
	/*
	 * getRunway
	 * @return method return runway
	 */
	public String getRunway() {
		return runway;
	}
	/*
	 * setRunway
	 * @param take new runway and changes the planes designated runway to the runway specifed in the parameter
	 */
	
	public void setRunway(String newRunway) {
		runway = newRunway;
	}
        
        public String toString() {
            String str = ("Flight " + flightNumber + " to " + destination + "\n");
            return str;
        }

}

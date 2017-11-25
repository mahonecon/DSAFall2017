public class Plane {
	protected int flightNumber;
	protected String destination;
	protected String runway;

	public Plane(int flightNumber, String destination, String runway) {
		this.flightNumber = flightNumber;
		this.destination = destination;
		this.runway = runway;
	}

	public int getFlightNumber() {
		return flightNumber;
	}


	public String getDestination() {
		return destination;
	}


	public String getRunway() {
		return runway;
	}

}

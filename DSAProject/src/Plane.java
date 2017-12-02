public class Plane {
	protected String flightNumber;
	protected String destination;
	protected String runway;

	public Plane(String flightNumber, String destination, String runway) {
		this.flightNumber = flightNumber;
		this.destination = destination;
		this.runway = runway;
	}

	public String getFlightNumber() {
		return flightNumber;
	}


	public String getDestination() {
		return destination;
	}


	public String getRunway() {
		return runway;
	}
	public void setRunway(String newRunway) {
		runway = newRunway;
	}

}

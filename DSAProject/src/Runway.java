public class Runway<T> extends Queue<T>{
	protected String name;
	public Runway(String name) {
		super();
		this.name = name;
	}
	public String getName() {
		return name;
	}

}

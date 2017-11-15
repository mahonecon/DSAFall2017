/*
 * Purpose: Data Structure and Algorithms Lab 5
 * Status: Complete and thoroughly tested
 * Last update: 10/09/17
 * Submitted: 10/10/2017
 * Comment: test suite and sample run attached
 * @author: Conor J. Mahoney
 * @version: 2017.10.09
 */

public class Layer {
	private int numItems;
	private double weight;
	
	public Layer(int numItems, double weight) {
		this.numItems = numItems;
		this.weight = weight;
	}
	
	public double weight() {
		return weight;
	}
	
	public int items() {
		return numItems;
	}
	
	public double totalWeight() {
		return weight * numItems;
	}
}

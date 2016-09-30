package queue;

import list.*;

/** Queue class, using an ArrayList as a backbone*/
public class ArrayQueue<E> implements QueueADT<E> {

	int front = 0, back = 0, qSize = 0;
	List<E> values = new ArrayList<E>();
	
	public ArrayQueue() {} //Default constructor
	
	public void add(E value) {
		if(qSize != values.size()){ //If the ArrayList isn't full, use set(int ndx, E value).
			values.set(back, value);
		}
		else { //If the ArrayList is full, switch from set(int ndx, E value) to add(int ndx, E value).
			values.add(back, value);
			front = (front + 1) % values.size(); //Same thing as for back. Still witchcraft.
		}
		back = (back + 1) % values.size(); //If (back+1) < values.size(), back = (back+1). If (back+1) >= values.size(), back = 0.
		qSize++;
	}
	
	public E remove() {
		E result = values.get(front);
		front = (front + 1) % values.size();
		qSize--;
		return result;
	}
	
	public E peek() {
		return values.get(front);
	}
}

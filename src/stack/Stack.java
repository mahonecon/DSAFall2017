package stack;

import list.*;

/** A Stack can be implemented with some kind of List */
public class Stack<E> implements StackADT<E> {

	List<E> values = new ArrayList<E>();
	
	public Stack(boolean refBased) {
		if(refBased) values = new LinkedList<E>();
	}
	
	public Stack() {		
	}
	
	public E push(E value) {
		values.add(value);
		return value;
	}

	public E pop() {
		return values.remove(values.size() - 1);
	}

	public E peek() {
		return values.get(values.size() - 1);
	}
	
	public void clear() {
		if(values instanceof ArrayList) {
			values = new ArrayList<E>();
		}
		else values = new LinkedList<E>();
	}
	
	public boolean isEmpty() {
		if(values.size() == 0) {
			return true;
		} else return false;
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof StackADT) {
			
			Stack<E> temp = (Stack<E>) obj;
			if(temp.values.equals(values)) {
				return true;
			}
		} return false;
	}
	
	public String toString() {
		return values.toString();
	}

}

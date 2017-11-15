/*
 * Purpose: Data Structure and Algorithms Lab 2 Problem 2
 * Status: Complete and Thoroughly tested
 * Last update: 09/18/17
 * Submitted: 09/19/17
 * Comment: test suite and sample run attached
 * @author: Conor J. Mahoney
 * @version: 2017.09.18
 */
import java.util.*;
public class ListArrayListBased implements ListInterface {
	protected ArrayList<Object> items = new ArrayList<Object>();

	public ListArrayListBased() {
		
	}
	public boolean isEmpty() {
		return items.isEmpty();
	}

	public int size() {
		return items.size();
	}

	public void add(int index, Object item) throws ListIndexOutOfBoundsException {
		items.add(index, item);
	}

	public Object get(int index) throws ListIndexOutOfBoundsException {
		return items.get(index);
	}

	public void remove(int index) throws ListIndexOutOfBoundsException {
		items.remove(index);
	}

	public void removeAll() {
		items.clear();
	}

}

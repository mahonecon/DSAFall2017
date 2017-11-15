/*
 * Purpose: Data Structure and Algorithms Lab 5
 * Status: Complete and thoroughly tested
 * Last update: 10/09/17
 * Submitted: 10/10/2017
 * Comment: test suite and sample run attached
 * @author: Conor J. Mahoney
 * @version: 2017.10.09
 */
public class Stack<T> implements StackInterface<T> {

	T[] list = (T[]) new Object[10];
	int position = 0;
	
	public Stack() {
	}//end constructor

	public boolean isEmpty() {
		return position == 0;
	}//end isEmpty

	public void popAll() {
		list = (T[]) new Object[10];
		position = 0;
	}//end popAll

	public void push(T newItem) {
		try { //try to add the item and increase position
			list[position] = newItem;
			position++;
		} catch(IndexOutOfBoundsException x) { //adds 10 to size if not large enough
			T[] temp = (T[]) new Object[list.length + 10];
			for(int i = 0; i < list.length - 1; i++) {
				temp[i] = list[i];
			}
			list = temp;
		}//end try/catch
	}//end push

	public T pop() throws StackException {
		if(isEmpty()) {
			throw new StackException("Nothing to pop!");
		} else {
			position--;
			T t = list[position];
			list[position] = null;
			return t;
		}//end if/else
	}//end pop

	public T peek() throws StackException {
		if(isEmpty()) {
			throw new StackException("Nothing to peek!");
		} else {
			return list[position - 1];
		}//end if/else
	}//end peek
	
}//end Stack

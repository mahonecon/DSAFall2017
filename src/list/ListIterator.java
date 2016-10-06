package list;

/** Permit traversal of a list in either direction */
public interface ListIterator<E> extends Iterator<E> {
	
	/** @return true if there is a previous value */
	boolean hasPrevious();
	
	/** @return previous value
	 * pre: hasPrevious() == true */
	E previous();
	
	/** Remove the value last obtained by a call to next or previous */
	void remove();
	
	/** Insert the given value just prior to the implicit cursor
	 * position */
	void add(E value);
}

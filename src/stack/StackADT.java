package stack;

/**StackADT is a Last-in, First-out List */
public interface StackADT<E> {
	
	/** @return pushed value */
	E push(E value);
	
	/** remove top value of stack
	 * @return remove value */
	E pop();
	
	/** @return the top value of this stack */
	E peek();
}

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
	
	/** Clear this StackADT */
	void clear();
	
	/** @return true only if this StackADT is empty */
	boolean isEmpty();
	
	/** @return true only if this StackADT is equal to the parameter,
	 * other */
	boolean equals(Object obj);
}

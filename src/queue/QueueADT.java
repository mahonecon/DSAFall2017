package queue;

/** A first-in, first-out List. */
public interface QueueADT<E> {

	/** Add given value to the back of this queue. */
	void add(E value);
	
	/** Remove the value which is at the front of the queue
	 * Pre: QueueADT<E> is not empty
	 * @return value that was removed */
	E remove();
	
	/** @return the value at the front of the queue,
	 *  or null if the queue is empty */
	E peek();	
}

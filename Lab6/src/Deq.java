
public class Deq<T> extends Queue<T> implements ExtendedQueueInterface<T> {

	public Deq() {
		super();
	}//end default constructor
		
	public void enqueueFirst(T newItem) throws ExtendedQueueException {
		if(size == queue.length) {
			resize();
		}
		if(front == 0) {
			front = queue.length - 1;
		} else {
			front = front - 1;
		}
		queue[front] = newItem;
		size ++;
		
	}//end enqueueFirst
	
	public T dequeueLast() throws ExtendedQueueException {
		if(size == 0) {
			throw new ExtendedQueueException("Nothing to Dequeue!");
		}
		
		if(back == 0) {
			back = queue.length - 1;
		} else {
			back--;
		}
		
		T t = queue[back];
		size --;
		return t;
	}//end dequeueLast

	public T peekLast() throws ExtendedQueueException {
		return queue[back - 1];
	}//end peekLast
	
}

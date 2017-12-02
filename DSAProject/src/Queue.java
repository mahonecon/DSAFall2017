
public class Queue<T> implements QueueInterface<T> {

	protected T[] queue;
	protected int front;
	protected int back;
	protected int numItems;

	public Queue() {

		queue = (T[]) new Object[3];
		front = 0;
		back = 0;
		numItems = 0;
	}

	public void resize() {
		int newLength = 0;
		newLength = (int) ((int) (numItems + 1) * 1.5);
		Object[] newArray = new Object[newLength];
		for (int k = 0; k < numItems; k++) {
			newArray[k] = queue[(front + k) % queue.length];
		}
		front = 0;
		back = numItems;
		queue = (T[]) newArray;

	}

	public boolean isEmpty() {
		return (numItems == 0);
	}

	public void enqueue(T newItem) throws QueueException {
		if (numItems == queue.length) {
			resize();
		}
		queue[back] = newItem;
		back = (back + 1) % queue.length;
		numItems++;

	}

	public T dequeue() throws QueueException {
		if (numItems == 0) {
			throw new QueueException("Stack is already empty");
		} else {
			T result = queue[front];
			queue[front] = null;
			front = (front + 1) % queue.length;
			numItems--;
			return result;
		}
	}

	public void dequeueAll() {
		queue = (T[]) new Object[3];
		front = 0;
		back = 0;
		numItems = 0;
	}

	public T peek() throws QueueException {
		if (numItems == 0) {
			throw new QueueException("Stack is already empty");
		} else {
			return queue[front];
		}
	}

	public String toString() {
		String s = "";
		for (int i = 0; i < numItems; i++) {
			s += (String) queue[(front + i) % queue.length] + " ";

		}
		return s;
	}

}

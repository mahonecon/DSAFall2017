/*
 * Purpose: Data Structure and Algorithms Midterm
 * Status: Complete and thoroughly tested
 * Last update: 10/18/17
 * Submitted: 10/18/2017
 * Comment: test suite and sample run attached
 * @author: Conor J. Mahoney
 * @version: 2017.10.18
 */
public class Queue<T> implements QueueInterface<T> {

    protected T[] queue;
    protected int front;
    protected int back;
    protected int size;

    public Queue() {
        queue = (T[]) new Object[3];
        back = 0;
        front = 0;
        size = 0;
    }//end default constructor

    public boolean isEmpty() {
        return size == 0;
    }//end isEmpty

    public void enqueue(T newItem) throws QueueException {
        if (size == queue.length) {
            resize();
        }
        queue[back] = newItem;
        back = (back + 1) % queue.length;
        size++;

    }//end enqueue

    public T dequeue() throws QueueException {
        if (size == 0) {
            throw new QueueException("Nothing to dequeue!");
        }

        T t = queue[front];
        queue[front] = null;
        size--;
        front = (front + 1) % queue.length;

        return t;
    }//end dequeue

    public T peek() throws QueueException {
        if (size == 0) {
            throw new QueueException("Nothing to peek!");
        }
        return queue[front];
    }//end peek

    public void dequeueAll() {
        queue = (T[]) new Object[3];
        size = 0;
        front = 0;
        back = 0;
    }//end dequeueAll

    protected void resize() {
        T[] temp = (T[]) new Object[(int) Math.round(size * 1.5)];
        for (int i = 0; i < size; i++) {
            temp[i] = queue[(i + front) % queue.length];
        }
        front = 0;
        back = size;
        queue = temp;
    }//end resize

    public String toString() {
        String s = "";
        if (!isEmpty()) {
            for (int i = 0; i < size; i++) {
                s += queue[(i + front) % queue.length];
            }
        }
        return s;
    } //end toString
}

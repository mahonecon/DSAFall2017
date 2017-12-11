
public class QueueTester {

    public static void main(String[] args) {
        Queue<Integer> q = new Queue<Integer>();
        Queue<String> s = new Queue<String>();
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        q.enqueue(4);
        q.enqueue(5);
        System.out.println("Peek() results: " + q.peek()); //Should return 1
        System.out.println("Dequeue() results: " + q.dequeue()); //Should return 1
        System.out.println("Dequeue() results: " + q.dequeue()); //Should return 2
        System.out.println("Dequeue() results: " + q.dequeue()); //Should return 3
        System.out.println("Dequeue() results: " + q.dequeue()); //Should return 4
        System.out.println("Dequeue() results: " + q.dequeue()); //Should return 5
        q.enqueue(12);
        q.enqueue(13);
        System.out.println("Dequeue() results: " + q.dequeue()); //Should return 12
        System.out.println("The next line should return false");
        System.out.println(q.isEmpty()); //Should return false
        q.dequeueAll();
        System.out.println("The next line should return true to show that the queue has been succesfully dequeued using dequeueAll");
        System.out.println(q.isEmpty()); //Should return true
        s.enqueue("Time");
        s.enqueue("To");
        s.enqueue("Test");
        s.enqueue("With");
        s.enqueue("STRINGS");
        System.out.println("Dequeue() results: " + s.dequeue());
        System.out.println("Dequeue() results: " + s.dequeue());
        System.out.println("Dequeue() results: " + s.dequeue());
        System.out.println("Dequeue() results: " + s.dequeue());
        System.out.println("Dequeue() results: " + s.dequeue());
        System.out.println("The next line should be true");
        System.out.println(s.isEmpty());
    }
}

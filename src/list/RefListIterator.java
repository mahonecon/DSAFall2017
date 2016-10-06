package list;

/** A class that implements ListIterators for LinkedLists */
public class RefListIterator<E> extends RefIterator<E> implements ListIterator<E> {
	//cursor refers...
	private boolean forward = true;
	
	public RefListIterator(LinkedList<E> linkedList){
		super(linkedList);
	}
	
	public RefListIterator(LinkedList<E> linkedList, int start) {
		super(linkedList);
		for(int i = 0; i < start; i++) {
			cursor = cursor.next;
		}
	}
	
	public boolean hasNext() {
		if(list.isEmpty())
			return false;
		
		if(forward) 
			return cursor.next != list.tail;
		else return true;
	}
	
	public E next() {
		if(forward)
			cursor = cursor.next;
		forward = true;
		return cursor.value;
	}
	
	public boolean hasPrevious() {
		if(list.isEmpty()) 
			return false;
		if(!forward) 
			return cursor.prev != list.head;
		if(cursor.prev == null)
			return false;
		else return true;
	}
	
	public E previous() {
		if(!forward)
			cursor = cursor.prev;
		forward = false;
		return cursor.value;
	}
	
	public void remove() {
		super.remove();
		if(!forward)
			cursor = cursor.next;
	}
	
	public void add(E value) {
		Node<E> temp;
		
		if(forward) {
			temp = new Node<E>(value, cursor.next, cursor);
			temp.prev.next = temp;
			temp.next.prev = temp;
			cursor = cursor.next;
		} else  {
			temp = new Node<E>(value, cursor, cursor.prev);
			temp.prev.next = temp;
			temp.next.prev = temp;
		}
		
		list.size++;
	}
}


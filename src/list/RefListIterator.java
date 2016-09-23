package list;

/** A class that implements ListIterators for LinkedLists */
public class RefListIterator<E> extends RefIterator<E> implements ListIterator<E> {
	//cursor refers...
	boolean forward = true;
	
	public RefListIterator(LinkedList<E> linkedList){
		super(linkedList);
	}
	
	public RefListIterator(LinkedList<E> linkedList, int start) {
		super(linkedList);
		for(int i = 0; i < start; i++) {
			cursor = cursor.next;
		}
	}
}

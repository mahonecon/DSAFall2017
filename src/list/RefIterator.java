package list;

public class RefIterator<E> implements Iterator<E>
{
	LinkedList<E> list;
	Node<E> cursor;
	
	RefIterator(LinkedList<E> list)
	{
		this.list = list;
		cursor = list.head;
	}
	
	public boolean hasNext()
	{
		return cursor != list.tail.prev;
	}
	
	public E next()
	{
		cursor = cursor.next;
		return cursor.value;
	}
	
	public void remove()
	{
		cursor.next.prev = cursor.prev;
		cursor.prev.next = cursor.next;
		cursor = cursor.prev;
		list.size--;
	}
}

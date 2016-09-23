package list;

public class ArrayListIterator<E> extends ArrayIterator<E> implements ListIterator<E>{

	boolean forward = true;
	
	ArrayListIterator(List<E> list) 
	{ super(list); cursor = 0; }
	
	ArrayListIterator(List<E> list, int start)
	{ super(list); cursor = start; }
	
	public boolean hasNext() {
		if(list.isEmpty())
			return false;
		return cursor < list.size();
	}
	
	public E next() {
		cursor++;
		forward = true;
		return list.get(cursor-1);
	}
	
	public boolean hasPrevious() {
		if(list.isEmpty())
			return false;
		return cursor > 0;
	}
	
	public E previous() {
		cursor--;
		forward = false;
		return list.get(cursor);
	}
	
	public void remove() {
		if(forward) {
			cursor--;
		}
		list.remove(cursor);
	}
	
}

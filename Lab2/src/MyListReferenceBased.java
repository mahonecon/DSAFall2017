

public class MyListReferenceBased implements ListInterface {

	Node head;
	public MyListReferenceBased() {
		head = null;
	}

	public boolean isEmpty() {
		return size() == 0;
	}

	public int size() {
		int numItems = 0;
		Node newNode = new Node(head.getItem(),head.getNext());
		while(newNode.getNext() != null) {
			newNode = newNode.getNext();
			numItems++;
		}
		return numItems;
	}

	public void add(int index, Object item) throws ListIndexOutOfBoundsException {
		if (index >= 0 && index < size() + 1) 
		{
			if (index == 0) 
			{
				Node newNode = new Node(item, head);
				head = newNode;
			} else {
				Node prev = find(index-1);
				Node newNode = new Node(item, prev.getNext());
				prev.setNext(newNode);
			}
		}else {
			throw new ListIndexOutOfBoundsException("List index out of bounds exception on add");
		}		
	}
	
	private Node find(int index) 
	  {
	    Node curr = head;
	    for (int skip = 0; skip < index; skip++) 
	    {
	      curr = curr.getNext();
	    }
	    return curr;
	  }

	public Object get(int index)  throws ListIndexOutOfBoundsException {
		if (index >= 0 && index < size()) {
			Node curr = find(index);
			Object dataItem = curr.getItem();
			return dataItem;
			} else {
				throw new ListIndexOutOfBoundsException("List index out of bounds exception on get");
			}
		}

	public void remove(int index) throws ListIndexOutOfBoundsException {
		if (index >= 0 && index < size()) 
	    {
	      if (index == 0) 
	      {
	        head = head.getNext();
	      } else {
	        Node prev = find(index-1);
	        Node curr = prev.getNext(); 
	        prev.setNext(curr.getNext());
	      } 
	    } else {
	      throw new ListIndexOutOfBoundsException("List index out of bounds exception on remove");
	    }
	}
	
	public void removeAll() {
		head = null;
	}
	
	public String toString() {
		String s = "";
		Node newNode = new Node(head.getItem(),head.getNext());
		while(newNode.getNext() != null) {
			s += newNode.getItem();
			newNode = newNode.getNext();
		}
		return s;
	}
}
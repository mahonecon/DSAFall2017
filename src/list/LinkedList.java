package list;

public class LinkedList<E> implements List<E>{

	int size = 0;
	Node<E> head;
	Node<E> tail;
	private Node<E> ref;
	
	public LinkedList(){
		head = new Node<E>(null, null, null);
		tail = new Node<E>(null, null, head);
		head.next = tail;
	}
	
	public int size(){
		return size;
	}
	
	public boolean isEmpty(){
		if(size==0){
			return true;
		}
		return false;
	}
	
	public void clear(){
		head.next = null;
		tail = head;
		size = 0;
		head.next = tail;
		tail.prev = head;
	}
	
	public void add(E value){
		Node <E> temp = new Node<E>(value, tail, tail.prev);
		tail.prev = temp;
		temp.prev.next = temp;
		size++;
	}
	
	public void add(int ndx, E value){
		if(ndx == size) {
			add(value);
		}
		else{
			setRef(ndx);
			Node<E> temp = new Node<E>(value, ref, ref.prev);
			ref.prev = temp;
			temp.prev.next = temp;
			size++;
		}
	}
	
	public E get(int ndx){
		setRef(ndx);
		return ref.value;
	}
	
	public E set(int ndx, E value){
		setRef(ndx);
		E temp = ref.value;
		ref.value = value;
		return temp;
	}
	
	public E remove(int ndx){
		setRef(ndx);
		E result = ref.value;
		ref.next.prev = ref.prev;
		ref.prev.next = ref.next;
		size --;
		return result;
	}
	
	public int indexOf(Object obj){
		Node<E> ref = head.next;
		for(int i = 0;i < size;i++){
			if(ref.equals(obj)){
				return i;
			}
			ref = ref.next;		
		}
		return -1;
	}
	
	public boolean remove(Object other) {
		int i = indexOf(other);
		remove(i);
		if(get(i) != other) {
			return true;
		}
		else return false;
	}
	
	public boolean contains(Object obj) {
		return true;
	}
	
	public String toString() {
		String str = "[";
		Node<E> temp = head.next;
		while(temp.value != null) {
			if(!(temp.next.value == null)) {
				str += temp.value + ",";
			}else {
				str += temp.value;
			}
			temp = temp.next;
		}
		str += "]";
		return str;
	}
	
	public boolean equals(Object other) {
		if(!(other instanceof List)) {
			return false;
		}
		@SuppressWarnings("unchecked")
		List<E> lit = (List<E>)other;
		if(lit.size() != this.size()) {
			return false;
		}
			Iterator<E> it = lit.iterator();
			Iterator<E> itty = this.iterator();
			while(it.hasNext() && itty.hasNext()) {
				if(!(it.next().equals(itty.next()))) {
					return false;
				}
			} return true;
	}
	
	private void setRef(int ndx) {
		ref = head.next;
		for(int i = 0; i < ndx; i++) {
			ref = ref.next;
		}
	}
	
	public Iterator<E> iterator() {
		return new RefIterator<E>(this);
	}
	
	public ListIterator<E> listIterator() {
		return new RefListIterator<E>(this);
	}
	
	public ListIterator<E> listIterator(int start) {
		return new RefListIterator<E>(this, start);
	}
	
	public boolean containsNull() {
		return true;
	}
	
	public void addAll(List<E> other) {
		Iterator<E> itty = other.iterator();
		while(itty.hasNext()) {
			add((E)itty.next());
		}
	}
}
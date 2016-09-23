package list;

public class ArrayList<E> implements List<E>{

	int size = 0;
	E[]values;
	
	@SuppressWarnings("unchecked")
	public ArrayList(int cap){
		values=(E[]) new Object [cap];
	}
	
	public ArrayList(){
		this(10);
	}
	
	public int size(){
		return size;
	}
	
	public boolean isEmpty(){
		if(size == 0){
			return true;
		}
		return false;
	}
	
	public void clear(){
		for(int i = 0; i < values.length; i++){
			values[i]=null;
		}
		size=0;
	}
	
	public void add(E value){
		add(size, value);
	}
	
	public void add(int ndx, E value){
		if(size == values.length){
			alloc();
		}
		for(int i = size; i > ndx; i--){
			values[i] = values[i - 1];
		}
		values[ndx] = value;
		size++;
	}
	
	public E get(int ndx){
		return values[ndx];
	}
	
	public E set(int ndx, E value){
		E temp = values[ndx];
		values [ndx] = value;
		return temp;
	}
	
	public E remove(int ndx){
		if(ndx >= 0 && ndx < size){
		E result = values[ndx];
		for(int i = ndx; i < size; i++){
			values[i] = values[i + 1];
		}
			size--;
			return result;
		}
		return null;
	}
	
	public int indexOf(Object obj){
		for(int i = 0; i < size; i++){
			if(values[i].equals(obj)){
				return i;
			}
		}
		return -1;
	}
	
	@SuppressWarnings("unchecked")
	public void alloc(){
		E[] temp=(E[])new Object[2 * values.length];
		for(int i = 0; i < values.length; i++){
			temp[i]=values[i];
		}
		values = temp;
	}
	
	public boolean remove(Object obj) {
		int i = indexOf(obj);
		if(i == -1) {
			return false;
		}
		remove(i);
		return true;
	}
	
	public boolean contains(Object obj) {
		if(indexOf(obj) > -1) {
			return true;
		} return false;
	}
	
	public String toString() {
		String s = "[";
		for(int i = 0; i < size; i++){
			if( values[i] != null ) {
				if(i == size - 1) {
					s += values[i].toString();
				} else {
					s += values[i].toString() + ",";
				}
			} else if(i == size - 1)
				s += "null";
			else
				s += "null,";
				
		}
		return (s += "]");
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
	
	public Iterator<E> iterator() {
		return new ArrayIterator<E>(this);
	}
	
	public ListIterator<E> listIterator() {
		return new ArrayListIterator<E>(this);
	}
	
	public ListIterator<E> listIterator(int start) {
		return new ArrayListIterator<E>(this, start);
	}
	
	public boolean containsNull() {
		if(!isEmpty()) {
			for(int i = 0; i < size; i++) {
				if(values[i] == null) {
					return true;
				}
			}
		}
		return false;
	}
	
	public void addAll(List<E> other) {
		Iterator<E> itty = other.iterator();
		while(itty.hasNext()) {
			add((E)itty.next());
		}
	}
}

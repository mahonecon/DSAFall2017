package list;

public interface List<E> {

	int size();
	
	boolean isEmpty();
	
	void clear();
	
	void add(E value);
	
	void add(int ndx, E value);
	
	E get(int ndx);
	
	E set(int ndx, E value);
	
	E remove(int ndx);
	
	int indexOf(Object obj);
	
	/** @return true only if the given object is contained in this List */
    boolean contains (Object obj);
    
    /** Remove the first occurrence of the given object from this List, if possible.
    *  @return true only if it was removed.
    */
    boolean remove (Object obj);
    
    /** @return the elements of this List as a String, with elements
     * separated by commas [a,b,c] */
    String toString();
    
    /** @return true only if this List is equal to the parameter, other */
    boolean equals(Object other);
    
    /**  @return true if this List contains at least one null reference.  */
    boolean containsNull();
    
    /** Add all elements of other to the end of this List */
    void addAll (List<E> other);
    
    /** @return iterator */
    Iterator<E> iterator();
}
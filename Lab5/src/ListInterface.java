// ********************************************************
// Interface ListInterface for the ADT list.
// *********************************************************
/*
 * Purpose: Data Structure and Algorithms Lab 5
 * Status: Complete and thoroughly tested
 * Last update: 10/09/17
 * Submitted: 10/10/2017
 * Comment: test suite and sample run attached
 * @author: Conor J. Mahoney
 * @version: 2017.10.09
 */
public interface ListInterface<T> {

    boolean isEmpty();

    int size();

    void add(int index, T item)
            throws ListIndexOutOfBoundsException;

    T get(int index)
            throws ListIndexOutOfBoundsException;

    void remove(int index)
            throws ListIndexOutOfBoundsException;

    void removeAll();
}  // end ListInterface

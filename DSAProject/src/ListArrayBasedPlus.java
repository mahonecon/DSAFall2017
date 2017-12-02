/*
 * Purpose: Data Structure and Algorithms Midterm
 * Status: Complete and thoroughly tested
 * Last update: 10/18/17
 * Submitted: 10/18/2017
 * Comment: test suite and sample run attached
 * @author: Conor J. Mahoney
 * @version: 2017.10.18
 */
public class ListArrayBasedPlus<T> extends ListArrayBased<T> {

    public ListArrayBasedPlus() {
        super();
    }

    public boolean isEmpty() {
        if(size() == 0) {
            return true;
        }
        return false;
    }

    public int size() {
        return super.size();
    }

    public void removeAll() {
        super.removeAll();
    }

    public void add(int index, T item) {
        try {
            super.add(index, item);
        } catch (ListIndexOutOfBoundsException x) {
            resize();
            super.add(index, item);
        } catch (ListException x) {
        	resize();
        	super.add(index, item);
        }
    }

    public T get(int index) {
        return super.get(index);
    }

    public void remove(int index) {
        super.remove(index);
    }

    public void reverse() {
        T[] temp = (T[])new Object[size()];
        if(size() >= 1) {
            for(int i = 0; i < size(); i++) {
                temp[i] = items[(size() - 1) - i];
            }
            items = temp;
        }
        else {
            System.out.println("List has no items to reverse!");
        }
    }

    public void resize() {
        int newSize = (int)Math.round(1.5*size());
        T[] temp = (T[])new Object[newSize];
        for(int i = 0; i < size(); i++) {
            temp[i] = items[i];
        }
        items = temp;
    }

    public String toString() {
        String s = "";
        for(int i = 0; i < size(); i++) {
            s += items[i].toString() + " ";
        }
        return s;
    }
}

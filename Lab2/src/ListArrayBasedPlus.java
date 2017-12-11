/*
 * Purpose: Data Structure and Algorithms Lab 2 Problem 1
 * Status: Complete and thoroughly tested
 * Last update: 11/04/17
 * Comment: test suite and sample run attached
 * @author: Conor J. Mahoney
 * @version: 2017.11.04
 */
public class ListArrayBasedPlus extends ListArrayBased {

    public ListArrayBasedPlus() {
        super();
    }

    public void add(int index, Object item) {
        try {
            super.add(index, item);
        } catch (ListException x) {
            resize();
            super.add(index, item);
        }
    }

    public void reverse() {
        Object[] temp = new Object[size()];
        if (size() >= 1) {
            for (int i = 0; i < size(); i++) {
                temp[i] = items[(size() - 1) - i];
            }
            items = temp;
        } else {
            System.out.println("List has no items to reverse!");
        }
    }

    public void resize() {
        int newSize = (int) Math.round(1.5 * size()) + 1;
        Object[] temp = new Object[newSize];
        for (int i = 0; i < size(); i++) {
            temp[i] = items[i];
        }
        items = temp;
    }

    public String toString() {
        String s = "";
        for (int i = 0; i < size(); i++) {
            s += items[i].toString() + " ";
        }
        return s;
    }
}

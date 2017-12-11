/*
 * Purpose: Data Structure and Algorithms Lab 2 Problem 2
 * Status: Complete and Thoroughly tested
 * Last update: 09/18/17
 * Submitted: 09/19/17
 * Comment: test suite and sample run attached
 * @author: Conor J. Mahoney
 * @version: 2017.09.18
 */
import java.util.*;

public class ListArrayListBasedPlus extends ListArrayListBased {

    public ListArrayListBasedPlus() {
    }

    public void reverse() {
        ArrayList<Object> temp = new ArrayList<Object>();
        for (int i = 0; i < items.size(); i++) {
            temp.add(items.get((size() - 1) - i));
        }
        items = temp;
    }

    public String toString() {
        String out = "";
        for (Object o : items) {
            out += (o + " ");
        }
        return out;
    }
}

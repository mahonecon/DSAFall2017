
public class ListCDLSBased implements ListInterface {
    // reference to linked list of items

    private DNode tail;
    private int numItems; // number of items in list

    public ListCDLSBased() {
        numItems = 0;
        tail = null;
    }  // end default constructor

    public boolean isEmpty() {
        return numItems == 0;
    }  // end isEmpty

    public int size() {
        return numItems;
    }  // end size

    private DNode find(int index) {
        DNode curr = tail;
        if (index < numItems / 2) {
            for (int x = 0; x < index; x++) {
                curr = curr.getNext();
            } // end for
        } else {
            for (int x = numItems - index; x > 0; x--) {
                curr = curr.getBack();
            } // end for
        }

        return curr;
    } // end find

    public Object get(int index)
            throws ListIndexOutOfBoundsException {
        if (index >= 0 && index < numItems) {
            // get reference to node, then data in node
            DNode curr = find(index);
            Object dataItem = curr.getItem();
            return dataItem;
        } else {
            throw new ListIndexOutOfBoundsException(
                    "List index out of bounds exception on get");
        } // end if
    } // end get

    public void add(int index, Object item)
            throws ListIndexOutOfBoundsException {
        if (index == 0 && numItems == 0) {
            tail = new DNode(item);

        } else if (index == numItems) {
            // insert the new node containing item at
            // end of list
            DNode newDNode = new DNode(item, tail.getNext(), tail);
            tail.getNext().setBack(newDNode);
            tail.setNext(newDNode);
            tail = newDNode;

        } else if (index >= 0 && index < numItems) {
            DNode prev = find(index);
            // insert the new node containing item after
            // the node that prev references
            DNode newDNode = new DNode(item, prev, prev.getBack());
            prev.getBack().setNext(newDNode);
            prev.setNext(newDNode);

        } // end if
        else {
            throw new ListIndexOutOfBoundsException(
                    "List index out of bounds exception on add");
        } // end else
        numItems++;
    }  // end add

    public void remove(int index)
            throws ListIndexOutOfBoundsException {
        if (index >= 0 && index < numItems) {
            if (index == 0) {
                // delete the first node from the list
                tail = tail.getNext();
            } else {
                DNode prev = find(index - 1);
                // delete the node after the node that prev
                // references, save reference to node
                DNode curr = prev.getNext();
                prev.setNext(curr.getNext());
            } // end if
            numItems--;
        } // end if
        else {
            throw new ListIndexOutOfBoundsException(
                    "List index out of bounds exception on remove");
        }
    }

    public void removeAll() {
        tail = null;
        numItems = 0;
    }

    public String toString() {
        DNode temp = tail.getNext();
        String stringList = "";
        stringList += temp.getItem() + " ";
        while (temp != tail) {
            stringList += temp.getNext().getItem() + " ";
            temp = temp.getNext();
        }
        return stringList;
    }
} // end ListCDLSBased


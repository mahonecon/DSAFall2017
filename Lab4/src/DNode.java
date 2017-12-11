
public class DNode {

    private Object item;
    private DNode next;
    private DNode back;

    public DNode(Object newItem) {
        item = newItem;
        next = this;
        back = this;
    } // end constructor

    public DNode(Object newItem, DNode nextDNode, DNode backDNode) {
        item = newItem;
        next = nextDNode;
        back = backDNode;
    } // end constructor

    public void setItem(Object newItem) {
        item = newItem;
    } // end setItem

    public Object getItem() {
        return item;
    } // end getItem

    public void setNext(DNode nextDNode) {
        next = nextDNode;
    } // end setNext

    public DNode getNext() {
        return next;
    } // end getNext

    public void setBack(DNode backDNode) {
        next = backDNode;
    } // end setBack

    public DNode getBack() {
        return back;
    } // end getBack

} // end class Node

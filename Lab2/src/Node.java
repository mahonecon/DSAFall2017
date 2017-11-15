
/*
 * Purpose: Data Structure and Algorithms Lab 3 Problem Y
 * Status: Barely started 
 * Last update: 09/20/17
 * Submitted:
 * Comment: test suite and sample run attached
 * @author: Conor J. Mahoney
 * @version: 2017.09.20
 */
public class Node 
{
private Object item;
private Node next;

public Node(Object newItem) 
{
  item = newItem;
  next = null;
} // end constructor

public Node(Object newItem, Node nextNode) 
{
  item = newItem;
  next = nextNode;
} // end constructor

public void setItem(Object newItem) 
{
  item = newItem;
} // end setItem

public Object getItem() 
{
  return item;
} // end getItem

public void setNext(Node nextNode) 
{
  next = nextNode;
} // end setNext

public Node getNext() 
{
  return next;
} // end getNext
} // end class Nodeend class Node
import java.util.ArrayList;
//import java.io.*;
public class ListArrayListBased implements ListInterface{
	protected static ArrayList<Object> items = new ArrayList<>();
	protected int numItems;
	ListArrayListBased(){
	  
	  items = new ArrayList<Object>();
  	}
  	public void add(int index, Object item){
	  	items.add(index, item);

  	}
  	public void remove(int index){
  		items.remove(index);
  	}
  	public void removeAll(){
  		for(int i = 0;i < items.size();i++){
  			items.remove(i);
  		}
  	}
  	public static void reverse(){
  		ArrayList<Object> revItems = new ArrayList<>();
  		int index = items.size() - 1;
  		for(int j = 0; j < items.size();j++){
  			Object revItem = items.get(index - j);
  			revItems.add(revItem);
	  }
  	}
  	public static void printList(){
	  System.out.println("The List has a size of" + items.size() + "and has the items" + items.toString());
  	}
  	@Override
	public boolean isEmpty() {
		return (numItems ==0);
	}
	@Override
	public int size() {
	
		return items.size();
	}
	@Override
	public Object get(int index) throws ListIndexOutOfBoundsException {
		return null;
	}
  
  
}


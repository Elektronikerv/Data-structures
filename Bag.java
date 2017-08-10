import java.util.*;

//implementation of Bag collection

public class Bag<T> implements Iterable<T>  {
	private T array[];
	private int lastIndex = 0;
	
	public Bag(int n) {
		array = (T[])new Object[n];
	}

	public void add(T item) {
		if(lastIndex >= array.length)
			resize(2 * array.length);			
		array[lastIndex] = item;
		lastIndex++;
	}

	private void resize(int capacity) {
		T[] a = (T[]) new Object[capacity];
		for(int i = 0; i < lastIndex; i++)
			a[i] = array[i];
		array = a;  
	}

	public void clear() {
		for(int i = 0;i < lastIndex;i++) 
			array[i] = null;
		lastIndex = 0;
	}

	public boolean contains(T item) {
		for (int i = 0;i < lastIndex;i++) { 
			if(array[i] == item)
				return true;
		}
		return false;
	}

	public boolean remove(T item) {
		boolean exist = this.contains(item);
		if(!exist) 
			return false;
		for(int i = 0;i < lastIndex;i++) {
			if(array[i] == item) {
				lastIndex--;	
				array[i] = array[lastIndex]; //move last element to the free space
			}
		}
		return true;
	}

	public T grab() {
		Random rand = new Random();
		return array[rand.nextInt(lastIndex)];
	}

	public boolean isEmpty() {
		return (lastIndex == 0) ? true : false ;
	}
	public int size() {
		return lastIndex;
	}
	public String toString() {
		String s = "";
		for (int i = 0; i < lastIndex; i++) 
			s = s + (array[i] + " ");
	return  s;
	}

	public T[] toArray() {
		return array;
	}

	public Iterator iterator() {
		return new BagIterator();
	}

	private class BagIterator implements Iterator {
		int i = 0;
		
		public boolean hasNext() {
			return i < lastIndex;
		}

		public T next() {
			return array[i++]; 
		}

		public void remove() {}
	}
}
import java.util.*;

public class ArrayList<T> implements Iterable<T>{
	private T[] array;
	private int length = 0;
	private int capacity = 10;

	public ArrayList() {
		array = (T[])new Object[capacity];
	}

	public ArrayList(int capacity) {
		array = (T[])new Object[capacity];
		this.capacity = capacity;
	}

	public void add(T item) {
		if (isFull())
			enlarge();
		array[length++] = item;
	}

	public void add(int index, T item) {
		if(isFull())
			enlarge();
		System.out.println(length+ " " + capacity);
		System.arraycopy(array, index, array, index+1, length-index);
		array[index] = item;
		length++;
	}

	public void clear() {
		for (int i = 0; i < length; i++)
				array[i] = null;
		length = 0;	
	}

	public T get(int index) {
		return array[index];
	}

	public void set(int index, T item) {
		array[index] = item;
	}

	public boolean isFull() {
		return length >= capacity; 
	}

	public boolean isEmpty() {
		return length == 0;
	}

	public boolean remove(T item) {
		int index = indexOf(item);
		if(index == -1)
			return false;
		System.arraycopy(array, index+1, array, index, length-index-1);
		array[--length] = null;
		return true;
	}

	public void removeByIndex(int index) {
		System.arraycopy(array, index+1, array, index, length-index-1);
		array[--length] = null;
	}

	public void removeRange(int fromIndex, int toIndex) {
		if( fromIndex < toIndex) {
			int quentity = length - (toIndex);
			System.arraycopy(array, toIndex, array, fromIndex, quentity);
			for(int i = fromIndex + quentity; i < length; i++)
				array[i] = null;
			length -= (toIndex - fromIndex);
		}
		else 
			throw new IllegalArgumentException("fromIndex must be less than toIndex");
	}

	private void enlarge() {
		int newCapacity = (capacity * 3) / 2;
		T[] newArray = (T[]) new Object[newCapacity];
		System.arraycopy(array, 0, newArray, 0, length);
		capacity = newCapacity;
		array = newArray;
	}

	public void trimToSize() {
		T[] newArray = (T[]) new Object[length];
		System.arraycopy(array, 0, newArray,0, length);
		array = newArray;
	}

	public boolean contains(T item) {
		return indexOf(item) > 0;
	} 

	public int indexOf(T item) {
		int index = -1;
			for(int i=0; i < length; i++) {
				if(array[i].equals(item)) {
					index = i; 
					break;
				}
			}
		return index; 
	}

	public T[] toArray() {
		return array;
	}

	public int size() {
		return length;
	}

	@Override 
	public String toString() {
		String s = "";
		for(int i=0; i< array.length; i++)
				s += array[i] + " ";
		return s;
	}

	public ArrayListIterator iterator() {
		return new ArrayListIterator();
	}

	private class ArrayListIterator implements Iterator {
		int i = 0;

		public boolean hasNext() {
			return i < length;
		}

		public T next() {
			return array[i++];
		}
	}
}
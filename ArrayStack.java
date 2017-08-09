import java.util.*;
//Stack based on array

public class ArrayStack<T> implements Iterable<T> {


	private T[] array;
	private int n = 0;

	ArrayStack(int capacity) {
		array = (T[]) new Object[capacity];
	}

	public void push(T item) {
		if(n >= array.length)
			resize(2 * array.length);
		array[n++] = item;
	}
	public T pop() {
		if(n <= array.length / 4) 
			resize(array.length / 2);
		return  array[--n];
	}
	public boolean isEmpty() {
		return (n == 0) ? true : false;
	}

	private void resize(int capacity) {
		T[] a = (T[]) new Object[capacity];
		for(int i = 0; i < n; i++)
			a[i] = array[i];
		array = a;  
	}

	public T peek() {
		T item = pop();
		push(item);
		return item;
	}

	public Iterator<T> iterator() {
 		return new ArrayIterator();
	}

	private class ArrayIterator implements Iterator<T> {
		private int i = n;

		public boolean hasNext() {
			return i > 0;
		}

		public T next() {
			return array[--i];
		}
		public void remove() {}
	}
}
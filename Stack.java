
import java.util.*;

public class Stack<T> implements Iterable<T>  {
	private Node top;
	private int count = 0;
	private class Node<T> {
		T item;
		Node next;
		public Node() {}
		public Node(T item) {
			this.item = item;
		}
	}

	public void push(T item) {
		Node<T> node = new Node<>(item);
		node.next = top;
		top = node;
		count++;
	}

	public T pop() {
		count--;
		T item = (T)top.item;
		top = top.next;
		return item;
	}

	public T peek() {
		T item = (T)top.item;
		return item;
	}

	public boolean isEmpty() {
		return (count > 0) ? true : false ;
	}
	public void print() {
		for(Node n = top; n != null; n = n.next) {
			System.out.println(n.item);
		}
	}

	public Iterator iterator() {
		return new StackIterator();
	}

	private class StackIterator implements Iterator {
		int i = count;
		Node t = top;
		public boolean hasNext() {
			return i > 0;
		}

		public T next() {
			i--;
			T item = (T)t.item;
			t = t.next;
			return item; 
		}

		public void remove() {}
	}
}
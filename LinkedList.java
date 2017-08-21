
import java.util.*;

public class LinkedList<T> implements Iterable<T> {
	private Node<T> head = null;
	private Node<T> tail = null;
	private int size = 0;
	
	private class Node<T> {
		T item;
		Node next;
		public Node(){}
		public Node(T item) {
			this.item = item;
		}
	}

	public void add(T item) {
		addLast(item);
	}

	public void addFirst(T item) {
		Node<T> node = new Node<>(item);
		node.next = head;
		head = node; 
		size++;
	}

	public void addLast(T item) {
		Node<T> node = new Node<>(item);
		if(head == null) {
			head = node;
			tail = node;
		}
		else {
			tail.next = node; 
			tail = node;
		}
		size++;
	}

	public void removeFirst() {
		head = head.next;
		size--;
	}

	public void removeLast() {
		Node<T> node = head;
		while(node.next != tail)
			node = node.next;
		node.next = null;
		size--;
	}

	public T getLast() {
		return tail.item;
	}

	public T getFirst() {
		return head.item;
	}

	public boolean delete(T item) {
		Node<T> node = head;
		Node<T> nodeToDelete = head.next;
		while (nodeToDelete != tail) {
			if(nodeToDelete.item == item){
				node.next = node.next.next;
				return true;
			}
			node = node.next;
			nodeToDelete = nodeToDelete.next;
		}
		size--;
		return false;
	}

	public int size() {
		return size;
	}

	public boolean contains(T item) {
		Node<T> node = head;
		while(node != null){
			if(node.item == item)
				return true;
			node = node.next;
		}
		return false;
	}

@Override
	public String toString() {
		Node<T> pointer = head;
		String list = "";
		while(pointer != null) {
			list += pointer.item + " ";
			pointer = pointer.next;
		}
		return list;
	} 

	public Iterator iterator() {
		return new ListIterator();
	}

	private class ListIterator implements Iterator {
		Node<T> node = head;

		public boolean hasNext() {
			return (node != null);
		}

		public T next() {
			T next =  node.item;
			node = node.next;
			return next;
		}
	}	
}
package list;

public class LinkedList<E> implements List<E> {

	private int size = 0;
	private Node<E> head = null;
	private Node<E> tail = null;

	@Override
	public void add(E element) {
		Node<E> newNode = new Node<E>(element);
		if (head == null) {

			head = newNode;
		} else {
			Node<E> x = head;
			while (x.next != null) {
				x = x.next;
			}

			x.next = newNode;
		}

		tail = newNode;
		size++;

	}

	@Override
	public void add(int index, E element) {
		Node<E> newNode = new Node<E>(element);
		Node<E> x = head;

		if (size < index) {
			throw new IndexOutOfBoundsException("Index:" + index + ", size:" + size);
		}

		if (head == null) {
			head = newNode;
		} else if (index == 0) {

			head = newNode;
			newNode.next = x;

		} else {
			Node<E> prex = head;
			for (int i = 0; i < index - 1; i++) {
				prex = prex.next;
			}
			for (int i = 0; i < index; i++) {
				x = x.next;
			}

			prex.next = newNode;
			newNode.next = x;
		}

		settail();
		size++;
	}

	@Override
	public E get(int index) {

		if (index == size) {
			throw new IndexOutOfBoundsException("Index:" + index + ", size:" + size);
		}
		Node<E> x = head;

		for (int i = 0; i < index; i++) {
			x = x.next;
		}

		return x.data;
	}

	@Override
	public E remove(int index) {
		Node<E> x = head;

		if (size <= index) {
			throw new IndexOutOfBoundsException("Index:" + index + ", size:" + size);
		}

		if (index == 0) {
			head = head.next;
			x = null;

		} else {
			Node<E> prex = head;
			for (int i = 0; i < index - 1; i++) {
				prex = prex.next;
			}
			for (int i = 0; i < index; i++) {
				x = x.next;
			}

			prex.next = x.next;
			x = null;
		}

		settail();
		size--;

		return null;
	}

	@Override
	public void removeAll() {

		for (Node<E> x = head; x != null;) {
			Node<E> next = x.next;
			x.data = null;
			x.next = null;

			x = next;
		}

		head = null;
		tail = null;
		size = 0;

	}

	public void settail() {
		Node<E> x = head;
		while (x.next != null) {
			x = x.next;
		}
		tail = x;

	}

	@Override
	public int size() {
		return size;
	}

	private static class Node<E> {
		private Node<E> next;
		private E data;

		private Node(E element) {
			this.data = element;
			this.next = null;
		}

		private Node(E element, Node<E> next) {
			this.data = element;
			this.next = next;
		}

	}
}

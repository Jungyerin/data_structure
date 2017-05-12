package stack;

public class DoublyLinkedList<E> implements List<E> {

	private int size = 0;
	private Node<E> head = null;
	private Node<E> tail = null;

	@Override
	public void add(E element) {
		final Node<E> newNode = new Node<E>(element);

		if (head == null) {
			head = tail = newNode;
		} else {
			tail.next = newNode;
			newNode.prev = tail;
			tail = newNode;
		}

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
			head = tail = newNode;
		} else if (index == 0) {

			head = x.prev = newNode;
			newNode.next = x;
			newNode.prev = null;

		} else {

			for (int i = 0; i < index; i++) {
				x = x.next;
			}
			newNode.prev = x.prev;
			newNode.next = x;
			x.prev.next = newNode;
			x.prev = newNode;
		}

		settail();
		size++;

	}

	@Override
	public E get(int index) {
		if (index == size) {
			throw new IndexOutOfBoundsException("Index:" + index + ", size:" + size); // unchecked
																						// exception
																						// ?
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
			// x = null;

		} else if (index == size - 1) {
			for (int i = 0; i < index; i++) {
				x = x.next;
			}

			x.prev.next = null;
		}

		else {
			for (int i = 0; i < index; i++) {
				x = x.next;
			}

			x.prev.next = x.next;
			x.next.prev = x.prev;
			// x = null;
		}
		settail();
		size--;

		return x.data;
	}

	@Override
	public void removeAll() {
		Node<E> x = head;

		while (x != null) {
			Node<E> next = x.next;
			x.next = null;
			x.prev = null;
			x = next;
		}
		size = 0;
		head = null;
		tail = null;

	}

	@Override
	public int size() {

		return size;
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String toString() {
		String s = "[";
		int index = 0;
		Node<E> x = head;

		while (x != null) {
			if (index++ > 0) {
				s += ", ";
			}
			s += x.data;
			x = x.next;
		}
		s += "]";

		return s;
	}

	public void settail() {
		Node<E> x = head;
		while (x.next != null) {
			x = x.next;
		}
		tail = x;

	}

	@Override
	public stack.Iterator<E> iterator() {

		return new Iterator<E>() {
			private int index = 0;
			Node<E> x = head;

			@Override
			public boolean hasNext() {

				return index < size;
			}

			@Override
			public E next() {

				index++;
				if (index - 1 == 0) {
					return head.data;
				} else {
					x = x.next;
					return x.data;
				}

			}

		};
	}

	private static class Node<E> {
		private Node<E> next;
		private Node<E> prev;
		private E data;

		private Node(E element) {
			this.data = element;
			this.next = null;
			this.prev = null;
		}

	}

}

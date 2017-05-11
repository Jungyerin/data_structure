package list;

public class CircularLinkedList<E> implements List<E> {

	private int size = 0;
	private Node<E> tail = null;
	private Node<E> pos = null;

	@Override
	public void add(E element) {
		final Node<E> newNode = new Node<E>(element);

		if (tail == null) {
			tail = newNode.next = newNode; // 처음 노드를 추가할 때 하나의 노드 밖에 존재하지 않기 때문에
											// 자신을 가리키고 있어야 함.
		} else {
			newNode.next = tail.next; // 추가는 head에 추가를 함. head
			tail.next = newNode;
			tail = tail.next;
		}

		size++;

	}

	@Override
	public void add(int index, E element) {

		Node<E> newNode = new Node<E>(element);
		Node<E> x = tail.next;

		if (size < index) {
			throw new IndexOutOfBoundsException("Index:" + index + ", size:" + size);
		}

		if (tail == null) {
			tail = newNode.next = newNode;
		} else if (index == 0) {

			tail.next = newNode;
			newNode.next = x;

		} else {
			Node<E> prex = tail.next;
			for (int i = 0; i < index - 1; i++) {
				prex = prex.next;
			}
			for (int i = 0; i < index; i++) {
				x = x.next;
			}

			prex.next = newNode;
			newNode.next = x;
		}

		size++;

	}

	@Override
	public E get(int index) {
		if (index == size) {
			throw new IndexOutOfBoundsException("Index:" + index + ", size:" + size); // unchecked
																						// exception
																						// ?
		}
		Node<E> x = tail.next;
		for (int i = 0; i < index; i++) {
			x = x.next;
		}

		return x.data;

	}

	@Override
	public E remove(int index) {
		Node<E> x = tail.next;

		if (size <= index) {
			throw new IndexOutOfBoundsException("Index:" + index + ", size:" + size);
		}

		if (index == 0) {
			tail.next = tail.next.next;

		} else {
			Node<E> prex = tail.next;
			for (int i = 0; i < index - 1; i++) {
				prex = prex.next;
			}
			for (int i = 0; i < index; i++) {
				x = x.next;
			}

			prex.next = x.next;
		}

		size--;

		return x.data;
	}

	@Override
	public void removeAll() {
		Node<E> x = tail.next;
		while (x != tail) {
			Node<E> next = x.next;
			x.next = null;
			x = next;
		}

		tail.next = null;
		tail = null;
		size = 0;

	}

	@Override
	public int size() {

		return size;
	}

	@Override
	public Object[] toArray() {
		Object[] arr = new Object[size];
		if (tail == null) {
			return arr;
		}

		int index = 0;
		Node<E> x = tail.next;
		while (true) {
			arr[index++] = x.data;
			x = x.next;

			if (x == tail.next) // 다시 head로 이동됨.
			{
				break;
			}
		}
		return arr;
	}

	@Override
	public String toString() {
		String s = "[";
		int index = 0;
		Node<E> x = tail == null ? null : tail.next;

		while (index < size) {
			if (index++ > 0) {
				s += ", ";
			}
			s += x.data;
			x = x.next;
		}
		s += "]";

		return s;

	}

	public E next() {

		return null;
	}

	@Override
	public list.Iterator<E> iterator() {

		return new Iterator<E>() {
			private int index = 0;
			Node<E> x = tail.next;

			@Override
			public boolean hasNext() {

				return index < size;
			}

			@Override
			public E next() {

				index++;
				if (index - 1 == 0) {
					return tail.next.data;
				} else {
					x = x.next;
					return x.data;
				}

			}

		};
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

package stack;


public class ArrayList<E> implements List<E> {

	private static final int INIT_CAPACITY = 3;
	private E[] data;
	private int size;

	@SuppressWarnings("unchecked")
	public ArrayList() {
		size = 0;
		resize();
	}

	private void resize() {
		int capacity = (data == null) ? INIT_CAPACITY : data.length * 2;
		E[] temp = (E[]) (new Object[capacity * 2]);

		for (int i = 0; i < size; i++) {
			temp[i] = data[i];
		}

		data = temp; // ????????저절로 늘어남?????
	}

	@Override
	public void add(E element) {

		if (data.length <= size) {   //버퍼가 모자라지 않은 경우 : 1 버퍼가 모자란 경우 : n (빅오 시간복잡도) 최악의 경우를 정하기 때문에 시간복잡도는 n이 됨
			resize();
		}

		data[size] = element;
		size++;
	}

	@Override
	public void add(int index, E element) {

	}

	@Override
	public E get(int index) {
		
		if(index==size)
		{
			throw new IndexOutOfBoundsException("Index:"+index+", size:"+size); //unchecked exception ?
		}

		return data[index];  //복잡도 1
	}

	@Override
	public E remove(int index) {
		if (size <= index || index < 0) {
			throw new IndexOutOfBoundsException("Index:" + index + ", size:" + size);
		}

		E element = data[index];

		for (int i = index; i < size - 1; i++) {
			data[i] = data[i + 1];
		}

		size--;

		return element;
	}

	@Override
	public void removeAll() {
		for(int i=0;i<size;i++){
			data[i]=null;
		}
		size=0;

	}

	@Override
	public int size() {

		return size;
	}

	@Override
	public Object[] toArray() {
		return null;
	}

	@Override
	public stack.Iterator<E> iterator() {
		
		return new Iterator<E>(){
			private int index=0;
			@Override
			public boolean hasNext() {
				
				return index<size;
			}

			@Override
			public E next() {
				
				return data[index++];
			}
			
		};
	}


	

}

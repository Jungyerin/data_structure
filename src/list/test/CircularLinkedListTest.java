package list.test;

import java.util.Arrays;

import list.CircularLinkedList;
import list.Iterator;
import list.List;

public class CircularLinkedListTest {

	public static void main(String[] args) {

		List<Integer> list = new CircularLinkedList<Integer>();

		// add 연산
		list.add(11);
		list.add(22);
		list.add(22);
		list.add(33);
		list.add(44);
		list.add(44);

		// size 연산
		int count = list.size();
		System.out.println("리스트 크기:" + count);

		// get 연산 테스트
		for (int i = 0; i < count; i++) {
			System.out.println(i + "번째 항목: " + list.get(i));
		}
		
	/*	Iterator<Integer> it = list.iterator();				//iterator는 한번 할당받아서 루프를 돌고나서는 다시 쓸수없다(다시 할당을 받아서 사용가능)
		while(it.hasNext())
		{
			int i=it.next();		//auto unboxing
			System.out.println("it:"+i);
		}*/

		// add(index, element) 테스트
		System.out.println(list);
		list.add(0, 1);
		System.out.println(list);
		list.add(1, 2);
		System.out.println(list);
		list.add(2, 3);
		System.out.println(list);
		list.add(3, 4);
		System.out.println(list);

		// remove( index ) 테스트
		System.out.println("삭제 항목: " + list.remove(0));
		System.out.println(list);
		System.out.println("삭제 항목: " + list.remove(1));
		System.out.println(list);
		System.out.println("삭제 항목: " + list.remove(list.size() - 1));
		System.out.println(list);

		
		for(int i=0;i<list.size();i++)
		{
			System.out.println(((CircularLinkedList<Integer>) list).next());
		}
		
		
		// removeAll 테스트
	/*	list.removeAll();
		System.out.println(Arrays.toString(list.toArray()));

		// 예외 테스트
		try {
			list.get(0);
		} catch (IndexOutOfBoundsException e) {
			System.out.println("예외발생:" + e);
		}*/

	}

}

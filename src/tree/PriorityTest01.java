package tree;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityTest01 {

	public static void main(String[] args) {
		Queue<String> pq=new PriorityQueue<String>(10,new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				return o1.length()-o2.length(); //앞의 것이 긴수이면 + 뒤의 것이 길면 - 
			}	
			
		});  //초기값을 넣어줌 : 배열을 할때만 초기값을 넣어주었으므로 우선순위큐는 배열을 기반으로 만들어져 있다.
		
		
		pq.offer("A");
		pq.offer("ABCDE");
		pq.offer("ABC");
		pq.offer("ABCDEFGHI");
		pq.offer("ABCDE");
		
		while(pq.isEmpty()==false){
			System.out.println(pq.poll());
		}
		

	}

}

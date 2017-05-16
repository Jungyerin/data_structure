package tree;



public class PiorityTest02 {

	public static void main(String[] args) {

		PriorityQueue pq=new PriorityQueue(10);		
		
		pq.offer("A");
		pq.peek();
		
		pq.offer("ABCDE");
		pq.peek();
		
		pq.offer("ABC");
		pq.peek();
		
		pq.offer("ABCDEFGHI");
		pq.peek();
		
		pq.offer("ABCDEF");
		pq.peek();
		
		pq.offer("AB");
		pq.peek();
		
		System.out.println(pq.poll());
		pq.peek();		
		System.out.println(pq.poll());
		pq.peek();

		System.out.println(pq.poll());
//		System.out.println(pq.poll());
//		System.out.println(pq.poll());

	}

}

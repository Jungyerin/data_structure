package list;

public class ArrayListTest {

	public static void main(String[] args) {
		
		List<Integer> list=new ArrayList<Integer>();
		
		//add 연산
		list.add(11);
		list.add(22);
		list.add(22);
		list.add(33);
		list.add(44);
		list.add(44);
		
		//size 연산
		int count=list.size();
		System.out.println("리스트 크기:"+list.size());
		
		//get연산 테스트
		for(int i=0;i<count;i++)
		{
			System.out.println(i+"번쨰 항목:"+list.get(i));
		}
		
		//removeall 테스트
		list.removeAll();
		
		//size 연산
		count=list.size();
		System.out.println("리스트 크기 : "+count);
		
		//예외 테스트
		try{
		list.get(0);
		}catch(IndexOutOfBoundsException e)
		{
			e.printStackTrace();
		}

		
	}

}

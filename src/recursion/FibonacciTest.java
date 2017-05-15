package recursion;

public class FibonacciTest {

	public static int countOfCall=0;
	public static void main(String[] args) {
		
		
			System.out.println("5"+" : "+fibonacci(5)+" : "+countOfCall);
		

	}

	public static int fibonacci(int n) {
		
		countOfCall++;
		if(n==0){
			return 0;
		}
		
		if(n==1){
			return 1;
		}
		
		return fibonacci(n-1)+fibonacci(n-2);
	}

	/*public static int fibonacciLoop(int n){ //피보나치 반복문으로바꾸기
		return 0;
	}*/
}

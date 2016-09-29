package algorithmicToolBox.introduction;

public class Fibonacci {

	public static void main(String[] args) {
		

		System.out.println(new Fibonacci().fibonacciNaive(20));
		System.out.println(new Fibonacci().fibonacci(30));

	}

	public int fibonacciNaive(int n) {
		if (n <= 1) {
			return n;
		} else {
			return fibonacciNaive(n - 1) + fibonacciNaive(n - 2);
		}
	}
	
	public int fibonacci(int n) {
		
		if (n <= 1) {
			return n;
		}
		
		int[] fibSequence = new int[n+1];
		fibSequence[0]=0;
		fibSequence[1]=1;
		
		for (int i = 2; i <= n; i++) {
			fibSequence[i]=fibSequence[i-1]+fibSequence[i-2];
		}
		
		
		return fibSequence[n];
	}

}

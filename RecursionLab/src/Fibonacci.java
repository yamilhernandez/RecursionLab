
public class Fibonacci {

	public static void main(String[] args) {
		System.out.println(fib(30));

	}
	public static long fib(int n) { 
		   if (n == 1 || n == 0) return 1; 
		   else return fib(n-1) + fib(n-2); 
		}
	

}

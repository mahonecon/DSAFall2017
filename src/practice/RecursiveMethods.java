package practice;

public class RecursiveMethods {

	public static void main(String[] args) {
		int i = fact(3);
		System.out.println(i);
		i = fib(2);
		System.out.println(i);
		System.out.println(pal(""));
	}
	
	public static int fact(int n) { //Factorial recursive method
		if (n == 0) return 1; //Base Case
		return (n*fact(n-1)); //Recursive Case
	}
	
	/** @return the nth number of the fibonacci sequence. */
	public static int fib(int n) { //Fibonacci sequence
		if(n < 2) return 1; //Base case, fib(0) && fib(1) == 1.
		return fib(n-1) + fib(n-2); //Recursive Case
	}
	
	/** @return true only if str is a palindrome. (CASE-SENSITIVE) */
	public static boolean pal(String str) { /* Palindrome: A String that reads the same forward or backward.
		* If the first and last letters are not equal, then it is not a palindrome. If the length of the String
		* is less than 2, it is a palindrome. */
		if(str.length() < 2) {
			return true;
		}
		if(str.charAt(0) != str.charAt(str.length() - 1)) {
			return false;
		}
		String mid = str.substring(1, (str.length() - 1));
		return pal(mid);
	}
}

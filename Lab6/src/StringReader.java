import java.io.*;

public class StringReader {

	public static BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
	public static ListArrayBased<String> q = new ListArrayBasedPlus<String>();
	public static String firstHalf = "";
	public static String secondHalf = "";
	
	public static void main(String[] args) throws IOException {
		
		System.out.println("*****************************************************************************");
		
		String code = "";
		int pos = 0;
		int minusPos = 0;
		boolean minus = false;
		while(!code.equals(".")) {
			System.out.print("Enter Character: ");
			code = stdin.readLine().replaceAll("//s+", "");
			System.out.print(code + "\n");
			q.add(pos, code);
			if(code.equals("-")) {
				minusPos = pos;
				minus = true;
			}//end if
			pos++;
		}//end while
		if(minus) {
			
			for(int i = 0; i < minusPos; i++) {
				firstHalf += q.get(i);
			}//end for
			
			for(int i = (minusPos + 1); i < q.size() - 1; i++) {
				secondHalf += q.get(i);
			}//end for
			
			if(firstHalf.length() > secondHalf.length() && firstHalf.length() != 0) {
				System.out.println("Left Longer<<");
				} 
			else if(secondHalf.length() > firstHalf.length() && secondHalf.length() != 0) {
					System.out.println("\t >>Right Longer");
					} 
			else if(secondHalf.toUpperCase().equals(firstHalf.toUpperCase())) {
				System.out.print("Same Length and Same content, ");
				if(isPalindrome(secondHalf.toUpperCase())) {
					System.out.print("Palindrome \n");
					} else {
						System.out.print("No Palindrome \n");
						}
					}
			else if(secondHalf.length() == firstHalf.length()) {
						System.out.println("Same Length, Different Content"); 
						}
		} else {
			System.out.println("No Minus");
		}
		
	}//end main
	
	public static boolean isPalindrome(String s) {
		int size = s.length();
		
		if(s.length() == 0) {
			return false;
		}
		
		for(int i = 0; i < (size/2); i++) {
			if(s.charAt(i) != s.charAt(size - i - 1)) {
				return false;
			}
		}
		return true;
	}
}
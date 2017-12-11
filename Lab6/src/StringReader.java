
import java.io.*;

public class StringReader {

    public static BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
    public static ListArrayBased<Character> q = new ListArrayBasedPlus<Character>();
    public static String firstHalf = "";
    public static String secondHalf = "";

    public static void main(String[] args) throws IOException {

        System.out.println("*****************************************************************************");

        char code = 0;
        int pos = 0;
        int minusPos = 0;
        boolean minus = false;
        while (code != '.') {
            System.out.print("Enter Character: ");
            code = (char) stdin.read();
            System.out.print(code + "\n");
            if (code != '\n') {
                q.add(pos, code);
                pos++;
            }
            if (code == '-') {
                minusPos = pos;
                minus = true;
            }//end if
        }//end while
        if (minus) {

            for (int i = 0; i < minusPos - 1; i++) {
                firstHalf += q.get(i);
            }//end for

            for (int i = (minusPos); i < q.size() - 1; i++) {
                secondHalf += q.get(i);
            }//end for

            if ((firstHalf.length() > secondHalf.length()) && firstHalf.length() != 0) {
                System.out.println("Left Longer<<");
            } else if ((secondHalf.length() > firstHalf.length()) && secondHalf.length() != 0) {
                System.out.println("\t >>Right Longer");
            } else if (secondHalf.length() == firstHalf.length()) {
                if (!secondHalf.equalsIgnoreCase(firstHalf)) {
                    System.out.println("Same Length, Different Content");
                } else {
                    System.out.print("Same Length and Same content, ");
                    if (isPalindrome(secondHalf.toUpperCase())) {
                        System.out.print("Palindrome \n");
                    } else {
                        System.out.print("No Palindrome \n");
                    }
                }
            }
        } else {
            System.out.println("No Minus");
        }

    }//end main

    public static boolean isPalindrome(String s) {
        int size = s.length();

        if (s.length() == 0) {
            return false;
        }

        for (int i = 0; i < (size / 2); i++) {
            if (s.charAt(i) != s.charAt(size - i - 1)) {
                return false;
            }
        }
        return true;
    }
}

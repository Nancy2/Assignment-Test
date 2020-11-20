import java.util.*;

public class Test {

	public static String getPalindromeString(String str) {

	
		int n = str.length();

		// Character Array with ASCII 256 length
		int[] charCountArray = new int[256];

		// Increment value of Character Array based on String characters
		for (int i = 0; i < n; i++) {
			charCountArray[str.charAt(i)]++;
		}

		StringBuilder leftString = new StringBuilder();
		StringBuilder rightString = new StringBuilder();

		//leftString and RightString will form the half of Palindrome
		for (int i = 0; i < 256; i++) {

			for (int j = 0; j < charCountArray[i] / 2; j++) {
				leftString.append((char) i);
			}

			for (int j = (charCountArray[i] + 1) / 2; j < charCountArray[i]; j++) {
				rightString.append((char) i);
			}
		}
		// tmp to store the reverse copy of one half of str.
		StringBuilder tmp = rightString.reverse();

		// Odd character append boolean variable
		boolean b = false;

		// Append all the character which occurs odd number of times
		for (int i = 0; i < 256; i++) {
			// If count of occurrence of characters is odd
			if (charCountArray[i] % 2 == 1) {
				if (!b) {
					leftString.append((char) i);
					b = true;
				} else {
					return "Not a Valid Palindrome Input";	//will be executed when input string cannot form a palindrome.
				}
			}
		}
		return (leftString.toString() + tmp.toString());
	}

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in); 
		System.out.println("Enter word length");
		int w = s.nextInt();
		System.out.println("Enter alphabet count");
		int x = s.nextInt();
		System.out.println("Enter number count");
		int y = s.nextInt();
		System.out.println("Enter special symbol count");
		int z = s.nextInt();
		s.close();

		String str = "";

		if (w == x + y + z) {
			for (int i = 0; i < x; i++) {
				str = str + "a";
			}
			for (int i = 0; i < y; i++) {
				str = str + "1";
			}
			for (int i = 0; i < z; i++) {
				str = str + "$";
			}
			System.out.println("The created string based on input is : " + str);
			String palinString = getPalindromeString(str);
			System.out.println("----------------------------------------------");
			System.out.println(palinString);
		} else {
			System.out
					.println("Input count invalid. Sum of alpha + num + special symbol should be equal to word length");
		}

	}

}

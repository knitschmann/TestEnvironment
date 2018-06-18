package Palindrom;

import java.util.Scanner;

/**
 * Created by kevin on 11/06/15.
 */
public class PalindromMain {
    	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			//System.out.println(checkPalindromeIterativeVanilla(scanner.next()));
			System.out.println(showLongestPalindrome(scanner.next()));
		}
	}

	public static String showLongestPalindrome(String input){
		for (int i = 0; i < input.length(); i++) {
			String toCheck = input.substring(i, input.length()-i);
			if(checkPalindromeRecursive(toCheck)){
				return toCheck;
			}
		}	
		return null;
	}
    public static boolean checkPalindromeRecursive(String input) {
        if (input.length() > 1) {

            char first = input.charAt(0);
            char last = input.charAt(input.length() - 1);

            if (first == last) {
                String tmp = input.substring(1, input.length() - 1);
//                System.out.println("DEBUG: " + tmp);
                return checkPalindromeRecursive(tmp);
            }
            if (first != last) {
                return false;
            }
        }
        return true;

    }

    public static boolean checkPalindromeIterative(String input) {
        String reverse = "";

        for (int i = 0; i < input.length(); i++) {
            reverse = reverse + input.charAt(input.length() - 1 - i);
        }
        System.out.println(reverse);
        if (input.equals(reverse)) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean checkPalindromeIterativeVanilla(String input) {
        int j = input.length();
        for (int i = 0; i < input.length(); i++) {
            j--;
            if (j <= i) {
                break;
            }
            char front = input.charAt(i);
            char back = input.charAt(j);
            if (!(front == back)) {
                return false;
            }
        }
        return true;
    }

}

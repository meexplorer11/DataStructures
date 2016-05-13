package algos.String;

import java.util.Scanner;

/**
 * 
 * @author Javargon
 *
 */
public class StringReversal {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter input string- ");
		String input = sc.nextLine();
		System.out.println("Input: "+input);
		reverse(input);
	}

	private static void reverse(String input) {
		usingSplit(input);
		usingLoopOnly(input);
	}

	private static void usingLoopOnly(String input) {
		int count = 0;
		int i = input.length()-1;
		while(i >= 0) {
			if(input.charAt(i) != ' ') {
				++count;
			} else {
				int temp = i;
				System.out.print(input.substring(temp+1, temp+1+count)+" ");
				count = 0;
			}
			i--;
		}
		System.out.print(input.substring(i+1, i+1+count));
	}

	private static void usingSplit(String input) {
		String[] tokens = input.split(" ");
		for(int i=tokens.length-1; i>=0; i--) {
			System.out.print(tokens[i]+" ");
		}
	}

}

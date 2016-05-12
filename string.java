package algos.String;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * 
 * @author Javargon
 *
 */
public class MaskString {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter input: ");
		String input = sc.next();
		System.out.println("Characters to remove: ");
		String toRemove = sc.next();
		System.out.println("Remove '"+toRemove+"' from input '"+input+"'");
		maskString(input, toRemove);
	}

	private static void maskString(String input, String toRemove) {
		usingHashSet(input, toRemove);
		usingArray(input, toRemove);
	}

	//If both strings contain only a-z
	private static void usingArray(String input, String toRemove) {
		boolean[] hitArray = new boolean[26];
		for(char ch : toRemove.toLowerCase().toCharArray()) {
			hitArray[ch-97] = true;
		}
		StringBuilder s = new StringBuilder();
		for(char ch : input.toLowerCase().toCharArray()) {
			if(!hitArray[ch-97])
				s.append(ch);
		}
		System.out.println("Using array, Output: "+s);
	}

	private static void usingHashSet(String input, String toRemove) {
		Set<Character> removeSet = new HashSet<Character>();
		for(char ch : toRemove.toLowerCase().toCharArray()) {
			removeSet.add(ch);
		}
		StringBuilder s = new StringBuilder();
		for(char ch : input.toLowerCase().toCharArray()) {
			if(!removeSet.contains(ch))
				s.append(ch);
		}
		System.out.println("Using set, Output: "+s);
	}

}

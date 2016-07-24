package LeetCodeOJ;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ValidParentheses {
	public void test() {
		System.out.println("true : " + isValid("{}()[]"));
		System.out.println("true : " + isValid("{([])}"));
		System.out.println("false : " + isValid("{([)}"));
		System.out.println("false : " + isValid("(((((())))))("));
		System.out.println("false : " + isValid("]"));
	}

	public boolean isValid(String s) {
		Stack<Integer> stack = new Stack<Integer>();
		for (int i = 0; i < s.length(); i++) {
			if ("([{".indexOf(s.charAt(i)) != -1)
				stack.push("([{".indexOf(s.charAt(i)));
			else if (stack.isEmpty() || (")]}".indexOf(s.charAt(i)) != stack.pop()))
				return false;
		}
		return stack.isEmpty();
	}
}

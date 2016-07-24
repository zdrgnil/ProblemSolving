package LeetCodeOJ;

import java.util.Stack;

public class MinStack {
	/** initialize your data structure here. */

	Stack<Integer> stack;
	Stack<Integer> minStack;
	Integer min;

	public MinStack() {
		stack = new Stack<Integer>();
		minStack = new Stack<Integer>();
	}

	public void push(int x) {
		stack.push(x);
		if (minStack.isEmpty() || x <= minStack.peek()) {
			minStack.push(x);
		}
	}

	public void pop() {
		if (stack.isEmpty())
			return;
		if (stack.peek().equals(minStack.peek()))
			minStack.pop();
		stack.pop();
	}

	public int top() {
		return stack.peek();
	}

	public int getMin() {
		return minStack.peek();
	}

	public void status() {
		System.out.println("    stack:" + stack.toString());
		System.out.println("min stack:" + minStack.toString());
	}
}

package cebs_training;

import cebs_training.StackUsingLL.Node;

public class SpecialStackSimple {
	private StackUsingLL<Integer> stack;
	int min;
	
	SpecialStackSimple(){
		min = 0;
		stack = new StackUsingLL<>();
	}
	
	public int sizeOfStack() {
		return stack.sizeOfStack();
	}
	
	public int peek() {
		return stack.peek();
	}
	
	public void traverse() {
		if(isEmpty()) {
			System.out.println("Stack Empty");
			return;
		}
		@SuppressWarnings("rawtypes")
		Node temp = stack.getTop();
		System.out.println("Now Printing Stack Elements: \n");
		int i = 1;
		int m = min;
		
		while(temp != null) {
			int val = (int) temp.data;
			if(val < m) {
				m = 2*m - val;
				val = (val + min)/2;
			}
			System.out.println("Element " + i++ + " ==> " + temp.data);
			temp = temp.next;
		}
		
		System.out.println();	
	}
	
	
	public void push(int data) {
		if(isEmpty()) {
			stack.push(data);
			min = data;
			return;
		}
		if(data >= min) {
			stack.push(data);
			return;
		}
		int y = 2*data - min;
		min = data;
		stack.push(y);
	}
	
	public int pop() {
		if(isEmpty())
			return -1;
		int u = stack.peek();
		if(u >= min)
			return stack.pop();
		int y = 2*min - u;
		u = min;
		min = y;
		return u;
	}
	
	public boolean isEmpty() {
		return stack.isEmpty();
	}
	
	public int getMin() {
		return min;
	}
}

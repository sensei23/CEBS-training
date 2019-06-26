package cebs_training;

public class SpecialStackWithAuxStack {

	private StackUsingLL<Integer> min;
	private StackUsingLL<Integer> stack;
	
	
	SpecialStackWithAuxStack(){
		min = new StackUsingLL<>();
		stack = new StackUsingLL<>();
	}
	
	
	public boolean isEmpty() {
		return stack.isEmpty();
	}
	
	public int sizeOfStack() {
		return stack.sizeOfStack();
	}
	
	public int peek() {
		return stack.peek();
	}
	
	public void traverse() {
		stack.traverse();
	}
	
	
	public void push(int data) {
		stack.push(data);
		if(min.isEmpty()) {
			min.push(data);
			return;
		}
		if(min.peek() > data)
			min.push(data);
	}
	
	public int pop() {
		if(isEmpty())
			return -1;
		if(min.peek() == stack.peek())
			min.pop();
		return stack.pop();
		
	}
	
	public int getMin() {
		if(min.isEmpty()) {
			System.out.println("Stack Empty");
			return -1;
		}
			
		return min.peek();
	}
}

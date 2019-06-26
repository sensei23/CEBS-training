package cebs_training;

public class StackImplementation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StackUsingLL<Integer> stack = new StackUsingLL<>();
		stack.push(21);
		stack.push(33);
		
		stack.traverse();
		System.out.println("size: " + stack.sizeOfStack() + "  " + stack.pop());
		System.out.println("size: " + stack.sizeOfStack() + "  " + stack.pop());
		System.out.println("size: " + stack.sizeOfStack() + "  " + stack.pop());

	}

}

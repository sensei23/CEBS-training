package cebs_training;

public class SpecialStackImplementations {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpecialStackSimple stack1 = new SpecialStackSimple();
		stack1.push(23);
		stack1.push(25);
		stack1.push(11);
		stack1.push(33);
		stack1.push(9);
		stack1.traverse();
		System.out.println("\n The min element is : " + stack1.getMin());
		stack1.pop();
		System.out.println("\n The min element is : " + stack1.getMin());
		stack1.pop();
		System.out.println("\n The min element is : " + stack1.getMin());
		stack1.pop();
		System.out.println("\n The min element is : " + stack1.getMin());
		stack1.pop();
		System.out.println("\n The min element is : " + stack1.getMin());
		stack1.pop();
		System.out.println("\n The min element is : " + stack1.getMin());
		stack1.pop();
		System.out.println("\n The min element is : " + stack1.getMin());

	}

}

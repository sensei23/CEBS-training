package cebs_training;

public class StackUsingLL<T> {
	
	private Node top;
	private int size;
	
	StackUsingLL(){
		size = 0;
		top = null;
	}
	
	class Node{
		T data;
		Node next;
		Node(){
		}
		Node(T data){
			this.data = data;
		}
	}
	
	public Node getTop() {
		return top;
	}
	
	public int sizeOfStack() {
		return size;
	}
	
	public T peek() {
		if(isEmpty()) {
			System.out.print("Stack Empty: ");
			return null;
		}
		return top.data;
	}
	
	public void traverse() {
		if(isEmpty()) {
			System.out.println("Stack Empty");
			return;
		}
		
		System.out.println("Now Printing Stack Elements: \n");
		Node temp = top;
		int i = 1;
		while(temp != null) {
			System.out.println("Element " + i++ + " ==> " + temp.data);
			temp = temp.next;
		}
		System.out.println();
	}
	
	public boolean isEmpty() {
		if(top == null)
			return true;
		return false;
	}
	
	public void push(T data) {
		Node node = new Node(data);
		size++;
		if(isEmpty()) {
			top = node;
			return;
		}
		node.next = top;
		top = node;
	}
	
	public T pop() {
		if(isEmpty()) {
			System.out.print("Stack Empty: ");
			return null;
		}
		Node temp = top;
		top = top.next;
		size--;
		return temp.data;
	}
}

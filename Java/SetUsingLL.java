package cebs_training;


public class SetUsingLL<T> {
	private Node top;
	private int size;
	
	SetUsingLL(){
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
	
	public int sizeOfset() {
		return size;
	}
	
	public void traverse() {
		if(isEmpty()) {
			System.out.println("Set Empty");
			return;
		}
		
		System.out.println("Now Printing Set Elements: \n");
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
	
	public void insert(T data) {
		boolean flag = false;
		if(isEmpty())
			flag = true;
		else {
			Node temp = top;
			while(temp != null) {
				if(temp.data == data) {
					return;
				}
				temp = temp.next;
			}
			flag = true;
		}
		if(flag) {
			Node node = new Node(data);
			size++;
			if(isEmpty()) {
				top = node;
				return;
			}
			node.next = top;
			top = node;
		}
	}
	
	public T delete(T val) {
		if(isEmpty()) {
			System.out.print("set Empty: ");
			return null;
		}
		Node temp = top;
		Node prev = null;
		while(temp.data != val) {
			if(temp.next == null){
				System.out.println("The value : " + val + "  is not present in the set");
				return null;
			}
			prev = temp;
			temp = temp.next;
		}
		if(temp == top) {
			top = top.next;
		}
		else if(temp.next == null) {
			prev.next = null;
		}
		else {
			prev.next = temp.next;
		}
		size--;
		return temp.data;
	}
}

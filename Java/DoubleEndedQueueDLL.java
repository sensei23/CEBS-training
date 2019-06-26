package cebs_training;


public class DoubleEndedQueueDLL<E> {
	class Node{
		E data;
		Node next, prev;
		Node(){}
		Node(E data){
			this.data = data;
		}
	}
	
	private Node front, rear;
	private int size;
	
	public DoubleEndedQueueDLL() {
		size = 0;
		front = rear = null;
	}
	
	public boolean isEmpty() {
		if(front == null && rear == null)
			return true;
		return false;
	}
	
	public int sizeOfQueue() {
		return size;
	}
	
	public void traverse() {
		if(isEmpty()) {
			System.out.println("Queue Empty");
			return;
		}
		System.out.println("Now traversing the Queue: \n");
		Node temp = front;
		int i = 1;
		while(temp != rear) {
			System.out.println("Element " + i++ + " ==> " + temp.data);
			temp = temp.next;
		}
		System.out.println("Element " + i++ + " ==> " + temp.data);
		System.out.println();
	}
	
	public void reverseTraversing() {
		if(isEmpty()) {
			System.out.println("Queue Empty");
			return;
		}
		System.out.println("Now Reversibly traversing the Queue: \n");
		Node temp = rear;
		int i = 1;
		while(temp != front) {
			System.out.println("Element " + i++ + " ==> " + temp.data);
			temp = temp.prev;
		}
		System.out.println("Element " + i++ + " ==> " + temp.data);
		System.out.println();
	}
	
	public void enqueueBack(E data) {
		Node node = new Node(data);
		size++;
		if(isEmpty()) {
			front = rear = node;
			return;
		}
		rear.next = node;
		node.prev = rear;
		rear = node;
	}
	
	public void enqueueFront(E data) {
		Node node = new Node(data);
		size++;
		if(isEmpty()) {
			front = rear = node;
			return;
		}
		node.next = front;
		front.prev = node;
		front = node;
	}
	
	public void dequeueFront() {
		if(isEmpty()) {
			System.out.print("Queue Empty: ");
			return;
		}
		if(front == rear) {
			System.out.println("Dequeing : " + front.data);
			front = rear = null;
			return;
		}
		Node temp = front.next;
		temp.prev = null;
		System.out.println("Dequeing : " + front.data);
		front = temp;
	}
	
	public void dequeueBack() {
		if(isEmpty()) {
			System.out.print("Queue Empty: ");
			return;
		}
		if(front == rear) {
			System.out.println("Dequeing : " + rear.data);
			front = rear = null;
			return;
		}
		Node temp = rear.prev;
		temp.next = null;
		System.out.println("Dequeing : " + rear.data);
		rear = temp;
	}
	
}

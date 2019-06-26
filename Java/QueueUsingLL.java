package cebs_training;

public class QueueUsingLL<E> {

	class Node{
		E data;
		Node next;
		Node(){}
		Node(E data){
			this.data = data;
		}
	}
	
	private Node front, rear;
	private int size;
	
	public QueueUsingLL() {
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
	
	public void enqueue(E data) {
		Node node = new Node(data);
		size++;
		if(isEmpty()) {
			front = rear = node;
			return;
		}
		rear.next = node;
		rear = node;
	}
	
	public void dequeue() {
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
		System.out.println("Dequeing : " + front.data);
		front = temp;
	}
	
}

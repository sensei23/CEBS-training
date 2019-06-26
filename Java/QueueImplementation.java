package cebs_training;

public class QueueImplementation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		QueueUsingLL<Integer> queue = new QueueUsingLL<>();
		queue.enqueue(22);
		queue.enqueue(44);
		queue.traverse();
		queue.dequeue();
		queue.traverse();
	}

}

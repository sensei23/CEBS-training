package cebs_training;

public class DoubleEndedQueueImplementation {

	public static void main(String[] args) {

		DoubleEndedQueueDLL<Integer> deque = new DoubleEndedQueueDLL<>();
		deque.enqueueBack(33);
		deque.enqueueBack(44);
		deque.traverse();
		deque.enqueueFront(22);
		deque.traverse();
		deque.enqueueFront(55);
		deque.dequeueBack();
		deque.reverseTraversing();
		
	}

}

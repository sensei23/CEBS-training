package cebs_training;

public class LinkList<E> implements Collections<E>{

	class Node{
		E data;
		Node next;
		Node prev;
		Node(E data){
			this.data = data;
		}
	}
	
	private Node first;
	private Node last;
	private int size;
	
	public LinkList() {
		this.first = null;
		this.last = null;
		this.size = 0;
	}
	
	public void addFirst(E value) {
		Node node = new Node(value);
		size++;
		if(isEmpty()) {
			last = node;
			node.next = first;
			first = node;
			return;
		}
		node.next = first;
		first.prev = node;
		first = node;
	}
	
	public void addLast(E value) {
		Node node = new Node(value);
		size++;
		if(isEmpty()) {
			first = node;
			last = node;
			return;
		}
		last.next = node;
		node.prev = last;
		last = node;
	}
	
	public E removeFirst() {
		if(isEmpty()) {
			System.out.println("Empty...");
			return null;
		}
		size--;
		E val = first.data;
		first.next.prev = null;
		first = first.next;
		return val;
	}
	public E removeLast() {
		size--;
		if(isEmpty()) {
			System.out.println("Empty...");
			return null;
		}
		E val = last.data;
		last = last.prev;
		last.next.prev = null;
		last.next = null;
		return val;		
	}

	@Override
	public boolean isEmpty() {
		return this.first == null;
	}

	@Override
	public IteratorLL<E> iterator() {
		return new IteratorLL<E>() {
			public Node curr = first;

			@Override
			public boolean hasNext() {
				return this.curr != null;
			}

			@Override
			public E next() {
				E value = this.curr.data;
				this.curr = this.curr.next;
				return value;
			}
		};
	}

	@Override
	public int getSize() {
		return size;
	}
	
}

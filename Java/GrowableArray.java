package cebs_training;

//50% Growable Array

public class GrowableArray<T> {
	private T arr[];
	private int size;
	private int capacity;
	
	public GrowableArray() {
		this(5);
	}
	
	@SuppressWarnings("unchecked")
	public GrowableArray(int capacity) {
		this.capacity = capacity;
		arr = (T[]) new Object[capacity];
		size = 0;
	}
	
	public void traverse() {
		System.out.println("Now traversing Array...");
		for(int i=0; i<size; i++) {
			System.out.println("Element " + (i+1) + " ==> " + arr[i]);
		}
		System.out.println("...........................................");
		
	}
	
	public void add(T value) {
		if(size == capacity) {
			capacity *= 1.5;
			@SuppressWarnings("unchecked")
			T newArr[] = (T[]) new Object[capacity];
			for(int i=0; i<size; i++)
				newArr[i] = this.arr[i];
			this.arr = newArr;
		}
		arr[size++] = value;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public int getCapacity() {
		return this.capacity;
	}
	
	public int getSize() {
		return this.size;
	}
}

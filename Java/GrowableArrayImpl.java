package cebs_training;

public class GrowableArrayImpl {

	public static void main(String[] args) {
		GrowableArray<Integer> arr = new GrowableArray<>(10);
		arr.add(2);
		arr.add(4);
		arr.add(6);
		arr.add(33);
		arr.add(65);
		arr.add(23);
		arr.add(73);
		arr.add(4);
		System.out.println("Capacity: " + arr.getCapacity() + " Size : " + arr.getSize());
		arr.add(22);
		arr.add(56);
		arr.add(25);
		arr.add(12);
		System.out.println("Capacity: " + arr.getCapacity() + " Size : " + arr.getSize());
		System.out.println();
		arr.traverse();
	}

}

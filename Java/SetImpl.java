package cebs_training;

public class SetImpl {

	public static void main(String[] args) {
		SetUsingLL<Integer> set = new SetUsingLL<>();
		set.insert(4);
		set.insert(6);
		set.insert(2);
		set.traverse();
		set.insert(4);
		set.traverse();
	}

}

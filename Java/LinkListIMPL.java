package cebs_training;

public class LinkListIMPL {

	public static void main(String[] args) {
		LinkList<Integer> list = new LinkList<>();
		list.addFirst(12);
		list.addFirst(13);
		list.addLast(14);
		IteratorLL<Integer> itr = list.iterator();
		int i=1;
		while(itr.hasNext()) {
			System.out.println("Element " + (i++) + " : " + itr.next() );
		}
		System.out.println(list.getSize());
	}

}

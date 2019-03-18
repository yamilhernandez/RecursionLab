
public class Tester {

	public static void main(String[] args) {
		
		SLL<Integer> list = new SLL();
		for (int i = 10; i >=0; i--) {
			list.addFirst(i);
		}
		System.out.println(list.toString());
		list.reverse();
		System.out.println(list.toString());

	}

}

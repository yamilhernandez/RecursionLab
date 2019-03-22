
public class SLLReverseTester {

	public static void main(String[] args) {
		
		SLL<Integer> list = new SLL();
		for (int i = 20; i >=0; i--) {
			list.addFirst(i);
		}
		System.out.println(list.toString());
		list.reverse();
		//System.out.println(list.getSize());
		System.out.println(list.toString());

	}

}

import java.util.ArrayList;
import java.util.Random;

public class SLLReverseTester {

	public static void main(String[] args) {
		
		SLL<Integer> list = new SLL();
		for (int i = 20; i >=0; i--) {
			list.addFirst(i);
		}
		//System.out.println(list.toString());
		list.reverse();
		//System.out.println(list.getSize());
		//System.out.println(list.toString());
		
		
		SLL<Integer> list2 = new SLL<Integer>();
		Random rand= new Random();
		for (int f = 10; f >=0; f--) {
			list2.addFirst(rand.nextInt(20));
		}
		
		System.out.println(list2.toString());
		ArrayList<Pair<Integer>> list3= list2.consecutiveIncreasingPairs();
		System.out.println("Consecutive Increasing Pairs Test");
	

		for (Pair<Integer> pair : list3) {
			System.out.println
			("[ "+pair.first().toString()+" , "+ pair.second().toString()+" ]   ");
		}
		
	}

}

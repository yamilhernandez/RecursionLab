import java.util.ArrayList;
import java.util.Random;

public class MergeSortTester {

	public static void main(String[] args) {
		ArrayList<Integer> results = new ArrayList<>(); 
		
		Random r = new Random(); 
		
		for (int i=0; i<100; i++) 
			results.add(r.nextInt(100));
		
		
		
		
		
		for (int i=0; i<results.size(); i++) 
			System.out.println("list["+i + "] = " + results.get(i)); 
		System.out.println("END\n\n");
		
		

	}

}

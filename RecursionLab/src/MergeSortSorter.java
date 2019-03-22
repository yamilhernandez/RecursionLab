import java.util.ArrayList;
import java.util.Random;

public class MergeSortSorter<E> {

	public static <E> void  sort(Queue<E> q){    
		if (q.size() > 1) {     
			Queue<E> q1, q2; 
			
			q1 = new ArrayQueue<>(); 
			q2 = new ArrayQueue<>(); 

			
			int n = q.size(); 
			for (int i=0; i<n/2; i++) 
				q1.enqueue(q.dequeue()); 
			while (!q.isEmpty())
				q2.enqueue(q.dequeue()); 

			sort(q1);    
			sort(q2);    

			
			while (!q1.isEmpty() && !q2.isEmpty())
				if (((Comparable<E>) q1.first()).compareTo(q2.first()) <= 0)
					q.enqueue(q1.dequeue()); 
				else 
					q.enqueue(q2.dequeue()); 
			
			Queue<E> r = (!q1.isEmpty() ? q1 : q2);  
			while (!r.isEmpty())
				q.enqueue(r.dequeue()); 
		} 
	}
	public static <E> void sort(ArrayList<E> list){
		
		if (list.size() > 1) {    
			ArrayList<E> l1, l2; 
			
			l1 = new ArrayList<E>(); 
			l2 = new ArrayList<E>(); 

			int n = list.size(); 
			for (int i=0; i<n/2; i++) 
				l1.add(list.remove(0)); 
			while (!list.isEmpty()) {
				l2.add(list.remove(0));  
			}
			
			sort(l1);  
			sort(l2);    

			while (!l1.isEmpty() && !l2.isEmpty())
				if (((Comparable<E>) l1.get(0)).compareTo(l2.get(0)) <= 0)
					list.add(l1.remove(0)); 
				else 
					list.add(l2.remove(0)); 
			
			ArrayList<E> r = (!l1.isEmpty() ? l1 : l2);
			while (!r.isEmpty())
				list.add(r.remove(0)); 
		} 
	}


	public static void main(String[] args) {
		
		Random rand = new Random();
		int cap = 10;

		
		ArrayList<Integer> test = new ArrayList<>();
		System.out.println("List: " );
		for(int i = 0; i < cap ; i++) {
			test.add(rand.nextInt(50));
			System.out.print("  "+test.get(i));
		}
		
		
		sort(test);
		
	
		System.out.println("\nSorted list: ");
		for(int i = 0; i < test.size(); i++) {
			System.out.print("  "+test.get(i));
		}

	}

}

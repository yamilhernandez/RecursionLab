import java.util.ArrayList;

public class SLL<E> implements Reversible {
	
	private static class Node<E> {
		private E element; 
		private Node<E> next;
		public Node(E element, Node<E> next) {
			super();
			this.element = element;
			this.next = next;
		}
		public Node(E element) { this(element, null); } 
		public Node() { this(null, null); }
		public E getElement() { return element; }
		public void setElement(E element) { this.element = element; }
		public Node<E> getNext() { return next; }
		public void setNext(Node<E> next) { this.next = next; }    
	}



	private Node<E> first = null; 
	private int size = 0;     
	public void addFirst(E e) { 
		first = new Node<>(e, first); 
		size++; 
	}

	// returns string formed by elements in this list, separated by spaces
	public String toString() { 
		String s = ""; 
		Node<E> current = first; 
		while (current != null) { 
			s += " " + current.getElement(); 
			current = current.getNext(); 
		}
		return s; 
	}

	public void reverse() { 
		if (size > 1) 
			first = recReverse(first).first(); 
	}
	
	public Pair<Node<E>> recReverse(Node<E> node){
		if(node.getNext().getNext()==null) {
			addFirst(node.getNext().element);
			size--;
			node.setNext(null);
			return new Pair<Node<E>>(first, node);
		}
		addFirst(node.getNext().element);
		size--;
		node.setNext(node.getNext().getNext());
		return recReverse(node);
		
	}
	
	public ArrayList<Pair<E>> consecutiveIncreasingPairs() { 
		ArrayList<Pair<E>> result = new ArrayList<>();  
		if (size > 0) recCIP(first, result); 
		return result; 
	}
	
	private ArrayList<Pair<E>> recCIP(Node<E> second, ArrayList<Pair<E>> result) {
		if(second.getNext()==null) return result;

		else if(((Comparable<E>) second.getElement()).compareTo(second.getNext().getElement())<0) {
			result.add(new Pair<E>(second.getElement(),second.getNext().getElement()));
			second = second.getNext();
			return recCIP(second, result);
		}else {			
		second = second.getNext();
		return recCIP(second, result);
		}
	}


	public int getSize() {
		return size;
	}






}

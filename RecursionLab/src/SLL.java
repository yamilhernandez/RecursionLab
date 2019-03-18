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
		if(node.getNext()==null) {
			return new Pair<Node<E>>(node, first);
		}
		
		Node<E> temp= node.getNext();
		if(node==first) {
			node.setNext(null);
		}
		Node<E> tempNext= temp.getNext();
		
		temp.setNext(node);
		return recReverse(tempNext);
		
		
		
	}






}


public class ArrayQueue<E> implements Queue<E> {
	private final static int INITCAP = 4; 
	private E[] elements; 
	private int first, size; 
	public ArrayQueue() { 
		elements = (E[]) new Object[INITCAP]; 
		first = 0; 
		size = 0; 
	}
	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public E first() {
		if (isEmpty()) return null; 
		return elements[first]; 
	}

	public E dequeue() {
		if (isEmpty()) return null;
		E etr = elements[first]; 
		elements[first]=null;
		first = (first+1)%elements.length;
		this.size--;
		//		... adjust whatever needs to be adjusted ...

		// Check if number of available positions in the array exceeds 3/4
		// of its total length. If so, and if the current capacity is not
		// less than 2*INITCAP, shrink the internal array to 1/2 of its
		// current length (the capacity of the queue). 
		int avaiPos = elements.length - size;
		if(avaiPos > (elements.length*0.75) && elements.length > 2*INITCAP )
			changeCapacity(elements.length/2); 

		return etr; 
	}

	public void enqueue(E e) {
		if (size == elements.length)   // check capacity, double it if needed
			changeCapacity(2*size); 
		if(isEmpty()) {
			this.elements[first] =e;
			this.size++;
		}
		else {
			int i =0;
			while(elements[(first +i)%elements.length]!=null) {
				i++;
			}
			elements[(first +i)%elements.length]=e;
			this.size++;
		}
	}

	private void changeCapacity(int newCapacity) { 
		if(newCapacity<0) {
			throw new IndexOutOfBoundsException("Invalid capacity change");
		}
		if(newCapacity >= size) {
			E [] newAr = (E[])new Object[newCapacity];
			for( int i =0; i<size();i++) {
				newAr[(first +i)%newAr.length] = 
						elements[(first +i)%elements.length];
			}
			elements = newAr;
		}
		else {
			throw new IllegalArgumentException("Capacity<size");
		}
	}
}

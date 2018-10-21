/*
 * This class is the one you need to complete. Only the member variables
 * and constructor have been implemented for you.
 */

public class LinkedPositionalList<E> implements PositionalList<E> {
	
	/*
	 * This nested class contains a completed implementation of Position
	 * which you should use within LinkedPositionalList.
	 * 
	 * You do not need to edit this class.
	 */
	
	private class Node<E> implements Position<E> {
		
		private Node<E> prev;
		private Node<E> next;
		private E element;
		
		public Node(E element) {
			this.element = element;
			this.prev = null;
			this.next = null;
		}
		
		public Node<E> getPrev() {return prev;}
		public Node<E> getNext() {return next;}
		public E getElement() {return element;}
		public void setPrev(Node<E> prev) {this.prev = prev;}
		public void setNext(Node<E> next) {this.next= next;}
		public void setElement(E element) {this.element = element;}
	}
	
	//The header sentinel
	private Node<E> header;

	//The trailer sentinel
	private Node<E> trailer;

	//The number of positions in the list, not counting sentinels
	int size;

	//This constructor creates an empty list
	public LinkedPositionalList() {
		header = new Node<E>(null);
		trailer = new Node<E>(null);
		header.setNext(trailer);
		trailer.setPrev(header);
		size = 0;
	}

	//TODO: You will need to implement the remaining methods!

	@Override
	public int size() {
		// TODO Implement this.
		
		return size;
	}

	@Override
	public boolean isEmpty() {
		// TODO Implement this.
		if(size==0){ 
		
			return true;
		}
		return false;
	}

	@Override
	public Position<E> first() {
		// TODO Implement this.
		if(	isEmpty()){
			return null;
		}
		
		else{ 
		return header.getNext();
	}
	}
	@Override
	public Position<E> last() {
		// TODO Implement this.
		if(size!=0){
			return trailer.getPrev();
		}
		return null;
	}

	@Override
	public Position<E> before(Position<E> p) {
		// TODO Implement this.
		Node<E> n = (Node<E>)p;
        if(n.getPrev()!=header){ return n.getPrev();
        }
		
		return null;
	}

	@Override
	public Position<E> after(Position<E> p) {
		Node<E> n = (Node<E>)p;
        if(n.getNext()!=trailer){ 
        	return n.getNext();
        }
		
		return null;
	}

	@Override
	public Position<E> addFirst(E e) {
		// TODO Implement this.
		
		
		Node<E> n = new Node<E>(e);
		n.setPrev(header);
		n.setNext(header.getNext());
		header.getNext().setPrev(n);
		header.setNext(n);
		size++;
		return n;
		}
		
		
		
		
		
		
		
	

	@Override
	public Position<E> addLast(E e) {
		// TODO Implement this;
		Node<E> n=new Node<E>(e);
		Node<E> m=trailer.getPrev();
		n.setPrev(m);
		n.setNext(trailer);
		trailer.setPrev(n);
		m.setNext(n);
		size++;
		return n;
	}

	@Override
	public Position<E> addBefore(Position<E> p, E e) {
		// TODO Implement this.
        Node<E> n=(Node<E>) p;
        Node<E> m=new Node<E> (e);
        Node<E> q=n.getPrev();
        m.setNext(n);
        n.setPrev(m);
		m.setPrev(q);
        q.setNext(m);
        size++;
        
      
        
        
        
        
		return  m;
	}

	@Override
	public Position<E> addAfter(Position<E> p, E e) {
		// TODO Implement this.
		Node<E> n=(Node<E>) p;
		Node<E> m=new Node<E> (e);
        Node<E> n=(Node<E>) p;
        Node<E> m=new Node<E> (e);
        m.setNext(n.get(Next());
        n.getNext().setPrev(m);
        n.setNext(m);
        m.setNext(n);
        return m;

        size++;
		return m;
	}

	@Override
	public E set(Position<E> p, E e) {
		// TODO Implement this.
	 Node<E> n=(Node<E>) p;
	 E prev=p.getElement();
	 
	 n.setElement(e);
   
		return prev;
	}

	@Override
	public E remove(Position<E> p) {
		// TODO Implement this.
		Node<E> n=(Node<E>) p;
		E old=n.getElement();
		Node<E> m=n.getPrev();
		Node<E> q=n.getNext();
		m.setNext(q);
		q.setPrev(m);
	    n.setElement(null);
		size--;
		
		
		return old;
	}
		
}

package dsApp;

/**
 * 
 * @author Nicholas LoPilato
 *
 * @param <T>
 */
public class Queue<T> 
{
	/*
	 * Create a Node class
	 */
	private class Node<T>
	{
		T contents;
		Node<T> previous;
		Node<T> next;
		
		public Node(T contents)
		{
			this.contents = contents;
			previous = null;
			next = null;
		}
		
		public Node<T> getPrevious()
		{
			return this.previous;
		}
		
		public Node<T> getNext()
		{
			return this.next;
		}
		
		public void setNext(Node<T> next)
		{
			this.next = next;
		}
		
		public void setPrevious(Node<T> previous)
		{
			this.previous = previous;
		}
		
		public T getContents()
		{
			return this.contents;
		}
		
	}
	/*
	 * End of Node Class
	 */
	
	/**
	 * head is the node at the top of the queue
	 * tail is the node at the bottom of the queue
	 */
	Node<T> head;
	Node<T> tail;
	
	/**
	 * default constructor to create an empty queue
	 */
	public Queue()
	{
		head = null;
		tail = null;
	}
	
	/**
	 * main constructor
	 * @param firstToQueue the first item you are adding to the queue
	 */
	public Queue(T firstToQueue)
	{
		head = new Node<T>(firstToQueue);
		tail = null;
	}
	
	public Queue(Queue copyOf)
	{
		//head = new Node(copyOf.getHead().getContents());
		head = copyOf.getHead();
		
		Node<T> n = head.getNext();
		while(n != tail && n != null)
		{
			enqueue(n.getContents());
			n = n.getNext();
		}
		enqueue((T)copyOf.getTail().getContents());
	}
	
	/**
	 * add a new item to the bottom of the queue
	 * @param contents the item you are adding to the queue
	 */
	public void enqueue(T contents)
	{
		Node<T> n = new Node<T>(contents);
		
		if(head == null)//head is null which means tail is also null
		{
			head = n;
			n.setNext(null);
		}
		else if(tail == null)//tail is null but head isn't
		{
			tail = n;
			head.setNext(n);
			n.setNext(null);//
		}
		else//head and tail both are something
		{
			tail.setNext(n);
			n.setPrevious(tail);
			n.setNext(null);
			
			tail = n;
		}
	}
	
	/**
	 * takes the head of the queue out of the queue and returns it's contents
	 * @return head of queue's contents
	 */
	public T dequeue()
	{
		if(head == null)
		{
			return null;
		}
		T contents = getHead().getContents();
		head = head.getNext();
		
		if(head == null)
		{
			tail = null;
		}
		
		return contents;
	}
	
	/**
	 * gets the head of the queue
	 * @return head
	 */
	private Node<T> getHead()
	{
		return head;
	}
	
	/**
	 * gets the tail of the queue
	 * @return tail
	 */
	private Node<T> getTail()
	{
		if(tail == null)
		{
			return head;
		}
		return tail;
	}
	
	/**
	 * gets the contents from the head of the queue
	 * @return contents of the head
	 */
	public T getHeadContents()
	{
		return getHead().getContents();
	}
	
	/**
	 * gets the contents from the tail of the queue
	 * @return contents of the tail
	 */
	public T getTailContents()
	{
		return getTail().getContents();
	}
	
	public Boolean isEmpty()
	{
		if(head != null)
			return false;
		
		return true;
	}
	
	/**
	 * prints out to the console all the toString of each item in the queue in order from head to tail
	 * @return the contents of the head and the contents of the tail
	 */
	public String toString()
	{
		if(head == null)
		{
			return null;
		}
		
		Node<T> it = head;
		while(it.getNext() != null)
		{
			System.out.print(it.getContents().toString());
			it = it.getNext();
		}
		
		System.out.print(getTail().getContents());
		
		return " Head: " + getHead().getContents().toString() + " Tail: " + getTail().getContents().toString();
	}
	

}

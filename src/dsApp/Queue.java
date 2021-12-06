package dsApp;

public class Queue<T> 
{
	/*
	 * Create a Node class
	 */
	private class Node<T>
	{
		T contents;
		Node previous;
		Node next;
		
		public Node(T contents)
		{
			this.contents = contents;
			previous = null;
			next = null;
		}
		
		public Node getPrevious()
		{
			return this.previous;
		}
		
		public Node getNext()
		{
			return this.next;
		}
		
		public void setNext(Node next)
		{
			this.next = next;
		}
		
		public void setPrevious(Node previous)
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
	Node head;
	Node tail;
	
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
		head = new Node(firstToQueue);
		tail = null;
	}
	
	/**
	 * add a new item to the bottom of the queue
	 * @param contents the item you are adding to the queue
	 */
	public void enqueue(T contents)
	{
		Node n = new Node(contents);
		
		if(head == null)//head is null which means tail is also null
		{
			head = n;
		}
		else if(tail == null)//tail is null but head isn't/
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
	 * takes the head of the queue out of the queue and returns it
	 * @return head of queue's contents
	 */
	public Object dequeue()
	{
		Object contents = getHead().getContents();
		head = head.getNext();
		
		return contents;
	}
	
	/**
	 * gets the head of the queue
	 * @return head
	 */
	private Node getHead()
	{
		return head;
	}
	
	/**
	 * gets the tail of the queue
	 * @return tail
	 */
	private Node getTail()
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
	public Object getHeadContents()
	{
		return getHead().getContents();
	}
	
	/**
	 * gets the contents from the tail of the queue
	 * @return contents of the tail
	 */
	public Object getTailContents()
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
		
		Node it = head;
		while(it.getNext() != null)
		{
			System.out.print(it.getContents().toString());
			it = it.getNext();
		}
		
		System.out.print(getTail().getContents());
		
		return " Head: " + getHead().getContents().toString() + " Tail: " + getTail().getContents().toString();
	}
	

}

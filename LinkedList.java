
public class LinkedList 
{
	private Node head;
	private int count;
	
	public LinkedList()
	{
		this.head = null;
		this.count = 0;
	}
	
	public void addFront(int value)
	{
		Node n = new Node(value);
		n.setNextNode(head);
		head = n;
		this.count++;
	}
	
	public int removeFront() throws Exception
	{
		if(this.head == null)
		{
			throw new Exception("Empty List Exception: Can't remove from empty list");
		}
		else
		{
			Node nodeToReturn = head;
			head = head.getNextNode();
			nodeToReturn.setNextNode(null);
			this.count--;
			return nodeToReturn.getPayload();
		}
	}
	
	public void addEnd(int value)
	{
		if(head == null)
		{
			this.addFront(value);
		}
		else
		{
			Node n = new Node(value);
			
			//traverse to last node in list
			Node currNode = head;
			while(currNode.getNextNode() != null)
			{
				currNode = currNode.getNextNode();
			}
			currNode.setNextNode(n);
			this.count++;
		}
	}
	
	public int removeEnd() throws Exception
	{
		if(head == null)
		{
			return this.removeFront();
		}
		else
		{
			this.count--;
			Node currNode = head;
			while(currNode.getNextNode() != null && currNode.getNextNode().getNextNode() != null)
			{
				currNode = currNode.getNextNode();
			}
			if(currNode == head && currNode.getNextNode() == null)
			{
				head = null;
				return currNode.getPayload();
			}
			else
			{
				Node nodeToReturn = currNode.getNextNode();
				currNode.setNextNode(null);
				return nodeToReturn.getPayload();
			}
		}
	}
	
	public int removeAtIndex(int index) throws Exception
	{
		if(index < 0 || index >= this.count)
		{
			throw new Exception("Remove At Index: Index Out of Bounds (" + index + ")");
		}
		else if(index == 0)
		{
			return this.removeFront();
		}
		else if(index == this.count-1)
		{
			return this.removeEnd();
		}
		else
		{
			Node posBefore = head;
			for(int i = 0; i < index - 1; i++)
			{
				posBefore = posBefore.getNextNode();
			}
			Node actualPos = posBefore.getNextNode();
			posBefore.setNextNode(actualPos.getNextNode());
			actualPos.setNextNode(null);
			return actualPos.getPayload();
		}
		
	}
	
	public void addAtIndex(int value, int index) throws Exception
	{
		if(index < 0 || index > this.count)
		{
			throw new Exception("Add At Index: Index Out of Bounds (" + index + ")");
		}
		else if(index == 0)
		{
			this.addFront(value);
		}
		else if(index == this.count)
		{
			this.addEnd(value);
		}
		else
		{
			//move to the pos right before index
			Node currNode = head;
			for(int i = 0; i < index-1; i++)
			{
				currNode = currNode.getNextNode();
			}
			Node n = new Node(value);
			n.setNextNode(currNode.getNextNode());
			currNode.setNextNode(n);
			this.count++;
		}
		
	}
	
	public void displayInReverse() throws Exception
	{
		LinkedList temp = new LinkedList();
		while(head != null)
		{
			temp.addEnd(this.removeEnd());
		}
		temp.display();
		while(temp.count > 0)
		{
			this.addFront(temp.removeFront());
		}
	}
	
	public void display()
	{
		if(head == null)
		{
			System.out.println("Empty List");
		}
		else
		{
			System.out.println("Count: " + this.count);
			this.head.display();
		}
	}
}


public class Node 
{
	private int payload;
	private Node nextNode;
	
	public Node(int payload)
	{
		this.payload = payload;
		this.nextNode = null;
	}

	public Node getNextNode() 
	{
		return nextNode;
	}

	public void setNextNode(Node nextNode) 
	{
		this.nextNode = nextNode;
	}

	public int getPayload() 
	{
		return payload;
	}
	
	public void display()
	{
		System.out.print(this.payload + " -> ");
		if(this.nextNode != null)
		{
			this.nextNode.display();
		}
		else
		{
			System.out.println("end");
		}
	}
}

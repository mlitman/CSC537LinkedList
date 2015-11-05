
public class Driver 
{
	public static void main(String[] args) throws Exception
	{
		LinkedList ll = new LinkedList();
		ll.addFront(5);
		ll.addFront(7);
		ll.addEnd(3);
		ll.removeFront();
		ll.addAtIndex(7, 1);
		ll.display();
		ll.displayInReverse();
		ll.display();
	}
}

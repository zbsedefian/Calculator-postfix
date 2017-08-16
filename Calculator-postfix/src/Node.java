
public class Node 
{
	private Node next;
	private double data;
	
	public Node(double data)
	{
		this.data = data;
		this.next = null;
	}
	
	public double getData() 
	{
		return data;
	}

	public void setData(double data) 
	{
		this.data = data;
	}

	public void setNext(Node next)
	{
		this.next = next;
	}
	
	public Node getNext()
	{
		return this.next;
	}
}

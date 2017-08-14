import java.util.EmptyStackException;

import javax.swing.JOptionPane;

public class Stack {
	
	private Node tos;
	
	public Stack(){
		this.tos = null;
	}
	
	public Node getTos(){
		return tos;
	}

	public void setTos(Node tos){
		this.tos = tos;
	}
	
	void push(double data){
		Node newNode = new Node(data);	
		if(!isEmpty())
			newNode.setNext(tos);
		setTos(newNode);
	}
	
	double pop(){
		if (isEmpty()) return 0;
		double poppedValue = peek();
		setTos(tos.getNext());
		return poppedValue;
	}
	
	double peek(){
		return getTos().getData();
	}
	
	String print(){
		String returnable = new String("");
		if(isEmpty()){
			return "Stack is empty.";
		} else {
			Node c = getTos();
			returnable = ("-->" + c.getData());
			c = c.getNext();
			while(c != null){
				returnable += "\n" + "   " + c.getData();
				c = c.getNext();
			}			
		}
		return returnable;
	}
	
	boolean isEmpty(){
		return (tos == null);
	}
	
	void destroy(){
		setTos(null);
	}
	
	double add(double a, double b){
		return (a + b);
	}
	
	double subtract(double a, double b){
		return (a - b);
	}
	
	double multiply(double a, double b){
		return (a * b);
	}
	
	double divide(double a, double b){
		return (a / b);
	}
}

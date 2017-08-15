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
	
	String operation(String str, double a, double b){
		switch(str){
		case "ln": return Double.toString(Math.log(a));
		case "log": return Double.toString(Math.log10(a));
		case "square": return Double.toString(a * a);
		case "exp": return Double.toString(Math.pow(a,  b));
		case "sin": return Double.toString(Math.sin(a));
		case "cos": return Double.toString(Math.cos(a));
		case "tan": return Double.toString(Math.tan(a));
		case "sqrt": return Double.toString(Math.sqrt(a));
		case "add": return Double.toString(a + b);
		case "eExp": return Double.toString(Math.exp(a));
		case "sub": return Double.toString(a - b);
		case "div": return Double.toString(a / b);
		case "mul": return Double.toString(a * b);
		}
		return "No operation selected.";
	}
	
	
	static double previousResult;
	
	void setPreviousResult(double result){
		previousResult = result;
	}
		
	String getPreviousResult(){
//		String previousResultStr = Double.toString(previousResult);
//		previousResultStr = previousResultStr.substring(0, previousResultStr.indexOf("."));
		return Double.toString(previousResult);
	}
}

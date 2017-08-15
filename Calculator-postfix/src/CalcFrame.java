import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class CalcFrame extends JFrame {
	
	private int operationSelected;
	
	public CalcFrame(){
		Stack stack = new Stack();

		JTextField userInput = new JTextField();
		userInput.setEditable(false);
		userInput.setFont(new Font("Courier New", Font.BOLD, 16));
		
		JScrollPane stackViewer = new JScrollPane();
		JTextArea stackViewerArea = new JTextArea();
		stackViewerArea.setText(stack.print());
		stackViewerArea.add(stackViewer);
		stackViewerArea.setEditable(false);
		stackViewerArea.setFont(new Font("Courier New", Font.BOLD, 16));
		
		JButton lnButton = new JButton("ln(x)");
		JButton logButton = new JButton("log(x)");
		JButton CEButton = new JButton("CE");
		JButton popButton = new JButton("POP");
		JButton backArrowButton = new JButton("<--");
		JButton squaredButton = new JButton("<html>x<sup>2</sup></html>");
		JButton exponentButton = new JButton("<html>x<sup>y</sup></html>");
		JButton sinButton = new JButton("sin(x)");
		JButton cosButton = new JButton("cos(x)");
		JButton tanButton = new JButton("tan(x)");
		JButton squareRootButton = new JButton("\u221A");
		JButton oneButton = new JButton("1");
		JButton twoButton = new JButton("2");
		JButton threeButton = new JButton("3");
		JButton addButton = new JButton("+");
		JButton eExponentButton = new JButton("<html>e<sup>x</sup></html>");
		JButton fourButton = new JButton("4");
		JButton fiveButton = new JButton("5");
		JButton sixButton = new JButton("6");
		JButton subtractButton = new JButton("-");
		JButton eButton = new JButton("e");
		JButton sevenButton = new JButton("7");
		JButton eightButton = new JButton("8");
		JButton nineButton = new JButton("9");
		JButton multiplyButton = new JButton("*");
		JButton piButton = new JButton("\u03c0");
		JButton decimalButton = new JButton(".");
		JButton zeroButton = new JButton("0");
		JButton pushButton = new JButton("PUSH");
		JButton divideButton = new JButton("/");
		
		JPanel operationPanel = new JPanel();
		GridLayout fiveBySix = new GridLayout(6, 5);
		operationPanel.setLayout(fiveBySix);
		operationPanel.add(lnButton);
		operationPanel.add(logButton);
		operationPanel.add(CEButton);
		operationPanel.add(popButton);
		operationPanel.add(backArrowButton);
		operationPanel.add(squaredButton);
		operationPanel.add(exponentButton);
		operationPanel.add(sinButton);
		operationPanel.add(cosButton);
		operationPanel.add(tanButton);
		operationPanel.add(squareRootButton);
		operationPanel.add(oneButton);
		operationPanel.add(twoButton);
		operationPanel.add(threeButton);
		operationPanel.add(addButton);
		operationPanel.add(eExponentButton);
		operationPanel.add(fourButton);
		operationPanel.add(fiveButton);
		operationPanel.add(sixButton);
		operationPanel.add(subtractButton);
		operationPanel.add(eButton);
		operationPanel.add(sevenButton);
		operationPanel.add(eightButton);
		operationPanel.add(nineButton);
		operationPanel.add(multiplyButton);
		operationPanel.add(piButton);
		operationPanel.add(decimalButton);
		operationPanel.add(zeroButton);
		operationPanel.add(pushButton);
		operationPanel.add(divideButton);
		
		JPanel lowerPanel = new JPanel(new GridLayout(1, 2));
		lowerPanel.add(stackViewerArea);
		lowerPanel.add(operationPanel);

		add(userInput, BorderLayout.PAGE_START);
		add(lowerPanel);
		
		setTitle("Calculator");
		setSize(800,500);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		
		lnButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if (!stack.isEmpty()){
					double input = stack.pop();
					String result = stack.operation("ln", input, 0);
					userInput.setText(result);
					stack.setPreviousResult(Double.parseDouble(result));
					stackViewerArea.setText(stack.print());
				} else {
					userInput.setText("Error: Stack is empty.");
				}
			}
		});
		
		logButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if (!stack.isEmpty()){
					double input = stack.pop();
					String result = stack.operation("log", input, 0);
					userInput.setText(result);
					stackViewerArea.setText(stack.print());
					stack.setPreviousResult(Double.parseDouble(result));
				} else {
					userInput.setText("Error: Stack is empty.");
				}
			}
		});
		
		CEButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				userInput.setText("");
				stack.destroy();
				stackViewerArea.setText(stack.print());
				stack.setPreviousResult(0);
			}
		});
		
		popButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if (!stack.isEmpty()){
					userInput.setText("");
					stack.pop();
					stackViewerArea.setText(stack.print());
				} else {
					userInput.setText("Error: Stack is empty.");
				}
			}
		});
		
		backArrowButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String truncated = userInput.getText();
				if(truncated.length() != 0){
					truncated = truncated.substring(0, truncated.length()-1);
					userInput.setText(truncated);
				}
			}
		});
		
		squaredButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(!stack.isEmpty()){
					double input = stack.pop();
					String result = stack.operation("square", input, 0);
					userInput.setText(result);
					stackViewerArea.setText(stack.print());
					stack.setPreviousResult(Double.parseDouble(result));
				}  else {
					userInput.setText("Error: Stack is empty.");
				}
			}
		});
		
		exponentButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if (!stack.isEmpty()){
					double b = stack.pop();
					if(stack.isEmpty()){
						userInput.setText("Error: Not enough arguments.");
						stack.push(b);
					} else{
						double a = stack.pop();
						String result = stack.operation("exp", a, b);
						userInput.setText(result);
						stackViewerArea.setText(stack.print());
						stack.setPreviousResult(Double.parseDouble(result));
					}
				} else {
					userInput.setText("Error: Stack is empty.");
				}
			}
		});
		
		sinButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if (!stack.isEmpty()){
					double input = stack.pop();
					String result = stack.operation("sin", input, 0);
					userInput.setText(result);
					stackViewerArea.setText(stack.print());
					stack.setPreviousResult(Double.parseDouble(result));
				}  else {
					userInput.setText("Error: Stack is empty.");
				}
			}
		});
		
		cosButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if (!stack.isEmpty()){
					double input = stack.pop();
					String result = stack.operation("cos", input, 0);
					userInput.setText(result);
					stackViewerArea.setText(stack.print());
					stack.setPreviousResult(Double.parseDouble(result));
				}  else {
					userInput.setText("Error: Stack is empty.");
				}
			}
		});
		
		tanButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(!stack.isEmpty()){
					double input = stack.pop();
					String result = stack.operation("tan", input, 0);
					userInput.setText(result);
					stackViewerArea.setText(stack.print());
					stack.setPreviousResult(Math.tan(input));
				} else {
					userInput.setText("Error: Stack is empty.");
				}
			}
		});
		
		squareRootButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(!stack.isEmpty()){
					double input = stack.pop();
					String result = stack.operation("sqrt", input, 0);
					userInput.setText(result);
					stackViewerArea.setText(stack.print());
					stack.setPreviousResult(Double.parseDouble(result));
				} else {
					userInput.setText("Error: Stack is empty.");
				}
			}
		});
		
		oneButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String previousResult = stack.getPreviousResult();
				if(userInput.getText().equals("3.14159265359") || userInput.getText().equals("2.7182818284590452353602874713527") ||
				   userInput.getText().equals(previousResult) ){
					userInput.setText("1");
				}  else if (userInput.getText().length() > 7 && userInput.getText().substring(0, 7).equals("Error: ")){
					 userInput.setText("1");
				}  else{
					userInput.setText(userInput.getText() + "1");
				}
			}
		});
		
		twoButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String previousResult = stack.getPreviousResult();
				if(userInput.getText().equals("3.14159265359") || userInput.getText().equals("2.7182818284590452353602874713527") ||
				   userInput.getText().equals(previousResult) ){
					userInput.setText("2");
				}  else if (userInput.getText().length() > 7 && userInput.getText().substring(0, 7).equals("Error: ")){
					 userInput.setText("2");
				}  else {
					userInput.setText(userInput.getText() + "2");
				}
			}
		});
		
		threeButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String previousResult = stack.getPreviousResult();
				if(userInput.getText().equals("3.14159265359") || userInput.getText().equals("2.7182818284590452353602874713527") ||
				   userInput.getText().equals(previousResult) ){
					userInput.setText("3");
				} else if (userInput.getText().length() > 7 && userInput.getText().substring(0, 7).equals("Error: ")){
					 userInput.setText("3");
				} else {
					userInput.setText(userInput.getText() + "3");
				}
			}
		});
		
		addButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(!stack.isEmpty()){
					double b = stack.pop();
					if(stack.isEmpty()){
						userInput.setText("Error: Not enough arguments.");
						stack.push(b);
					} else{
						double a = stack.pop();
						String result = stack.operation("add", a, b);
						userInput.setText(result);
						stackViewerArea.setText(stack.print());
						stack.setPreviousResult(Double.parseDouble(result));
					}
				} else {
					userInput.setText("Error: Stack is empty.");
				}
			}
		});
		
		eExponentButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if (!stack.isEmpty()){
					double input = stack.pop();
					String result = stack.operation("eExp", input, 0);
					userInput.setText(result);
					stackViewerArea.setText(stack.print());
					stack.setPreviousResult(Double.parseDouble(result));
				} else {
					userInput.setText("Error: Stack is empty.");
				}
			}
		});
		
		fourButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String previousResult = stack.getPreviousResult();
				if(userInput.getText().equals("3.14159265359") || userInput.getText().equals("2.7182818284590452353602874713527") ||
						   userInput.getText().equals(previousResult) ){
					userInput.setText("4");
				}  else if (userInput.getText().length() > 7 && userInput.getText().substring(0, 7).equals("Error: ")){
					 userInput.setText("4");
				} else {
					userInput.setText(userInput.getText() + "4");
				}
			}
		});
		
		fiveButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String previousResult = stack.getPreviousResult();
				if(userInput.getText().equals("3.14159265359") || userInput.getText().equals("2.7182818284590452353602874713527") ||
						   userInput.getText().equals(previousResult) ){
					userInput.setText("5");
				} else if (userInput.getText().length() > 7 && userInput.getText().substring(0, 7).equals("Error: ")){
					 userInput.setText("5");
				} else{
					userInput.setText(userInput.getText() + "5");
				}
			}
		});
		
		sixButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String previousResult = stack.getPreviousResult();
				if(userInput.getText().equals("3.14159265359") || userInput.getText().equals("2.7182818284590452353602874713527") ||
						   userInput.getText().equals(previousResult) ){
					userInput.setText("6");
				}  else if (userInput.getText().length() > 7 && userInput.getText().substring(0, 7).equals("Error: ")){
					 userInput.setText("6");
				} else{
					userInput.setText(userInput.getText() + "6");
				}
			}
		});
		
		subtractButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if (!stack.isEmpty()){
					double b = stack.pop();
					if(stack.isEmpty()){
						userInput.setText("Error: Not enough arguments.");
						stack.push(b);
					} else {
						double a = stack.pop();
						String result = stack.operation("sub", a, b);
						userInput.setText(result);
						stackViewerArea.setText(stack.print());
						stack.setPreviousResult(Double.parseDouble(result));
					}
				} else {
					userInput.setText("Error: Stack is empty.");
				}
			}
		});
		
		eButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				userInput.setText("2.7182818284590452353602874713527");
			}
		});
		
		sevenButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String previousResult = stack.getPreviousResult();
				if(userInput.getText().equals("3.14159265359") || userInput.getText().equals("2.7182818284590452353602874713527") ||
						   userInput.getText().equals(previousResult)){
					userInput.setText("7");
				} else if (userInput.getText().length() > 7 && userInput.getText().substring(0, 7).equals("Error: ")){
					 userInput.setText("7");
				} else {
					userInput.setText(userInput.getText() + "7");
				}
			}
		});
		
		eightButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String previousResult = stack.getPreviousResult();
				if(userInput.getText().equals("3.14159265359") || userInput.getText().equals("2.7182818284590452353602874713527") ||
						   userInput.getText().equals(previousResult)){
					userInput.setText("8");
				} else if (userInput.getText().length() > 7 && userInput.getText().substring(0, 7).equals("Error: ")){
					 userInput.setText("8");
				} else {
					userInput.setText(userInput.getText() + "8");
				}
			}
		});
		
		nineButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String previousResult = stack.getPreviousResult();
				if(userInput.getText().equals("3.14159265359") || userInput.getText().equals("2.7182818284590452353602874713527") ||
						   userInput.getText().equals(previousResult)){
					userInput.setText("9");
				} else if (userInput.getText().length() > 7 && userInput.getText().substring(0, 7).equals("Error: ")){
						 userInput.setText("9");
				} else {
					userInput.setText(userInput.getText() + "9");
				}
			}
		});
		
		multiplyButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if (!stack.isEmpty()){
					double b = stack.pop();
					if(stack.isEmpty()){
						userInput.setText("Error: Not enough arguments.");
						stack.push(b);
					} else{
						double a = stack.pop();
						String result = stack.operation("mul", a, b);
		     			userInput.setText(result);
		     			stackViewerArea.setText(stack.print());
		     			stack.setPreviousResult(Double.parseDouble(result));
					}
				} else {
					userInput.setText("Error: Stack is empty.");
				}
			}
		});
		
		piButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				userInput.setText("3.14159265359");
			}
		});
		
		decimalButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){			
				String previousResult = stack.getPreviousResult();
				if(userInput.getText().equals("3.14159265359") || userInput.getText().equals("2.7182818284590452353602874713527") ||
				   userInput.getText().equals("") || userInput.getText().equals(previousResult))
					userInput.setText("0.");
				String[] onlyOneDecimal = userInput.getText().split("");
				boolean hasOneDecimal = false;
				for (int i = 0; i < onlyOneDecimal.length; i++) {
					if (onlyOneDecimal[i].equals("."))
						hasOneDecimal = true;
				}
				if (!hasOneDecimal)
					userInput.setText(userInput.getText() + ".");
			}
		});
		
		zeroButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String previousResult = stack.getPreviousResult();
				if(userInput.getText().equals("3.14159265359") || userInput.getText().equals("2.7182818284590452353602874713527") ||
						   userInput.getText().equals(previousResult)){
					userInput.setText("0");
				} else if (userInput.getText().length() > 7 && userInput.getText().substring(0, 7).equals("Error: ")){
					 userInput.setText("0");
				} else {
					userInput.setText(userInput.getText() + "0");
				}
			}
		});
		
		pushButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if ( !userInput.getText().equals("")){
					try {
						stack.push(Double.parseDouble(userInput.getText()));
					} catch (NumberFormatException ex) {
					    JOptionPane.showMessageDialog(null, "That's not a valid number.");
					}
					userInput.setText("");
					stackViewerArea.setText(stack.print());
				} else {
					stackViewerArea.setText(stack.print());
				}
			}
		});
		
		divideButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if (!stack.isEmpty()){
					double b = stack.pop();
					if(stack.isEmpty()){
						userInput.setText("Error: Not enough arguments.");
						stack.push(b);
					} else{
						double a = stack.pop();
						if (b == 0){
							userInput.setText("Error: Division by zero.");
						} 
						else {
							String result = stack.operation("div", a, b);
							userInput.setText(result);
							stackViewerArea.setText(stack.print());
							stack.setPreviousResult(Double.parseDouble(result));
						}
					}
				} else {
					userInput.setText("Error: Stack is empty.");
				}
			}
		});
		
	}

	public static void main(String[] args){
		CalcFrame frame = new CalcFrame();
	}
}

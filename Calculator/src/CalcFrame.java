import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import javafx.scene.paint.Color;

public class CalcFrame extends JFrame {
	
	private int operationSelected;
	
	public CalcFrame(){
		Stack stack = new Stack();
		
		
		
		JTextField userInput = new JTextField();
		userInput.setEditable(false);
		
		JLabel resultLabel = new JLabel("");
		
		JButton lnButton = new JButton("ln(x)");
		//lnButton.setBackground(Color.TRANSPARENT);
		//lnButton.setOpaque(true);
		JButton logButton = new JButton("log(x)");
		JButton CEButton = new JButton("CE");
		JButton popButton = new JButton("POP");
		JButton backArrowButton = new JButton("<--");
		JButton squaredButton = new JButton("<html>x<sup>2</sup></html>");
		JButton exponentButton = new JButton("<html>x<sup>y</sup></html>");
		JButton sinButton = new JButton("sin(x)");
		JButton cosButton = new JButton("cos(x)");
		JButton tanButton = new JButton("tan(x)");
		JButton squareRootButton = new JButton("sqrt");
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
		
		JPanel resetExitPanel = new JPanel();
		//resetExitPanel.add(resetButton);
		//resetExitPanel.add(exitButton);
		
		add(userInput, BorderLayout.PAGE_START);
		add(operationPanel, BorderLayout.CENTER);
		add(resetExitPanel, BorderLayout.PAGE_END);
		
		setTitle("Calculator");
		setSize(600,600);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		
		lnButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				
			}
		});
		
		logButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				
			}
		});
		
		CEButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				userInput.setText("");
				//resultLabel.setText("");
				//stack.destroy();
			}
		});
		
		popButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				
			}
		});
		
		backArrowButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				
			}
		});
		
		squaredButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				double x = stack.pop();
				stack.push(x * x);
			}
		});
		
		exponentButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				
			}
		});
		
		sinButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				
			}
		});
		
		cosButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				
			}
		});
		
		tanButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				
			}
		});
		
		squareRootButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				double a = stack.pop();
				double result = Math.sqrt(a);
				userInput.setText(Double.toString(result));
			}
		});
		
		oneButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				userInput.setText("1");
			}
		});
		
		twoButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				userInput.setText("2");
			}
		});
		
		threeButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				userInput.setText("3");
			}
		});
		
		addButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				double b = stack.pop();
				double a = stack.pop();
				double result = stack.add(a, b);
				userInput.setText(String.valueOf(result));
			}
		});
		
		eExponentButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				
			}
		});
		
		fourButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				userInput.setText("4");
			}
		});
		
		fiveButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				userInput.setText("5");
			}
		});
		
		sixButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				userInput.setText("6");
			}
		});
		
		subtractButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				double b = stack.pop();
				double a = stack.pop();
				double result = stack.subtract(a, b);
				userInput.setText(String.valueOf(result));
			}
		});
		
		eButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				userInput.setText("2.7182818284590452353602874713527");
			}
		});
		
		sevenButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				userInput.setText("7");
			}
		});
		
		eightButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				userInput.setText("8");
			}
		});
		
		nineButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				userInput.setText("9");
			}
		});
		
		multiplyButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				double b = stack.pop();
				double a = stack.pop();
				double result = stack.multiply(a, b);
     			userInput.setText(String.valueOf(result));
			}
		});
		
		piButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				userInput.setText("3.14159265359");
			}
		});
		
		decimalButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				userInput.setText(".");
			}
		});
		
		zeroButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				stack.push(3.14159265359);
			}
		});
		
		pushButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				resultLabel.setText(userInput.getText() + "\n");
				stack.push(Double.parseDouble(userInput.getText()));
				userInput.setText("");
			}
		});
		
		divideButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				double b = stack.pop();
				double a = stack.pop();
				double result = stack.divide(a, b);
				userInput.setText(String.valueOf(result));
			}
		});
		
	}
	
	public static void main(String[] args){
		CalcFrame frame = new CalcFrame();
	}
}

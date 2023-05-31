import java.awt.EventQueue;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.EmptyBorder;

class calc extends JFrame{

	private JPanel contentPane;
	private JTextField textField;
	private JButton b1;
	private JButton b2;
	private JButton b3;
	private JButton b4;
	private JButton b5;
	private JButton b6;
	private JButton b7;
	private JButton b8;
	private JButton b9;
	private JButton b0;
	private JButton ba;
	private JButton bb;
	private JButton bc;
	private JButton bce;
	private JButton bd;
	private JButton bdot;
	private JButton be;
	private JButton bm;
	private JButton bmc;
	private JButton bma;
	private JButton bms;
	private JButton bmp;
	private JButton bp;
	private JButton bpm;
	private JButton bpo;
	private JButton b1x;
	private JButton bs;
	private String current, previous, operator;
	

 
	public void updateOutput() {
		
	textField.setText(current);//set the current output into the textfield
	
	}
	public void addToOutput(String num) { //adds the inputs namely num from the button to the current output
        if (num.equals(".") && current.contains(".")) {//if num contains . or the current string have . it return the value
            return;//since we cannot have two decimal point in a number
        }
        current += num; //the current string is updated into what we add when we clicked the numbuttons
    }
	public void selectOperator(String newOperator) {
        // if no number is entered yet
        if (current.isEmpty()) {
            operator = newOperator;//return the very same operator back
            return;
        }

        if (!previous.isEmpty()) {//if not empty proceed into calculation
            calculate();
        }
        operator = newOperator;
        previous = current; //set the current number as the previous 
        current = "";//make the current null so we can store another value thaw we can calculate later on to the previous
    }
	
    public void calculate() {
        if (previous.length() < 1 || current.length() < 1) {
            return;//if there is no input found in previous and current it will only return null and not cause error
        }
        double answer = 0.0;
        double num1 = Double.parseDouble(previous);
        double num2 = Double.parseDouble(current);
        switch (operator) {
        	case "+":
        		answer = num1 + num2;
        		break;
        	case "-":
        		answer = num1 - num2;
        		break;
            case "*":
                answer = num1 * num2;
                break;
            case "/":
                answer = num1 / num2;
                break;
            default:
                break;
        }
        current = String.valueOf(answer);//convert result into string so we can store it in the current variable
        operator = null;//will be null after each computation so that the if the equal button is pressed it will not calculate since there is no operator
        previous = "";//the previous input will be null, however if the user input new number the previous variable will take the value displayed
        
        if (current.length() > 0) {//if the current string lenght > 0
            String wholeNumber = current.split("\\.")[0]; //all numbers after . will not included
            String decimalNumber = current.split("\\.")[1];//all numbers before . will not be included
            if (decimalNumber.equals("0")) {//if found that there is no decimal point that comes after . decimalpart will not be included
                current = wholeNumber;
            }
        }
    }
	
	private class NumButton implements ActionListener {//the function numbutton gets the text from the buttons
	@Override//when pressed and add it to the textfield adding it to the previous string and make it as current
		public void actionPerformed(ActionEvent e) {
			JButton selectedBtn = (JButton) e.getSource();
	        if(selectedBtn == b0) {
	          	addToOutput(b0.getText());
                updateOutput();
	        }
	        else if(selectedBtn == b1) {
	          	addToOutput(b1.getText());
                updateOutput();
	       }
	        else if(selectedBtn == b2) {
	          	addToOutput(b2.getText());
                updateOutput();
	        }
	        else if(selectedBtn == b3) {
	          	addToOutput(b3.getText());
                updateOutput();
	        }
	        else if(selectedBtn == b4) {
	          	addToOutput(b4.getText());
                updateOutput();
	        }
	        else if(selectedBtn == b5) {
	          	addToOutput(b5.getText());
                updateOutput();
	        }
	        else if(selectedBtn == b6) {
	          	addToOutput(b6.getText());
                updateOutput();
	        }
	        else if(selectedBtn == b7) {
	          	addToOutput(b7.getText());
                updateOutput();
	        }
	        else if(selectedBtn == b8) {
	          	addToOutput(b8.getText());
                updateOutput();
	        }
	        else if(selectedBtn == b9) {
	          	addToOutput(b9.getText());
                updateOutput();
	        }
	        else if(selectedBtn == bdot) {
	        	addToOutput(bdot.getText());
	        	updateOutput();
	        }
	    }
	 }
	private class OperatorButton implements ActionListener{ //get the button text and value when pressed and add 
		@Override// it to the textfield
		public void actionPerformed(ActionEvent e) {
			 JButton selectedBtn = (JButton) e.getSource();
	            if (selectedBtn == ba) {
	                selectOperator(ba.getText());
	            } 
	            else if (selectedBtn == bpo) {
	                selectOperator(bpo.getText());
	            } 
	            else if (selectedBtn == bm) {
	                selectOperator(bm.getText());
	            } 
	            else if (selectedBtn == bd) {
	                selectOperator(bd.getText());
	            }
	            updateOutput();
		}
	}
	private class OtherButton implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			   JButton selectedBtn = (JButton) e.getSource();
	            if (selectedBtn == bb) {
	            	 if (current.length() > 0) {//if current is found and not null 
	                     current = current.substring(0, current.length() - 1);//it will get the whole string in the current 
	                 }//and subtract the lenght to one so we can eliminate the latest charc
	            } 
	            else if (selectedBtn == bc) {//erase all clear all inputs 
	            	 current = "";
	                 previous = "";
	                 operator = null;
	            }
	            else if (selectedBtn == bce) {
	            	current = "";//erase the current input instead the whole equation
	            }
	            else if (selectedBtn == be) {
	                calculate();
	            }
	            updateOutput();
		}
	}
	/**
	 * Create the frame.
	 */
	calc() {
		current = "";
	    previous = "";
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 440, 410);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));//set border 
		setTitle("Calculator");//setting the title of frame
		setLocationRelativeTo(null);//so the frame always appear on the middle of the screen
		setResizable(false);//so that user cannnot resize the frame
		setVisible(true);
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Image icon = Toolkit.getDefaultToolkit().getImage("C:\\Users\\rvabr\\OneDrive\\Pictures\\Windows_Calculator_icon.png");
		//Get the image icon from the files
		setIconImage(icon);//setting the icon image to frame
		
		JPanel Textareapanel = new JPanel();
		Textareapanel.setBounds(10, 35, 411, 65);
		contentPane.add(Textareapanel);
		Textareapanel.setLayout(null);//setting the layout to absolute so we can drag any component around the panel we create
		//without worrying of affecting other components
		
		textField = new JTextField();
		textField.setFont(new Font("Times New Roman", Font.PLAIN, 14));//set the font to times new roman with size 14
		textField.setBounds(25, 15, 363, 40);//location, width and height of the component
		Textareapanel.add(textField);
		textField.setEditable(false);
		textField.setText("0");
		textField.setColumns(10);//Sets the number of columns in this TextField
		
		JPanel panel = new JPanel();
		panel.setForeground(new Color(0, 0, 255));
		panel.setBounds(10, 105, 411, 252);
		contentPane.add(panel);
		panel.setLayout(null);//setting the layout to absolute so we can drag any component around the panel we create
		//without worrying of affecting other components
		
		bmc = new JButton("MC");
		bmc.setAlignmentX(Component.CENTER_ALIGNMENT);
		bmc.setForeground(new Color(255, 0, 0));
		bmc.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		bmc.setBounds(25, 50, 55, 40);
		panel.add(bmc);
		
		bma = new JButton("MA");
		bma.setAlignmentX(Component.CENTER_ALIGNMENT);
		bma.setForeground(new Color(255, 0, 0));
		bma.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		bma.setBounds(25, 100, 55, 40);
		panel.add(bma);
		
		bms = new JButton("MS");
		bms.setAlignmentX(Component.CENTER_ALIGNMENT);
		bms.setForeground(new Color(255, 0, 0));
		bms.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		bms.setBounds(25, 150, 55, 40);
		panel.add(bms);
		
		bmp = new JButton("M+");
		bmp.setAlignmentX(Component.CENTER_ALIGNMENT);
		bmp.setForeground(new Color(255, 0, 0));//set the color to red
		bmp.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		bmp.setBounds(25, 200, 55, 40);
		panel.add(bmp);
		
		b0 = new JButton("0");
		b0.setAlignmentX(Component.CENTER_ALIGNMENT);
		b0.setForeground(new Color(0, 0, 255));
		b0.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		b0.setBounds(95, 200, 50, 40);
		panel.add(b0);
		
		b1 = new JButton("1");
		b1.setAlignmentX(Component.CENTER_ALIGNMENT);
		b1.setForeground(new Color(0, 0, 255));
		b1.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		b1.setBounds(95, 150, 50, 40);
		panel.add(b1);
		
		b2 = new JButton("2");
		b2.setAlignmentX(Component.CENTER_ALIGNMENT);
		b2.setForeground(new Color(0, 0, 255));
		b2.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		b2.setBounds(155, 150, 50, 40);
		panel.add(b2);
		
		b3 = new JButton("3");
		b3.setAlignmentX(Component.CENTER_ALIGNMENT);
		b3.setForeground(new Color(0, 0, 255));
		b3.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		b3.setBounds(215, 150, 50, 40);
		panel.add(b3);
		
		b4 = new JButton("4");
		b4.setAlignmentX(Component.CENTER_ALIGNMENT);
		b4.setForeground(new Color(0, 0, 255));
		b4.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		b4.setBounds(95, 100, 50, 40);
		panel.add(b4);
		
		b5 = new JButton("5");
		b5.setAlignmentX(Component.CENTER_ALIGNMENT);
		b5.setForeground(new Color(0, 0, 255));
		b5.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		b5.setBounds(155, 100, 50, 40);
		panel.add(b5);
		
		b6 = new JButton("6");
		b6.setAlignmentX(Component.CENTER_ALIGNMENT);
		b6.setForeground(new Color(0, 0, 255));
		b6.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		b6.setBounds(215, 100, 50, 40);
		panel.add(b6);
		
		b7 = new JButton("7");
		b7.setAlignmentX(Component.CENTER_ALIGNMENT);
		b7.setForeground(new Color(0, 0, 255));//set color to blue
		b7.setFont(new Font("Times New Roman", Font.PLAIN, 12));//set the font to times new roman with size 12
		b7.setBounds(95, 50, 50, 40);
		panel.add(b7);
		
		b8 = new JButton("8");
		b8.setAlignmentX(Component.CENTER_ALIGNMENT);
		b8.setForeground(new Color(0, 0, 255));
		b8.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		b8.setBounds(155, 50, 50, 40);
		panel.add(b8);
		
		b9 = new JButton("9");
		b9.setAlignmentX(Component.CENTER_ALIGNMENT);
		b9.setForeground(new Color(0, 0, 255));
		b9.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		b9.setBounds(215, 50, 50, 40);
		panel.add(b9);
		
		bd = new JButton("/");
		bd.setAlignmentX(Component.CENTER_ALIGNMENT);
		bd.setForeground(new Color(255, 0, 0));
		bd.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		bd.setBounds(275, 50, 52, 40);
		panel.add(bd);
				
		ba = new JButton("*");
		ba.setAlignmentX(Component.CENTER_ALIGNMENT);
		ba.setForeground(new Color(255, 0, 0));
		ba.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		ba.setBounds(275, 100, 52, 40);
		panel.add(ba);
		
		bp = new JButton("%");
		bp.setAlignmentX(Component.CENTER_ALIGNMENT);
		bp.setForeground(new Color(0, 0, 255));
		bp.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		bp.setBounds(337, 100, 52, 40);
		panel.add(bp);
		
		
		bm = new JButton("-");
		bm.setAlignmentX(Component.CENTER_ALIGNMENT);
		bm.setForeground(new Color(255, 0, 0));
		bm.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		bm.setBounds(275, 150, 52, 40);
		panel.add(bm);
		
		b1x = new JButton("1/x");
		b1x.setAlignmentX(Component.CENTER_ALIGNMENT);
		b1x.setForeground(new Color(0, 0, 255));
		b1x.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		b1x.setBounds(337, 150, 52, 40);
		panel.add(b1x);
		
		bs = new JButton("sqrt");
		bs.setAlignmentX(Component.CENTER_ALIGNMENT);
		bs.setForeground(new Color(0, 0, 255));
		bs.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		bs.setBounds(337, 50, 52, 40);
		panel.add(bs);
		
		bpm = new JButton("+/-");
		bpm.setAlignmentX(Component.CENTER_ALIGNMENT);
		bpm.setForeground(new Color(0, 0, 255));
		bpm.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		bpm.setBounds(155, 200, 50, 40);
		panel.add(bpm);
		
		bdot = new JButton(".");
		bdot.setAlignmentX(Component.CENTER_ALIGNMENT);
		bdot.setForeground(new Color(0, 0, 255));
		bdot.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		bdot.setBounds(215, 200, 50, 40);
		panel.add(bdot);
		
		bpo = new JButton("+");
		bpo.setAlignmentX(Component.CENTER_ALIGNMENT);
		bpo.setForeground(new Color(255, 0, 0));
		bpo.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		bpo.setBounds(275, 200, 52, 40);
		panel.add(bpo);
		
		be = new JButton("=");
		be.setAlignmentX(Component.CENTER_ALIGNMENT);
		be.setForeground(new Color(255, 0, 0));
		be.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		be.setBounds(337, 200, 52, 40);
		panel.add(be);
		
		bb = new JButton("Backspace");
		bb.setAlignmentX(Component.CENTER_ALIGNMENT);
		bb.setForeground(new Color(255, 0, 0));
		bb.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		bb.setBounds(95, 0, 90, 40);
		panel.add(bb);
		
		bce = new JButton("CE");
		bce.setAlignmentX(Component.CENTER_ALIGNMENT);
		bce.setForeground(new Color(255, 0, 0));
		bce.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		bce.setBounds(197, 0, 90, 40);
		panel.add(bce);
		
		bc = new JButton("C");
		bc.setAlignmentX(Component.CENTER_ALIGNMENT);
		bc.setForeground(new Color(255, 0, 0));
		bc.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		bc.setBounds(298, 0, 90, 40);
		panel.add(bc);
		
		NumButton numBtn = new NumButton();
	    b0.addActionListener(numBtn);//0
	    b1.addActionListener(numBtn);//1
	    b2.addActionListener(numBtn);//2
	    b3.addActionListener(numBtn);//3
	    b4.addActionListener(numBtn);//4
	    b5.addActionListener(numBtn);//5
	    b6.addActionListener(numBtn);//6
	    b7.addActionListener(numBtn);//7
	    b8.addActionListener(numBtn);//8
	    b9.addActionListener(numBtn);//9
	    bdot.addActionListener(numBtn);//.
	    
	    OperatorButton OpBtn= new OperatorButton();
	    bpo.addActionListener(OpBtn);//addition
	    bm.addActionListener(OpBtn);//subtraction
	    ba.addActionListener(OpBtn);//multiplication
	    bd.addActionListener(OpBtn);//division
	    //bs.addActionListener(OpBtnHandler);//squareroot unused
	    //bp.addActionListener(OpBtnHandler);//percentage unused
	    //b1x.addActionListener(OpBtnHandler);//inverse unused
	    
	    OtherButton Obutton = new OtherButton();
	    be.addActionListener(Obutton);//equals
	    bb.addActionListener(Obutton);//backspace
	    bc.addActionListener(Obutton);//clear all
	    bce.addActionListener(Obutton);//clear entry
	}
	 
}
public class abrigo8 {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					calc frame = new calc();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}

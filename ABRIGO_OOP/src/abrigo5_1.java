import java.text.DecimalFormat;
import javax.swing.*;
public class abrigo5_1 {

	public static void main(String[] args) {
		JOptionPane.showMessageDialog(null, "Two number calculator");
		getInputNumbers(); //goes to getInputNumbers method
	}
	public static void getInputNumbers() {//allows the user to input two numbers
		String no1 = JOptionPane.showInputDialog(null, "Enter the first number: ");
		int num1 = Integer.parseInt(no1);
		String no2 = JOptionPane.showInputDialog(null, "Enter the second number: ");
		int num2 = Integer.parseInt(no2);
		chooseOperator(num1,num2);//goes to choose operator
	}
	public static void chooseOperator(double num1,double num2) { /*allows the user to choose an operator while
		we store the numbers inputted by the user into num1 and num2 that will be used on later by addtion()
		subtraction,multiplication and division methods*/
		String choice = JOptionPane.showInputDialog(null, "Select Operator you want to use:\n"
				+ "[1] Addition\n[2] Subtraction\n[3] Multiplication\n[4] Division");
		int operator = Integer.parseInt(choice);//convert string choice into int so we can use it to
		switch (operator) {//the switch case 1 and so on for the operation
		case 1: {
			int c1 = JOptionPane.showConfirmDialog(null, "You have selected Addition!");
			if(c1 == JOptionPane.YES_OPTION) {
				int sum = addition(num1,num2);//goes to method int addition that returns the sum of two numbers 
				JOptionPane.showMessageDialog(null,num1+" + "+num2+" = "+sum);
			}
			else {
				chooseOperator(num1, num2); //if the user doesn't want that operator he will be loop back to
			}//chooseOperator method
			break;
		}
		case 2:{
			int c2 = JOptionPane.showConfirmDialog(null, "You have selected Subtraction!");
			if(c2 == JOptionPane.YES_OPTION) {
				int difference = subtraction(num1,num2);//returns the int difference of two numbers
				JOptionPane.showMessageDialog(null, num1+" - "+ num2+" = "+difference);
			}
			else {
				chooseOperator(num1, num2);
			}
			break;
		}
		case 3:{
			int c3 = JOptionPane.showConfirmDialog(null, "You have selected Multiplication!");
			if(c3 == JOptionPane.YES_OPTION) {
				int product = multiplication(num1,num2);//returns the int product of two numbers
				JOptionPane.showMessageDialog(null, num1+"*"+num2 +" = "+product);
			}
			else {
				chooseOperator(num1, num2);
			}
			break;
		}
		case 4:{
			DecimalFormat df = new DecimalFormat("#.##"); //decimal formatting for division
			int c3 = JOptionPane.showConfirmDialog(null, "You have selected Division!");
			if(c3 == JOptionPane.YES_OPTION) {
				Double quotient = division(num1,num2);//returns the quotient of two numbers
				JOptionPane.showMessageDialog(null, num1+"/"+num2+" = "+df.format(quotient));
			}
			else {
				chooseOperator(num1, num2);
			}
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + operator);
		}
	}
	private static int addition(double num1, double num2) {
		return (int) (num1+num2);
	}
	private static int subtraction(double num1, double num2) {
		return (int) (num1-num2);
	}
	private static int multiplication(double num1, double num2) {
		return (int) (num1*num2);
	}
	private static Double division(double num1, double num2) {
		return (double)(num1)/num2;
	}
}

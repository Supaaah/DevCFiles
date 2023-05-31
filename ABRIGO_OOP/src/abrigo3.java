import java.util.Scanner;
import java.lang.*;
import java.io.*;

public class abrigo3 {
	
	public static void main(String[] args) {
		
		Scanner ip = new Scanner(System.in);
		StringBuilder rev = new StringBuilder();
		
		String sen1,sen2;
		System.out.print("\n\tEnter 1st sentence: ");
		sen1 = ip.nextLine();
		System.out.print("\n\tEnter 2nd sentence: ");
		sen2 = ip.nextLine();
		System.out.println("\n\tThe lenght of the sentence1 is: " + sen1.length()); //get length of sen1
		System.out.println("\t"+ sen1 + " " +sen2); //join them creating one paragraph consisting 2 sentences
		System.out.println("\tUPPER CASE SEN1: "+sen1.toUpperCase()); //Change sen1 to uppercase
		System.out.println("\tlower case sen2: "+sen2.toLowerCase());//change sen2 to lowercase
		rev.append(sen2); //assign/join sen2 into stringBuilder rev
		rev.reverse();//reverses rev
		System.out.println("\tReverse of sen2: "+ rev);
	}
}	

import java.util.Scanner;

public class abrigo2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int input, row,Nprint;
		int output = 1, Sum = 0; //assign value to sum and product
		double Average = 0, Product = 1;
		
		Scanner inpu = new Scanner(System.in); //duplicate variable input
		System.out.print("Enter the number of rows of Floyd’s triangle you want: ");
		input = inpu.nextInt(); //variable in is not defined
		int spaces = input;
				System. out.println("Floyd’s Triangle: -");
				for(row = 1; row<=input; row++){
					for(int s=1; s<spaces;s++) {
						System.out.print(" ");
					}
					for( Nprint = 1; Nprint <= row; Nprint++){
						System.out.print(output+" ");
						Sum += output; //equation for the sum for every value in the pyramid
						Product *= output;//equation the product for every value in the pyramid
						Average = (double)Sum/output; //convert data type sum into double or any of
						output++;//the two so we can have an output of double for average
					}
				spaces--; // every the inner loop ends the space/input will decrease ----- -> next line ----
				System.out.println();
				}
		System.out.println("\nSum: "+ Sum);
		System.out.println("\nProduct: "+ Product);
		System.out.println("\nAverage: " + Average);
	}
}



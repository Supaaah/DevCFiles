import java.util.Scanner;

public class abrigo1 {
	
	static void square(int s) {
		System.out.println();
		for(int i = 0; i<s;i++) {
			for(int j=0; j<s;j++) {
				System.out.print("  *");
			}
			System.out.print("\n");
		}
	}
	static void rectangle(int l,int w) {
		System.out.println();
		for(int i = 0; i<l;i++) {
			for(int j=0; j<w;j++) {
				System.out.print("  *");
			}
			System.out.print("\n");
		}
	}
	
	public static void main(String[]args) {
		
		Scanner ip = new Scanner(System.in);
		
		System.out.println("What shape do you want to print?");
		System.out.println("  [1] square");
		System.out.println("  [2] rectangle");
		System.out.print("Your choice: ");
		int choice = ip.nextInt();
		
		if(choice == 1){
			System.out.print("\nPrint Square\n");
			System.out.print("Size of the side of the square: ");
			int s = ip.nextInt();
			square(s);
		}
		else if(choice == 2) {
			System.out.print("\nPrint Rectangle\n");
			System.out.print("Lenght of the rectangle: ");
			int l = ip.nextInt();
			System.out.print("Width of the rectangle: ");
			int w = ip.nextInt();
			if(l == w) {
				System.out.println("Lenght cannot be equal to width \nas it would be not a rectangle");
			}
			else{
				rectangle(l,w);
			}
		}
		else {
			System.out.println("Invalid Input!");
		}
	}
}

import java.util.Scanner;
public class abrigo4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner ip = new Scanner(System.in);
		String fullname, consonant = "",vowels = "";
		int vowelsnum =0, consonantnum=0;
		
		System.out.print("\tEnter your name: ");
		fullname = ip.nextLine().toLowerCase().replaceAll("\\s+", "");
		System.out.println("\tTotal number of character: "+fullname.length());

		for(char letters:fullname.toCharArray()) {
			if(letters == 'a'||letters == 'e'||letters == 'i'||letters == 'o'||letters == 'u') {
				vowels = vowels+letters;
				vowelsnum++; 
			}
			else {
				consonant=consonant+letters;
				consonantnum++;
			}
		}
		System.out.println("\t"+vowels+" "+consonant.replaceAll("\\s+",""));
		System.out.println("\tNumber of vowels: "+vowelsnum+"\t"+"Number of consonants: "+consonantnum);
	}

}

import javax.swing.*;
public class abrigo5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int Choice = JOptionPane.showConfirmDialog(null, "Please Enter your Personal Information");
		if (Choice == JOptionPane.YES_OPTION){
		JOptionPane.showMessageDialog(null, " Kindly enter your information after pressing OK!");
		String fullname = JOptionPane.showInputDialog(null, "What is your Fullname?");
		String nickname = JOptionPane.showInputDialog(null, "What is your Nickanme?");
		String birthday = JOptionPane.showInputDialog(null, "When is your birthday?");
		String hometown = JOptionPane.showInputDialog(null, "Where is your Home Town?");
		String CYS = JOptionPane.showInputDialog(null, "What is your Course, Year and Section?");
		
		JOptionPane.showMessageDialog(null, "Name: "+fullname+"\nNickname: "+nickname+"\nBirthday: "+ birthday
				+"\nHometown: "+hometown+"\nCourse, Year and Section: "+CYS);
		}
		else {
			JOptionPane.showMessageDialog(null, "Its just for sample XD");
		}
	}

}

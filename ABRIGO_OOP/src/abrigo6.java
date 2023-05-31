import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;

public class abrigo6 extends JFrame{
	
	private JPanel frame;
	private JTextField usernamteT;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JTextField fname;
	private JTextField lname;
	private JTextField citenshipt;
	private JTextField religiont;
	private JTextField contactinfot;
	private JTextField fnameFather;
	private JTextField lnameFather;
	private JTextField fnamemother;
	private JTextField lnamemother;
	private JTextField mottoT;
	private JTextField skillsT;
	private JTextField yeardob;
	private JTextField month;
	private JTextField Day;
	private JTextField aget;
	boolean isblank = true;
	boolean error = true;
	boolean isvalidated =false;
	
	public abrigo6() {
		setName("Regform");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800, 680);
		setLocationRelativeTo(null);
		setResizable(false);
		frame = new JPanel();
		frame.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(frame);
		frame.setLayout(null);
		
		JLabel schoolname = new JLabel("Southern Luzon State University");
		schoolname.setBounds(165, 25, 480, 29);
		schoolname.setForeground(new Color(0, 128, 0));
		schoolname.setFont(new Font("Cambria Math", Font.BOLD, 32));
		frame.add(schoolname);
		
		JLabel regform = new JLabel("Student Registration Form");
		regform.setBounds(240, 65, 300, 22);
		regform.setFont(new Font("Cambria Math", Font.BOLD, 24));
		regform.setAlignmentX(Component.CENTER_ALIGNMENT);
		frame.add(regform);
		
		JLabel username = new JLabel("Username:");
		username.setFont(new Font("Arial", Font.BOLD, 16));
		username.setBounds(50, 140, 88, 22);
		frame.add(username);
		
		usernamteT = new JTextField();
		usernamteT.setFont(new Font("Arial", Font.PLAIN, 16));
		usernamteT.setBounds(50, 165, 310, 24);
		frame.add(usernamteT);
		usernamteT.setColumns(10);
		
		JLabel password = new JLabel("Password:");
		password.setFont(new Font("Arial", Font.BOLD, 16));
		password.setBounds(50, 200, 88, 22);
		frame.add(password);
		
		JLabel cpassword = new JLabel("Confirm Password:");
		cpassword.setFont(new Font("Arial", Font.BOLD, 16));
		cpassword.setBounds(50, 260, 150, 22);
		frame.add(cpassword);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Arial", Font.PLAIN, 16));
		passwordField.setBounds(50, 225, 310, 24);
		frame.add(passwordField);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setFont(new Font("Arial", Font.PLAIN, 16));
		passwordField_1.setBounds(50, 285, 310, 24);
		frame.add(passwordField_1);
		
		JLabel Fullname = new JLabel("Full Name:");
		Fullname.setFont(new Font("Arial", Font.BOLD, 16));
		Fullname.setBounds(50, 330, 135, 22);
		frame.add(Fullname);
		
		fname = new JTextField();
		fname.setFont(new Font("Arial", Font.PLAIN, 16));
		fname.setColumns(10);
		fname.setBounds(50, 355, 150, 24);
		frame.add(fname);
		
		JLabel linebreak = new JLabel("---------------------------------------------- Please fill in the form below ---------------------------------------------");
		linebreak.setFont(new Font("Arial", Font.PLAIN, 14));
		linebreak.setBounds(80, 115, 640, 14);
		frame.add(linebreak);
		
		lname = new JTextField();
		lname.setFont(new Font("Arial", Font.PLAIN, 16));
		lname.setColumns(10);
		lname.setBounds(210, 355, 150, 24);
		frame.add(lname);
		
		JLabel fnamelabel = new JLabel("First Name");
		fnamelabel.setBounds(50, 380, 70, 14);
		frame.add(fnamelabel);
		
		JLabel lnamelabel = new JLabel("Last Name");
		lnamelabel.setBounds(210, 380, 70, 14);
		frame.add(lnamelabel);
		
		JLabel ycs = new JLabel("Year, Course, and Section:");
		ycs.setFont(new Font("Arial", Font.BOLD, 16));
		ycs.setBounds(50, 405, 205, 22);
		frame.add(ycs);
		
		JComboBox year = new JComboBox();
		year.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4"}));
		year.setFont(new Font("Arial", Font.PLAIN, 16));
		year.setBounds(50, 430, 40, 24);
		frame.add(year);
		
		JComboBox course = new JComboBox();
		course.setModel(new DefaultComboBoxModel(new String[] {"Computer Engineering", "Electrical Engineering", "Mechanical Engineering", "Electronics Engineering", "Industrial Engineering", "Civil Engineering"}));
		course.setFont(new Font("Arial", Font.PLAIN, 16));
		course.setBounds(100, 430, 200, 24);
		frame.add(course);
		
		JComboBox section = new JComboBox();
		section.setModel(new DefaultComboBoxModel(new String[] {"GE", "GF", "GG", "GH", "GI", "GJ", "IE", "IF", "IG", "IH", "II", "IJ"}));
		section.setFont(new Font("Arial", Font.PLAIN, 16));
		section.setBounds(310, 430, 50, 24);
		frame.add(section);
		
		JLabel yearlabel = new JLabel("Year");
		yearlabel.setBounds(50, 453, 35, 14);
		frame.add(yearlabel);
		
		JLabel courselabel = new JLabel("Course");
		courselabel.setBounds(98, 453, 45, 14);
		frame.add(courselabel);
		
		JLabel secetionlabel = new JLabel("Section");
		secetionlabel.setBounds(310, 453, 45, 14);
		frame.add(secetionlabel);
		
		JLabel dob = new JLabel("Date of Birth:");
		dob.setFont(new Font("Arial", Font.BOLD, 16));
		dob.setBounds(50, 470, 120, 22);
		frame.add(dob);
		
		yeardob = new JTextField();
		yeardob.setFont(new Font("Arial", Font.PLAIN, 16));
		yeardob.setColumns(10);
		yeardob.setBounds(50, 495, 60, 24);
		frame.add(yeardob);
		
		month = new JTextField();
		month.setFont(new Font("Arial", Font.PLAIN, 16));
		month.setColumns(10);
		month.setBounds(120, 495, 95, 24);
		frame.add(month);
		
		Day = new JTextField();
		Day.setFont(new Font("Arial", Font.PLAIN, 16));
		Day.setColumns(10);
		Day.setBounds(225, 495, 40, 24);
		frame.add(Day);
		
		JLabel yeardob1 = new JLabel("Year");
		yeardob1.setBounds(50, 520, 35, 14);
		frame.add(yeardob1);
		
		JLabel monthdob = new JLabel("Month");
		monthdob.setBounds(120, 520, 45, 14);
		frame.add(monthdob);
		
		JLabel daydob = new JLabel("Day");
		daydob.setBounds(225, 520, 35, 14);
		frame.add(daydob);
		
		JLabel age = new JLabel("Age:");
		age.setFont(new Font("Arial", Font.BOLD, 16));
		age.setBounds(280, 470, 50, 22);
		frame.add(age);
		
		aget = new JTextField();
		aget.setFont(new Font("Arial", Font.PLAIN, 16));
		aget.setColumns(10);
		aget.setBounds(280, 495, 80, 24);
		frame.add(aget);
		
		JLabel gender = new JLabel("Gender:");
		gender.setFont(new Font("Arial", Font.BOLD, 16));
		gender.setBounds(50, 535, 70, 22);
		frame.add(gender);
		
		JRadioButton male = new JRadioButton("Male");
		male.setFont(new Font("Arial", Font.BOLD, 16));
		male.setBounds(115, 550, 70, 24);
		frame.add(male);
		
		JRadioButton female = new JRadioButton("Female");
		female.setFont(new Font("Arial", Font.BOLD, 16));
		female.setBounds(210, 550, 90, 24);
		frame.add(female);
		
		JLabel citizenship = new JLabel("Citizenship:");
		citizenship.setFont(new Font("Arial", Font.BOLD, 16));
		citizenship.setBounds(50, 575, 100, 22);
		frame.add(citizenship);
		
		citenshipt = new JTextField();
		citenshipt.setFont(new Font("Arial", Font.PLAIN, 16));
		citenshipt.setColumns(10);
		citenshipt.setBounds(50, 600, 310, 24);
		frame.add(citenshipt);
		
		JLabel religion = new JLabel("Religion:");
		religion.setFont(new Font("Arial", Font.BOLD, 16));
		religion.setBounds(420, 140, 70, 22);
		frame.add(religion);
		
		religiont = new JTextField();
		religiont.setFont(new Font("Arial", Font.PLAIN, 16));
		religiont.setColumns(10);
		religiont.setBounds(420, 165, 150, 24);
		frame.add(religiont);
		
		contactinfot = new JTextField();
		contactinfot.setFont(new Font("Arial", Font.PLAIN, 16));
		contactinfot.setColumns(10);
		contactinfot.setBounds(585, 165, 150, 24);
		frame.add(contactinfot);
		
		JLabel contactno = new JLabel("Contact No.");
		contactno.setFont(new Font("Arial", Font.BOLD, 16));
		contactno.setBounds(585, 140, 100, 22);
		frame.add(contactno);
		
		JLabel FathersName = new JLabel("Father's Name:");
		FathersName.setFont(new Font("Arial", Font.BOLD, 16));
		FathersName.setBounds(420, 200, 135, 22);
		frame.add(FathersName);
		
		fnameFather = new JTextField();
		fnameFather.setFont(new Font("Arial", Font.PLAIN, 16));
		fnameFather.setColumns(10);
		fnameFather.setBounds(420, 225, 150, 24);
		frame.add(fnameFather);
		
		lnameFather = new JTextField();
		lnameFather.setFont(new Font("Arial", Font.PLAIN, 16));
		lnameFather.setColumns(10);
		lnameFather.setBounds(585, 225, 150, 24);
		frame.add(lnameFather);
		
		JLabel fnamefather = new JLabel("First Name");
		fnamefather.setBounds(420, 249, 70, 14);
		frame.add(fnamefather);
		
		JLabel lnamefather = new JLabel("Last Name");
		lnamefather.setBounds(585, 249, 70, 14);
		frame.add(lnamefather);
		
		JLabel MothersName = new JLabel("Mother's Name:");
		MothersName.setFont(new Font("Arial", Font.BOLD, 16));
		MothersName.setBounds(420, 270, 135, 22);
		frame.add(MothersName);
		
		fnamemother = new JTextField();
		fnamemother.setFont(new Font("Arial", Font.PLAIN, 16));
		fnamemother.setColumns(10);
		fnamemother.setBounds(420, 295, 150, 24);
		frame.add(fnamemother);
		
		lnamemother = new JTextField();
		lnamemother.setFont(new Font("Arial", Font.PLAIN, 16));
		lnamemother.setColumns(10);
		lnamemother.setBounds(585, 295, 150, 24);
		frame.add(lnamemother);
		
		JLabel fnameMother = new JLabel("First Name");
		fnameMother.setBounds(420, 320, 70, 14);
		frame.add(fnameMother);
		
		JLabel lnameMother = new JLabel("Last Name");
		lnameMother.setBounds(585, 320, 70, 14);
		frame.add(lnameMother);
		
		JLabel motto = new JLabel("Motto:");
		motto.setFont(new Font("Arial", Font.BOLD, 16));
		motto.setBounds(420, 340, 60, 22);
		frame.add(motto);
		
		mottoT = new JTextField();
		mottoT.setFont(new Font("Arial", Font.PLAIN, 16));
		mottoT.setColumns(10);
		mottoT.setBounds(420, 365, 315, 24);
		frame.add(mottoT);
		
		JLabel Skills = new JLabel("Skills:");
		Skills.setFont(new Font("Arial", Font.BOLD, 16));
		Skills.setBounds(420, 400, 50, 22);
		frame.add(Skills);
		
		skillsT = new JTextField();
		skillsT.setFont(new Font("Arial", Font.PLAIN, 16));
		skillsT.setColumns(10);
		skillsT.setBounds(420, 425, 315, 24);
		frame.add(skillsT);
		
		JLabel Seminar = new JLabel("Seminars Attended:");
		Seminar.setFont(new Font("Arial", Font.BOLD, 16));
		Seminar.setBounds(420, 460, 155, 22);
		frame.add(Seminar);
		
		JTextArea seminars = new JTextArea();
		seminars.setFont(new Font("Arial", Font.PLAIN, 14));
		JScrollPane scrollBar = new JScrollPane(seminars,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollBar.setBounds(420, 485, 315, 93);
		frame.add(scrollBar);
		
		JButton Submit = new JButton();
		Submit.setIcon(new ImageIcon("C:\\Users\\rvabr\\Downloads\\button.png"));
		Submit.setAlignmentX(Component.CENTER_ALIGNMENT);
		Submit.setFont(new Font("Arial", Font.BOLD, 14));
		Submit.setBounds(430, 595, 90, 30);
		frame.add(Submit);
		
		JButton Reset = new JButton("Reset");
		Reset.setAlignmentX(Component.CENTER_ALIGNMENT);
		Reset.setFont(new Font("Arial", Font.BOLD, 14));
		Reset.setBounds(530, 595, 90, 30);
		frame.add(Reset);
		
		JButton Validate = new JButton("Validate");
		Validate.setAlignmentX(Component.CENTER_ALIGNMENT);
		Validate.setFont(new Font("Arial", Font.BOLD, 14));
		Validate.setBounds(636, 595, 90, 30);
		frame.add(Validate);
		
		
		//actionlistener events for submit, reset, validate
		Submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					if(error==false&&isblank==false&&isvalidated==true) {
						String data;
						String x = null;
						if(male.isSelected()) {
							x = "Gender: Male";
						}
						else if(female.isSelected()){
							x = "Gender: Female";
						}
						data = "Username: "+usernamteT.getText()+"\nName:"+fname.getText()+" "+lname.getText()
						+"\nYear,Course and Section: "+year.getSelectedItem()+" "+course.getSelectedItem()+" "+section.getSelectedItem()+
						"\nDate of Birth: "+yeardob.getText()+","+month.getText()+" "+Day.getText()+"\nAge: "+aget.getText()+"\n"+x+"\nCitizenship: "+
						citenshipt.getText()+"\nReligion: "+religiont.getText()+"\nContact No: "+contactinfot.getText()+"\nFather's Name: "+fnameFather.getText()+" "+lnameFather.getText()
						+"\nMother's Name: "+fnamemother.getText()+" "+lnamemother.getText()+"\nMotto: "+mottoT.getText()+"\nSkills: "+skillsT.getText()+"\nSeminar Attended: "+seminars.getText();
						int choice = JOptionPane.showConfirmDialog(null, "Is the information Correct?\n" + data);
						if(choice == JOptionPane.YES_OPTION) {
							JOptionPane.showMessageDialog(null, "You have successfuly sumbit your student registration form!");
						}
					}				
					else if(isvalidated==false&&isblank==false&&error==true){
						JOptionPane.showMessageDialog(null, "Please validate your inputs first");
					}
					else if(isblank==true&&isvalidated==false&&error==true) {
						JOptionPane.showMessageDialog(null, "Please fill out the forms");
					}
			}
		});
		Reset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String def = "";
	            usernamteT.setText(def);
	            passwordField.setText(def);
	            passwordField_1.setText(def);
	            fname.setText(def);
	            lname.setText(def);
	            year.setSelectedIndex(0);
	            course.setSelectedIndex(0);
	            section.setSelectedIndex(0);
	            yeardob.setText(def);
	            month.setText(def);
	            Day.setText(def);
	            aget.setText(def);
	            male.setSelected(false);
	            female.setSelected(false);
	            citenshipt.setText(def);
	            religiont.setText(def);
	            contactinfot.setText(def);
	            fnameFather.setText(def);
	            lnameFather.setText(def);
	            fnamemother.setText(def);
	            lnamemother.setText(def);
	            mottoT.setText(def);
	            skillsT.setText(def);
	            seminars.setText(def);
			}
		});
		Validate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String password = passwordField.getText();
				String confirmpassword = passwordField_1.getText();
				if(password.contains(confirmpassword)&&usernamteT.getText()!= null&&fname.getText()!= null&&lname.getText()!=null&&password!=null&&confirmpassword!=null&&yeardob.getText()!=null&&
				month.getText()!=null&&Day.getText()!=null&&aget.getText()!=null&&(male.isSelected()||female.isSelected())&&citenshipt.getText()!=null&&religion!=null&&contactinfot.getText()!=null&&
				fnameFather.getText()!=null&&lnameFather.getText()!=null&&fnamemother.getText()!=null&&lnamemother.getText()!=null&&mottoT.getText()!=null&&skillsT.getText()!=null&&seminars.getText()!=null) {
					JOptionPane.showMessageDialog(null, "Your inputs are now validated! You can now proceed to submit!");
					error = false;
					isblank = false;
					isvalidated = true;
				}
				if(!password.contains(confirmpassword)&&usernamteT.getText()!= null&&fname.getText()!= null&&lname.getText()!=null&&password!=null&&confirmpassword!=null&&yeardob.getText()!=null&&
					month.getText()!=null&&Day.getText()!=null&&aget.getText()!=null&&(male.isSelected()||female.isSelected())&&citenshipt.getText()!=null&&religion!=null&&contactinfot.getText()!=null&&
					fnameFather.getText()!=null&&lnameFather.getText()!=null&&fnamemother.getText()!=null&&lnamemother.getText()!=null&&mottoT.getText()!=null&&skillsT.getText()!=null&&seminars.getText()!=null){
					JOptionPane.showMessageDialog(null, "Password and Confirm Password isn't match");
					error = true;
					isblank = false;
					isvalidated = false;
				}
			}
		});
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					abrigo6 frame = new abrigo6();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}


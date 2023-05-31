import java.awt.EventQueue;

import javax.swing.*;
import java.awt.*;
import java.awt.Font;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.sql.*;
import java.awt.event.ActionEvent;

public class Login extends JFrame implements ActionListener{

	private JPanel contentPane;
	private Panel panel;
	private JLabel Title_1;
	private JPanel panel_2;
	private JLabel WelcomeM;
	private JTextField textField;
	private JPasswordField passwordField;
	private JButton loginbutton;
	private JButton Exit;
	
	private Connection connect;
	private PreparedStatement prepare;
	private ResultSet result;

	private MyMouseListener mouseListener;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		mouseListener = new MyMouseListener(this);	
		init();
	}
	public void init() {
		
		setUndecorated(true);
		setResizable(false);
		addMouseListener(mouseListener);
		addMouseMotionListener(mouseListener);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(0, 95, 95));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel = new Panel();
		panel.setBackground(new Color(81, 4, 0));
		panel.setBounds(0, 0, 300, 400);
		contentPane.add(panel);
		panel.setLayout(null);
		
		Title_1 = new JLabel("CEN RMS");
		Title_1.setBounds(100, 240, 100, 40);
		Title_1.setForeground(new Color(255, 255, 255));
		Title_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel.add(Title_1);
		
		panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 255, 255));
		panel_2.setBounds(300, 0, 300, 400);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		WelcomeM = new JLabel("Welcome back, Admin!");
		WelcomeM.setBackground(new Color(255, 255, 255));
		WelcomeM.setForeground(new Color(181, 0, 46));
		WelcomeM.setFont(new Font("Tahoma", Font.BOLD, 17));
		WelcomeM.setBounds(21, 95, 204, 20);
		panel_2.add(WelcomeM);
		
		textField = new JTextField();
		textField.setFont(new Font("Arial", Font.PLAIN, 13));
		textField.setBackground(new Color(239, 239, 239));
		textField.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		textField.setBounds(40, 145, 220, 35);
		panel_2.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		passwordField.setBackground(new Color(239, 239, 239));
		passwordField.setBounds(40, 200, 220, 35);
		panel_2.add(passwordField);
		
		loginbutton = new JButton("Login");
		loginbutton.setBackground(new Color(255, 255, 255));
		loginbutton.setFont(new Font("Arial", Font.PLAIN, 14));
		loginbutton.setBounds(40, 265, 220, 45);
		loginbutton.addActionListener(this);
		panel_2.add(loginbutton);
		
		Exit = new JButton("x");
		Exit.setHorizontalTextPosition(SwingConstants.LEFT);
		Exit.setAlignmentY(Component.TOP_ALIGNMENT);
		Exit.setBackground(new Color(255, 255, 255));
		Exit.setFont(new Font("Tahoma", Font.BOLD, 14));
		Exit.setBorderPainted(false);
		Exit.addActionListener(this);
		Exit.setBounds(250, 10, 43, 20);
		panel_2.add(Exit);
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()== Exit) {
			close();
		}
		if(e.getSource() == loginbutton) {
			loginAdmin();
		}
	}
	public void close() {
		System.exit(0);
	}
	public void loginAdmin() {
		
		Dashboard dboard = new Dashboard();
		
		String sql = "Select * FROM admin where username = ? and password = ?";
		
		connect = database.connectDb();
		
		try {
			prepare = connect.prepareStatement(sql);
			prepare.setString(1, textField.getText());
			prepare.setString(2, new String(passwordField.getPassword()));
			
			result = prepare.executeQuery();
			
			if (textField.getText().isEmpty() || passwordField.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Please fill all blank fields", "Error Message", JOptionPane.ERROR_MESSAGE);
			} 
			else {
				if (result.next()) {
					JOptionPane.showMessageDialog(null, "Successfully login", "Information Message", JOptionPane.INFORMATION_MESSAGE);
					this.setVisible(false);
					dboard.setVisible(true);
				} else {
					JOptionPane.showMessageDialog(null, "Wrong Username/Password", "Error Message", JOptionPane.ERROR_MESSAGE);
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		} 
		
	}
}
import java.awt.*;
import java.awt.event.*;

import java.sql.*;
import java.text.*;

import javax.swing.*;
import javax.swing.table.*;
import javax.swing.border.*;

public class Dashboard extends JFrame implements ActionListener
,MouseListener, MouseMotionListener, FocusListener{

	private int key,rid;
	public static String username;
	
	//other classes to be declared
	private MyMouseListener mouseListener;
	//database
	private static Connection connect;
	private PreparedStatement prepare;
	private static ResultSet result;
	private static Statement state;
	
	private JPanel contentPane, Buttonpanelleft, Toolpanel,linepanel;
	
	//panel Dashboard
	private ImageIcon signoutIcon,icon,scaledIcon;
	private Image image1;
	private JLabel welcomelabel, welcomelabel_2, Title, Signoutlabel, CEN,dboard,
	totalFaculty,TotalSections,Total1,Total2,Total3,Totalroom,imageLabel;
	private JButton signout,Dashboard1,RoomManagementButton,FacultyManagementButton,
	SectionButton,RoomAssignmentButton,Exit,Minimize;
	private JPanel DashBoardPanel,panel_8_1,panel_9_1,panel_2,panel_5,panel_6,panel_6_1,panel_8,panel_9;
	
	//panel RoomManagement
	private JPanel RoomManagementPanel,roommanagementinnerpanel,roommanagementpanel,upperpanelroommanagement;
	private JTable table;
	private JScrollPane scrollPane;
	private JScrollPane facultscrollpane;
	private JTextField search;
	private String searchS = "Search";
	private JLabel roomID,RoomNameLabel,RoomtypeLabel, capacityL,roomidlabel,roomidno,roommanagementtitle;
	private JTextField roomnameTextfield, capacityT;
	private JComboBox roomtype;
	private JButton addbutt, clearbutt,deletebutt, editbutt;
	
	//faculty management
	private JPanel FacultyManagementPanel,facultymanagementinnerpanel, facultytitle,
	upperpanel,formfacultypanel,tablefacultypanel;
	private JButton addbutt2, clearbutt2, editbutt2, deletebutt2;
	private JLabel facultytitlelabel,idno,FacultyName,facultydept,email,contact,facultyname;
	private JComboBox depttype;
	private JTextField idnum,namefield,emailfield,contactfield,searchfaculty;
	private JTable facultytable;

	private int fid,keyf;
	private String facultyidS;
	private boolean facultyIDExists;
	
	//section management
	private JPanel SectionManagementPanel,innerpanelsection,panelsection,
	upperpanelsection,panel,schedclasspanel, formsectionpanel, tablesectionpanel;
	private JLabel sectionlabel,sectionname, sectidlabel,sectid,Course,Year,Section,nofstudents;
	private JTextField coursetextF,sectField;
	private JButton addbutt3, deletebutt3, clearbutt3, editbutt3;
	private JScrollPane scrollpanesection;
	private JComboBox yearlevel;
	private JTable sectiontable;
	
	private String sectidS;
	private int sid, keys;
	private JTextField nostudentstextF;
	private JPanel schedulepanel, schedpanel1, upperpanel_1;
	private JScrollPane schedulescrollpane;
	private JLabel schedpaneltitle;
	private JButton SchedClassbutton;
	private static JTable scheduletable;
	private JTextField searchtfield;
	private JButton print;
	private JButton download;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Dashboard frame = new Dashboard();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public Dashboard() {
		mouseListener = new MyMouseListener(this);	
		
		init();
		getTotalRoom();
		addMouseListenerToTableRoom();
		setDefaultRendererToTable(table);
		autoID();
		showRooms();
		getTotalFaculty();
		setDefaultRendererToTable(facultytable);
		addMouseListenerToTableFaculty();
		showFaculty();
		getTotalSection();
		setDefaultRendererToTable(sectiontable);
		addMouseListenerToTableSection();
		autoIDsection();
		showSections();
		setDefaultRendererToTable(scheduletable);
		showSchedule();
	}
	public void init() {
		addMouseListener(mouseListener);
		addMouseMotionListener(mouseListener);
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1100, 600);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(250, 250, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Buttonpanelleft = new JPanel();
		Buttonpanelleft.setForeground(new Color(255, 255, 255));
		Buttonpanelleft.setBackground(new Color(255, 255, 255));
		Buttonpanelleft.setBounds(0, 35, 200, 565);
		contentPane.add(Buttonpanelleft);
		Buttonpanelleft.setLayout(null);
		
		welcomelabel = new JLabel("Welcome,");
		welcomelabel.setHorizontalAlignment(SwingConstants.CENTER);
		welcomelabel.setForeground(new Color(0, 0, 0));
		welcomelabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		welcomelabel.setBounds(10, 150, 180, 18);
		Buttonpanelleft.add(welcomelabel);
		
		welcomelabel_2 = new JLabel("ADMIN!");
        welcomelabel_2.setHorizontalAlignment(SwingConstants.CENTER);
        welcomelabel_2.setForeground(new Color(0, 0, 0));
        welcomelabel_2.setFont(new Font("Arial", Font.BOLD, 20));
        welcomelabel_2.setBounds(10, 168, 180, 22);
        Buttonpanelleft.add(welcomelabel_2);
        
        linepanel = new JPanel();
        linepanel.setBounds(20, 200, 160, 2);
        Buttonpanelleft.add(linepanel);
        
        Dashboard1 = new JButton("Dashboard");
        Dashboard1.setHorizontalAlignment(SwingConstants.LEFT);
        Dashboard1.setFont(new Font("Arial", Font.BOLD, 12));
        Dashboard1.setBounds(20, 225, 160, 35);
        Dashboard1.setIcon(new ImageIcon("images/dashboard.png"));
        Dashboard1.setOpaque(false); // Set the button to be transparent
        Dashboard1.setContentAreaFilled(false); // Remove the background color
        Dashboard1.setBorderPainted(false);
        Dashboard1.setForeground(new Color(0, 0, 0));
        Dashboard1.addActionListener(this);
        Buttonpanelleft.add(Dashboard1);
        
        RoomManagementButton = new JButton("Manage Room");
        RoomManagementButton.setHorizontalAlignment(SwingConstants.LEFT);
        RoomManagementButton.setFont(new Font("Arial", Font.BOLD, 12));
        RoomManagementButton.setBounds(20, 265, 160, 35);
        RoomManagementButton.setIcon(new ImageIcon("images/training.png"));
        RoomManagementButton.setOpaque(false); // Set the button to be transparent
        RoomManagementButton.setContentAreaFilled(false); // Remove the background color
        RoomManagementButton.setBorderPainted(false);
        RoomManagementButton.setForeground(new Color(0, 0, 0));
        RoomManagementButton.addActionListener(this);
        Buttonpanelleft.add(RoomManagementButton);
        
        FacultyManagementButton = new JButton("Manage Faculty");
        FacultyManagementButton.setHorizontalAlignment(SwingConstants.LEFT);
        FacultyManagementButton.setFont(new Font("Arial", Font.BOLD, 12));
        FacultyManagementButton.setBounds(20, 305, 160, 35);
        FacultyManagementButton.setIcon(new ImageIcon("images/teacher.png"));
        FacultyManagementButton.setOpaque(false); // Set the button to be transparent
        FacultyManagementButton.setContentAreaFilled(false); // Remove the background color
        FacultyManagementButton.setBorderPainted(false);
        FacultyManagementButton.setForeground(new Color(0, 0, 0));
        FacultyManagementButton.addActionListener(this);
        Buttonpanelleft.add(FacultyManagementButton);
        
        SectionButton = new JButton("Manage Section");
        SectionButton.setHorizontalAlignment(SwingConstants.LEFT);
        SectionButton.setFont(new Font("Arial", Font.BOLD, 12));
        SectionButton.setBounds(20, 345, 160, 35);
        SectionButton.setIcon(new ImageIcon("images/students.png"));
        SectionButton.setOpaque(false); // Set the button to be transparent
        SectionButton.setContentAreaFilled(false); // Remove the background color
        SectionButton.setBorderPainted(false);
        SectionButton.setForeground(new Color(0, 0, 0));
        SectionButton.addActionListener(this);
        Buttonpanelleft.add(SectionButton);
        
        RoomAssignmentButton = new JButton("Assign Class");
        RoomAssignmentButton.setHorizontalAlignment(SwingConstants.LEFT);
        RoomAssignmentButton.setFont(new Font("Arial", Font.BOLD, 12));
        RoomAssignmentButton.setBounds(20, 385, 160, 35);
        RoomAssignmentButton.setIcon(new ImageIcon("images/school.png"));
        RoomAssignmentButton.setOpaque(false); // Set the button to be transparent
        RoomAssignmentButton.setContentAreaFilled(false); // Remove the background color
        RoomAssignmentButton.setBorderPainted(false);
        RoomAssignmentButton.setForeground(new Color(0, 0, 0));
        RoomAssignmentButton.addActionListener(this);
        Buttonpanelleft.add(RoomAssignmentButton);
        
        signoutIcon = new ImageIcon("images/sign-out-option.png"); // create an ImageIcon from the image
        signout = new JButton(signoutIcon);
        signout.setBackground(new Color(255, 255, 255));
        signout.setBounds(10, 525, 35, 30);
        signout.addActionListener(this);
        Buttonpanelleft.add(signout);
        
        Signoutlabel = new JLabel("Sign out");
        Signoutlabel.setForeground(new Color(0, 0, 0));
        Signoutlabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
        Signoutlabel.setBounds(55, 530, 60, 18);
        Buttonpanelleft.add(Signoutlabel);
        
        imageLabel = new JLabel();
        imageLabel.setBounds(15, 15, 170, 130);
        icon = new ImageIcon("images/admin1.png");
        image1 = icon.getImage().getScaledInstance(imageLabel.getWidth(), imageLabel.getHeight(), Image.SCALE_SMOOTH);
        scaledIcon = new ImageIcon(image1);
        imageLabel.setIcon(scaledIcon);
        Buttonpanelleft.add(imageLabel);

		Toolpanel = new JPanel();
		Toolpanel.setBackground(new Color(128, 0, 0));
		Toolpanel.setBounds(0, 0, 1100, 35);
		contentPane.add(Toolpanel);
		Toolpanel.setLayout(null);
		
		Title = new JLabel("CEN Room Management System");
		Title.setForeground(new Color(255, 255, 255));
		Title.setHorizontalAlignment(SwingConstants.CENTER);
		Title.setFont(new Font("Tahoma", Font.BOLD, 14));
		Title.setBounds(40, 8, 235, 20);
		Toolpanel.add(Title);
		
		Exit = new JButton("x");
		Exit.setForeground(new Color(255, 255, 255));
		Exit.setHorizontalTextPosition(SwingConstants.LEFT);
		Exit.setFont(new Font("Tahoma", Font.BOLD, 14));
		Exit.setBorderPainted(false);
		Exit.setBackground(new Color(128, 0, 32));
		Exit.addActionListener(this);
		Exit.setAlignmentY(0.0f);
		Exit.setBounds(1057, 6, 43, 20);
		Toolpanel.add(Exit);
		
		Minimize = new JButton("-");
		Minimize.setForeground(new Color(255, 255, 255));
		Minimize.setHorizontalAlignment(SwingConstants.RIGHT);
		Minimize.setHorizontalTextPosition(SwingConstants.RIGHT);
		Minimize.setFont(new Font("Tahoma", Font.BOLD, 14));
		Minimize.setBorderPainted(false);
		Minimize.setBackground(new Color(128, 0, 32));
		Minimize.addActionListener(this);
		Minimize.setAlignmentY(0.0f);
		Minimize.setBounds(1014, 6, 40, 20);
		Toolpanel.add(Minimize);
		
		DashBoardPanel = new JPanel();
		DashBoardPanel.setBounds(200, 35, 900, 565);
		contentPane.add(DashBoardPanel);
		DashBoardPanel.setBackground(new Color(242, 242, 242));
		DashBoardPanel.setVisible(true);
		DashBoardPanel.setLayout(null);
		
		panel_5 = new JPanel();
		panel_5.setBorder(new LineBorder(new Color(251, 251, 251), 10, true));
		panel_5.setForeground(new Color(0, 0, 0));
		panel_5.setBackground(new Color(251, 251, 251));
		panel_5.setBounds(15, 96, 870, 458);
		DashBoardPanel.add(panel_5);
		panel_5.setLayout(null);
		
		panel_8 = new JPanel();
		panel_8.setBackground(new Color(255, 255, 255));
		panel_8.setBounds(22, 22, 402, 196);
		panel_5.add(panel_8);
		panel_8.setLayout(null);
		
		panel_8_1 = new JPanel();
		panel_8_1.setBounds(0, 146, 402, 50);
		panel_8_1.setBackground(new Color(128, 0, 0));
		panel_8.add(panel_8_1);
		panel_8_1.setLayout(null);
		
		Totalroom = new JLabel("Total Rooms");
		Totalroom.setHorizontalAlignment(SwingConstants.CENTER);
		Totalroom.setBounds(0, 0, 402, 50);
		Totalroom.setForeground(new Color(255, 255, 255));
		Totalroom.setFont(new Font("Arial", Font.PLAIN, 18));
		panel_8_1.add(Totalroom);
		
		Total1 = new JLabel();
		Total1.setFont(new Font("Arial", Font.PLAIN, 90));
		Total1.setHorizontalAlignment(SwingConstants.CENTER);
		Total1.setBounds(0, 0, 402, 147);
		panel_8.add(Total1);
		
		panel_9 = new JPanel();
		panel_9.setBackground(new Color(255, 255, 255));
		panel_9.setBounds(212, 240, 402, 196);
		panel_5.add(panel_9);
		panel_9.setLayout(null);
		
		panel_9_1 = new JPanel();
		panel_9_1.setBounds(0, 146, 402, 50);
		panel_9_1.setBackground(new Color(128, 0, 0));
		panel_9.add(panel_9_1);
		panel_9_1.setLayout(null);
		
		totalFaculty = new JLabel("Total Faculty");
		totalFaculty.setHorizontalAlignment(SwingConstants.CENTER);
		totalFaculty.setForeground(Color.WHITE);
		totalFaculty.setFont(new Font("Arial", Font.PLAIN, 18));
		totalFaculty.setBounds(0, 0, 402, 50);
		panel_9_1.add(totalFaculty);
		
		Total3 = new JLabel();
		Total3.setHorizontalAlignment(SwingConstants.CENTER);
		Total3.setFont(new Font("Arial", Font.PLAIN, 90));
		Total3.setBounds(0, 0, 402, 147);
		panel_9.add(Total3);
		
		panel_6 = new JPanel();
		panel_6.setBackground(new Color(255, 255, 255));
		panel_6.setBounds(446, 22, 402, 196);
		panel_5.add(panel_6);
		panel_6.setLayout(null);
		
		panel_6_1 = new JPanel();
		panel_6_1.setBounds(0, 146, 402, 50);
		panel_6_1.setBackground(new Color(128, 0, 0));
		panel_6.add(panel_6_1);
		panel_6_1.setLayout(null);
		
		TotalSections = new JLabel("Total Sections");
		TotalSections.setHorizontalAlignment(SwingConstants.CENTER);
		TotalSections.setForeground(Color.WHITE);
		TotalSections.setFont(new Font("Arial", Font.PLAIN, 18));
		TotalSections.setBounds(0, 0, 402, 50);
		panel_6_1.add(TotalSections);
		
		Total2 = new JLabel("0");
		Total2.setHorizontalAlignment(SwingConstants.CENTER);
		Total2.setFont(new Font("Arial", Font.PLAIN, 90));
		Total2.setBounds(0, 0, 402, 147);
		panel_6.add(Total2);
		
		panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(251, 251, 251), 1, true));
		panel_2.setBackground(new Color(251, 251, 251));
		panel_2.setBounds(15, 15, 870, 70);
		DashBoardPanel.add(panel_2);
		panel_2.setLayout(null);
		
		CEN = new JLabel("CEN Room Management System");
		CEN.setHorizontalAlignment(SwingConstants.CENTER);
		CEN.setBounds(305, 16, 260, 20);
		CEN.setFont(new Font("Arial", Font.BOLD, 16));
		panel_2.add(CEN);
		
		dboard = new JLabel("Dashboard");
		dboard.setBounds(395, 38, 80, 20);
		dboard.setFont(new Font("Arial", Font.BOLD, 14));
		panel_2.add(dboard);
		
		RoomManagementPanel = new JPanel();
		RoomManagementPanel.setBackground(new Color(242, 242, 242));
		RoomManagementPanel.setBounds(200, 35, 900, 565);
		contentPane.add(RoomManagementPanel);
		RoomManagementPanel.setLayout(null);
		
		roommanagementinnerpanel = new JPanel();
		roommanagementinnerpanel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		roommanagementinnerpanel.setBounds(15, 15, 870, 540);
		roommanagementinnerpanel.setBackground(new Color(255, 255, 255));
		RoomManagementPanel.add(roommanagementinnerpanel);
		roommanagementinnerpanel.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		scrollPane.setBackground(new Color(255, 255, 255));
		scrollPane.setAutoscrolls(true);
		scrollPane.setFont(new Font("Arial", Font.PLAIN, 12));
		scrollPane.setBounds(22, 100, 830, 250);
		roommanagementinnerpanel.add(scrollPane);
		
		table = new JTable();
		table.setFont(new Font("Arial", Font.PLAIN, 12));
		table.setBackground(Color.white);
		table.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		scrollPane.setViewportView(table);
		
		search = new JTextField(20);
		search.setFont(new Font("Arial", Font.PLAIN, 12));
		search.setBackground(new Color(255, 255, 255));
		search.setBounds(22, 60, 275, 28);
		search.setText(searchS);
		search.addFocusListener(this);
		search.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				filterTable(table, search);
			}
		});
		roommanagementinnerpanel.add(search);
		
		
		RoomNameLabel = new JLabel("Room Name:");
		RoomNameLabel.setFont(new Font("Arial", Font.BOLD, 14));
		RoomNameLabel.setBounds(170, 420, 90, 25);
		roommanagementinnerpanel.add(RoomNameLabel);
		
		roomnameTextfield = new JTextField(20);
		roomnameTextfield.setFont(new Font("Arial", Font.PLAIN, 12));
		roomnameTextfield.setBounds(270, 420, 150, 25);
		roommanagementinnerpanel.add(roomnameTextfield);
		
		RoomtypeLabel = new JLabel("Room Type:");
		RoomtypeLabel.setFont(new Font("Arial", Font.BOLD, 14));
		RoomtypeLabel.setBounds(450, 375, 90, 25);
		roommanagementinnerpanel.add(RoomtypeLabel);
		
		roomtype = new JComboBox();
		roomtype.setFont(new Font("Arial", Font.PLAIN, 12));
		roomtype.setModel(new DefaultComboBoxModel(new String[] {"Classroom", 
				"Facultyroom", "Laboratoryroom", "Stockroom"}));
		roomtype.setBounds(550, 376, 150, 25);
		roommanagementinnerpanel.add(roomtype);
		
		capacityL = new JLabel("Capacity:");
		capacityL.setFont(new Font("Arial", Font.BOLD, 14));
		capacityL.setBounds(450, 420, 90, 25);
		roommanagementinnerpanel.add(capacityL);
		
		capacityT = new JTextField(20);
		capacityT.setBackground(new Color(255, 255, 255));
		capacityT.setFont(new Font("Arial", Font.PLAIN, 12));
		capacityT.setBounds(550, 420, 150, 25);
		roommanagementinnerpanel.add(capacityT);
		
		addbutt = new JButton("Add");
		addbutt.setBackground(new Color(255, 255, 255));
		addbutt.setFont(new Font("Arial", Font.PLAIN, 14));
		addbutt.setBounds(170, 470, 90, 40);
		addbutt.addActionListener(this);
		roommanagementinnerpanel.add(addbutt);
		
		clearbutt = new JButton("Clear");
		clearbutt.setBackground(new Color(255, 255, 255));
		clearbutt.setFont(new Font("Arial", Font.PLAIN, 14));
		clearbutt.setBounds(460, 470, 90, 40);
		clearbutt.addActionListener(this);
		roommanagementinnerpanel.add(clearbutt);
		
		deletebutt = new JButton("Delete");
		deletebutt.setBackground(new Color(255, 255, 255));
		deletebutt.setFont(new Font("Arial", Font.PLAIN, 14));
		deletebutt.setBounds(312, 470, 90, 40);
		deletebutt.addActionListener(this);
		roommanagementinnerpanel.add(deletebutt);
		
		editbutt = new JButton("Edit");
		editbutt.setBackground(new Color(255, 255, 255));
		editbutt.setFont(new Font("Arial", Font.PLAIN, 14));
		editbutt.setBounds(610, 470, 90, 40);
		editbutt.addActionListener(this);
		roommanagementinnerpanel.add(editbutt);
		
		roomidlabel = new JLabel("Room ID:");
		roomidlabel.setFont(new Font("Arial", Font.BOLD, 14));
		roomidlabel.setBounds(170, 375, 90, 25);
		roommanagementinnerpanel.add(roomidlabel);
		
		roomidno = new JLabel();
		roomidno.setHorizontalAlignment(SwingConstants.LEFT);
		roomidno.setForeground(new Color(255, 0, 0));
		roomidno.setFont(new Font("Arial", Font.BOLD, 14));
		roomidno.setBounds(270, 375, 90, 25);
		roommanagementinnerpanel.add(roomidno);
		
		roommanagementpanel = new JPanel();
		roommanagementpanel.setLayout(null);
		roommanagementpanel.setBackground(new Color(128, 0, 0));
		roommanagementpanel.setBounds(0, 0, 870, 50);
		roommanagementinnerpanel.add(roommanagementpanel);
		
		upperpanelroommanagement = new JPanel();
		upperpanelroommanagement.setLayout(null);
		upperpanelroommanagement.setBorder(new LineBorder(new Color(255, 255, 255), 6, true));
		upperpanelroommanagement.setBackground(Color.WHITE);
		upperpanelroommanagement.setBounds(5, 5, 860, 40);
		roommanagementpanel.add(upperpanelroommanagement);
		
		roommanagementtitle = new JLabel("Room Management");
		roommanagementtitle.setFont(new Font("Arial", Font.PLAIN, 20));
		roommanagementtitle.setBounds(15, 8, 200, 25);
		upperpanelroommanagement.add(roommanagementtitle);
		
		FacultyManagementPanel = new JPanel();
		FacultyManagementPanel.setBackground(new Color(235, 235, 235));
		FacultyManagementPanel.setBounds(200, 35, 900, 565);
		contentPane.add(FacultyManagementPanel);
		FacultyManagementPanel.setLayout(null);
		
		facultymanagementinnerpanel = new JPanel();
		facultymanagementinnerpanel.setBackground(new Color(255, 255, 255));
		facultymanagementinnerpanel.setBounds(15, 15, 875, 535);
		FacultyManagementPanel.add(facultymanagementinnerpanel);
		facultymanagementinnerpanel.setLayout(null);
		
		facultytitle = new JPanel();
		facultytitle.setBounds(0, 0, 875, 50);
		facultytitle.setBackground(new Color(128, 0, 0));
		facultymanagementinnerpanel.add(facultytitle);
		facultytitle.setLayout(null);
		
		upperpanel = new JPanel();
		upperpanel.setBorder(new LineBorder(new Color(255, 255, 255), 6, true));
		upperpanel.setLayout(null);
		upperpanel.setBackground(new Color(255, 255, 255));
		upperpanel.setBounds(5, 5, 865, 40);
		facultytitle.add(upperpanel);
		
		facultytitlelabel = new JLabel("Faculty Management");
		facultytitlelabel.setFont(new Font("Arial", Font.PLAIN, 20));
		facultytitlelabel.setBounds(15, 8, 200, 25);
		upperpanel.add(facultytitlelabel);
		
		formfacultypanel = new JPanel();
		formfacultypanel.setBackground(new Color(248, 248, 248));
		formfacultypanel.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		formfacultypanel.setBounds(10, 103, 330, 370);
		facultymanagementinnerpanel.add(formfacultypanel);
		formfacultypanel.setLayout(null);
		
		idno = new JLabel("ID number:");
		idno.setFont(new Font("Arial", Font.BOLD, 14));
		idno.setBounds(30, 77, 100, 18);
		formfacultypanel.add(idno);
		
		FacultyName = new JLabel("Name:");
		FacultyName.setFont(new Font("Arial", Font.BOLD, 14));
		FacultyName.setBounds(30, 138, 100, 18);
		formfacultypanel.add(FacultyName);
		
		facultydept = new JLabel("Department:");
		facultydept.setFont(new Font("Arial", Font.BOLD, 14));
		facultydept.setBounds(30, 193, 100, 18);
		formfacultypanel.add(facultydept);
		
		email = new JLabel("Email:");
		email.setFont(new Font("Arial", Font.BOLD, 14));
		email.setBounds(30, 248, 100, 18);
		formfacultypanel.add(email);
		
		contact = new JLabel("Contact No:");
		contact.setFont(new Font("Arial", Font.BOLD, 14));
		contact.setBounds(30, 303, 100, 18);
		formfacultypanel.add(contact);
		
		idnum = new JTextField(20);
		idnum.setFont(new Font("Arial", Font.PLAIN, 14));
		idnum.setBounds(150, 74, 150, 25);
		formfacultypanel.add(idnum);
		
		depttype = new JComboBox();
		depttype.setModel(new DefaultComboBoxModel(new String[] {"CE", "CPE", "ECE", "EE", "IE", "ME"}));
		depttype.setFont(new Font("Arial", Font.PLAIN, 14));
		depttype.setBounds(150, 193, 150, 25);
		formfacultypanel.add(depttype);
		
		namefield = new JTextField(20);
		namefield.setFont(new Font("Arial", Font.PLAIN, 14));
		namefield.setBounds(150, 138, 150, 25);
		formfacultypanel.add(namefield);
		
		emailfield = new JTextField(20);
		emailfield.setFont(new Font("Arial", Font.PLAIN, 14));
		emailfield.setBounds(150, 248, 150, 25);
		formfacultypanel.add(emailfield);
		
		contactfield = new JTextField(20);
		contactfield.setFont(new Font("Arial", Font.PLAIN, 14));
		contactfield.setBounds(150, 303, 150, 25);
		formfacultypanel.add(contactfield);
		
		facultyname = new JLabel("Faculty");
		facultyname.setForeground(new Color(255, 0, 0));
		facultyname.setHorizontalAlignment(SwingConstants.CENTER);
		facultyname.setFont(new Font("Arial", Font.BOLD, 25));
		facultyname.setBounds(0, 15, 330, 40);
		formfacultypanel.add(facultyname);
		
		tablefacultypanel = new JPanel();
		tablefacultypanel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		tablefacultypanel.setBackground(new Color(255, 255, 255));
		tablefacultypanel.setBounds(350, 61, 515, 463);
		facultymanagementinnerpanel.add(tablefacultypanel);
		tablefacultypanel.setLayout(null);
		
		facultscrollpane = new JScrollPane();
		facultscrollpane.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		facultscrollpane.setBackground(new Color(255, 255, 255));
		facultscrollpane.setAutoscrolls(true);
		facultscrollpane.setFont(new Font("Arial", Font.PLAIN, 12));
		facultscrollpane.setBounds(0, 0, 515, 463);
		tablefacultypanel.add(facultscrollpane);
		
		facultytable = new JTable();
		facultytable.setFont(new Font("Arial", Font.PLAIN, 12));
		facultytable.setBackground(Color.white);
		facultscrollpane.setViewportView(facultytable);
		facultytable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		
		addbutt2 = new JButton("Add");
		addbutt2.addActionListener(this);
		addbutt2.setFont(new Font("Arial", Font.PLAIN, 14));
		addbutt2.setBackground(Color.WHITE);
		addbutt2.setBounds(12, 484, 75, 40);
		facultymanagementinnerpanel.add(addbutt2);
		
		clearbutt2 = new JButton("Clear");
		clearbutt2.setFont(new Font("Arial", Font.PLAIN, 14));
		clearbutt2.addActionListener(this);
		clearbutt2.setBackground(Color.WHITE);
		clearbutt2.setBounds(183, 484, 75, 40);
		facultymanagementinnerpanel.add(clearbutt2);
		
		deletebutt2 = new JButton("Delete");
		deletebutt2.setFont(new Font("Arial", Font.PLAIN, 14));
		deletebutt2.setBackground(Color.WHITE);
		deletebutt2.setBounds(97, 484, 75, 40);
		deletebutt2.addActionListener(this);
		facultymanagementinnerpanel.add(deletebutt2);
		
		editbutt2 = new JButton("Edit");
		editbutt2.setFont(new Font("Arial", Font.PLAIN, 14));
		editbutt2.addActionListener(this);
		editbutt2.setBackground(Color.WHITE);
		editbutt2.setBounds(267, 484, 75, 40);
		facultymanagementinnerpanel.add(editbutt2);
		
		searchfaculty = new JTextField(searchS);
		searchfaculty.setFont(new Font("Arial", Font.PLAIN, 12));
		searchfaculty.setBounds(10, 63, 330, 28);
		searchfaculty.setText(searchS);
		searchfaculty.addFocusListener(this);
		searchfaculty.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				filterTable(facultytable, searchfaculty);
			}
		});
		facultymanagementinnerpanel.add(searchfaculty);
		
		//sectionamangement
		SectionManagementPanel = new JPanel();
		SectionManagementPanel.setBounds(200, 35, 900, 565);
		SectionManagementPanel.setLayout(null);
		contentPane.add(SectionManagementPanel);
	
		
		innerpanelsection = new JPanel();
		innerpanelsection.setBackground(new Color(255, 255, 255));
		innerpanelsection.setBounds(15, 15, 871, 536);
		SectionManagementPanel.add(innerpanelsection);
		innerpanelsection.setLayout(null);
		
		panelsection = new JPanel();
		panelsection.setLayout(null);
		panelsection.setBackground(new Color(128, 0, 0));
		panelsection.setBounds(0, 0, 875, 50);
		innerpanelsection.add(panelsection);
		
		upperpanelsection = new JPanel();
		upperpanelsection.setLayout(null);
		upperpanelsection.setBorder(new LineBorder(new Color(255, 255, 255), 6, true));
		upperpanelsection.setBackground(Color.WHITE);
		upperpanelsection.setBounds(5, 5, 861, 40);
		panelsection.add(upperpanelsection);
		
		sectionlabel = new JLabel("Section Management");
		sectionlabel.setFont(new Font("Arial", Font.PLAIN, 20));
		sectionlabel.setBounds(15, 8, 200, 25);
		upperpanelsection.add(sectionlabel);
		
		formsectionpanel = new JPanel();
		formsectionpanel.setLayout(null);
		formsectionpanel.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		formsectionpanel.setBackground(new Color(248, 248, 248));
		formsectionpanel.setBounds(10, 61, 330, 369);
		innerpanelsection.add(formsectionpanel);
		
		sectid = new JLabel("Section ID:");
		sectid.setFont(new Font("Arial", Font.BOLD, 14));
		sectid.setBounds(30, 95, 100, 18);
		formsectionpanel.add(sectid);
		
		Course = new JLabel("Course:");
		Course.setFont(new Font("Arial", Font.BOLD, 14));
		Course.setBounds(30, 145, 100, 18);
		formsectionpanel.add(Course);
		
		Year = new JLabel("Year:");
		Year.setFont(new Font("Arial", Font.BOLD, 14));
		Year.setBounds(30, 201, 100, 18);
		formsectionpanel.add(Year);
		
		Section = new JLabel("Section:");
		Section.setFont(new Font("Arial", Font.BOLD, 14));
		Section.setBounds(30, 255, 100, 18);
		formsectionpanel.add(Section);
		
		coursetextF = new JTextField(20);
		coursetextF.setFont(new Font("Arial", Font.PLAIN, 14));
		coursetextF.setBounds(150, 145, 150, 25);
		formsectionpanel.add(coursetextF);
		
		sectField = new JTextField(20);
		sectField.setFont(new Font("Arial", Font.PLAIN, 14));
		sectField.setBounds(150, 255, 150, 25);
		formsectionpanel.add(sectField);
		
		sectionname = new JLabel("Section"); 
		sectionname.setHorizontalAlignment(SwingConstants.CENTER);
		sectionname.setForeground(new Color(128, 0, 0));
		sectionname.setFont(new Font("Arial", Font.BOLD, 25));
		sectionname.setBounds(0, 15, 330, 40);
		formsectionpanel.add(sectionname);
		
		sectidlabel = new JLabel("");
		sectidlabel.setForeground(new Color(255, 0, 0));
		sectidlabel.setFont(new Font("Arial", Font.BOLD, 14));
		sectidlabel.setBounds(150, 95, 100, 18);
		formsectionpanel.add(sectidlabel);
		
		yearlevel = new JComboBox();
		yearlevel.setModel(new DefaultComboBoxModel(new String[] {"I", "II", "III", "IV"}));
		yearlevel.setFont(new Font("Arial", Font.BOLD, 12));
		yearlevel.setBounds(150, 200, 150, 22);
		formsectionpanel.add(yearlevel);
		
		nofstudents = new JLabel("No. Students:");
		nofstudents.setFont(new Font("Arial", Font.BOLD, 14));
		nofstudents.setBounds(30, 307, 100, 18);
		formsectionpanel.add(nofstudents);
		
		nostudentstextF = new JTextField(20);
		nostudentstextF.setFont(new Font("Arial", Font.PLAIN, 14));
		nostudentstextF.setBounds(150, 305, 150, 25);
		formsectionpanel.add(nostudentstextF);
		
		tablesectionpanel = new JPanel(); //jpanel 
		tablesectionpanel.setLayout(null);
		tablesectionpanel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		tablesectionpanel.setBackground(Color.WHITE);
		tablesectionpanel.setBounds(350, 61, 510, 463);
		innerpanelsection.add(tablesectionpanel);
		
		scrollpanesection = new JScrollPane(); 
		scrollpanesection.setFont(new Font("Arial", Font.PLAIN, 12));
		scrollpanesection.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		scrollpanesection.setBackground(Color.WHITE);
		scrollpanesection.setAutoscrolls(true);
		scrollpanesection.setBounds(0, 0, 510, 463);
		tablesectionpanel.add(scrollpanesection);
		
		sectiontable = new JTable();
		sectiontable.setFont(new Font("Arial", Font.PLAIN, 12));
		sectiontable.setBackground(Color.white);
		scrollpanesection.setViewportView(sectiontable);
		sectiontable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		
		addbutt3 = new JButton("Add"); 
		addbutt3.setFont(new Font("Arial", Font.PLAIN, 14));
		addbutt3.setBackground(Color.WHITE);
		addbutt3.setBounds(10, 464, 75, 40);
		addbutt3.addActionListener(this);
		innerpanelsection.add(addbutt3);
		
		deletebutt3 = new JButton("Delete");
		deletebutt3.setFont(new Font("Arial", Font.PLAIN, 14));
		deletebutt3.setBackground(Color.WHITE);
		deletebutt3.setBounds(95, 464, 75, 40);
		deletebutt3.addActionListener(this);
		innerpanelsection.add(deletebutt3);
		
		clearbutt3 = new JButton("Clear");
		clearbutt3.setFont(new Font("Arial", Font.PLAIN, 14));
		clearbutt3.setBackground(Color.WHITE);
		clearbutt3.setBounds(181, 464, 75, 40);
		clearbutt3.addActionListener(this);
		innerpanelsection.add(clearbutt3);
		
		editbutt3 = new JButton("Edit");
		editbutt3.setFont(new Font("Arial", Font.PLAIN, 14));
		editbutt3.setBackground(Color.WHITE);
		editbutt3.setBounds(265, 464, 75, 40);
		editbutt3.addActionListener(this);
		innerpanelsection.add(editbutt3);
		
		schedclasspanel = new JPanel();
		schedclasspanel.setBounds(200, 35, 900, 565);
		contentPane.add(schedclasspanel);
		schedclasspanel.setLayout(null);
		
		panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(10, 11, 880, 543);
		schedclasspanel.add(panel);
		panel.setLayout(null);
		
		schedpanel1 = new JPanel(); 
		schedpanel1.setLayout(null); 
		schedpanel1.setBackground(new Color(64, 0, 0));
		schedpanel1.setBounds(0, 0, 880, 50);
		panel.add(schedpanel1);
		
		upperpanel_1 = new JPanel();
		upperpanel_1.setLayout(null);
		upperpanel_1.setBorder(new LineBorder(new Color(255, 255, 255), 6, true));
		upperpanel_1.setBackground(Color.WHITE);
		upperpanel_1.setBounds(10, 10, 860, 32);
		schedpanel1.add(upperpanel_1);
		
		schedpaneltitle = new JLabel("Class Assignment");
		schedpaneltitle.setFont(new Font("Arial", Font.BOLD, 20));
		schedpaneltitle.setBounds(15, 4, 200, 25);
		upperpanel_1.add(schedpaneltitle);
		
		schedulepanel = new JPanel();
		schedulepanel.setForeground(new Color(128, 0, 0));
		schedulepanel.setLayout(null);
		schedulepanel.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(128, 0, 0), null, null, null));
		schedulepanel.setBackground(new Color(128, 0, 0));
		schedulepanel.setBounds(0, 49, 880, 493);
		panel.add(schedulepanel);
		
		schedulescrollpane = new JScrollPane();
		schedulescrollpane.setFont(new Font("Arial", Font.PLAIN, 12));
		schedulescrollpane.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		schedulescrollpane.setBackground(Color.WHITE);
		schedulescrollpane.setAutoscrolls(true);
		schedulescrollpane.setBounds(10, 57, 860, 425);
		schedulepanel.add(schedulescrollpane);
		
		scheduletable = new JTable();
		scheduletable.setFont(new Font("Arial", Font.PLAIN, 12));
		scheduletable.setBackground(Color.white);
		schedulescrollpane.setViewportView(scheduletable);
		scheduletable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		
		print = new JButton("Print");
		print.addActionListener(this);
		print.setFont(new Font("Arial", Font.BOLD, 12));
		print.setBackground(Color.WHITE);
		print.setIcon(new ImageIcon("images/print.png"));
		print.setBounds(560, 11, 150, 35);
		schedulepanel.add(print);
		
		/*download = new JButton("PDF");
		download.setFont(new Font("Arial", Font.BOLD, 12));
		download.setBackground(Color.WHITE);
		download.setIcon(new ImageIcon("images/pdf.png"));
		download.setBounds(400, 11, 150, 35);
		download.addActionListener(this);
		schedulepanel.add(download);*/
		
		SchedClassbutton = new JButton("Sched Class");
		SchedClassbutton.setBackground(new Color(255, 255, 255));
		SchedClassbutton.setIcon(new ImageIcon("images/add.png"));
		SchedClassbutton.setFont(new Font("Arial", Font.BOLD, 12));
		SchedClassbutton.setBounds(720, 11, 150, 35);
		SchedClassbutton.addActionListener(this);
		schedulepanel.add(SchedClassbutton);
		
		searchtfield = new JTextField();
		searchtfield.setFont(new Font("Arial", Font.PLAIN, 12));
		searchtfield.setBounds(10, 10, 270, 35);
		searchtfield.setColumns(20);
		searchtfield.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				filterTable(scheduletable, searchtfield);
			}
		});
		schedulepanel.add(searchtfield);
		
		
		RoomManagementPanel.setVisible(false);
		FacultyManagementPanel.setVisible(false);
		SectionManagementPanel.setVisible(false);
		schedclasspanel.setVisible(false);
	}
private void autoID() {
		
		try {
			connect = database.connectDb();
			result = state.executeQuery("SELECT MAX(roomid) from room");
			result.next();
			result.getString("MAX(roomid)");
			if(result.getString("MAX(roomid)") == null) {
				roomidno.setText("1");
			}
			else{
				long id = Long.parseLong(result.getString("MAX(roomid)"));
				id++;
				roomidno.setText(String.format("%d", id));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void getTotalRoom() {
	
		try {
			connect = database.connectDb();
			state = connect.createStatement();
			result = state.executeQuery("SELECT COUNT(*) FROM room");
			result.next();
	        int totalRooms = result.getInt(1);
	        Total1.setText(Integer.valueOf(totalRooms).toString());
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void addMouseListenerToTableRoom() {
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DefaultTableModel model = (DefaultTableModel)table.getModel();
				int MyIndex = table.getSelectedRow();
				key = Integer.valueOf(model.getValueAt(MyIndex, 0).toString());
				roomidno.setText(model.getValueAt(MyIndex, 0).toString());
				roomnameTextfield.setText(model.getValueAt(MyIndex, 1).toString());
				roomtype.setSelectedItem(model.getValueAt(MyIndex, 2).toString());
				capacityT.setText(model.getValueAt(MyIndex, 3).toString());
				addbutt.setEnabled(false);
			}
		});
		table.setCellSelectionEnabled(true);
		table.setDefaultEditor(Object.class, null);
	}
	private void setDefaultRendererToTable(JTable table) {
		JTableHeader header = table.getTableHeader();
		header.setBackground(new Color(128, 0, 0));
		header.setForeground(Color.white);
		table.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
		    @Override
		    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
		        Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
		        if (row % 2 == 0) {
		            c.setBackground(Color.WHITE);
		        } else {
		            c.setBackground(new Color(248,248,248));
		        }
		        return c;
		    }
		});
	}
	private void filterTable(JTable table, JTextField searchField) {
		DefaultTableModel obj = (DefaultTableModel) table.getModel();
		TableRowSorter<DefaultTableModel> obj1 = new TableRowSorter<>(obj);
		table.setRowSorter(obj1);
		obj1.setRowFilter(RowFilter.regexFilter(searchField.getText()));	
	}
	private void showRooms() {
		try {
			connect = database.connectDb();
			state = connect.createStatement();
			result = state.executeQuery("SELECT * FROM room");
			  DefaultTableModel model = new DefaultTableModel();
		        model.setColumnIdentifiers(new Object[]{"Room ID", "Room Name", "Room Type", "Capacity"});
		        while (result.next()) {
		            model.addRow(new Object[]
		            		{result.getString("roomid"), 
		            		result.getString("roomname"), 
		            		result.getString("roomtype"), 
		            		result.getInt("capacity")});
		        }
		        table.setModel(model);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	private void countRooms() {
		try {
			state = connect.createStatement();
			result = state.executeQuery("SELECT MAX(roomid) from room");
			result.next();
			rid = result.getInt(1)+1;
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void clearText(){
		roomnameTextfield.setText(null);
		roomtype.setSelectedIndex(0);
		capacityT.setText(null);
		autoID();
		addbutt.setEnabled(true);
	}
	public void countFaculty() {
		try {
			state = connect.createStatement();
			result = state.executeQuery("SELECT MAX(id) from faculty");
			result.next();
			fid = result.getInt(1)+1;
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	private void getTotalFaculty() {
		try {
			connect = database.connectDb();
			state = connect.createStatement();
			result = state.executeQuery("SELECT COUNT(*) FROM faculty");
			result.next();
			int totalfaculty = result.getInt(1);
			Total3.setText(Integer.valueOf(totalfaculty).toString());
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void clearTextFaculty() {
		idnum.setText(null);
		namefield.setText(null);
		depttype.setSelectedIndex(0);
		emailfield.setText(null);
		contactfield.setText(null);
		addbutt2.setEnabled(true);
	}
	private void showFaculty() {
		try {
			connect = database.connectDb();
			state = connect.createStatement();
			result = state.executeQuery("SELECT * FROM faculty");
			  DefaultTableModel model = new DefaultTableModel();
		        model.setColumnIdentifiers(new Object[]{"ID", "Faculty ID", "Name", "Department", "Email", "Contact Number"});
		        while (result.next()) {
		            model.addRow(new Object[]
		            		{result.getString("id"),
		            		result.getString("facultyid"), 
		            		result.getString("facultyname"), 
		            		result.getString("facultydeptype"), 
		            		result.getString("email"),
		            		result.getString("contact")});
		        }
		        facultytable.setModel(model);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	private void addMouseListenerToTableFaculty() {
		facultytable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DefaultTableModel model = (DefaultTableModel)facultytable.getModel();
				int MyIndex = facultytable.getSelectedRow();
				keyf = Integer.valueOf(model.getValueAt(MyIndex, 0).toString());
				idnum.setText(model.getValueAt(MyIndex, 1).toString());
				namefield.setText(model.getValueAt(MyIndex, 2).toString());
				depttype.setSelectedItem(model.getValueAt(MyIndex, 3).toString());
				emailfield.setText(model.getValueAt(MyIndex, 4).toString());
				contactfield.setText(model.getValueAt(MyIndex, 5).toString());
				addbutt2.setEnabled(false);
			}
		});
		facultytable.setCellSelectionEnabled(true);
		facultytable.setDefaultEditor(Object.class, null);
	}
	private void showSections() {
		try {
			connect = database.connectDb();
			state = connect.createStatement();
			result = state.executeQuery("SELECT * FROM section");
			  DefaultTableModel model = new DefaultTableModel();
		        model.setColumnIdentifiers(new Object[]{"Section ID", "Course", "Year Level", "Section Name","No of Students"});
		        while (result.next()) {
		            model.addRow(new Object[]
		            		{result.getString("sectid"),
		            		result.getString("course"), 
		            		result.getString("yearlevel"), 
		            		result.getString("sectionN"),
		            		result.getInt("students"),});
		         
		        }
		        sectiontable.setModel(model);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	private void countSections() {
		try {
			state = connect.createStatement();
			result = state.executeQuery("SELECT MAX(sectid) from section");
			result.next();
			sid = result.getInt(1)+1;
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	private void getTotalSection() {
		try {
			connect = database.connectDb();
			state = connect.createStatement();
			result = state.executeQuery("SELECT COUNT(*) FROM section");
			result.next();
			int totalsection = result.getInt(1);
			Total2.setText(Integer.valueOf(totalsection).toString());
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	private void sectionClearText() {
		coursetextF.setText(null);
		yearlevel.setSelectedIndex(0);
		sectField.setText(null);
		nostudentstextF.setText(null);
		addbutt3.setEnabled(true);
		autoIDsection();
	}
	private void autoIDsection() {
		try {
			connect = database.connectDb();
			result = state.executeQuery("SELECT MAX(sectid) from section");
			result.next();
			result.getString("MAX(sectid)");
			if(result.getString("MAX(sectid)") == null) {
				sectidlabel.setText("1");
			}
			else{
				long id = Long.parseLong(result.getString("MAX(sectid)"));
				id++;
				sectidlabel.setText(String.format("%d", id));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	private void addMouseListenerToTableSection() {
		sectiontable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DefaultTableModel model = (DefaultTableModel)sectiontable.getModel();
				int MyIndex = sectiontable.getSelectedRow();
				keys = Integer.valueOf(model.getValueAt(MyIndex, 0).toString());
				sectidlabel.setText(model.getValueAt(MyIndex, 0).toString());
				coursetextF.setText(model.getValueAt(MyIndex, 1).toString());
				yearlevel.setSelectedItem(model.getValueAt(MyIndex, 2).toString());
				sectField.setText(model.getValueAt(MyIndex, 3).toString());
				nostudentstextF.setText(model.getValueAt(MyIndex, 4).toString());
				addbutt3.setEnabled(false);
			}
		});
		sectiontable.setCellSelectionEnabled(true);
		sectiontable.setDefaultEditor(Object.class, null);
	}
	public static void showSchedule() {
		try {
			connect = database.connectDb();
			state = connect.createStatement();
			result = state.executeQuery("SELECT * FROM schedule");
			DefaultTableModel model = new DefaultTableModel();
	        model.setColumnIdentifiers(new Object[]{"ID", "Subject", "Section", "Faculty","Day","Start Time","End Time","Room"});
	        while (result.next()) {
	            model.addRow(new Object[]
	            		{result.getInt("id"),
	            		result.getString("subject"), 
	            		result.getString("section"), 
	            		result.getString("faculty"),
	            		result.getString("day"),
	            		result.getTime("start_time"),
	            		result.getTime("end_time"),
	            		result.getString("room")});
	         
	        }
	        scheduletable.setModel(model);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()== Exit) {
			System.exit(0);
		}
		if(e.getSource() == Minimize) {
			setState(JFrame.ICONIFIED);
		}
		if(e.getSource()== signout) {
			int option = JOptionPane.showConfirmDialog(contentPane, "Are you sure you want to logout?", "Logout Confirmation", JOptionPane.YES_NO_OPTION);
			if(option == JOptionPane.YES_OPTION) {
				this.dispose();
				new Login().setVisible(true);
			}
			else {
				return;
			}
		}
		if(e.getSource() == Dashboard1) {
			DashBoardPanel.setVisible(true);
			getTotalRoom();
			getTotalFaculty();
			RoomManagementPanel.setVisible(false);
			FacultyManagementPanel.setVisible(false);
			SectionManagementPanel.setVisible(false);
			schedclasspanel.setVisible(false);
		}
		if(e.getSource() == RoomManagementButton) {
			DashBoardPanel.setVisible(false);
			RoomManagementPanel.setVisible(true);
			FacultyManagementPanel.setVisible(false);
			SectionManagementPanel.setVisible(false);
			schedclasspanel.setVisible(false);
		}
		if(e.getSource() == FacultyManagementButton) {
			DashBoardPanel.setVisible(false);
			RoomManagementPanel.setVisible(false);
			FacultyManagementPanel.setVisible(true);
			SectionManagementPanel.setVisible(false);
			schedclasspanel.setVisible(false);
		}
		if(e.getSource() == SectionButton) {
			DashBoardPanel.setVisible(false);
			RoomManagementPanel.setVisible(false);
			FacultyManagementPanel.setVisible(false);
			SectionManagementPanel.setVisible(true);
			schedclasspanel.setVisible(false);
		}
		if(e.getSource() == RoomAssignmentButton) {
			DashBoardPanel.setVisible(false);
			RoomManagementPanel.setVisible(false);
			FacultyManagementPanel.setVisible(false);
			SectionManagementPanel.setVisible(false);
			schedclasspanel.setVisible(true);
		}
		if(e.getSource() == SchedClassbutton) {
			schedclassform schedform = new schedclassform();
			schedform.setVisible(true);
		}
		if(e.getSource() == print) {
			MessageFormat header = new MessageFormat("College of Engineering Room Schedule");
			MessageFormat footer = new MessageFormat("Southern Luzon State University");
			try {
				scheduletable.print(JTable.PrintMode.FIT_WIDTH,header,footer);
			} catch (Exception e2) {
				// TODO: handle exception
				JOptionPane.showMessageDialog(null,"Cannot be Print!" + e2.getMessage());
			}
		}
		if(e.getSource() == addbutt) {
			if(roomnameTextfield.getText().isEmpty()||roomtype.getSelectedIndex()==-1||capacityT.getText().isEmpty()) {
				JOptionPane.showMessageDialog(this, "Missing Data!!!");
			}
			else {
				try {
					countRooms();
					connect = database.connectDb();
					prepare = connect.prepareStatement("SELECT * FROM room WHERE roomname = ?");
					prepare.setString(1, roomnameTextfield.getText().toString());
					result = prepare.executeQuery();
					if (result.next()) {
					    JOptionPane.showMessageDialog(this, "Room with this name already exists!!!");
					}
					else {
						prepare = connect.prepareStatement("INSERT INTO room (roomid, roomname, roomtype, capacity) VALUES (?, ?, ?, ?)");
						prepare.setInt(1, rid);
						prepare.setString(2, roomnameTextfield.getText().toString());
						prepare.setString(3, roomtype.getSelectedItem().toString());
						prepare.setInt(4, Integer.valueOf(capacityT.getText().toString()));
						int row = prepare.executeUpdate();
						JOptionPane.showMessageDialog(this, "Room Added!!!");
						connect.close();
						clearText();
						showRooms();
					}
					
				} catch (Exception e2) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(this, e2);
				}
			}
		}
		if(e.getSource() == deletebutt) {
			if(key == 0) {
				JOptionPane.showMessageDialog(this, "Select a Room!!!");
			}else {
				try {
					countRooms();
					connect = database.connectDb();
					prepare = connect.prepareStatement("DELETE FROM room where roomid = ?");
					prepare.setInt(1, key);
					int row  = prepare.executeUpdate();
					JOptionPane.showMessageDialog(this, "Room Deleted!!!");
					connect.close();
					clearText();
					showRooms();
				}catch (Exception e1) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(this, e1);
				}
			}
		}
		if(e.getSource() == clearbutt) {
			clearText();
		}
		if(e.getSource() == editbutt) {
			if(roomnameTextfield.getText().isEmpty()||roomtype.getSelectedIndex()==-1||capacityT.getText().isEmpty()) {
				JOptionPane.showMessageDialog(this, "Select Room!!!");
			}
			else {
				try {
					countRooms();
					connect = database.connectDb();
					String currentName = "";
			        prepare = connect.prepareStatement("SELECT roomname FROM room WHERE roomid = ?");
			        prepare.setInt(1, key);
			        result = prepare.executeQuery();
			        	if(result.next()) {
			        		currentName = result.getString("roomname");
			            }
			            
			            // Check if the new room name is equal to any existing room name
			            if(!roomnameTextfield.getText().toString().equals(currentName)) {
			                prepare = connect.prepareStatement("SELECT roomname FROM room WHERE roomname = ?");
			                prepare.setString(1, roomnameTextfield.getText().toString());
			                result = prepare.executeQuery();
			                if(result.next()) {
			                    JOptionPane.showMessageDialog(this, "Room name already exists!!!");
			                    return;
			                }
			            }
					prepare = connect.prepareStatement("UPDATE room set roomname=?, roomtype=?, capacity=? where roomid = ?");
					prepare.setInt(4, key);
					prepare.setString(1, roomnameTextfield.getText().toString());
					prepare.setString(2, roomtype.getSelectedItem().toString());
					prepare.setInt(3, Integer.valueOf(capacityT.getText().toString()));
					int row = prepare.executeUpdate();
					JOptionPane.showMessageDialog(this, "Room Updated!!!");
					connect.close();
					clearText();
					showRooms();
				} catch (Exception e2) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(this, e2);
				}
			}
		}
		if(e.getSource()==addbutt2) {
			if(idnum.getText().isEmpty()||namefield.getText().isEmpty()
					||depttype.getSelectedIndex()==-1||emailfield.getText().isEmpty()||contactfield.getText().isEmpty()) {
				JOptionPane.showMessageDialog(this, "Select Faculty!!!");
			}
			else {
				try {
					facultyidS = idnum.getText().trim();
					facultyIDExists = false;
		            
		            prepare = connect.prepareStatement("SELECT * FROM faculty WHERE facultyid = ?");
		            prepare.setString(1, facultyidS);
		            result = prepare.executeQuery();
		            if(result.next()) {
		            	facultyIDExists = true;
		            }
		            if(facultyIDExists) {
		            	JOptionPane.showMessageDialog(this, "Faculty ID already exists!!!");
		            }
		            else {
		            	countFaculty();
		            	connect = database.connectDb();
						prepare = connect.prepareStatement("INSERT INTO faculty (id, facultyid, facultyname, facultydeptype, email, contact) VALUES (?, ?, ?, ?, ?, ?)");
						prepare.setInt(1, fid);
						prepare.setString(2, idnum.getText().toString());
						prepare.setString(3, namefield.getText().toString());
						prepare.setString(4, depttype.getSelectedItem().toString());
						prepare.setString(5, emailfield.getText().toString());
						prepare.setString(6, contactfield.getText().toString());
						int row = prepare.executeUpdate();
						JOptionPane.showMessageDialog(this, "Faculty Added!!!");
						connect.close();
						clearTextFaculty();
						showFaculty();
		            }
				} catch (Exception e2) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(this, e2);
				}
			}
		}
		if(e.getSource()==deletebutt2) {
			if(keyf == 0) {
				JOptionPane.showMessageDialog(this, "Select a Faculty!!!");
			}else {
				try {
					countFaculty();
					connect = database.connectDb();
					prepare = connect.prepareStatement("DELETE FROM faculty where id = ?");
					prepare.setInt(1, keyf);
					int row  = prepare.executeUpdate();
					JOptionPane.showMessageDialog(this, "Faculty Deleted!!!");
					connect.close();
					clearTextFaculty();
					showFaculty();
				}catch (Exception e1) {
					JOptionPane.showMessageDialog(this, e1);
				}
			}
		}
		if(e.getSource()==clearbutt2) {
			clearTextFaculty();
		}
		if(e.getSource() == editbutt2) {
			if(idnum.getText().isEmpty()||namefield.getText().isEmpty()
					||depttype.getSelectedIndex()==-1||emailfield.getText().isEmpty()||contactfield.getText().isEmpty()) {
				JOptionPane.showMessageDialog(this, "Missing Data!!!");
			}
			else {
				try {
					facultyidS = idnum.getText().trim();
					facultyIDExists = false;
					
					 // check if faculty ID already exists in the database
		            prepare = connect.prepareStatement("SELECT * FROM faculty WHERE facultyid = ?");
		            prepare.setString(1, facultyidS);
		            result = prepare.executeQuery();
		            if (result.next()) {
		                if (result.getInt("id") != keyf) { // check if the ID belongs to the current record or not
		                	facultyIDExists = true;
		                }
		            }
		            if (facultyIDExists) {
		                JOptionPane.showMessageDialog(this, "Faculty ID already exists!!!");
		            }
		            else {
		            	countFaculty();
						connect = database.connectDb();
						prepare = connect.prepareStatement("UPDATE faculty set facultyid=?, facultyname=?, facultydeptype=?, email=?, contact=? where id = ?");
						prepare.setInt(6, keyf);
						prepare.setString(1, idnum.getText().toString());
						prepare.setString(2, namefield.getText().toString());
						prepare.setString(3, depttype.getSelectedItem().toString());
						prepare.setString(4, emailfield.getText().toString());
						prepare.setString(5, contactfield.getText().toString());
						int row = prepare.executeUpdate();
						JOptionPane.showMessageDialog(this, "Faculty Updated!!!");
						connect.close();
		            }
					clearTextFaculty();
					showFaculty();
				} catch (Exception e2) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(this, e2);
				}
			}
		}
		if(e.getSource()==addbutt3) {
			if(coursetextF.getText().isEmpty()||yearlevel.getSelectedIndex()==-1||
					sectField.getText().isEmpty()) {
				JOptionPane.showMessageDialog(this, "Missing Data!!!");
			}
			else {
				try {
					countSections();
					connect = database.connectDb();
					prepare = connect.prepareStatement("SELECT * FROM section WHERE course = ? AND yearlevel = ? AND sectionN = ?");
					prepare.setString(1, coursetextF.getText().toString());
					prepare.setString(2, yearlevel.getSelectedItem().toString());
					prepare.setString(3, sectField.getText().toString());
					result = prepare.executeQuery();
					if (result.next()) {
					    JOptionPane.showMessageDialog(this, "Section already exists!!!");
					}
					else {
						prepare = connect.prepareStatement("INSERT INTO section (sectid, course, yearlevel, sectionN, students) VALUES (?, ?, ?, ?, ?)");
						prepare.setInt(1, sid);
						prepare.setString(2, coursetextF.getText().toString().toUpperCase());
						prepare.setString(3, yearlevel.getSelectedItem().toString());
						prepare.setString(4, sectField.getText().toString().toUpperCase());
						prepare.setInt(5, Integer.valueOf(nostudentstextF.getText().toString()));
						int row = prepare.executeUpdate();
						JOptionPane.showMessageDialog(this, "Section Added!!!");
						connect.close();
						sectionClearText();
						showSections();
					}
	
				} catch (Exception e2) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(this, e2);
				}
			}
		}
		if(e.getSource()==deletebutt3) {
			if(keys == 0) {
				JOptionPane.showMessageDialog(this, "Select Section!!!");
			}else {
				try {
					countRooms();
					connect = database.connectDb();
					prepare = connect.prepareStatement("DELETE FROM section where sectid = ?");
					prepare.setInt(1, keys);
					int row  = prepare.executeUpdate();
					JOptionPane.showMessageDialog(this, "Section Deleted!!!");
					connect.close();
					sectionClearText();
					showSections();
				}catch (Exception e1) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(this, e1);
				}
			}
		}
		if(e.getSource()==clearbutt3) {
			sectionClearText();
		}
		if(e.getSource()==editbutt3) {
			if(coursetextF.getText().isEmpty()||yearlevel.getSelectedIndex()==-1||
				sectField.getText().isEmpty()||nostudentstextF.getText().isEmpty()) {
				JOptionPane.showMessageDialog(this, "Missing Data!!!");
			}
			else {
				try {
		            countSections();
					connect = database.connectDb();
					prepare = connect.prepareStatement("UPDATE section set course=?, yearlevel=?, sectionN=?, students=? where sectid = ?");
					prepare.setInt(5, keys);
					prepare.setString(1, coursetextF.getText().toString());
					prepare.setString(2, yearlevel.getSelectedItem().toString());
					prepare.setString(3, sectField.getText().toString());
					prepare.setInt(4, Integer.valueOf(nostudentstextF.getText().toString()));
					int row = prepare.executeUpdate();
					JOptionPane.showMessageDialog(this, "Section Updated!!!");
					connect.close();
					sectionClearText();
					showSections();
				} catch (Exception e2) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(this, e2);
				}
			}
		}
	}


@Override
public void focusGained(FocusEvent e) {
	// TODO Auto-generated method stub
	if (e.getComponent() instanceof JTextField) {
		JTextField searchField = (JTextField) e.getComponent();
		if (searchField == search) {
			search.setText(null);
		} else if (searchField == searchfaculty) {
			searchfaculty.setText(null);
		}
    }
}

@Override
public void focusLost(FocusEvent e) {
	// TODO Auto-generated method stub
	String cStringSearch = search.getText();
	String cStringsearchfaculty = searchfaculty.getText();
	if(cStringSearch.isEmpty()) {
		search.setText(searchS);
		
	}else if(cStringsearchfaculty.isEmpty()) {
		searchfaculty.setText(searchS);
		
	}
}

@Override
public void mouseDragged(MouseEvent e) {
	// TODO Auto-generated method stub
	
}

@Override
public void mouseMoved(MouseEvent e) {
	// TODO Auto-generated method stub
	
}

@Override
public void mouseClicked(MouseEvent e) {
	// TODO Auto-generated method stub
	
}

@Override
public void mousePressed(MouseEvent e) {
	// TODO Auto-generated method stub
	
}

@Override
public void mouseReleased(MouseEvent e) {
	// TODO Auto-generated method stub
	
}

@Override
public void mouseEntered(MouseEvent e) {
	// TODO Auto-generated method stub
	
}

@Override
public void mouseExited(MouseEvent e) {
	// TODO Auto-generated method stub
	
}
}

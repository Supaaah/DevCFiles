import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;

public class schedclassform extends JFrame implements ActionListener
,MouseListener, MouseMotionListener{

	private MyMouseListener mouseListener;
	
	//database
	private Connection connect;
	private PreparedStatement prepare;
	private ResultSet result;
	private Statement state;
	
	private JPanel contentPane,checkBoxPanel;
	public JTextField subjectfield;
	private JLabel subjlabel, sectlabel,facultylabel,daylabel,time1label,time2label, roomlabel;
	public JComboBox<String> sectioncombo, facultycombo,roomcombobox;
	private JButton Exit, save;

	public JComboBox<LocalTime> startTimeComboBox;
	public JComboBox<LocalTime> endTimeComboBox;
	public Map<DayOfWeek, JCheckBox> dayCheckBoxes;
    
    int x = 85; // Starting x-coordinate for checkboxes
	 int width = 150; // Width of each checkbox
	 private JButton btnNewButton;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					schedclassform frame = new schedclassform();
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
	public schedclassform() {
		mouseListener = new MyMouseListener(this);	
		
		init();
		addDatatoComboBox();
		populateTimeComboBox(startTimeComboBox);
		populateTimeComboBox(endTimeComboBox);
		
		JLabel title = new JLabel("Sched Class Form");
		title.setForeground(new Color(128, 0, 0));
		title.setFont(new Font("Arial", Font.BOLD, 18));
		title.setBounds(160, 24, 170, 18);
		contentPane.add(title);
		addCheckbox();
	}
	private void populateTimeComboBox(JComboBox<LocalTime> ComboBox) {
		// TODO Auto-generated method stub
		LocalTime time = LocalTime.of(6, 0);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");

        while (time.isBefore(LocalTime.of(21, 30))) {
        	ComboBox.addItem(time);
            time = time.plusMinutes(30);
        }

        ComboBox.setRenderer(new TimeSlotRenderer(formatter));
    }


	public void init() {
		addMouseListener(mouseListener);
		addMouseMotionListener(mouseListener);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(100, 100, 490, 400);
		setUndecorated(true);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		subjlabel = new JLabel("Subject"); 
		subjlabel.setBounds(30, 84, 80, 20);
		subjlabel.setFont(new Font("Arial", Font.PLAIN, 12));
		contentPane.add(subjlabel);
		
		sectlabel = new JLabel("Section");
		sectlabel.setBounds(30, 115, 80, 20);
		sectlabel.setFont(new Font("Arial", Font.PLAIN, 12));
		contentPane.add(sectlabel);
		
		facultylabel = new JLabel("Faculty");
		facultylabel.setBounds(30, 146, 80, 20);
		facultylabel.setFont(new Font("Arial", Font.PLAIN, 12));
		contentPane.add(facultylabel);
		
		daylabel = new JLabel("Day");
		daylabel.setBounds(30, 177, 80, 20);
		daylabel.setFont(new Font("Arial", Font.PLAIN, 12));
		contentPane.add(daylabel);
		
		time1label = new JLabel("From");
		time1label.setBounds(30, 250, 80, 20);
		time1label.setFont(new Font("Arial", Font.PLAIN, 12));
		contentPane.add(time1label);
		
		time2label = new JLabel("To");
		time2label.setBounds(30, 281, 80, 20);
		time2label.setFont(new Font("Arial", Font.PLAIN, 12));
		contentPane.add(time2label);
		
		roomlabel = new JLabel("Room");
		roomlabel.setBounds(30, 312, 80, 20);
		roomlabel.setFont(new Font("Arial", Font.PLAIN, 12));
		contentPane.add(roomlabel);
		
		subjectfield = new JTextField();
		subjectfield.setBounds(105, 84, 150, 20);
		contentPane.add(subjectfield);
		subjectfield.setColumns(10);
		
		checkBoxPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		checkBoxPanel.setBounds(105, 177, 345, 62);
		checkBoxPanel.setBackground(new Color(255, 255, 255));
		contentPane.add(checkBoxPanel);
		
		sectioncombo = new JComboBox();
		sectioncombo.setBounds(105, 115, 150, 22);
		contentPane.add(sectioncombo);
		
		facultycombo = new JComboBox();
		facultycombo.setBounds(105, 146, 150, 22);
		contentPane.add(facultycombo);
		
		startTimeComboBox = new JComboBox();
		startTimeComboBox.setBounds(105, 249, 150, 22);
		startTimeComboBox.addActionListener(e -> validateTimeSelection());
		contentPane.add(startTimeComboBox);
		
		endTimeComboBox = new JComboBox();
		endTimeComboBox.setBounds(105, 281, 150, 22);
		endTimeComboBox.addActionListener(e -> validateTimeSelection());
		contentPane.add(endTimeComboBox);
		
		roomcombobox = new JComboBox();
		roomcombobox.setBounds(105, 312, 150, 22);
		contentPane.add(roomcombobox);
		
		Exit = new JButton("x");
		Exit.setBounds(447, 0, 43, 20);
		Exit.setHorizontalTextPosition(SwingConstants.LEFT);
		Exit.setForeground(new Color(0, 0, 0));
		Exit.setFont(new Font("Tahoma", Font.BOLD, 14));
		Exit.setBorderPainted(false);
		Exit.setBackground(new Color(255, 255, 255));
		Exit.setAlignmentY(0.0f);
		Exit.addActionListener(this);
		contentPane.add(Exit);
			
		save = new JButton("Save");
		save.setBounds(105, 343, 80, 22);
		save.setFont(new Font("Arial", Font.PLAIN, 12));
		save.addActionListener(this);
		contentPane.add(save);
	}
	private void validateTimeSelection() {
		// TODO Auto-generated method stub
		LocalTime startTime = (LocalTime) startTimeComboBox.getSelectedItem();
	    LocalTime endTime = (LocalTime) endTimeComboBox.getSelectedItem();

	    if (startTime != null && endTime != null && endTime.isBefore(startTime)) {
	    	save.setEnabled(false);
	    	JOptionPane.showMessageDialog(this, "End time must be after start time!");
	   }else {
		    save.setEnabled(true);
	   }
	  
	}

	public void addDatatoComboBox() {
		try {
			connect = database.connectDb();
			state = connect.createStatement();
			result = state.executeQuery("SELECT * FROM section");

			sectioncombo.removeAllItems();
			
			while(result.next()) {
				String course = result.getString("course");
				String yearLevel = result.getString("yearlevel");
			    String sectionName = result.getString("sectionN");
		        
			    String combinedString = course + " " + yearLevel + " " + sectionName;
		        sectioncombo.addItem(combinedString);
			}
			result.close();
			state.close();
		    connect.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
		try {
			connect = database.connectDb();
			state = connect.createStatement();
			result = state.executeQuery("SELECT * FROM faculty");

			facultycombo.removeAllItems();
			
			while(result.next()) {
				String name = result.getString("facultyname");
				String dept = result.getString("facultydeptype");
				
				String faculty = name + " - " + dept;
		        facultycombo.addItem(faculty);
			}
			result.close();
			state.close();
		    connect.close();
		}catch (Exception e1) {
			e1.printStackTrace();
		}
		try {
			connect = database.connectDb();
			state = connect.createStatement();
			result = state.executeQuery("SELECT * FROM room");
			
			while(result.next()) {
				String rname = result.getString("roomname");
				roomcombobox.addItem(rname);
			}
		}catch (Exception e2) {
			e2.printStackTrace();
		}
	}
	public void addCheckbox() {
		dayCheckBoxes = new EnumMap<>(DayOfWeek.class);
		 for (DayOfWeek day : DayOfWeek.values()) {
			 if (day != DayOfWeek.SUNDAY) {
			        JCheckBox checkBox = new JCheckBox(day.toString());
			        checkBox.setBackground(Color.WHITE);
			        dayCheckBoxes.put(day, checkBox);
			        checkBoxPanel.add(checkBox);
			 }
		 }
	}
	private static class TimeSlotRenderer extends DefaultListCellRenderer {
        private DateTimeFormatter formatter;

        public TimeSlotRenderer(DateTimeFormatter formatter) {
            this.formatter = formatter;
        }

        @Override
        public Component getListCellRendererComponent(javax.swing.JList<?> list, Object value, int index,
                boolean isSelected, boolean cellHasFocus) {
            super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
            if (value instanceof LocalTime) {
                setText(((LocalTime) value).format(formatter));
            }
            return this;
        }
    }
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == Exit) {
			dispose();
		}
		if(e.getSource() == save) {
			if (validateInput()) {
	            saveData();
	        }
		}
	}
	

	private boolean validateInput() {
		
		   String subject = subjectfield.getText().trim();
		    if (subject.isEmpty()) {
		        JOptionPane.showMessageDialog(this, "Please enter a subject.");
		        return false;
		    }
		    
		  boolean isDaySelected = false;
		    for (JCheckBox checkBox : dayCheckBoxes.values()) {
		        if (checkBox.isSelected()) {
		            isDaySelected = true;
		            break;
		        }
		    }
		    if (!isDaySelected) {
		        JOptionPane.showMessageDialog(this, "Please select at least one day.");
		        return false;
		    }

		    // Check for overlapping time slots
		    LocalTime startTime = (LocalTime) startTimeComboBox.getSelectedItem();
		    LocalTime endTime = (LocalTime) endTimeComboBox.getSelectedItem();
		    if (startTime != null && endTime != null && endTime.isBefore(startTime)) {
		        JOptionPane.showMessageDialog(this, "End time must be after start time.");
		        return false;
		    }else if (endTime.equals(startTime)) {
	            JOptionPane.showMessageDialog(this, "Start time and end time cannot be the same.");
	            return false;
	        }
		    List<DayOfWeek> selectedDays = getSelectedDays();
		    Set<DayOfWeek> overlappingDays = new HashSet<>();
		    for (DayOfWeek day : selectedDays) {
		    	if (isScheduleOverlap(selectedDays, startTime, endTime, roomcombobox.getSelectedItem().toString())) {
		    	    overlappingDays.add(day);
		    	}
		    }

		    if (!overlappingDays.isEmpty()) {
		        String overlappingDaysString = overlappingDays.stream()
		                .map(DayOfWeek::toString)
		                .collect(Collectors.joining(", "));

		        JOptionPane.showMessageDialog(this, "There are overlapping schedules for the following days: " + overlappingDaysString + " in the selected room.");
		        return false;
		    }
	 return true;
	}

	private List<DayOfWeek> getSelectedDays() {
        List<DayOfWeek> selectedDays = new ArrayList<>();

        for (Map.Entry<DayOfWeek, JCheckBox> entry : dayCheckBoxes.entrySet()) {
            if (entry.getValue().isSelected()) {
                selectedDays.add(entry.getKey());
            }
        }

        return selectedDays;
    }

	private boolean isScheduleOverlap(List<DayOfWeek> selectedDays, LocalTime newStartTime, LocalTime newEndTime, String room) {
	    try {
	        connect = database.connectDb();
	        prepare = connect.prepareStatement("SELECT * FROM schedule WHERE room = ?");
	        prepare.setString(1, room);
	        result = prepare.executeQuery();

	        while (result.next()) {
	            LocalTime startTime = result.getTime("start_time").toLocalTime();
	            LocalTime endTime = result.getTime("end_time").toLocalTime();
	            String day = result.getString("day");
	            List<DayOfWeek> existingDays = Arrays.stream(day.split(" "))
	                    .map(DayOfWeek::valueOf)
	                    .collect(Collectors.toList());

	            // Check if any of the selected days overlap with the existing schedule
	            boolean isOverlap = selectedDays.stream()
	                    .anyMatch(existingDays::contains);

	            // Check if the time slot overlaps
	            if (isOverlap && newStartTime.isBefore(endTime) && newEndTime.isAfter(startTime)) {
	                return true; // There is an overlap
	            }
	        }
	        result.close();
	        prepare.close();
	        connect.close();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return false;
	}

	private void saveData() {
		// TODO Auto-generated method stub
		String subject = subjectfield.getText();
	    String section = sectioncombo.getSelectedItem().toString();
	    String faculty = facultycombo.getSelectedItem().toString();
	    String room = roomcombobox.getSelectedItem().toString();
	    LocalTime startTime = (LocalTime) startTimeComboBox.getSelectedItem();
	    LocalTime endTime = (LocalTime) endTimeComboBox.getSelectedItem();
	    List<DayOfWeek> selectedDays = getSelectedDays();

	    try {
	        connect = database.connectDb();
	        prepare = connect.prepareStatement("INSERT INTO schedule (subject, section, faculty, room, start_time, end_time, day) VALUES (?, ?, ?, ?, ?, ?, ?)");
	        StringBuilder dayBuilder = new StringBuilder();
	        for (DayOfWeek day : selectedDays) {
	            dayBuilder.append(day.toString()).append(" ");
	        }
	        String day = dayBuilder.toString().trim();
	            prepare.setString(1, subject);
	            prepare.setString(2, section);
	            prepare.setString(3, faculty);
	            prepare.setString(4, room);
	            prepare.setTime(5, Time.valueOf(startTime));
	            prepare.setTime(6, Time.valueOf(endTime));
	            prepare.setString(7, day.toString());

	            prepare.executeUpdate();

	        prepare.close();
	        connect.close();

	        JOptionPane.showMessageDialog(this, "Data saved successfully!");
	        clearForm();
	        Dashboard.showSchedule();
	    } catch (Exception e) {
	        e.printStackTrace();
	        JOptionPane.showMessageDialog(this, "Error saving data. Please try again.");
	    }
	}

	private void clearForm() {
		// TODO Auto-generated method stub
		 subjectfield.setText("");
		 sectioncombo.setSelectedIndex(0);
		 facultycombo.setSelectedIndex(0);
		 roomcombobox.setSelectedIndex(0);
		 startTimeComboBox.setSelectedIndex(0);
		 endTimeComboBox.setSelectedIndex(0);
		 for (JCheckBox checkBox : dayCheckBoxes.values()) {
			 checkBox.setSelected(false);
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

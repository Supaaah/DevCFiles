import java.awt.FlowLayout;
import java.awt.Component;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Example extends JFrame {
    private JComboBox<LocalTime> startTimeComboBox;
    private JComboBox<LocalTime> endTimeComboBox;

    public Example() {
        setTitle("Time Selection Example");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        // Create the start time combo box
        startTimeComboBox = new JComboBox<>();
        populateTimeComboBox(startTimeComboBox);
        panel.add(new JLabel("Start Time: "));
        panel.add(startTimeComboBox);

        // Create the end time combo box
        endTimeComboBox = new JComboBox<>();
        populateTimeComboBox(endTimeComboBox);
        panel.add(new JLabel("End Time: "));
        panel.add(endTimeComboBox);

        // Add action listener to handle time selection
        startTimeComboBox.addActionListener(e -> validateTimeSelection());
        endTimeComboBox.addActionListener(e -> validateTimeSelection());

        add(panel);
    }

    private void populateTimeComboBox(JComboBox<LocalTime> comboBox) {
        LocalTime time = LocalTime.of(0, 0);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");

        while (time.isBefore(LocalTime.of(23, 30))) {
            comboBox.addItem(time);
            time = time.plusMinutes(30);
        }

        comboBox.setRenderer(new TimeSlotRenderer(formatter));
    }

    private void validateTimeSelection() {
        LocalTime startTime = (LocalTime) startTimeComboBox.getSelectedItem();
        LocalTime endTime = (LocalTime) endTimeComboBox.getSelectedItem();

        if (startTime != null && endTime != null && endTime.isBefore(startTime)) {
            JOptionPane.showMessageDialog(this, "End time must be after start time!");
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

    public static void main(String[] args) {
        Example frame = new Example();
        frame.setVisible(true);
    }
}


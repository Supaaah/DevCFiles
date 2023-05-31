import javax.swing.*;
import java.awt.image.*;
import java.awt.*;

public class abrigo10_1 {
public static void main(String[]args){
JFrame frame = new JFrame(); //creation of frame
frame.setLayout(new FlowLayout()); // layout manager (flow layout)
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // terminate the GUI


frame.setLocation(10,50); //set initial location
frame.setSize(300,1500); // set horizontal, vertical length
frame.setTitle("Frame Name"); //the name of the frame
JButton button1 = new JButton("Button1"); // creation of button
button1.setIcon(new ImageIcon("C:\\\\Users\\\\rvabr\\\\OneDrive\\\\Pictures\\\\Windows_Calculator_icon.png"));

button1.setBackground(Color.YELLOW); //set color
frame.add(button1); //add button to the frame

JButton button2 = new JButton("Button2"); // creation of button

BufferedImage image = new BufferedImage(100, 100, BufferedImage.TYPE_INT_ARGB);
Graphics g = image.getGraphics();
g.setColor(Color.YELLOW);
g.fillRect(10, 20, 80, 70);
g.setColor(Color.RED);
g.fillOval(40, 50, 25, 25);
ImageIcon icon = new ImageIcon(image);
button2.setIcon(icon);
button2.setBackground(Color.GREEN); // set color
frame.add(button2); // add button to frame
frame.pack();// make the frame compact
frame.setVisible(true); //set visibility
}
}
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MyMouseListener implements MouseListener, MouseMotionListener {
    private Point mouseOffset;
    private boolean isDragging;
    private JFrame frame;
    
	public MyMouseListener(JFrame frame) {
		this.frame = frame;
	}
    @Override
    public void mouseClicked(MouseEvent e) {
        // Handle mouse clicked event
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // Handle mouse pressed event
    	mouseOffset = e.getPoint();
        isDragging = true;
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // Handle mouse released event
    	isDragging = false;
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // Handle mouse entered event
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // Handle mouse exited event
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        // Handle mouse dragged event
    	if (isDragging) {
	        // Calculate the new position of the frame based on the mouse drag distance
	        Point mousePos = e.getLocationOnScreen();
	        frame.setLocation(mousePos.x - mouseOffset.x, mousePos.y - mouseOffset.y);
	     }
    }
	@Override
    public void mouseMoved(MouseEvent e) {
        // Handle mouse moved event
    }
}

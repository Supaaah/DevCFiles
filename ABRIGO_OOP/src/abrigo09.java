import javax.swing.*;
import java.awt.*;

class notepad extends JFrame{
	
	private JMenuBar menubar;
	private JMenu File;
	private JMenu Edit;
	private JMenu View;
	private JMenuItem New;
	private JMenuItem Newitem;
	private JMenuItem Open;
	private JMenuItem Save;
	private JMenuItem Saveas;
	private JMenuItem Pageset;
	private JMenuItem Print;
	private JMenuItem Exit;
	//jmenu items for edit
	private JMenuItem undo;
	private JMenuItem cut;
	private JMenuItem copy;
	private JMenuItem paste;
	private JMenuItem delete;
	private JMenuItem find;
	private JMenuItem findn;
	private JMenuItem findp;
	private JMenuItem replace;
	private JMenuItem goto1;
	private JMenuItem selectall;
	private JMenuItem timedate;
	private JMenuItem font;
	//jmenu item for view
	private JMenu zoom;
	//jmenu item for zoom
	private JMenuItem zoomin;
	private JMenuItem zoomout;
	private JMenuItem restoreD;
	//jmenu for view
	private JCheckBoxMenuItem status;
	private JCheckBoxMenuItem wordwrap;
 	//textarea
	private JTextArea areaText;
	private JScrollPane scrollPane;
	//statusbar
	private JPanel statusb;
	private JPanel labels;
	private JLabel lines;
	private JLabel size;
	private JLabel txt;
	private JLabel utf;

	
	public notepad() {
		setTitle("Notepad");
		setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500, 450);        
        
        //setting menu bar
        menubar = new JMenuBar();
        setJMenuBar(menubar);
        File = new JMenu("File");
        Edit = new JMenu("Edit");
        View = new JMenu("View");
        menubar.add(File);
        menubar.add(Edit);
        menubar.add(View);
        
        //setting jmenu item for file
        New = new JMenuItem("New");
        Newitem = new JMenuItem("New item");
        Open = new JMenuItem("Open");
        Save = new JMenuItem("Save");
        Saveas = new JMenuItem("Save as");
        Pageset = new JMenuItem("Page setup");
        Print = new JMenuItem("Print");
        Exit = new JMenuItem("Exit");
        
        //adding item to file
        File.add(New);
        File.add(Newitem);
        File.add(Open);
        File.add(Save);
        File.add(Saveas);
        File.addSeparator();
        File.add(Pageset);
        File.add(Print);
        File.addSeparator();
        File.add(Exit);
        
        //setting jmenu items for edit
        undo = new JMenuItem("Undo");
        cut = new JMenuItem("Cut");
        copy = new JMenuItem("Copy");
        paste = new JMenuItem("Paste");
        delete = new JMenuItem("Delete");
        find = new JMenuItem("Find");
        findn = new JMenuItem("Find next");
        findp = new JMenuItem("Find previous");
        replace = new JMenuItem("Replace");
        goto1 = new JMenuItem("Go to");
        selectall = new JMenuItem("Select all");
        timedate = new JMenuItem("Time/Date");
        font = new JMenuItem("Font");
        
        Edit.add(undo);
        Edit.addSeparator();
        Edit.add(cut);
        Edit.add(copy);
        Edit.add(paste);
        Edit.add(delete);
        Edit.addSeparator();
        Edit.add(find);
        Edit.add(findn);
        Edit.add(findp);
        Edit.add(replace);
        Edit.add(goto1);
        Edit.addSeparator();
        Edit.add(selectall);
        Edit.add(timedate);
        Edit.addSeparator();
        Edit.add(font);
        
        //setting jmenu for view
        zoom = new JMenu("Zoom");
        //jmenu item for zoom
        zoomin = new JMenuItem("Zoom in");
        zoomout = new JMenuItem("Zoom out");
        restoreD = new JMenuItem("Restore default zoom");
        //jcheckbox
        status = new JCheckBoxMenuItem("Status Bar");
        status.setSelected(true);
        wordwrap = new JCheckBoxMenuItem("Word wrap");
        
        View.add(zoom);
        zoom.add(zoomin);
        zoom.add(zoomout);
        zoom.add(restoreD);
        View.add(status);
        View.add(wordwrap);
        
        areaText = new JTextArea();
        //Creating Scrollbars around textarea
        scrollPane = new JScrollPane(areaText,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        add(scrollPane,BorderLayout.CENTER);
        
        //settting up status bar at the bottom
        statusb = new JPanel(new GridLayout(1,6));
        add(statusb,BorderLayout.SOUTH);
        statusb.setBorder(BorderFactory.createEtchedBorder()); // set broder to etched border
        statusb.add(new JSeparator(SwingConstants.VERTICAL)); // creation of vertical separator
        statusb.add(lines = new JLabel("Ln 1, Col 1")); 
        statusb.add(new JLabel(" "));
        statusb.add(new JLabel(" "));
        statusb.add(new JSeparator(SwingConstants.VERTICAL)); 
        statusb.add(size = new JLabel("100%")); 
        statusb.add(new JSeparator(SwingConstants.VERTICAL)); 
        statusb.add(txt = new JLabel("Windows (CRLF)")); 
        statusb.add(new JSeparator(SwingConstants.VERTICAL)); 
        statusb.add(utf = new JLabel("UTF-8")); 
        
        setVisible(true);
	}
}

public class abrigo09 {
	public static void main(String[] args) {
		notepad frame = new notepad();
	}
}

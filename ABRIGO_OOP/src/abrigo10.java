import javax.swing.*;
import java.awt.*;
import java.sql.Savepoint;

class paint extends JFrame{
	
	private JMenuBar menubar;
	private JMenu File;
	private JMenu Home;
	private JMenu View;
	private JMenuItem newfiles;
	private JMenuItem opens;
	private JMenuItem recents;
	private JMenuItem saves;
	
	private JMenu saveass;
	private JMenuItem png;
	private JMenuItem jpeg;
	private JMenuItem bmp;
	private JMenuItem gif;
	private JMenuItem other;
	
	private JMenu prints;
	private JMenuItem printIMG;
	private JMenuItem pageSetup;
	private JMenuItem printPreview;
	
	private JMenuItem fromscanners;
	private JMenuItem sends;
	
	private JMenu sets;
	private JMenuItem fill;
	private JMenuItem tile;
	private JMenuItem center;
	
	private JMenuItem imagepropertys;
	private JMenuItem settings;
	private JMenuItem exit;

	public paint() {
		setTitle("Paint");
		setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(550, 400); 	
      
        
        menubar = new JMenuBar();
        setJMenuBar(menubar);
      
        //setting jmenu
        File = new JMenu("File");
        Home = new JMenu("Home");
        View = new JMenu("View");
        //adding items to menubar
        menubar.add(File);
        menubar.add(Home);
        menubar.add(View);

        
        //setting Jmenu items
        newfiles = new JMenuItem("New",new ImageIcon("C:/Users/rvabr/OneDrive/Documents/image/file.png"));
        opens = new JMenuItem("Open",new ImageIcon("C:/Users/rvabr/OneDrive/Documents/image/folder.png"));
        recents = new JMenuItem("Recent",new ImageIcon("C:/Users/rvabr/OneDrive/Documents/image/recent.png"));
        saves = new JMenuItem("Save",new ImageIcon("C:/Users/rvabr/OneDrive/Documents/image/diskette.png"));
        
        //save as jmenu
        saveass = new JMenu("Save as");
        saveass.setIcon(new ImageIcon("C:/Users/rvabr/OneDrive/Documents/image/saveas.png"));
        png = new JMenuItem("PNG Picture", new ImageIcon("C:/Users/rvabr/OneDrive/Documents/image/png.png"));
        jpeg = new JMenuItem("JPEG Picture",new ImageIcon("C:/Users/rvabr/OneDrive/Documents/image/jpeg.png"));
        bmp = new JMenuItem("BMP Picture",new ImageIcon("C:/Users/rvabr/OneDrive/Documents/image/bmp.png"));
        gif = new JMenuItem("GIF Picture",new ImageIcon("C:/Users/rvabr/OneDrive/Documents/image/gif.png"));
        other = new JMenuItem("Other Formats",new ImageIcon("C:/Users/rvabr/OneDrive/Documents/image/other.png"));
        
        //adding jmenu items into save as
        saveass.add(png);
        saveass.add(jpeg);
        saveass.add(bmp);
        saveass.add(gif);
        saveass.add(other);
        
        //print jmenu 
        prints = new JMenu("Print");
        prints.setIcon(new ImageIcon("C:/Users/rvabr/OneDrive/Documents/image/print.png"));
        printIMG = new JMenuItem("Print", new ImageIcon("C:/Users/rvabr/OneDrive/Documents/image/print.png"));
        prints.add(printIMG);
        pageSetup = new JMenuItem("Page Setup", new ImageIcon("C:/Users/rvabr/OneDrive/Documents/image/pageSetupIMG.png"));
        prints.add(pageSetup);
        printPreview = new JMenuItem("Print Preview", new ImageIcon("C:/Users/rvabr/OneDrive/Documents/image/printPreviewIMG.png"));
        prints.add(printPreview);
        
        //setting scanner and send
        fromscanners = new JMenuItem("From scanner or camera", new ImageIcon("C:/Users/rvabr/OneDrive/Documents/image/fromscanner.png"));
        sends = new JMenuItem("Send", new ImageIcon("C:/Users/rvabr/OneDrive/Documents/image/send.png"));
        
        //setbackground jmenu
        sets = new JMenu("Set as desktop background");
        sets.setIcon(new ImageIcon("C:/Users/rvabr/OneDrive/Documents/image/setasbackground.png"));
        

        // SET BACKGROUND MENU
        fill = new JMenuItem("Fill", new ImageIcon("C:/Users/rvabr/OneDrive/Documents/image/fillIMG.png"));
        sets.add(fill);
        tile = new JMenuItem("Tile", new ImageIcon("C:/Users/rvabr/OneDrive/Documents/image/tileIMG.png"));
        sets.add(tile);
        center = new JMenuItem("Center", new ImageIcon("C:/Users/rvabr/OneDrive/Documents/image/centerIMG.png"));
        sets.add(center);
        
        //addition of jmenu items imageproperties and such
        imagepropertys = new JMenuItem("Image properties", new ImageIcon("C:/Users/rvabr/OneDrive/Documents/image/pictures.png"));
        settings = new JMenuItem("About Paint", new ImageIcon("C:/Users/rvabr/OneDrive/Documents/image/settings.png"));
        exit = new JMenuItem("Exit", new ImageIcon("C:/Users/rvabr/OneDrive/Documents/image/exit.png"));
    
        //adding item to file
        File.add(newfiles);
        File.add(opens);
        File.add(recents);
        File.add(saves);
        File.add(saveass);
        File.addSeparator();
        File.add(prints);
        File.add(fromscanners);
        File.add(sends);
        File.addSeparator();
        File.add(sets);
        File.addSeparator();
        File.add(imagepropertys);
        File.addSeparator();
        File.add(settings);
        File.addSeparator();
        File.add(exit);
        
        setVisible(true);
	}
}

public class abrigo10 {
	public static void main(String[] args) {
		paint frame = new paint();
	}
}

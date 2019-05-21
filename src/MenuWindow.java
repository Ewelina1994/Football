import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JFrame;

public class MenuWindow extends JMenuBar
{
	JMenu file= new JMenu("File");
	JMenuItem openFile=new JMenuItem("Open File");
	JMenuItem exit=new JMenuItem("Exit");
	
	JMenu edit=new JMenu("Edit");
			
	public MenuWindow()
	{
		file.add(openFile);
		file.add(new JSeparator());
		file.add(exit);
		add(file);
		/*
		add(whihPlayer);
		add(moveFirstTeam);
		add(moveSecondTeam);
		add(moveResetFirstTeam);
		add(moveResetSecondTeam);
		add(howMetersFront);
		add(howMetersBack);
		add(howMetersRight);
		add(howMetersLeft);
		add(jump);
		add(nearBall);
		add(kick);
		add(shot);
		*/
	}
	
}

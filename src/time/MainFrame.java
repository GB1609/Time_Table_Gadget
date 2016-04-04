package time;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;
public class MainFrame extends JFrame
{
	public static void main(String[] args)
	{
		new MainFrame();
	}
	private static final long serialVersionUID=1L;
	private Dimension screenSize;
	private StartPanel startPanel;
	private boolean create=true;
	public MainFrame()
	{
		this.screenSize=Toolkit.getDefaultToolkit().getScreenSize();
		this.setSize(372,134);
		this.setUndecorated(true);
		this.setBackground(new Color(0,0,0,0));
		this.setTitle("Time_Table_Gadget");
		this.setDefaultCloseOperation(0);
		this.startPanel=new StartPanel(this);
		this.setContentPane(startPanel);
		this.setLocation((int) (screenSize.getWidth()-(this.getWidth()+20)),20);
		this.setVisible(true);
	}
	@Override
	public void setSize(int width,int height)
	{
		super.setSize(width,height);
		if (width==1240)
			this.setLocationRelativeTo(null);
		else
		{
			this.setLocation((int) (screenSize.getWidth()-(this.getWidth()+20)),20);
			if (!create)
				this.startPanel.remove(startPanel.getClose());
		}
		this.revalidate();
	}
	public void setCreate(boolean b)
	{
		create=b;
	}
}

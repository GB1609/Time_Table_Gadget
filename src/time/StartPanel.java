package time;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
public class StartPanel extends JPanel
{
	private static final long serialVersionUID=1;
	private Image timeTable;
	private ImageIcon close1;
	private ImageIcon close2;
	private ModifiedButton close;
	public StartPanel(MainFrame frame)
	{
		this.requestFocus();
		this.setSize(frame.getSize());
		this.setLayout(null);
		frame.setCreate(false);
		try
		{
			timeTable=ImageIO.read(StartPanel.class.getClassLoader().getResource("time_table.png"));
			close1=new ImageIcon(ImageIO.read(StartPanel.class.getClassLoader().getResource("close1.png")));
			close2=new ImageIcon(ImageIO.read(StartPanel.class.getClassLoader().getResource("close2.png")));
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		this.close=new ModifiedButton(close1,close2,frame,e -> System.exit(0));
		this.close.setBounds(((timeTable.getWidth(null)/2)-(close1.getIconWidth()/2)),465,close1.getIconWidth(),close1.getIconHeight());
		this.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				if (frame.getWidth()==372)
				{
					frame.setSize(timeTable.getWidth(null),timeTable.getHeight(null)+close1.getIconHeight()+20);
					setSize(timeTable.getWidth(null),timeTable.getHeight(null)+close1.getIconHeight()+20);
					add(close);
				}
				else
				{
					frame.setSize((int) (timeTable.getWidth(null)*0.3),(int) (timeTable.getHeight(null)*0.3));
					setSize((int) (timeTable.getWidth(null)*0.3),(int) (timeTable.getHeight(null)*0.3));
				}
			}
		});
		this.setVisible(true);
	}
	public JButton getClose()
	{
		return close;
	}
	@Override
	protected void paintComponent(Graphics g)
	{
		if (this.getWidth()==372)
			g.drawImage(timeTable.getScaledInstance(this.getWidth(),this.getHeight(),Image.SCALE_SMOOTH),0,0,this.getWidth(),this.getHeight(),null);
		else
			g.drawImage(timeTable,0,0,timeTable.getWidth(null),timeTable.getHeight(null),null);
	}
}

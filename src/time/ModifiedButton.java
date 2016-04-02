package time;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import javax.swing.Icon;
import javax.swing.JButton;
public class ModifiedButton extends JButton
{
	private static final long serialVersionUID=1;
	private MouseListener passOn;
	public ModifiedButton(Icon icon1,Icon icon2,MainFrame frame,ActionListener a)
	{
		super(icon1);
		this.addActionListener(a);
		this.setSize(new Dimension(icon1.getIconWidth(),icon1.getIconHeight()));
		this.setBackground(Color.BLACK);
		this.setBorderPainted(false);
		this.setContentAreaFilled(false);
		this.setFocusPainted(false);
		this.setOpaque(true);
		this.setRolloverIcon(icon2);
		this.addMouseListener(this.passOn);
	}
}
